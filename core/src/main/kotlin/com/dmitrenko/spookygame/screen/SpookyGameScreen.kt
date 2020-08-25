package com.dmitrenko.spookygame.screen

import com.badlogic.ashley.core.Engine
import com.badlogic.gdx.graphics.g2d.Batch
import com.dmitrenko.spookygame.SpookyGame
import ktx.app.KtxScreen

abstract class SpookyGameScreen(
		val game: SpookyGame,
		val batch: Batch = game.batch,
		val engine: Engine = game.engine
): KtxScreen
