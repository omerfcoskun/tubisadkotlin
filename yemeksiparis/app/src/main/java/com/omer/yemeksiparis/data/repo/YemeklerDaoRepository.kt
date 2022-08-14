package com.omer.yemeksiparis.data.repo

import android.content.Intent
import android.util.Log
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.MutableLiveData
import com.omer.yemeksiparis.data.entity.*
import com.omer.yemeksiparis.retrofit.Yemeklerdao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class YemeklerDaoRepository(var yemeklerdao: Yemeklerdao) {

    var yemekler_listesi:MutableLiveData<List<Yemekler>>
    var yemekler_card_listesi:MutableLiveData<List<SepetYemekEkleme>>

    init {
        yemekler_listesi= MutableLiveData()
        yemekler_card_listesi= MutableLiveData()
    }
    fun yemek_al():MutableLiveData<List<Yemekler>>{
        return yemekler_listesi
    }
    fun yemek_card_al():MutableLiveData<List<SepetYemekEkleme>>{
        return yemekler_card_listesi
    }
    fun tum_yemek_al(){
        yemeklerdao.tum_Yemekler().enqueue(object :Callback<YemeklerCevap>{

            override fun onResponse(
                call: Call<YemeklerCevap>,
                response: Response<YemeklerCevap>
            ) {
                val list=response.body()!!.yemekler
                yemekler_listesi.value=list

            }

            override fun onFailure(call: Call<YemeklerCevap>, t: Throwable) {}

        })
    }
    fun sepetteki_yemekler(kullanici_adi:String){
        yemeklerdao.sepetteki_yemekler(kullanici_adi).enqueue(object :Callback<SepetYemekAlma>{
            override fun onResponse(
                call: Call<SepetYemekAlma>,
                response: Response<SepetYemekAlma>
            ) {
                val list=response.body()!!.sepet_yemekler
                yemekler_card_listesi.value=list

            }

            override fun onFailure(call: Call<SepetYemekAlma>, t: Throwable) {}
        })




    }
   fun sepet_yemek_sil (sepet_yemek_id:Int,kullanici_adi: String){
       yemeklerdao.sepet_yemek_sil(sepet_yemek_id,kullanici_adi).enqueue(object :Callback<Crud>{
           override fun onResponse(call: Call<Crud>, response: Response<Crud>) {
               val success=response.body()!!.success
               val message =response.body()!!.message
               Log.e("Add To Cart", "$success - $message")
               sepetteki_yemekler(kullanici_adi)


           }

           override fun onFailure(call: Call<Crud>, t: Throwable) {

           }

       })

   }

    fun sepete_ekle(yemek_adi:String,yemek_resim_adi:String,yemek_fiyat:Int,yemek_siparis_sayisi:Int,kullanici_adi: String){

        yemeklerdao.yemek_ekle(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_sayisi,kullanici_adi).enqueue(object :Callback<Crud>{

            override fun onResponse(call: Call<Crud>, response: Response<Crud>) {
                val success =response.body()!!.success
                val message=response.body()!!.message
                Log.e("Add To Cart", "$success - $message")
            }

            override fun onFailure(call: Call<Crud>, t: Throwable) {}


        })
    }


}