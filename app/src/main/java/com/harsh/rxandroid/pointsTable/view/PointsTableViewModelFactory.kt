package com.harsh.rxandroid.pointsTable.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.harsh.rxandroid.pointsTable.datasource.PlayersRepository
import com.harsh.rxandroid.pointsTable.datasource.PointsTableUseCase

class PointsTableViewModelFactory(
    private val pointsTableUseCase: PointsTableUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PointsTableViewModel(pointsTableUseCase) as T
    }
}
