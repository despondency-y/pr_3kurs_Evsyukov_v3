package com.bignerdranch.android.json_pr_31_evsyukov

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class MovieStorage(context: Context){
    val sharedPreferences = context.getSharedPreferences("movie_prefs", Context.MODE_PRIVATE)
    val gson = Gson()
    val KEY_MOVIES = "key_movies_list"

    fun saveMovies(movieList: List<Movie>){
        val jsonString = gson.toJson(movieList)
        sharedPreferences.edit().putString(KEY_MOVIES, jsonString).apply()
    }

    fun getMovies(): List<Movie>{
        val jsonString = sharedPreferences.getString(KEY_MOVIES, "[]")
        val listType = object : TypeToken<List<Movie>>(){}.type

        return gson.fromJson(jsonString, listType) ?: emptyList()
    }
}