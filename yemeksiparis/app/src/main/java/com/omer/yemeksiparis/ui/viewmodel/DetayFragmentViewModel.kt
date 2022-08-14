package com.omer.yemeksiparis.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.omer.yemeksiparis.data.repo.YemeklerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetayFragmentViewModel @Inject constructor(var yrepo:YemeklerDaoRepository):ViewModel() {
    fun yemek_ekle(yemek_adi:String,yemek_resim_adi:String,yemek_ucret:Int,yemek_siparis_sayisi:Int,kullanici_adi:String){
        yrepo.sepete_ekle(yemek_adi,yemek_resim_adi,yemek_ucret,yemek_siparis_sayisi,kullanici_adi)
    }
}