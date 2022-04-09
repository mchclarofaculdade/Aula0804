package com.example.aula0804

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var lista = findViewById<ListView>(R.id.lista)
        var n: ArrayList<String> = ArrayList<String>();
        n.add("1")
        n.add("2")
        n.add("3")
        n.add("4")
        n.add("5")
        n.add("6")
        n.add("7")
        n.add("8")
        n.add("9")
        n.add("10")

        var adapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, n)
        lista.adapter = adapter
        lista.onItemClickListener = AdapterView.OnItemClickListener{ _, _, all, id ->
            var url = "https://jsonplaceholder.typicode.com/users/${n[id.toInt()]}"
            Toast.makeText(this, url, Toast.LENGTH_LONG).show()
            var i = Intent(this, MainActivity2::class.java).apply {
            }
            startActivity(i)
        }

        /*lista.onItemClickListener = AdapterView.OnItemClickListener{ _, _, title, id ->
            Toast.makeText(this, "title: "+ title, Toast.LENGTH_LONG).show()
        }*/

        var url = "https://jsonplaceholder.typicode.com/users/${lista.id}"
        Toast.makeText(this, url, Toast.LENGTH_LONG).show()
        var jsonRequest = JsonObjectRequest(
            Request.Method.GET,url,null,
            Response.Listener { response ->
                n.add("Response is: ${response.toString()}")
                adapter!!.notifyDataSetChanged()
            },
            Response.ErrorListener { error ->
                print("That didn't work!")
            })

        var url2 = "https://jsonplaceholder.typicode.com/users/X/posts"
        var jsonRequest2 = JsonObjectRequest(
            Request.Method.GET,url2,null,
            Response.Listener { response ->
                n.add("Response is: ${response.toString()}")
                adapter!!.notifyDataSetChanged()
            },
            Response.ErrorListener { error ->
                print("That didn't work!")
            })

    }
}