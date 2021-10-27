package com.masai.taskmanagerapp.Remote

import com.masai.taskmanagerapp.Remote.Request.CreatetaskRequestModel
import com.masai.taskmanagerapp.Remote.Request.LoginRequestModel
import com.masai.taskmanagerapp.Remote.Responses.CreateTaskResponseModel
import com.masai.taskmanagerapp.Remote.Responses.GetTasksResponseModel
import com.masai.taskmanagerapp.Remote.Responses.LoginResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface TaskApi {

    //@Headers("Accept: application/json")
    @POST("users/login")
    suspend fun login(
        @Body loginRequest: LoginRequestModel
    ): LoginResponse

    @GET("tasks")
    suspend fun getTasksFromAPI(
        @Header("Authorization") token: String
    ): GetTasksResponseModel

    @POST("tasks")
    suspend fun createTask(
        @Header("Authorization") token: String,
        @Body createtaskRequestModel: CreatetaskRequestModel
    ): CreateTaskResponseModel

    /*@POST("/v2/courses/new")
    suspend fun signUp(
        @Header("Authorization") authToken: String?,
        @Body createNewCourseRequest: CreateNewCourseRequest
    ): CreateNewCourseResponse
    @GET("app/android/version")
    suspend fun getAllTasks(
        @Header("Content-Type") contentType: String
    ): ForceUpdateAppResponseModel*/
    /*@POST("v2/data/{code}/register")
    suspend fun getPostPaymentDetails(
        @Header("Authorization") authToken: String?,
        @Path("code") code: String,
        @Body postPaymentRequestModel: PostPaymentRequestModel
    ): PostPaymentRequestModel*/
    /*@GET("/v2/videos/generate-live-token")
    suspend fun getLiveToken(
        @Header("Authorization") token: String,
        @Header("Content-Type") contentType: String,
        @Query("l_id") lessonId: String,
        @Query("user_id") userId: String,
        @Query("role") role: String
    :disappointed: GetLiveTokenResponseModel*/
}