package com.omer.navigationc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.omer.navigationc.databinding.FragmentSayfaXBinding


class SayfaXFragment : Fragment() {

    private lateinit var tasarim:FragmentSayfaXBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        tasarim =FragmentSayfaXBinding.inflate(inflater, container, false)

        tasarim.button4.setOnClickListener {
            Navigation.findNavController(tasarim.button4).navigate(R.id.SayfaYGecis2)
        }

        return tasarim.root
    }


}