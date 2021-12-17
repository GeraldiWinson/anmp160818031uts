package com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.model

import androidx.room.*

@Dao
interface NotesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllNotes(vararg notes:Notes)

    @Query("SELECT * FROM notes")
    suspend fun selectAllNotes(): List<Notes>

    @Query("SELECT * FROM notes WHERE uuid = :id")
    suspend fun selectNote(id:Int) : Notes

    @Query
    ("UPDATE notes SET title = :title, desc = :desc, content = :content, photoUrl = :photoUrl WHERE uuid = :id")
    suspend fun updateNote(title:String, desc:String, content:String, photoUrl:String, id:Int)

    @Query
    ("DELETE FROM notes WHERE uuid = :id")
    suspend fun deleteNote(id:Int)

    @Delete
    suspend fun deleteNote(notes: Notes)
}

/*
title
desc
content
photoUrl
uuid
}*/
