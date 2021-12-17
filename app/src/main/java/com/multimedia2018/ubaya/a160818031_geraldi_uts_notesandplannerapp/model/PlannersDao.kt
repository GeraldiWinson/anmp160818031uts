package com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.model

import androidx.room.*

@Dao
interface PlannersDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPlans(vararg planners: Planners)

    @Query("SELECT * FROM planners ORDER BY priority ASC")
    suspend fun selectAllPlans(): List<Planners>

    @Query("SELECT * FROM planners WHERE uuid = :id")
    suspend fun selectPlan(id:Int) : Planners

    @Query
    ("UPDATE planners SET title = :title, desc = :desc, date = :date, time = :time, priority = :priority WHERE uuid = :id")
    suspend fun updatePlan(title:String, desc:String, date:String, time:String, priority:Int, id:Int)

    @Query
    ("DELETE FROM planners WHERE uuid = :id")
    suspend fun deletePlan(id:Int)

    @Delete
    suspend fun deletePlan(planners: Planners)
}