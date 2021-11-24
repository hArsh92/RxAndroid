package com.harsh.rxandroid.pointsTable.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.harsh.rxandroid.pointsTable.datasource.PlayersRepository
import com.harsh.rxandroid.pointsTable.view.model.Player
import io.reactivex.BackpressureStrategy

class PointsTableViewModel(
    private val playersRepository: PlayersRepository
) : ViewModel() {

    fun getPlayers(): LiveData<List<Player>> {
        return LiveDataReactiveStreams
            .fromPublisher(
                playersRepository
                    .getAllPlayers()
                    .toFlowable(BackpressureStrategy.BUFFER)
            )
    }
}