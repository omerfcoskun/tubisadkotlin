package com.omer.yemeksiparis.retrofit

import com.omer.yemeksiparis.data.entity.Crud
import com.omer.yemeksiparis.data.entity.SepetYemekAlma
import com.omer.yemeksiparis.data.entity.YemeklerCevap
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Yemeklerdao {

    @GET("yemekler/tumYemekleriGetir.php")
    fun tum_Yemekler():Call<YemeklerCevap>

    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    fun yemek_ekle(@Field("yemek_adi") yemek_adi:String,
                   @Field("yemek_resim_adi") yemek_resim_adi:String,
                   @Field("yemek_fiyat") yemek_fiyat:Int,
                   @Field("yemek_siparis_adet") yemek_siparis_adet:Int,
                   @Field("kullanici_adi")kullanici_adi:String
    ):Call<Crud>

    @POST("yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    fun sepetteki_yemekler(@Field("kullanici_adi") kullanici_adi:String)
                            :Call<SepetYemekAlma>

    @POST("yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
    fun sepet_yemek_sil(@Field("sepet_yemek_id") sepet_yemek_id:Int,
                       @Field("kullanici_adi") kullanici_adi:String):
                              Call<Crud>




}