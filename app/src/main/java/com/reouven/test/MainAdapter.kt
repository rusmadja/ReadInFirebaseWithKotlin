package com.reouven.test

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private val datalist = mutableListOf<User>()

    fun setListData(data:MutableList<User>){
        datalist.clear()
        datalist.addAll(data)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val  view =LayoutInflater.from(parent.context).inflate(R.layout.item_row,parent,false)

        return ViewHolder(view,parent.context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = datalist.get(position)
        holder.bindView(user)
    }

    override fun getItemCount(): Int {
        return datalist.size
    }
    inner class ViewHolder(itemView: View, context: Context): RecyclerView.ViewHolder(itemView) {
        var mycontext = context
        var profil = itemView.findViewById<ImageView>(R.id.profil)
        var name = itemView.findViewById<TextView>(R.id.nameuser)
        var description = itemView.findViewById<TextView>(R.id.description)

        fun bindView(user:User){
            Glide.with(mycontext).load(user.imageUrl).into(profil)
            name.setText(user.name)
            description.setText(user.description)
        }
    }

}
