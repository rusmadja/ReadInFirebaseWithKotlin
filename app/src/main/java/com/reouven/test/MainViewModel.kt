package com.reouven.test

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    val repo = Repo()
    fun fetchUserData():LiveData<MutableList<User>>{
        val mutableData = MutableLiveData<MutableList<User>>()
        repo.getUserData().observeForever { userlist->
            mutableData.value = userlist
        }
        return mutableData
    }
}


/*
* val dummyList = mutableListOf<User>()
        dummyList.add(
            User(
                "https://upload.wikimedia.org/wikipedia/commons/f/fd/Christian_Clavier_Cannes_2013.jpg",
                "cristian Clavier", "il a jouer dans quest ce qu on a fait au bondieu"
            )
        )
        dummyList.add(
            User(
                "https://fr.web.img3.acsta.net/pictures/15/11/20/14/53/049755.jpg",
                "omar si", "il a jouer dans intouchable et xmen"
            )
        )
        dummyList.add(
            User(
                "https://img.fifa.com/image/upload/t_l4/nw5w9s5aj2quebt6hp8x.jpg",
                "cristiano ronaldo", "c'est certainement le meilleur joueur de football au monde"
            )
        )
        dummyList.add(
            User(
                "https://images.pexels.com/photos/220453/pexels-photo-220453.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "inconnu inconnu", "on en sait rien on le connais pas"
            )
        )
        adapter.setListData(dummyList)
        adapter.notifyDataSetChanged()
       */
