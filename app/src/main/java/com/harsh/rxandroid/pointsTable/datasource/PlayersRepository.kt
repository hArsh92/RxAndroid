package com.harsh.rxandroid.pointsTable.datasource

import com.harsh.rxandroid.common.BaseSchedulerProvider
import com.harsh.rxandroid.common.SchedulerProvider
import com.harsh.rxandroid.pointsTable.datasource.model.PlayerEntity
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
            .flatMap(::addPointsInfoToPlayers)
    }

    private fun addPointsInfoToPlayers(playerEntities: List<PlayerEntity>) =
        Observable.fromIterable(playerEntities)
            .observeOn(scheduler.io())
            .flatMap(::getMatchPointsForPlayer)
            .collect({ mutableListOf<Player>() }, { players, player -> players.add(player) })
            .toObservable()

    private fun getMatchPointsForPlayer(playerEntity: PlayerEntity) =
        pointsTableDao.getPlayerPoints(playerEntity.id)
            .map { mapper.map(playerEntity, it) }
            .toObservable()
}
