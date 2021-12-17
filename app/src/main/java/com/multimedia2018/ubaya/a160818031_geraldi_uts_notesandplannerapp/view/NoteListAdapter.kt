package com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.R
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.model.Notes
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.util.loadImage
import kotlinx.android.synthetic.main.note_list_item.view.*

class NoteListAdapter(val noteList:ArrayList<Notes>) : RecyclerView.Adapter<NoteListAdapter.NoteViewHolder> ()
{
    class NoteViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    fun updateNoteList(newNoteList: List<Notes>) {
        noteList.clear()
        noteList.addAll(newNoteList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.note_list_item, parent, false)

        return NoteViewHolder(v)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        /*holder.view.txtCreateNoteTitle.text = noteList[position].title
        holder.view.txtCreateNoteDesc.text = noteList[position].desc
        holder.view.imgNoteList.loadImage(noteList[position].photoUrl, holder.view.progressBar)

        holder.view.btnRead.setOnClickListener {
            var idNote = noteList[position].id.toString()
            val action = NoteMenuFragmentDirections.actionReadNote(idNote)
            Navigation.findNavController(it).navigate(action)
        }*/

        holder.view.txtCreateNoteTitle.setText(noteList[position].title)
        holder.view.txtCreateNoteDesc.setText(noteList[position].desc)
        holder.view.imgNoteList.loadImage(noteList[position].photoUrl, holder.view.progressBar)

        holder.view.btnRead.setOnClickListener {
            var idNote = noteList[position].uuid.toString()
            val action = NoteMenuFragmentDirections.actionReadNote(idNote)
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return noteList.size
    }
}