package com.harsh.rxandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.harsh.rxandroid.pointsTable.view.PointsTableFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .apply {
                add(R.id.container, PointsTableFragment(), PointsTableFragment::class.simpleName)
                commit()
            }
    }
}