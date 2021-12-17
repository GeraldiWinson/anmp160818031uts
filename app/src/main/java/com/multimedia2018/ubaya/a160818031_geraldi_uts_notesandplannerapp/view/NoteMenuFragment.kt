package com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.R
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.viewmodel.NoteListViewModel
import kotlinx.android.synthetic.main.fragment_note_menu.*

class NoteMenuFragment : Fragment() {
    private lateinit var viewModelNote: NoteListViewModel
    private val noteListAdapter = NoteListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_note_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModelNote = ViewModelProvider(this).get(NoteListViewModel::class.java)
        viewModelNote.refresh()

        recViewNote.layoutManager = LinearLayoutManager(context)
        recViewNote.adapter = noteListAdapter

        fabCreateNote.setOnClickListener{
            val action = NoteMenuFragmentDirections.actionCreateNote()
            Navigation.findNavController(it).navigate(action)
        }

        observeViewModel()
    }

    fun observeViewModel() {
        viewModelNote.noteLD.observe(viewLifecycleOwner, Observer {
            noteListAdapter.updateNoteList(it)
        })
    }
}