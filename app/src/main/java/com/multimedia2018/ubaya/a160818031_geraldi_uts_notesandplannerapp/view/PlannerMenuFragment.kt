package com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.R
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.viewmodel.PlanListViewModel
import kotlinx.android.synthetic.main.fragment_planner_menu.*

class PlannerMenuFragment : Fragment() {
    private lateinit var viewModelPlan: PlanListViewModel
    private val plannerListAdapter = PlannerListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_planner_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModelPlan = ViewModelProvider(this).get(PlanListViewModel::class.java)
        viewModelPlan.refresh()

        recViewPlan.layoutManager = LinearLayoutManager(context)
        recViewPlan.adapter = plannerListAdapter

        observePlanViewModel()

        fabCreatePlan.setOnClickListener {
            val action = PlannerMenuFragmentDirections.actionCreatePlan()
            Navigation.findNavController(it).navigate(action)
        }
    }

    fun observePlanViewModel() {
        viewModelPlan.planLD.observe(viewLifecycleOwner, Observer {
            plannerListAdapter.updatePlannerList(it)
        })
    }
}