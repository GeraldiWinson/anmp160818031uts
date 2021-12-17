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
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.databinding.FragmentNoteEditBinding
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.model.Notes
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.model.Planners
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.viewmodel.NoteDetailViewModel
import kotlinx.android.synthetic.main.fragment_note_edit.*
import kotlinx.android.synthetic.main.fragment_note_read.*

class NoteEditFragment : Fragment(), NoteSaveChangesClick {
    private lateinit var viewModelDetailNote: NoteDetailViewModel
    private lateinit var dataBinding:FragmentNoteEditBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate<FragmentNoteEditBinding>(inflater, R.layout.fragment_note_edit, container, false)
        return dataBinding.root
        //return inflater.inflate(R.layout.fragment_note_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            var noteId = NoteReadFragmentArgs.fromBundle(requireArguments()).idNote
            viewModelDetailNote = ViewModelProvider(this).get(NoteDetailViewModel::class.java)

            val uuid = NoteEditFragmentArgs.fromBundle(requireArguments()).idNote.toInt()
            viewModelDetailNote.fetch(uuid)
            observeNoteDetailViewModel()

//            btnEdit.setOnClickListener {
//                viewModelDetailNote.update(txtEditPlanTitle.text.toString(), txtEditNoteDesc.text.toString(),
//                    txtEditNoteContent.text.toString(), txtEditNoteImage.text.toString(), uuid)
//                Toast.makeText(view.context, "Note updated", Toast.LENGTH_SHORT).show()
//                Navigation.findNavController(it).popBackStack()
//            }
        }
    }

    fun observeNoteDetailViewModel() {
        viewModelDetailNote.noteLD.observe(viewLifecycleOwner, Observer {
//            txtEditPlanTitle.setText(it.title)
//            txtEditNoteDesc.setText(it.desc)
//            txtEditNoteContent.setText(it.content)
//            txtEditNoteImage.setText(it.photoUrl)
            dataBinding.note = it
            dataBinding.saveListener = this
        })
    }

    override fun onNoteSaveChangesClick(v: View, obj: Notes) {
        viewModelDetailNote.update(obj.title, obj.desc, obj.content, obj.photoUrl, obj.uuid)
        Toast.makeText(v.context, "Note updated", Toast.LENGTH_SHORT).show()
        Navigation.findNavController(v).popBackStack()
    }
}