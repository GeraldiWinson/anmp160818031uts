package com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.util.MIGRATIONPLAN_1_2

@Database(entities = arrayOf(Planners::class), version = 2)
abstract class PlannersDatabase:RoomDatabase() {
    abstract fun plannersDao(): PlannersDao

    companion object
    {
        //========
        @Volatile private var instance: PlannersDatabase ?= null
        private val LOCK = Any()
        private fun buildDatabase(context:Context) =
            Room.databaseBuilder(context.applicationContext, PlannersDatabase::class.java, "plannersdb")
                .addMigrations(MIGRATIONPLAN_1_2)
                .build()

        operator fun invoke(context:Context)
        {
            if(instance != null) {
                synchronized(LOCK) {
                    instance ?: buildDatabase(context).also {
                        instance = it
                    }
                }
            }
        }
        //===========
    }

}
