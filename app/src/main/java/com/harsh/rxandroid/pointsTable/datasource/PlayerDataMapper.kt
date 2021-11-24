package com.harsh.rxandroid.pointsTable.datasource

import com.harsh.rxandroid.pointsTable.view.model.Player
import com.harsh.rxandroid.pointsTable.datasource.model.PlayerEntity

class PlayerDataMapper {

    fun map(entity: PlayerEntity, score: Int): Player {
        return Player(
            id = entity.id,
            name = entity.name,
            image = entity.icon,
            points = score
        )
    }
}
