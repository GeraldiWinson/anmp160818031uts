package com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.model.Notes

class NoteDetailViewModel: ViewModel() {
    val noteDetailLD = MutableLiveData<Notes>()

    fun fetchData() {
        val singlenote = Notes("1", "Lorem Ipsum", "Lorem ipsum dolor sit amet",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
        "http://dummyimage.com/115x100.png/5fa2dd/ffffff")

        noteDetailLD.value = singlenote
    }
}