package com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.model.Notes
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.model.NotesDatabase
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.util.buildNotesDb
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.util.buildPlannersDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class NoteDetailViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {
    val noteLD = MutableLiveData<Notes>()
    private val job = Job()

    fun fetch(uuid: Int) {
        launch {
            val db = buildNotesDb(getApplication())
            noteLD.value = db.notesDao().selectNote(uuid)
        }
    }

    fun addNote(list: List<Notes>) {
        launch {
            val db = buildNotesDb(getApplication())
            db.notesDao().insertAllNotes(*list.toTypedArray())
        }
    }

    /*fun clearNote(notes: Notes) {
        launch {
            val db = buildNotesDb(getApplication())
            db.notesDao().deleteNote(notes)
        }
    }*/

    //Menghapus note dengan mendelete note pilihan lalu men-refresh kembali tampilan
    fun deleteNote(uuid: Int) {
        launch {
            val db = buildNotesDb(getApplication())
            db.notesDao().deleteNote(uuid)
        }
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
}