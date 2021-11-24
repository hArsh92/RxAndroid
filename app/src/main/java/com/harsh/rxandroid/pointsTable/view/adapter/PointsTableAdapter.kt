package com.harsh.rxandroid.pointsTable.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.harsh.rxandroid.R
import com.harsh.rxandroid.pointsTable.view.model.Player

class PointsTableAdapter : RecyclerView.Adapter<PointsViewHolder>() {

    private var players: List<Player> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PointsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_points_view, parent, false)
        return PointsViewHolder(view)
    }

    override fun onBindViewHolder(holder: PointsViewHolder, position: Int) {
        holder.bindView(players[position])
    }

    override fun getItemCount(): Int = players.count()

    fun onDatasetChanged(players: List<Player>) {
        if (players != this.players) {
            this.players = players
            notifyDataSetChanged()
        }
    }
}
