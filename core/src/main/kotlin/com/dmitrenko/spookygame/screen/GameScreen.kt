package com.dmitrenko.spookygame.screen

import com.badlogic.ashley.core.Entity
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.utils.viewport.FitViewport
import com.dmitrenko.spookygame.SpookyGame
import com.dmitrenko.spookygame.ecs.EntityFactory
import com.dmitrenko.spookygame.ecs.EntityType.PLAYER
import com.dmitrenko.spookygame.ecs.component.GraphicComponent
import ktx.ashley.get
import ktx.graphics.use

class GameScreen(game: SpookyGame) : SpookyGameScreen(game) {
	private val viewport: FitViewport by lazy { FitViewport(256f, 256f) }

	private val entityFactory: EntityFactory by lazy { EntityFactory(game) }

	private val player: Entity by lazy { entityFactory.getEntity(PLAYER) }

	override fun show() {
		//
	}

	override fun render(delta: Float) {
		engine.update(delta)
		viewport.apply()
		batch.use(viewport.camera.combined) {
			player[GraphicComponent.mapper]?.sprite?.draw(it)
		}
	}

	override fun resize(width: Int, height: Int) {
		viewport.update(width, height, true)
	}

	override fun dispose() {
		player[GraphicComponent.mapper]?.sprite?.texture?.dispose()
	}
}