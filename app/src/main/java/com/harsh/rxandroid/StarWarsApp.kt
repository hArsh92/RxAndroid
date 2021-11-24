package com.harsh.rxandroid

import android.app.Application
import com.harsh.rxandroid.datasource.StarWarsDatabase
import com.harsh.rxandroid.pointsTable.datasource.PlayersRepository
import com.harsh.rxandroid.pointsTable.datasource.PointsTableUseCase

class StarWarsApp : Application() {

    private val db: StarWarsDatabase by lazy { StarWarsDatabase.getInstance(this) }
    private val playersRepository: PlayersRepository by lazy { PlayersRepository(db.pointsTableDao()) }
    val pointsTableUseCase: PointsTableUseCase by lazy { PointsTableUseCase(playersRepository) }
}
