package com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.model.Planners

class PlanListViewModel : ViewModel() {
    val planLD = MutableLiveData<List<Planners>>()

    fun refresh() {
        val plan1 = Planners("1", "Monthly Checkup", "Biasakan teratur cek dokter", "03/02/2021", "10:00", "yes")
        val plan2 = Planners("2", "Tugas UAS", "Dikerjakan ya", "08/10/2021", "23:50", "no")
        val plan3 = Planners("3", "Cari pacar", "ya kali punya awaokwaokwaok", "31/02/20xx", "23:61", "yes")

        val planList:ArrayList<Planners> = arrayListOf<Planners>(plan1, plan2, plan3)
        planLD.value = planList
    }
}