package com.omer.yemeksiparis.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.omer.yemeksiparis.R
import com.omer.yemeksiparis.data.entity.Yemekler
import com.omer.yemeksiparis.databinding.AnasayfaCardTasarimBinding
import com.omer.yemeksiparis.retrofit.ApiUtils.Companion.base_url
import com.omer.yemeksiparis.retrofit.Yemeklerdao
import com.omer.yemeksiparis.ui.fragment.AnaSayfaFragmentDirections
import com.omer.yemeksiparis.ui.viewmodel.AnaSayfaFragmentViewModel
import com.omer.yemeksiparis.util.gecis_yap
import com.squareup.picasso.Picasso


class YemeklerAdapter(var mContext: Context,var yemeklerlistesi:List<Yemekler>):
    RecyclerView.Adapter<YemeklerAdapter.YemeklerCardTutucu>(){

    inner class YemeklerCardTutucu(tasarim:AnasayfaCardTasarimBinding):RecyclerView.ViewHolder(tasarim.root){
        var tasarim:AnasayfaCardTasarimBinding

        init {
            this.tasarim=tasarim
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YemeklerCardTutucu {
        val layoutInflater=LayoutInflater.from(mContext)
        val tasarim:AnasayfaCardTasarimBinding=DataBindingUtil.inflate(layoutInflater,R.layout.anasayfa_card_tasarim,parent,false)
        return YemeklerCardTutucu(tasarim)
    }
    override fun getItemCount(): Int {
        return yemeklerlistesi.size
    }
    override fun onBindViewHolder(holder: YemeklerCardTutucu, position: Int) {
        val yemek=yemeklerlistesi[position]
        val b =holder.tasarim
        b.yemeknesnesi=yemek

        Picasso.get().load(base_url+"yemekler/resimler/"+yemek.yemek_resim_adi).into(b.yemekresim)
        b.yemekCard.setOnClickListener {
            val gecis=AnaSayfaFragmentDirections.urunDetayGecis(yemek=yemek)
            Navigation.gecis_yap(it,gecis)
        }
    }
}