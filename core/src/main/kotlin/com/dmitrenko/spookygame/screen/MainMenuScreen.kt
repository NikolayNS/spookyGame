package com.dmitrenko.spookygame.screen

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.dmitrenko.spookygame.SpookyGame
import ktx.graphics.use

class MainMenuScreen(game: SpookyGame): SpookyGameScreen(game) {

	private val background = Texture(Gdx.files.internal("graphics/menu/main/main_menu_background.jpg"))
	private val sprite: Sprite by lazy { Sprite(background).apply { setSize(Gdx.app.graphics.width.toFloat(), Gdx.app.graphics.height.toFloat()) } }

	override fun show() {
		sprite.setPosition(0f, 0f)
	}

	override fun render(delta: Float) {
		batch.use { sprite.draw(batch) }
	}

	override fun dispose() {
		background.dispose()
	}
}
