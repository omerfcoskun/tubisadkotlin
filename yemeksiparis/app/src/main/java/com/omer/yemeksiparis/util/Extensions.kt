package com.omer.yemeksiparis.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun Navigation.gecis_yap(v: View, id:Int){
    findNavController(v).navigate(id)
}

fun Navigation.gecis_yap(v: View, id:NavDirections){
    findNavController(v).navigate(id)
}
