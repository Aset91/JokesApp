package ru.exercise.myasetapplication.data

import retrofit2.http.GET
import retrofit2.Response

interface JokeAPI {
    @GET("jokes/categories")
    fun getCategories() : Response<List<String>>
}