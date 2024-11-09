package com.example.ermayuni.sharedprefrencesexample

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ermayuni.sharedprefrencesexample.databinding.ActivityMainBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object {
        const val RPL = "RPL" // Konstanta nama file SharedPreferences
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Tombol untuk menyimpan data ke SharedPreferences
        binding.btnSave.setOnClickListener {
            val filename = "$packageName-$RPL"
            val pref = getSharedPreferences(filename, Context.MODE_PRIVATE)
            val editor = pref.edit()

            // Menyimpan data "Erma" sebagai firstName dan "Yuni" sebagai lastName
            editor.putString("firstName", "Erma")
            editor.putString("lastName", "Yuni")
            editor.apply() // Menyimpan data secara asinkron

            // Intent untuk membuka SecondActivity
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}
