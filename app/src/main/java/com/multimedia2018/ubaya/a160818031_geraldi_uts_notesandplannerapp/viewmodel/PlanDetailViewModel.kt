package com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.model.Planners

class PlanDetailViewModel: ViewModel() {
    val planLD = MutableLiveData<Planners>()

    fun fetch() {
        val singleplan = Planners("1","Lipsum", "Lorem ipsum dolor sit amet", "31/12/20xx", "23:59", "yes")

        planLD.value = singleplan
    }
}