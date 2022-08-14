package com.omer.yemeksiparis.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.omer.yemeksiparis.R
import com.omer.yemeksiparis.databinding.FragmentSepetBinding
import com.omer.yemeksiparis.ui.adapter.SepetAdapter
import com.omer.yemeksiparis.ui.viewmodel.SepetFragmentViewModel
import com.omer.yemeksiparis.util.gecis_yap
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SepetFragment : Fragment() {

    private lateinit var tasarim:FragmentSepetBinding
    private lateinit var viewModel: SepetFragmentViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_sepet, container, false)
        tasarim.sepetfragment=this
        //tasarim.sepetFragmentToolbarBaslik="Sepetim"
        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarSepet)

        viewModel.yemek_card_listesi.observe(viewLifecycleOwner){
            val adapter=SepetAdapter(requireContext(),it,viewModel)
            tasarim.sepetAdapter=adapter
        }

        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:SepetFragmentViewModel by viewModels()
        viewModel=tempViewModel
    }


}