package ru.exercise.myasetapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.exercise.myasetapplication.data.JokeAPI
import ru.exercise.myasetapplication.data.JokeService
import java.util.concurrent.TimeUnit

class CategoriesListViewModel : ViewModel() {
    val baseURL = "https://api.chucknorris.io/"
    private val _jokes: MutableLiveData<List<String>> = MutableLiveData()
    val jokes: LiveData<List<String>> = _jokes
    private val okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .connectTimeout(60, TimeUnit.SECONDS)
        .build()
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseURL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val api = retrofit.create(JokeAPI::class.java)
    private val service = JokeService(api)

    init {
        getCategories()
    }

    fun getCategories() {
        _jokes.value = service.getCategories()
    }
}