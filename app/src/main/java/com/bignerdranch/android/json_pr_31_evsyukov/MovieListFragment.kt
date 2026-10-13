package com.bignerdranch.android.json_pr_31_evsyukov

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MovieListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movie_list, container, false)
        val tvOutput = view.findViewById<TextView>(R.id.tvMoviesOutput)

        val movieStorage = MovieStorage(requireContext())

        val movieList = movieStorage.getMovies()

        if (movieList.isEmpty()) {
            tvOutput.text = "В коллекции пока нет сохраненных фильмов"
        } else {
            val stringBuilder = StringBuilder()
            for ((index, movie) in movieList.withIndex()) {
                stringBuilder.append("${index + 1}. ${movie.title}\n")
                stringBuilder.append("Режиссер: ${movie.director}\n")
                stringBuilder.append("Год: ${movie.year} | Жанр: ${movie.genre}\n")
                stringBuilder.append("---------------------------------------\n\n")
            }
            tvOutput.text = stringBuilder.toString()
        }
        return view
    }

}