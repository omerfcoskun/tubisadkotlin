package com.omer.yemeksiparis.data.entity

import com.google.gson.annotations.SerializedName

data class Crud (@SerializedName("success") var success:Int,
                  @SerializedName("message") var message:String) {
}