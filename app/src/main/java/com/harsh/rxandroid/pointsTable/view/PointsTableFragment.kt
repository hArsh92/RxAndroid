package com.harsh.rxandroid.pointsTable.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.harsh.rxandroid.R
import com.harsh.rxandroid.StarWarsApp
import com.harsh.rxandroid.pointsTable.datasource.PlayersRepository
import com.harsh.rxandroid.pointsTable.datasource.PointsTableUseCase
import com.harsh.rxandroid.pointsTable.view.adapter.PointsTableAdapter

class PointsTableFragment : Fragment(R.layout.fragment_points_table) {

    private val rvPoints: RecyclerView by lazy { requireView().findViewById(R.id.rv_points) }
    private val pointsTableUseCase: PointsTableUseCase by lazy { (requireActivity().applicationContext as StarWarsApp).pointsTableUseCase }
    private val pointsViewModel: PointsTableViewModel by lazy {
        ViewModelProvider(this, PointsTableViewModelFactory(pointsTableUseCase))
            .get()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvPoints.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        rvPoints.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        val pointsTableAdapter = PointsTableAdapter()
        rvPoints.adapter = pointsTableAdapter
        pointsViewModel.getPlayers().observe(this) { players ->
            pointsTableAdapter.onDatasetChanged(players)
        }
    }
}
