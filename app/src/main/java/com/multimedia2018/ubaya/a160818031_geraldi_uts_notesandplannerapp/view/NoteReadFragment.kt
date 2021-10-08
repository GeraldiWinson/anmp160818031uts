package com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.R
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.util.loadImage
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.viewmodel.NoteDetailViewModel
import kotlinx.android.synthetic.main.fragment_note_read.*
import kotlinx.android.synthetic.main.note_list_item.view.*

class NoteReadFragment : Fragment() {
    private lateinit var viewModelDetailNote: NoteDetailViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_note_read, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            var noteId = NoteReadFragmentArgs.fromBundle(requireArguments()).idNote
            viewModelDetailNote = ViewModelProvider(this).get(NoteDetailViewModel::class.java)
            viewModelDetailNote.fetchData()
            observeNoteDetailViewModel()
        }

        btnEditNote.setOnClickListener {
            var id = viewModelDetailNote.noteDetailLD.value?.id.toString()
            val action = NoteReadFragmentDirections.actionEditNote(id)
            Navigation.findNavController(it).navigate(action)
        }
    }

    fun observeNoteDetailViewModel() {
        viewModelDetailNote.noteDetailLD.observe(viewLifecycleOwner, Observer {
            txtReadNoteTitle.setText(viewModelDetailNote.noteDetailLD.value?.title)
            txtReadNoteDesc.setText(viewModelDetailNote.noteDetailLD.value?.desc)
            txtReadNoteContent.setText(viewModelDetailNote.noteDetailLD.value?.content)
            imgReadNote.loadImage(viewModelDetailNote.noteDetailLD.value?.photoUrl, progressBar2)
        })
    }
}