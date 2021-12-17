package com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.R
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.databinding.PlanListItemBinding
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.model.Planners
import kotlinx.android.synthetic.main.plan_list_item.view.*

class PlannerListAdapter(val plannerList:ArrayList<Planners>) : RecyclerView.Adapter<PlannerListAdapter.PlannerViewHolder>(),
    PlanReadClick
{
    class PlannerViewHolder(var view:PlanListItemBinding) : RecyclerView.ViewHolder(view.root)

    fun updatePlannerList(newPlanList: List<Planners>) {
        plannerList.clear()
        plannerList.addAll(newPlanList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlannerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = DataBindingUtil.inflate<PlanListItemBinding>(inflater, R.layout.plan_list_item, parent, false)

        return PlannerViewHolder(v)
    }

    override fun onBindViewHolder(holder: PlannerViewHolder, position: Int) {
        holder.view.planner = plannerList[position]
        holder.view.readListener = this
    }

    override fun getItemCount(): Int {
        return plannerList.size
    }

    override fun onPlanReadClick(v: View) {
        val uuid = v.tag.toString()
        val action = PlannerMenuFragmentDirections.actionReadPlan(uuid)
        Navigation.findNavController(v).navigate(action)
    }
}