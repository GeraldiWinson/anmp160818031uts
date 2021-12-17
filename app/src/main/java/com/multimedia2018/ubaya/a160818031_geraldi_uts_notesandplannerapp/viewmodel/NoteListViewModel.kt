package com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.model.Notes
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.model.NotesDatabase
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.util.buildNotesDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/*class NoteListViewModel:ViewModel() {
    val noteLD = MutableLiveData<List<Notes>>()

    fun refresh() {
        val note1 = Notes("Note 1", "Ujicoba deskripsi",
            "lorem ipsum dolor sit amet, blah blah i dont remember lipsum so have some random words instead",
            "http://dummyimage.com/119x100.png/dddddd/000000")
        val note2 = Notes("The Answer of Life", "The true answer to all humanity", "It's 42.",
            "http://dummyimage.com/117x100.png/cc0000/ffffff")
        val note3 = Notes("Three", "About number 3", "Number three is a... number. What did you expect?",
            "http://dummyimage.com/115x100.png/5fa2dd/ffffff")

        val noteList:ArrayList<Notes> = arrayListOf<Notes>(note1, note2, note3)

        noteLD.value = noteList
    }
}*/

class NoteListViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {
    val noteLD = MutableLiveData<List<Notes>>()
    val noteLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    private var job = Job()
    override val coroutineContext: CoroutineContext
    get() = job + Dispatchers.Main

    //Refresh livedata dengan mengambil kembali semua data note di DB
    fun refresh() {
        loadingLD.value = true
        noteLoadErrorLD.value = false
        launch {
            //val db = Room.databaseBuilder(getApplication(), NotesDatabase::class.java, "notesdb").build()
            val db = buildNotesDb(getApplication())
            noteLD.value = db.notesDao().selectAllNotes()
        }
    }

    //Menghapus note dengan mendelete note pilihan lalu men-refresh kembali tampilan
    fun clearNote(notes: Notes) {
        launch {
            //al db = Room.databaseBuilder(getApplication(), NotesDatabase::class.java,"notesdb").build()
            val db = buildNotesDb(getApplication())
            db.notesDao().deleteNote(notes)
            noteLD.value = db.notesDao().selectAllNotes()
        }
    }

    //==================
}
