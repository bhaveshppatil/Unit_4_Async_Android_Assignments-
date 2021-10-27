package com.masai.taskmanagerapp.Remote.Request

data class CreatetaskRequestModel(
    val description: String,
    val status: Int,
    val title: String
)