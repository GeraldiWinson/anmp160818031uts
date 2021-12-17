package com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.R
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.model.Planners
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.viewmodel.NoteDetailViewModel
import kotlinx.android.synthetic.main.fragment_note_edit.*
import kotlinx.android.synthetic.main.fragment_note_read.*

class NoteEditFragment : Fragment() {
    private lateinit var viewModelDetailNote: NoteDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_note_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            var noteId = NoteReadFragmentArgs.fromBundle(requireArguments()).idNote
            viewModelDetailNote = ViewModelProvider(this).get(NoteDetailViewModel::class.java)

            val uuid = NoteEditFragmentArgs.fromBundle(requireArguments()).idNote.toInt()
            viewModelDetailNote.fetch(uuid)
            observeNoteDetailViewModel()
        }
    }

    fun observeNoteDetailViewModel() {
        viewModelDetailNote.noteLD.observe(viewLifecycleOwner, Observer {
            txtEditPlanTitle.setText(it.title)
            txtEditNoteDesc.setText(it.desc)
            txtEditNoteContent.setText(it.content)
            txtEditNoteImage.setText(it.photoUrl)
        })
    }
}