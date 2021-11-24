package com.harsh.rxandroid.pointsTable.datasource

import com.harsh.rxandroid.common.BaseSchedulerProvider
import com.harsh.rxandroid.common.SchedulerProvider
import com.harsh.rxandroid.pointsTable.datasource.model.PointsDao
import com.harsh.rxandroid.pointsTable.view.model.Player
import io.reactivex.Observable

class PlayersRepository(
    private val pointsTableDao: PointsDao,
    private val scheduler: BaseSchedulerProvider = SchedulerProvider()
) {

    private val mapper = PlayerDataMapper()

    fun getAllPlayers(): Observable<List<Player>> {
        return pointsTableDao.getAllPlayers()
            .observeOn(scheduler.io())
            .flatMap { playerEntities ->
                Observable.fromIterable(playerEntities)
                    .observeOn(scheduler.io())
                    .flatMap { playerEntity ->
                        pointsTableDao.getPlayerPoints(playerEntity.id)
                            .map { mapper.map(playerEntity, it) }
                            .toObservable()
                    }
                    .collect({ mutableListOf<Player>() }, { players, player -> players.add(player) })
                    .map { players -> players.sortedBy { it.points } }
                    .toObservable()
            }
    }
}
