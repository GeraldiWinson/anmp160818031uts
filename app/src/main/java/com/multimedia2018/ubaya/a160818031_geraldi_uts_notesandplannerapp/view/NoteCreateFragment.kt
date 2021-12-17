package com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.R
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.model.Notes
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.viewmodel.NoteDetailViewModel
import kotlinx.android.synthetic.main.fragment_note_create.*

class NoteCreateFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_note_create, container, false)
    }

    private lateinit var viewModel: NoteDetailViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(NoteDetailViewModel::class.java)

        btnCreateNote.setOnClickListener {
            var note = Notes(txtCreateNoteTitle.text.toString(), txtCreateNoteDesc.text.toString(),
                txtCreateNoteContent.text.toString(), txtCreateNoteImage.text.toString())
            val list =  listOf(note)
            viewModel.addNote(list)
            Toast.makeText(view.context, "Note added", Toast.LENGTH_SHORT).show()
            Navigation.findNavController(it).popBackStack()
        }
    }

    //=========================
}