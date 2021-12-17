package com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.R
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.model.Planners
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.viewmodel.PlanDetailViewModel
import kotlinx.android.synthetic.main.fragment_planner_read.*

class PlannerReadFragment : Fragment() {
    private lateinit var viewModelDetailPlan : PlanDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_planner_read, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModelDetailPlan = ViewModelProvider(this).get(PlanDetailViewModel::class.java)

        val uuid = PlannerReadFragmentArgs.fromBundle(requireArguments()).idPlan.toInt()
        viewModelDetailPlan.fetch(uuid)
        observePlanDetailViewModel()

        btnEditPlan.setOnClickListener {
            val idplanlink = viewModelDetailPlan.planLD.value?.uuid.toString()
            val action = PlannerReadFragmentDirections.actionEditPlan(idplanlink)
            Navigation.findNavController(it).navigate(action)
        }

        btnClearPlan.setOnClickListener {
            viewModelDetailPlan.deletePlan(uuid)
            Navigation.findNavController(it).popBackStack()
            Toast.makeText(view.context, "Plan deleted", Toast.LENGTH_SHORT).show()
        }
    }

    fun observePlanDetailViewModel() {
        viewModelDetailPlan.planLD.observe(viewLifecycleOwner, Observer {
            txtReadPlanTitle.setText(it.title)
            txtReadPlanDesc.setText(it.desc)
            txtReadPlanDate.setText(it.date)
            txtReadPlanTime.setText(it.time)
        })
    }
}