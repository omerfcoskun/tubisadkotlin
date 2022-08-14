package com.omer.yemeksiparis.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.omer.yemeksiparis.data.entity.Yemekler
import com.omer.yemeksiparis.data.repo.YemeklerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class AnaSayfaFragmentViewModel @Inject constructor(var yrepo:YemeklerDaoRepository):ViewModel() {
    var yemekler_listesi=MutableLiveData<List<Yemekler>>()

    init {
        yemek_guncelle()
        yemekler_listesi=yrepo.yemek_al()

    }
    fun yemek_guncelle() {

        yrepo.tum_yemek_al()
    }



}