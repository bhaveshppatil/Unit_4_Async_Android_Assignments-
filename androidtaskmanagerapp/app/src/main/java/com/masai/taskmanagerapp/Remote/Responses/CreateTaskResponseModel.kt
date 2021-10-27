package com.masai.taskmanagerapp.Remote.Responses

data class CreateTaskResponseModel(
    val __v: Int,
    val _id: String,
    val createdAt: String,
    val description: String,
    val owner: String,
    val status: Int,
    val title: String,
    val updatedAt: String
)