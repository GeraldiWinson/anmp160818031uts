package com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Notes(
    @ColumnInfo(name="title")
    var title:String,
    @ColumnInfo(name="desc")
    var desc:String,
    @ColumnInfo(name="content")
    var content:String,
    @ColumnInfo(name="photoUrl")
    var photoUrl:String
) {
    @PrimaryKey(autoGenerate = true)
    var uuid:Int = 0
}

@Entity
data class Planners(
    @ColumnInfo(name="title")
    var title:String,
    @ColumnInfo(name="desc")
    var desc:String,
    @ColumnInfo(name="date")
    var date:String,
    @ColumnInfo(name="time")
    var time:String,
    @ColumnInfo(name="priority")
    var priority:Int
) {
    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0
}