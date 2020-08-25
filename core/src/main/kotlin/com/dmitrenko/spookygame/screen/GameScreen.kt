package com.dmitrenko.spookygame.screen

import com.badlogic.ashley.core.Entity
import com.dmitrenko.spookygame.SpookyGame
import com.dmitrenko.spookygame.ecs.EntityFactory
import com.dmitrenko.spookygame.ecs.EntityType.PLAYER
import com.dmitrenko.spookygame.ecs.component.GraphicComponent
import ktx.ashley.get

class GameScreen(game: SpookyGame) : SpookyGameScreen(game) {

	private val entityFactory: EntityFactory by lazy { EntityFactory(game) }

	private val player: Entity by lazy { entityFactory.getEntity(PLAYER) }

	override fun show() {
		player
	}

	override fun render(delta: Float) {
		engine.update(delta)
	}

	override fun dispose() {
		player[GraphicComponent.mapper]?.sprite?.texture?.dispose()
	}
}