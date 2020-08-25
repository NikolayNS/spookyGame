package com.dmitrenko.spookygame.screen

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.utils.viewport.FitViewport
import com.dmitrenko.spookygame.SpookyGame
import ktx.graphics.use

class GameScreen(game: SpookyGame) : SpookyGameScreen(game) {
	private val mobKnight = Texture(Gdx.files.internal("graphics/entity/unit/mob/knight/idle/Tuscan_idle_00000.png"))
	private val viewport: FitViewport by lazy { FitViewport(256f, 256f) }
	private val sprite: Sprite by lazy { Sprite(mobKnight).apply { setSize(128f, 96f) } }

	override fun show() {
		sprite.setPosition(1f, 1f)
	}

	override fun render(delta: Float) {
		engine.update(delta)
		viewport.apply()
		batch.use(viewport.camera.combined) {
			sprite.draw(it)
		}
	}

	override fun resize(width: Int, height: Int) {
		viewport.update(width, height, true)
	}

	override fun dispose() {
		mobKnight.dispose()
	}
}