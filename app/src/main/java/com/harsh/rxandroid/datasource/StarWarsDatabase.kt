package com.harsh.rxandroid.datasource

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.harsh.rxandroid.BuildConfig
import com.harsh.rxandroid.match.datasource.model.MatchEntity
import com.harsh.rxandroid.pointsTable.datasource.model.PlayerEntity
import com.harsh.rxandroid.pointsTable.datasource.model.PointsDao

@Database(
    entities = [PlayerEntity::class, MatchEntity::class],
    version = BuildConfig.DB_VERSION
)
abstract class StarWarsDatabase : RoomDatabase() {

    abstract fun pointsTableDao(): PointsDao

    companion object {

        @Volatile
        private var INSTANCE: StarWarsDatabase? = null

        fun getInstance(context: Context): StarWarsDatabase =
            INSTANCE.orElse {
                synchronized(this) {
                    INSTANCE.orElse { buildDatabase(context).also { INSTANCE = it } }
                }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                StarWarsDatabase::class.java,
                "star_wars.db"
            )
                .createFromAsset("star_wars.db")
                .build()
    }
}

fun <T> T?.orElse(block: () -> T): T = this ?: block()