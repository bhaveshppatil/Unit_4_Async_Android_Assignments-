package com.masai.taskmanagerapp.repository

import androidx.lifecycle.LiveData
import com.masai.taskmanagerapp.Remote.Network
import com.masai.taskmanagerapp.Remote.Request.CreatetaskRequestModel
import com.masai.taskmanagerapp.Remote.Request.ResponseHandler
import com.masai.taskmanagerapp.Remote.Responses.GetTasksResponseModel
import com.masai.taskmanagerapp.Remote.TaskApi
import com.masai.taskmanagerapp.models.Task
import com.masai.taskmanagerapp.models.TaskappDAO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskRepo(private val taskDAO: TaskappDAO) {


    private val retrofitAPI = Network.getRetrofit().create(TaskApi::class.java)
    private val responseHandler = ResponseHandler()
    private val token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MTRjYzk1NGYwNDg1NDBiNWMxNDkzNzciLCJpYXQiOjE2MzUzMzI2NTl9.diTLyDE-b52k3SQ5iQJKYS0WrYDR9T3V2mRlxhedyo8"

    //get the task from api
    fun getRemoteTask() {
        CoroutineScope(Dispatchers.IO).launch {
            //response -
            val response = retrofitAPI.getTasksFromAPI(token)
            saveToLocalDB(response)
        }
    }

    //storing api data to local database, offline use
    private fun saveToLocalDB(response: GetTasksResponseModel) {
        response.forEach {
            val taskData = Task(it.title, it.description)
            addTaskToRoom(taskData)
        }
    }

    fun addTaskToRoom(task: Task) {
        CoroutineScope(Dispatchers.IO).launch {
            taskDAO.addTask(task)
        }
    }

    fun getAllTasks(): LiveData<List<Task>> {
        return taskDAO.getTasks()
    }

    fun updateTask(task: Task) {
        CoroutineScope(Dispatchers.IO).launch {
            taskDAO.updateTask(task)
        }
    }

    fun deleteTask(task: Task) {
        CoroutineScope(Dispatchers.IO).launch {
            taskDAO.delete(task)
        }
    }

    fun createTaskAPI(createtaskRequestModel: CreatetaskRequestModel) {
        CoroutineScope(Dispatchers.IO).launch {
           retrofitAPI.createTask(token, createtaskRequestModel)
            addTaskToRoom(Task(createtaskRequestModel.title, createtaskRequestModel.description))
        }
    }
}