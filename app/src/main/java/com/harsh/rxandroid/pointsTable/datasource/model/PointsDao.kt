package com.harsh.rxandroid.pointsTable.datasource.model

import androidx.room.Dao
import androidx.room.Query
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface PointsDao {

    @Query("SELECT * FROM player")
    fun getAllPlayers(): Observable<List<PlayerEntity>>

    @Query(
        """
        SELECT COUNT(*) FROM matches WHERE 
        (player1_id == :playerId AND player1_score >= player2_score)
        OR
        (player2_id == :playerId AND player2_score >= player1_score)
        """
    )
    fun getPlayerPoints(playerId: Int): Single<Int>
}
