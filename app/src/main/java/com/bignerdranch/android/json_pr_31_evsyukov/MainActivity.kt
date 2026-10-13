package com.bignerdranch.android.json_pr_31_evsyukov

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson


/*data class Product (
    val name: String,
    val price: Double,
    val tags: List<String>
)*/


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       if (savedInstanceState == null){
           supportFragmentManager.beginTransaction().replace(R.id.fragment_container, LoginFragment()).commit()
       }
    }
}