package com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.model.Notes

class NoteListViewModel:ViewModel() {
    val noteLD = MutableLiveData<List<Notes>>()

    fun refresh() {
        val note1 = Notes("1", "Note 1", "Ujicoba deskripsi",
            "lorem ipsum dolor sit amet, blah blah i dont remember lipsum so have some random words instead",
            "http://dummyimage.com/119x100.png/dddddd/000000")
        val note2 = Notes("42", "The Answer of Life", "The true answer to all humanity", "It's 42.",
            "http://dummyimage.com/117x100.png/cc0000/ffffff")
        val note3 = Notes("3", "Three", "About number 3", "Number three is a... number. What did you expect?",
            "http://dummyimage.com/115x100.png/5fa2dd/ffffff")

        val noteList:ArrayList<Notes> = arrayListOf<Notes>(note1, note2, note3)

        noteLD.value = noteList
    }
}