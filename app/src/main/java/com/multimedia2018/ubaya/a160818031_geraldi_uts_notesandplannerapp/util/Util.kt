package com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.util

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.R
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.model.NotesDatabase
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.model.PlannersDatabase
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

fun ImageView.loadImage(url: String?, progressBar:ProgressBar) {

    Picasso.get()
        .load(url)
        .resize(400, 400)
        .centerCrop()
        .error(R.drawable.ic_baseline_error_24)
        .into(this, object:Callback {
            override fun onSuccess() {
                progressBar.visibility = View.GONE
            }
            override fun onError(e: Exception?) {
            }
        })
}

//===============================

val DB_NAME_1 = "notesdb"
val DB_NAME_2 = "plannersdb"

fun buildNotesDb(context: Context) : NotesDatabase {
    val db = Room.databaseBuilder(context, NotesDatabase::class.java, DB_NAME_1).build()
    return db
}

fun buildPlannersDb(context: Context) : PlannersDatabase {
    val db = Room.databaseBuilder(context, PlannersDatabase::class.java, DB_NAME_2)
        .addMigrations(MIGRATIONPLAN_1_2)
        .build()
    return db
}

val MIGRATIONPLAN_1_2 = object : Migration(1,2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "ALTER TABLE planners ADD COLUMN priority INTEGER DEFAULT 3 NOT NULL"
        )
    }
}



