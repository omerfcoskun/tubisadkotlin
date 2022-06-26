package com.omer.navigationc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.omer.navigationc.databinding.FragmentSayfaABinding


class SayfaAFragment : Fragment() {

    private lateinit var tasarim:FragmentSayfaABinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        tasarim =FragmentSayfaABinding.inflate(inflater, container, false)
        tasarim.button3.setOnClickListener {

            Navigation.findNavController(tasarim.button3).navigate(R.id.SayfaBGecis)
        }

        return tasarim.root
    }

}