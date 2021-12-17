package com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.model.Notes
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.model.NotesDatabase
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.model.Planners
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.model.PlannersDatabase
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.util.buildPlannersDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class PlanDetailViewModel(application: Application) : AndroidViewModel(application),
    CoroutineScope {
    val planLD = MutableLiveData<Planners>()
    private val job = Job()

    fun fetch(uuid: Int)
    {
        launch {
            val db = buildPlannersDb(getApplication())
            planLD.value = db.plannersDao().selectPlan(uuid)
        }
    }

    fun addPlan(list: List<Planners>)
    {
        launch {
            val db = buildPlannersDb(getApplication())
            db.plannersDao().insertAllPlans(*list.toTypedArray())
        }
    }

    /*fun clearPlan(planners: Planners) {
        launch {
            val db = buildPlannersDb(getApplication())
            db.plannersDao().deletePlan(planners)
        }
    }*/

    //Menghapus plan dengan mendelete plan pilihan lalu men-refresh kembali tampilan
    fun deletePlan(uuid: Int) {
        launch {
            val db = buildPlannersDb(getApplication())
            db.plannersDao().deletePlan(uuid)
        }
    }

    fun update(title:String, desc:String, date:String, time:String, priority:Int, uuid:Int) {
        launch {
            val db = buildPlannersDb(getApplication())
            db.plannersDao().updatePlan(title, desc, date, time, priority, uuid)
        }
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
}
