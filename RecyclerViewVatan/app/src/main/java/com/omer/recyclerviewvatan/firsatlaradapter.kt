package com.omer.recyclerviewvatan

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.omer.recyclerviewvatan.databinding.CardBinding
import com.omer.recyclerviewvatan.databinding.KampanyaTasarimBinding

class firsatlaradapter(var mContext: Context, var firsatlistesi:List<Firsatlar>)
    : RecyclerView.Adapter<firsatlaradapter.holder2>(){
    inner class holder2(tasarim2: CardBinding):RecyclerView.ViewHolder(tasarim2.root){
        var tasarim2:CardBinding
        init {
            this.tasarim2=tasarim2
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): holder2 {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim2 = CardBinding.inflate(layoutInflater,parent,false)
        return holder2(tasarim2)
    }

    override fun onBindViewHolder(holder: holder2, position: Int) {
        val fir = firsatlistesi.get(position)
        val f =holder.tasarim2
        f.imageView2.setImageResource(
            mContext.resources.getIdentifier(
                fir.resimId, "drawable", mContext.packageName
            )
        )
        f.cihazModel.text = fir.model
        f.cihazUcret.text = "${fir.ucret} TL"
        f.cihazAciklama.text = fir.aciklama



    }

    override fun getItemCount(): Int {
        return firsatlistesi.size
    }


}