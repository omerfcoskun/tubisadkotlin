package com.omer.yemeksiparis.data.entity

import com.google.gson.annotations.SerializedName

data class SepetYemekAlma(@SerializedName("sepet_yemekler") var sepet_yemekler:List<SepetYemekEkleme>,
                          @SerializedName("success") var success:Int

                          ) {
}