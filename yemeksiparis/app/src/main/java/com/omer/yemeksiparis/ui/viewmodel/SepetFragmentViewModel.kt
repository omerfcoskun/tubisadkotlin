package com.omer.yemeksiparis.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.omer.yemeksiparis.data.entity.SepetYemekEkleme
import com.omer.yemeksiparis.data.repo.YemeklerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SepetFragmentViewModel @Inject constructor(var yrepo:YemeklerDaoRepository):ViewModel() {

    var yemek_card_listesi=MutableLiveData<List<SepetYemekEkleme>>()
    var yemek_card_nesne=SepetYemekEkleme(0,"","",0,0,"omer2")

    init {
        card_yemek_guncelle()
        yemek_card_listesi=yrepo.yemek_card_al()
    }

    fun card_yemek_guncelle(){
        yrepo.sepetteki_yemekler(yemek_card_nesne.kullanici_adi)
    }

    fun sil(yemek_card_id:Int,kullanici_adi:String){
        yrepo.sepet_yemek_sil(yemek_card_id,kullanici_adi)
    }
}