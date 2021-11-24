package com.harsh.rxandroid.pointsTable.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.harsh.rxandroid.pointsTable.datasource.PlayersRepository
import com.harsh.rxandroid.pointsTable.datasource.PointsTableUseCase
import com.harsh.rxandroid.pointsTable.view.model.Player
import io.reactivex.BackpressureStrategy

class PointsTableViewModel(
    private val pointsTableUseCase: PointsTableUseCase
) : ViewModel() {

    fun getPlayers(): LiveData<List<Player>> {
        return LiveDataReactiveStreams
            .fromPublisher(
                pointsTableUseCase
                    .getAllPlayersSortedByPoints()
                    .toFlowable(BackpressureStrategy.BUFFER)
            )
    }
}