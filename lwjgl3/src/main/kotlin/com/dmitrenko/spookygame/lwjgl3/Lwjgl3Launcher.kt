package com.dmitrenko.spookygame.lwjgl3

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import com.dmitrenko.spookygame.SpookyGame

fun main() {
	Lwjgl3Application(SpookyGame(), Lwjgl3ApplicationConfiguration().apply {
		setTitle("Spooky Game")
		setWindowedMode(1600, 900)
		setWindowIcon("libgdx128.png", "libgdx64.png", "libgdx32.png", "libgdx16.png")
	})
}