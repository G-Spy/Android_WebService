package fr.epita.webservice

import retrofit2.Call
import retrofit2.http.GET

interface WSInterface {

    @GET("todos")
    fun getAllTodos (): Call<List<ToDoModel>>
}