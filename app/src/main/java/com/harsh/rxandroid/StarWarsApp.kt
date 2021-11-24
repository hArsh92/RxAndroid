package com.harsh.rxandroid

import android.app.Application
import com.harsh.rxandroid.datasource.StarWarsDatabase
import com.harsh.rxandroid.pointsTable.datasource.PlayersRepository

class StarWarsApp : Application() {

    private val db: StarWarsDatabase by lazy { StarWarsDatabase.getInstance(this) }
    val playersRepository: PlayersRepository by lazy { PlayersRepository(db.pointsTableDao()) }
}
