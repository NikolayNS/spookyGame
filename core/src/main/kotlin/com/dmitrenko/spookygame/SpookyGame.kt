package com.dmitrenko.spookygame

import com.badlogic.ashley.core.Engine
import com.badlogic.ashley.core.PooledEngine
import com.badlogic.gdx.Application.LOG_DEBUG
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.dmitrenko.spookygame.screen.GameScreen
import com.dmitrenko.spookygame.screen.LoadingScreen
import com.dmitrenko.spookygame.screen.MainMenuScreen
import ktx.app.KtxGame
import ktx.app.KtxScreen

class SpookyGame : KtxGame<KtxScreen>() {
	val engine: Engine by lazy { PooledEngine() }
	val batch: Batch by lazy { SpriteBatch() }

	override fun create() {
		Gdx.app.logLevel = LOG_DEBUG
		addScreen(MainMenuScreen(this))
		addScreen(LoadingScreen(this))
		addScreen(GameScreen(this))
		setScreen<GameScreen>()
	}

	override fun dispose() {
		super.dispose()
		batch.dispose()
	}
}