package com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.model

data class Notes(
    val id:String?,
    val title:String?,
    val desc:String?,
    val content:String?,
    val photoUrl:String?
)

data class Planners(
    val id:String?,
    val title:String?,
    val desc:String?,
    val date:String?,
    val time:String?,
    val alarm:String?
)