package com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.R
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.databinding.NoteListItemBinding
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.model.Notes
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.util.loadImage
import kotlinx.android.synthetic.main.note_list_item.view.*

class NoteListAdapter(val noteList:ArrayList<Notes>) : RecyclerView.Adapter<NoteListAdapter.NoteViewHolder>(),
    NoteReadClick
{
    class NoteViewHolder(var view: NoteListItemBinding) : RecyclerView.ViewHolder(view.root)

    fun updateNoteList(newNoteList: List<Notes>) {
        noteList.clear()
        noteList.addAll(newNoteList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = DataBindingUtil.inflate<NoteListItemBinding>(inflater, R.layout.note_list_item, parent, false)

        return NoteViewHolder(v)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.view.note = noteList[position]
        holder.view.readListener = this

        holder.view.imgNoteList.loadImage(noteList[position].photoUrl, holder.view.progressBar)
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    override fun onNoteReadClick(v: View) {
        val uuid = v.tag.toString()
        val action = NoteMenuFragmentDirections.actionReadNote(uuid)
        Navigation.findNavController(v).navigate(action)
    }
}