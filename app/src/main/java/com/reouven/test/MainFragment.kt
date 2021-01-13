package com.reouven.test


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainFragment : Fragment() {
    lateinit var adapter: MainAdapter
    lateinit var recyclerView: RecyclerView
    //lateinit var driverId :String

    val viewModel: MainViewModel by lazy { ViewModelProviders.of(this).get(MainViewModel::class.java) }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       return inflater.inflate(R.layout.fragment_user_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        adapter = MainAdapter()

        recyclerView = view.findViewById(R.id.rv)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
        observer()
        view.findViewById<Button>(R.id.button).setOnClickListener {
            Toast.makeText(
                this.activity,
                "please enter data",
                Toast.LENGTH_LONG
            ).show()
            findNavController().navigate(R.id.action_mainFragment_to_blankFragment)
        }
        super.onViewCreated(view, savedInstanceState)
    }

    fun observer(){
        viewModel.fetchUserData().observe(this.requireActivity(), Observer {
            adapter.setListData(it)
            adapter.notifyDataSetChanged()
        })
    }

}