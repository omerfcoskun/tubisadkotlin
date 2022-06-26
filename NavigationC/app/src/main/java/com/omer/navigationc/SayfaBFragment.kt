package com.omer.navigationc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.omer.navigationc.databinding.FragmentSayfaBBinding

class SayfaBFragment : Fragment() {

    private lateinit var tasarim:FragmentSayfaBBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        tasarim = FragmentSayfaBBinding.inflate(inflater, container, false)
        tasarim.button5.setOnClickListener {

            Navigation.findNavController(tasarim.button5).navigate(R.id.SayfaYGecis)
        }
        return  tasarim.root
    }


}