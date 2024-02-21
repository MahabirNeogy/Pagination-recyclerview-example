package com.example.pagination_example

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

public class Adapter(val context:Context,val arrnumber: ArrayList<Model>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val tvnumber = itemView.findViewById<TextView>(R.id.txtItem)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item,parent,false))
    }

    override fun getItemCount(): Int {
        return arrnumber.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvnumber.text = arrnumber[position].number.toString()
    }

}