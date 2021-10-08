package com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.model.Notes

class NoteListViewModel:ViewModel() {
    val noteLD = MutableLiveData<List<Notes>>()

    fun refresh() {
        val note1 = Notes("1", "Note 1", "Ujicoba deskripsi",
            "lorem ipsum dolor sit amet, blah blah i dont remember lipsum so have some random words instead",
            "https://konstfabrik.fi/wp-content/uploads/2018/05/SISUSTUSJULISTE-KIRJAIMET-NUMEROT-TEKSTIT-LOREM-IPSUM-1a.jpg")
        val note2 = Notes("42", "The Answer of Life", "The true answer to all humanity", "It's 42.",
            "https://i1.sndcdn.com/artworks-nwH9Ygn9YBMFPyRZ-rUeeZw-t500x500.jpg")
        val note3 = Notes("3", "Three", "About number 3", "Number three is a... number. What did you expect?",
            "https://thumbs.dreamstime.com/b/number-three-logo-design-vector-template-ribbon-font-style-typography-168208038.jpg")

        val noteList:ArrayList<Notes> = arrayListOf<Notes>(note1, note2, note3)

        noteLD.value = noteList
    }
}