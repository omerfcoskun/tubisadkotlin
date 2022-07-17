package com.omer.recyclerviewvatan

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.omer.recyclerviewvatan.databinding.KampanyaTasarimBinding

class kampanyaadapter (var mContext:Context,var kampanyalistesi:List<Kampanya> )
    :RecyclerView.Adapter<kampanyaadapter.holder>(){
    inner class holder(tasarim:KampanyaTasarimBinding):RecyclerView.ViewHolder(tasarim.root){
        var tasarim:KampanyaTasarimBinding
        init {
            this.tasarim=tasarim
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): holder {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim =KampanyaTasarimBinding.inflate(layoutInflater,parent,false)
        return holder(tasarim)
    }

    override fun onBindViewHolder(holder: holder, position: Int) {
        val kam =kampanyalistesi.get(position)
        val t =holder.tasarim
        t.kampanyaresim.setImageResource(mContext.resources.getIdentifier(kam.KampanyaResimAdi,"drawable",mContext.packageName))
    }

    override fun getItemCount(): Int {
        return  kampanyalistesi.size
    }

}