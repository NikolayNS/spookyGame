package com.dmitrenko.spookygame.ecs

import com.badlogic.ashley.core.Entity
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.dmitrenko.spookygame.SpookyGame
import com.dmitrenko.spookygame.ecs.EntityType.*
import com.dmitrenko.spookygame.ecs.component.GraphicComponent
import com.dmitrenko.spookygame.ecs.component.TransformComponent
import ktx.ashley.entity
import ktx.ashley.with

class EntityFactory(private val game: SpookyGame) {
    private val mobKnight = Texture(Gdx.files.internal("graphics/entity/unit/mob/knight/idle/Tuscan_idle_00000.png"))

    fun getEntity(type: EntityType): Entity {
        when (type) {
            PLAYER -> return getPlayer()
            else -> throw Throwable("Entity does not exist")
        }
    }

    private fun getPlayer(): Entity {
        return game.engine.entity {
            with<TransformComponent> {
                position.set(1f, 1f, 0f)
                size.set(PLAYER_SIZE_X, PLAYER_SIZE_Y)
            }
            with<GraphicComponent> {
                sprite.setRegion(mobKnight)
                sprite.setOriginCenter()
            }
        }
    }
}