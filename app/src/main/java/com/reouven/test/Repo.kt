package com.reouven.test

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.*

class Repo {
    fun getUserData():LiveData<MutableList<User>> {
        val dataMutable = MutableLiveData<MutableList<User>>()
        var database = FirebaseDatabase.getInstance().getReference()
         var query : Query = database.child("User").orderByChild("name").equalTo("elon musk")
            query.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(datasnapshot: DataSnapshot) {
                    val listData = mutableListOf<User>()
                    for (snapshot: DataSnapshot in datasnapshot.children) {
                        val user = snapshot.getValue(User::class.java)
                        listData.add(user!!)
                    }
                    dataMutable.value = listData
                }

                override fun onCancelled(error: DatabaseError) {

                }
            })
        return dataMutable
    }
}