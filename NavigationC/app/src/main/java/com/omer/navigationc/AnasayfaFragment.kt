package com.omer.navigationc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.omer.navigationc.databinding.FragmentAnasayfaBinding


class AnasayfaFragment : Fragment() {

    private lateinit var tasarim:FragmentAnasayfaBinding
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim = FragmentAnasayfaBinding.inflate(inflater, container, false)

        tasarim.button.setOnClickListener {

            Navigation.findNavController(tasarim.button).navigate(R.id.SayfaAGecis)
        }
        tasarim.button2.setOnClickListener {

            Navigation.findNavController(tasarim.button2).navigate(R.id.SayfaXGecis)
        }


        return  tasarim.root
    }


}