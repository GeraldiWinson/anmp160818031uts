package com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.model.Planners
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.model.PlannersDatabase
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.util.buildPlannersDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/*
class PlanListViewModel : ViewModel() {
    val planLD = MutableLiveData<List<Planners>>()

    fun refresh() {
        val plan1 = Planners("1", "Monthly Checkup", "Biasakan teratur cek dokter", "03/02/2021", "10:00", "yes")
        val plan2 = Planners("2", "Tugas UAS", "Dikerjakan ya", "08/10/2021", "23:50", "no")
        val plan3 = Planners("3", "Cari pacar", "ya kali punya awaokwaokwaok", "31/02/20xx", "23:61", "yes")

        val planList:ArrayList<Planners> = arrayListOf<Planners>(plan1, plan2, plan3)
        planLD.value = planList
    }
}*/

class PlanListViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {
    val planLD = MutableLiveData<List<Planners>>()
    val planLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    private var job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    //Refresh livedata dengan mengambil kembali semua data planner di DB
    fun refresh() {
        loadingLD.value = true
        planLoadErrorLD.value = false
        launch {
            //val db = Room.databaseBuilder(getApplication(), PlannersDatabase::class.java, "plannersdb").build()
            val db = buildPlannersDb(getApplication())
            planLD.value = db.plannersDao().selectAllPlans()
        }
    }

    //Menghapus plan dengan mendelete plan pilihan lalu men-refresh kembali tampilan
    fun clearPlan(planners: Planners) {
        launch {
            //val db = Room.databaseBuilder(getApplication(), PlannersDatabase::class.java,"plannersdb").build()
            val db = buildPlannersDb(getApplication())
            db.plannersDao().deletePlan(planners)
            planLD.value = db.plannersDao().selectAllPlans()
        }
    }

    //==================
}
