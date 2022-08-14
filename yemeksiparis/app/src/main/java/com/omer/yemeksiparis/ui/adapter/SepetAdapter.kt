package com.omer.yemeksiparis.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.omer.yemeksiparis.R
import com.omer.yemeksiparis.data.entity.SepetYemekEkleme
import com.omer.yemeksiparis.databinding.SepetCardTasarimBinding
import com.omer.yemeksiparis.retrofit.ApiUtils.Companion.base_url
import com.omer.yemeksiparis.ui.viewmodel.SepetFragmentViewModel
import com.squareup.picasso.Picasso

class SepetAdapter(var mContext: Context,var yemek_card_listesi:List<SepetYemekEkleme>,var viewModel: SepetFragmentViewModel):
        RecyclerView.Adapter<SepetAdapter.SepetCardTutucu>(){
        inner class SepetCardTutucu(binding:SepetCardTasarimBinding):RecyclerView.ViewHolder(binding.root){
            var binding:SepetCardTasarimBinding
            init {
                this.binding=binding
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SepetCardTutucu {
        val layoutInflater=LayoutInflater.from(mContext)
        val binding:SepetCardTasarimBinding=DataBindingUtil.inflate(layoutInflater, R.layout.sepet_card_tasarim,parent,false)
        return SepetCardTutucu(binding)
    }
    override fun getItemCount(): Int {
        return yemek_card_listesi.size
    }

    override fun onBindViewHolder(holder: SepetCardTutucu, position: Int) {
        val sepetcard=yemek_card_listesi[position]
        val b = holder.binding
        b.textViewSepetYemekAd.text="${sepetcard.yemek_adi}"
        b.textViewSepetYemekFiyat.text="${sepetcard.yemek_fiyat*sepetcard.yemek_siparis_adet}"+"₺"
        b.siparisAdet.text="${sepetcard.yemek_siparis_adet}"

        Picasso.get().load(base_url+"yemekler/resimler/"+sepetcard.yemek_resim_adi).into(b.imageViewSepetResim)




        b.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${sepetcard.yemek_adi} silinsin mi?",Snackbar.LENGTH_LONG).setAction("EVET"){
                viewModel.sil(sepetcard.sepet_yemek_id,sepetcard.kullanici_adi)
            }.show()
        }

    }



}

