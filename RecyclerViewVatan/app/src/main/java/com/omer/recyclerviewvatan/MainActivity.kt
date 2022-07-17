package com.omer.recyclerviewvatan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.omer.recyclerviewvatan.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var tasarim:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim=ActivityMainBinding.inflate(layoutInflater)
        setContentView(tasarim.root)

        tasarim.rv.layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL)

        val kampanyalist = ArrayList<Kampanya>()

        val k1=Kampanya("resim1")
        val k2=Kampanya("resim2")
        val k3=Kampanya("resim3")
        val k4=Kampanya("resim4")

        kampanyalist.add(k1)
        kampanyalist.add(k2)
        kampanyalist.add(k3)
        kampanyalist.add(k4)



        val adapter =kampanyaadapter(this,kampanyalist)
        tasarim.rv.adapter=adapter



        tasarim.rv2.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        val firsatlist = ArrayList<Firsatlar>()

        val f1=Firsatlar(1,"cardresim1","CPH2325_SİYAH","Oppo A55 4+128gb Akıllı Telefon Işıltılı Siyah",4.699)

        val f2=Firsatlar(2,"cardresim2","X415EA-EK663W","Asus X415ea 11.Nesil Core i5 1135G7-8Gb-512Gb Ssd+32Gb Optane-14inc-W11",8.499)
        val f3=Firsatlar(3,"cardresim3","43UP77006LB","LG 43UP77006 43inc 109 cm 4K UHD webOS Smart TV,Uydu Alıcılı",7.499)
        val f4=Firsatlar(1,"cardresim4","C21Y_Siyah","Realme C21Y (4GB+64GB) Çapraz Siyah",3.199)

        firsatlist.add(f1)
        firsatlist.add(f2)
        firsatlist.add(f3)
        firsatlist.add(f4)



        val adapter2 =firsatlaradapter(this,firsatlist)
        tasarim.rv2.adapter=adapter2

    }
}