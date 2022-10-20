package ru.exercise.myasetapplication.data

import retrofit2.Response

class JokeService(private val api: JokeAPI) {
    fun getCategories(): List<String> {
        val response : Response<List<String>> = api.getCategories()
        val categories = response.body()
        return categories ?: listOf()
    }
}