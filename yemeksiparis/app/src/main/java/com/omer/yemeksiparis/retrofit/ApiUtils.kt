package com.omer.yemeksiparis.retrofit

class ApiUtils {
    companion object{
        val base_url = "http://kasimadalan.pe.hu/"
        fun getYemeklerdao():Yemeklerdao{
            return RetrofitClient.getClient(base_url).create(Yemeklerdao::class.java)
        }
    }
}