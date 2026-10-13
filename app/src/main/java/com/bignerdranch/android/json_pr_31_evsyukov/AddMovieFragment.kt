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
import android.widget.Toast


class AddMovieFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_movie, container, false)

        val etTitle = view.findViewById<EditText>(R.id.etMovieTitle)
        val etDirector = view.findViewById<EditText>(R.id.etMovieDirector)
        val etYear = view.findViewById<EditText>(R.id.etMovieYear)
        val etGenre = view.findViewById<EditText>(R.id.etMovieGenre)
        val btnSave = view.findViewById<Button>(R.id.btnSaveMovie)
        val btnShow = view.findViewById<Button>(R.id.btnShowCollection)

        val movieStorage = MovieStorage(requireContext())

        btnSave.setOnClickListener {
            val title = etTitle.text.toString()
            val director = etDirector.text.toString()
            val yearString = etYear.text.toString()
            val genre = etGenre.text.toString()

            if (title.isEmpty() || director.isEmpty() || yearString.isEmpty() || genre.isEmpty()){
                Toast.makeText(requireContext(), "Заполните все поля", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val year = yearString.toIntOrNull() ?: 0

            val currentMovies = movieStorage.getMovies().toMutableList()

            val newMovie = Movie(title, director, year, genre)
            currentMovies.add(newMovie)

            movieStorage.saveMovies(currentMovies)

            Toast.makeText(requireContext(), "Фильм $title добавлен", Toast.LENGTH_SHORT).show()
            etTitle.text.clear()
            etDirector.text.clear()
            etYear.text.clear()
            etGenre.text.clear()
        }

        btnShow.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fragment_container, MovieListFragment()).addToBackStack(null).commit()
        }


        return view
    }
}