package com.dmitrenko.spookygame

import com.badlogic.gdx.Game

class SpookyGame : Game() {
	override fun create() {
		setScreen(FirstScreen())
	}
}