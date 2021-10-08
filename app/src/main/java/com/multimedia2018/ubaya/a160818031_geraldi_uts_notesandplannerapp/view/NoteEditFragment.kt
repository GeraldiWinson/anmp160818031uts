package com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.R
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.viewmodel.NoteDetailViewModel
import kotlinx.android.synthetic.main.fragment_note_edit.*

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
            viewModelDetailNote.fetchData()
            observeNoteDetailViewModel()
        }
    }

    fun observeNoteDetailViewModel() {
        viewModelDetailNote.noteDetailLD.observe(viewLifecycleOwner, Observer {
            txtEditNoteID.setText(viewModelDetailNote.noteDetailLD.value?.id)
            txtEditPlanTitle.setText(viewModelDetailNote.noteDetailLD.value?.title)
            txtEditPlanDesc.setText(viewModelDetailNote.noteDetailLD.value?.desc)
            txtEditNoteContent.setText(viewModelDetailNote.noteDetailLD.value?.content)
            txtEditNoteImage.setText(viewModelDetailNote.noteDetailLD.value?.photoUrl)
        })
    }
}