package com.dmitrenko.spookygame.ecs.system

import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.systems.SortedIteratingSystem
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.utils.viewport.Viewport
import com.dmitrenko.spookygame.ecs.component.GraphicComponent
import com.dmitrenko.spookygame.ecs.component.TransformComponent
import ktx.ashley.allOf
import ktx.ashley.get
import ktx.graphics.use

class RenderSystem(
		private val batch: Batch,
		private val gameViewport: Viewport
) : SortedIteratingSystem(
		allOf(TransformComponent::class, GraphicComponent::class).get(),
		compareBy { entity -> entity[TransformComponent.mapper] }
) {

	override fun update(deltaTime: Float) {
		forceSort()
		gameViewport.apply()
		batch.use(gameViewport.camera.combined) {
			super.update(deltaTime)
		}
	}

	override fun processEntity(entity: Entity, deltaTime: Float) {
		val transform = requireNotNull(entity[TransformComponent.mapper]) { "Entity $entity must have a TransformComponent" }
		val graphic = requireNotNull(entity[GraphicComponent.mapper]) { "Entity $entity must have a GraphicComponent" }

		graphic.sprite.run {
			rotation = transform.rotationDeg
			setBounds(transform.position.x, transform.position.y, transform.size.x, transform.size.y)
			draw(batch)
		}
	}
}