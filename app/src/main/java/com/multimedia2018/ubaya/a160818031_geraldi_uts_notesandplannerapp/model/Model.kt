package com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Notes(
    @ColumnInfo(name="title")
    val title:String,
    @ColumnInfo(name="desc")
    val desc:String,
    @ColumnInfo(name="content")
    val content:String,
    @ColumnInfo(name="photoUrl")
    val photoUrl:String
) {
    @PrimaryKey(autoGenerate = true)
    var uuid:Int = 0
}

@Entity
data class Planners(
    @ColumnInfo(name="title")
    val title:String,
    @ColumnInfo(name="desc")
    val desc:String,
    @ColumnInfo(name="date")
    val date:String,
    @ColumnInfo(name="time")
    val time:String,
    @ColumnInfo(name="priority")
    val priority:Int
) {
    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0
}