package com.omer.yemeksiparis.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.omer.yemeksiparis.R
import com.omer.yemeksiparis.data.entity.SepetYemekEkleme
import com.omer.yemeksiparis.data.entity.Yemekler
import com.omer.yemeksiparis.databinding.FragmentDetayBinding
import com.omer.yemeksiparis.retrofit.ApiUtils.Companion.base_url
import com.omer.yemeksiparis.ui.viewmodel.AnaSayfaFragmentViewModel
import com.omer.yemeksiparis.ui.viewmodel.DetayFragmentViewModel
import com.omer.yemeksiparis.util.gecis_yap
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetayFragment : Fragment() {

    private lateinit var tasarim:FragmentDetayBinding
    private lateinit var viewModel:DetayFragmentViewModel
    var adet=1
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        tasarim= DataBindingUtil.inflate(inflater,R.layout.fragment_detay ,container, false)
        tasarim.detayfragment=this
        //tasarim.yemekDetayToolBarBaslik ="Ürün Detay"

        val bundle:DetayFragmentArgs by navArgs()
        val yemek_kayit=bundle.yemek

        val url ="http://kasimadalan.pe.hu/yemekler/resimler/${yemek_kayit.yemek_resim_adi}"
        Picasso.get().load(url).into(tasarim.yemekresimdetay)
        tasarim.textViewYemekDetayAdi.text=yemek_kayit.yemek_adi
        tasarim.textViewYemekDetayFiyat.text="${yemek_kayit.yemek_fiyat}"
        tasarim.yemekadet.text="${adet}"

        tasarim.buttoneksi.setOnClickListener {
            if (adet>1){
                adet--
                tasarim.yemekadet.text="${adet}"
                tasarim.textViewYemekDetayFiyat.text="${adet*yemek_kayit.yemek_fiyat}"
            }
        }
        tasarim.buttonarti.setOnClickListener {
            adet++
            tasarim.yemekadet.text="${adet}"
            tasarim.textViewYemekDetayFiyat.text="${adet*yemek_kayit.yemek_fiyat}"

        }
        tasarim.buttonSepeteEkle.setOnClickListener {

            buttonSepeteEkleClick(yemek_kayit.yemek_adi,yemek_kayit.yemek_resim_adi,yemek_kayit.yemek_fiyat,adet,"omer2")

        }

        tasarim.fab2.setOnClickListener {
            Navigation.gecis_yap(requireView(),R.id.urun_detaydan_sepete_gecis)

        }

        tasarim.imageButtongeri.setOnClickListener{
            Navigation.gecis_yap(requireView(),R.id.detaydan_menuye_gecis)
        }



        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:DetayFragmentViewModel by viewModels()
        viewModel=tempViewModel
    }



    fun buttonSepeteEkleClick(
        yemek_adi:String,
        yemek_resim_adi:String,
        yemek_ucret:Int,
        yemek_siparis_sayisi:Int,
        kullanici_adi:String
    ){
        viewModel.yemek_ekle(yemek_adi,yemek_resim_adi,yemek_ucret,yemek_siparis_sayisi,kullanici_adi)

    }






}