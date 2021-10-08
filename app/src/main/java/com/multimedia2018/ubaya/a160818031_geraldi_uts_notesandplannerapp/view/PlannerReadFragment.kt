package com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.R
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
        viewModelDetailPlan.fetch()
        observePlanDetailViewModel()

        btnEditPlan.setOnClickListener {
            val idplanlink = viewModelDetailPlan.planLD.value?.id.toString()
            val action = PlannerReadFragmentDirections.actionEditPlan(idplanlink)
            Navigation.findNavController(it).navigate(action)
        }
    }

    fun observePlanDetailViewModel() {
        viewModelDetailPlan.planLD.observe(viewLifecycleOwner, Observer {
            txtReadPlanTitle.setText(viewModelDetailPlan.planLD.value?.title)
            txtReadPlanDesc.setText(viewModelDetailPlan.planLD.value?.desc)
            txtReadPlanDate.setText(viewModelDetailPlan.planLD.value?.date)
            txtReadPlanTime.setText(viewModelDetailPlan.planLD.value?.time)

            var alarm = "-"
            var alarmstatus = viewModelDetailPlan.planLD.value?.alarm.toString()
            if (alarmstatus == "yes")
            {
                alarm = "ON"
            }
            else
            {
                alarm = "OFF"
            }
            txtReadPlanAlarm.setText("Alarm: $alarm")
        })
    }
}