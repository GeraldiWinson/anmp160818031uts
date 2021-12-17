package com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.view

import android.view.View
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.model.Notes
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.model.Planners

interface NoteReadClick {
    fun onNoteReadClick(v: View)
}

interface NoteEditClick {
    fun onNoteEditClick(v: View)
}

interface NoteSaveChangesClick {
    fun onNoteSaveChangesClick(v:View, obj:Notes)
}
interface PlanReadClick {
    fun onPlanReadClick(v:View)
}

interface PlanEditClick {
    fun onPlanEditClick(v: View)
}

interface PlanSaveChangesClick {
    fun onPlanSaveChangesClick(v:View, obj: Planners)
}