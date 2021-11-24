package com.harsh.rxandroid.pointsTable.view.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.harsh.rxandroid.R
import com.harsh.rxandroid.pointsTable.view.model.Player

class PointsViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val ivProfile: ImageView by lazy { view.findViewById(R.id.iv_profile) }
    private val tvPoints: TextView by lazy { view.findViewById(R.id.tv_points) }
    private val tvPlayer: TextView by lazy { view.findViewById(R.id.tv_player) }


    fun bindView(player: Player) {
        tvPlayer.text = player.name
        tvPoints.text = player.points.toString()
        ivProfile.setImageResource(android.R.drawable.stat_notify_chat)
    }
}
