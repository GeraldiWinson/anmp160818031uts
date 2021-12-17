package com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.R
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.model.Planners
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.viewmodel.PlanDetailViewModel
import kotlinx.android.synthetic.main.fragment_planner_create.*
import kotlinx.android.synthetic.main.plan_list_item.*

class PlannerCreateFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_planner_create, container, false)
    }

    private lateinit var viewModel: PlanDetailViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(PlanDetailViewModel::class.java)

        btnCreatePlan.setOnClickListener {
            var plan = Planners(txtCreatePlanTitle.text.toString(), txtCreatePlanDesc.text.toString(),
                txtCreatePlanDate.text.toString(), txtCreatePlanTime.text.toString(),
                    txtCreatePlanPriority.text.toString().toInt())
            val list = listOf(plan)
            viewModel.addPlan(list)
            Toast.makeText(view.context, "Plan added", Toast.LENGTH_SHORT).show()
            Navigation.findNavController(it).popBackStack()
        }
    }
}