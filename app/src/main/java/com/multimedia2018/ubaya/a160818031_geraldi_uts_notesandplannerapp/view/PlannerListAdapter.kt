package com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.R
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.model.Planners
import kotlinx.android.synthetic.main.plan_list_item.view.*

class PlannerListAdapter(val plannerList:ArrayList<Planners>) : RecyclerView.Adapter<PlannerListAdapter.PlannerViewHolder>() {
    class PlannerViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    fun updatePlannerList(newPlanList: List<Planners>) {
        plannerList.clear()
        plannerList.addAll(newPlanList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlannerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.plan_list_item, parent, false)

        return PlannerViewHolder(v)
    }

    override fun onBindViewHolder(holder: PlannerViewHolder, position: Int) {
        holder.view.txtPlanTitle.text = plannerList[position].title
        holder.view.txtPlanDesc.text = plannerList[position].desc
        holder.view.txtPlanDate.text = plannerList[position].date
        holder.view.txtPlanTime.text = plannerList[position].time

        holder.view.btnCheck.setOnClickListener {
            val idPlan = plannerList[position].id.toString()
            val act = PlannerMenuFragmentDirections.actionReadPlan(idPlan)
            Navigation.findNavController(it).navigate(act)
        }
    }

    override fun getItemCount(): Int {
        return plannerList.size
    }
}