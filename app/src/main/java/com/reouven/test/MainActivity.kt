package com.reouven.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var adapter: MainAdapter
    lateinit var recyclerView: RecyclerView
    val viewModel:MainViewModel by lazy { ViewModelProviders.of(this).get(MainViewModel::class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = MainAdapter(this)

        recyclerView = findViewById(R.id.rv)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        observer()

    }
    fun observer(){
        viewModel.fetchUserData().observe(this, Observer {
            adapter.setListData(it)
            adapter.notifyDataSetChanged()
        })
    }
}