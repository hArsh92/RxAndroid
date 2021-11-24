package com.harsh.rxandroid.pointsTable.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.harsh.rxandroid.pointsTable.datasource.PlayersRepository

class PointsTableViewModelFactory(
    private val playersRepository: PlayersRepository
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PointsTableViewModel(playersRepository) as T
    }
}
