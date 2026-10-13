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

class LoginFragment : Fragment() {
    override  fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        val etUsername = view.findViewById<EditText>(R.id.etUsername)
        val btnLogin = view.findViewById<Button>(R.id.btnLogin)
        val sharedPrefs = requireActivity().getSharedPreferences("auth_prefs", Context.MODE_PRIVATE)

        btnLogin.setOnClickListener{
           val username = etUsername.text.toString().trim()

           if(username.isEmpty()){
               etUsername.error = "Заполните имя пользователя"
               Toast.makeText(requireContext(), "Пожалуйста заполните поле", Toast.LENGTH_SHORT).show()
           }
            else{
                sharedPrefs.edit().putString("saved_username",username).apply()
               Toast.makeText(requireContext(), "Здрайвствуйте, $username!", Toast.LENGTH_SHORT).show()
               requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fragment_container, AddMovieFragment()).commit()
           }
        }
     return view
    }
}