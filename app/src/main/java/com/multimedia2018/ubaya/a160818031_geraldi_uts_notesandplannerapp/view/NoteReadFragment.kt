package com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.R
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.databinding.FragmentNoteReadBinding
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.util.loadImage
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.viewmodel.NoteDetailViewModel
import kotlinx.android.synthetic.main.fragment_note_read.*
import kotlinx.android.synthetic.main.note_list_item.view.*

class NoteReadFragment : Fragment(), NoteEditClick {
    private lateinit var viewModelDetailNote: NoteDetailViewModel
    private lateinit var dataBinding:FragmentNoteReadBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate<FragmentNoteReadBinding>(inflater, R.layout.fragment_note_read, container, false)
        //return inflater.inflate(R.layout.fragment_note_read, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            viewModelDetailNote = ViewModelProvider(this).get(NoteDetailViewModel::class.java)

            val uuid = NoteReadFragmentArgs.fromBundle(requireArguments()).idNote.toInt()
            viewModelDetailNote.fetch(uuid)
            observeNoteDetailViewModel()

//            btnEditNote.setOnClickListener {
//                var id = viewModelDetailNote.noteLD.value?.uuid.toString()
//                val action = NoteReadFragmentDirections.actionEditNote(id)
//                Navigation.findNavController(it).navigate(action)
//            }

            btnClearNote.setOnClickListener {
                viewModelDetailNote.deleteNote(uuid)
                Navigation.findNavController(it).popBackStack()
                Toast.makeText(view.context, "Note deleted", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun observeNoteDetailViewModel() {
        viewModelDetailNote.noteLD.observe(viewLifecycleOwner, Observer {
            dataBinding.note = it
            dataBinding.editListener = this
//            txtReadNoteTitle.setText(it.title)
//            txtReadNoteDesc.setText(it.desc)
//            txtReadNoteContent.setText(it.content)
            imgReadNote.loadImage(it.photoUrl, progressBar2)
        })
    }

    override fun onNoteEditClick(v: View) {
        val uuid = v.tag.toString()
        val action = NoteReadFragmentDirections.actionEditNote(uuid)
        Navigation.findNavController(v).navigate(action)
    }
}