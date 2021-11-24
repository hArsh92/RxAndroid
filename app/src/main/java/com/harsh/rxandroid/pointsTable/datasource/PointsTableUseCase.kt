package com.harsh.rxandroid.pointsTable.datasource

import com.harsh.rxandroid.pointsTable.view.model.Player
import io.reactivex.Observable

class PointsTableUseCase(
    private val playersRepository: PlayersRepository
) {

    fun getAllPlayersSortedByPoints(): Observable<List<Player>> {
        return playersRepository.getAllPlayers().map { players -> players.sortedBy { it.points } }
    }
}