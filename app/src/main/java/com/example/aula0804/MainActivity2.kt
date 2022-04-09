package com.example.aula0804

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val message = intent.getStringExtra("atributos")

        val mt = findViewById<ListView>(R.id.lista)

        mt.text = message
    }
}