package com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.R
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.databinding.FragmentPlannerEditBinding
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.model.Planners
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.viewmodel.PlanDetailViewModel
import kotlinx.android.synthetic.main.fragment_planner_edit.*

class PlannerEditFragment : Fragment() , PlanSaveChangesClick{
    private lateinit var viewModelDetailPlan : PlanDetailViewModel
    private lateinit var dataBinding : FragmentPlannerEditBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_planner_edit, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModelDetailPlan = ViewModelProvider(this).get(PlanDetailViewModel::class.java)

        val uuid = PlannerEditFragmentArgs.fromBundle(requireArguments()).idPlan.toInt()
        viewModelDetailPlan.fetch(uuid)
        observePlanDetailViewModel()

        btnEditCurrentPlan.setOnClickListener {
            viewModelDetailPlan.update(txtEditPlanTitle.text.toString(), txtEditNoteDesc.text.toString(),
            txtEditPlanDate.text.toString(), txtEditPlanTime.text.toString(), txtEditPlanPriority.text.toString().toInt(), uuid)
            Toast.makeText(view.context, "Plan updated", Toast.LENGTH_SHORT).show()
            Navigation.findNavController(it).popBackStack()
        }
    }

    fun observePlanDetailViewModel() {
        viewModelDetailPlan.planLD.observe(viewLifecycleOwner, Observer {
            dataBinding.planner = it
            dataBinding.saveListener = this
        })
    }

    override fun onPlanSaveChangesClick(v: View, obj: Planners) {
        viewModelDetailPlan.update(obj.title, obj.desc, obj.date, obj.time, obj.priority, obj.uuid)
        Toast.makeText(v.context, "Plan updated", Toast.LENGTH_SHORT).show()
        Navigation.findNavController(v).popBackStack()
    }
}