package com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.R
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.viewmodel.PlanDetailViewModel
import kotlinx.android.synthetic.main.fragment_planner_edit.*

class PlannerEditFragment : Fragment() {
    private lateinit var viewModelDetailPlan : PlanDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_planner_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModelDetailPlan = ViewModelProvider(this).get(PlanDetailViewModel::class.java)
        viewModelDetailPlan.fetch()
        observePlanDetailViewModel()
    }

    fun observePlanDetailViewModel() {
        viewModelDetailPlan.planLD.observe(viewLifecycleOwner, Observer {
            txtEditPlanID.setText(viewModelDetailPlan.planLD.value?.id)
            txtEditPlanTitle.setText(viewModelDetailPlan.planLD.value?.title)
            txtEditPlanDesc.setText(viewModelDetailPlan.planLD.value?.desc)
            txtEditPlanDate.setText(viewModelDetailPlan.planLD.value?.date)
            txtEditPlanTime.setText(viewModelDetailPlan.planLD.value?.time)

            var alarm = "-"
            var alarmstatus = viewModelDetailPlan.planLD.value?.alarm.toString()
            if (alarmstatus == "yes")
            {
                switchEditPlanAlarm.isChecked = true
            }
            else
            {
                //
            }
        })
    }
}