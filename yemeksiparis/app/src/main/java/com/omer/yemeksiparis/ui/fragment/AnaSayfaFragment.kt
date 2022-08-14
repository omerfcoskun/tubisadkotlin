package com.omer.yemeksiparis.ui.fragment

import android.os.Bundle

import android.view.*
import androidx.appcompat.app.AppCompatActivity

import androidx.fragment.app.Fragment

import androidx.databinding.DataBindingUtil

import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.omer.yemeksiparis.R
import com.omer.yemeksiparis.databinding.FragmentAnaSayfaBinding
import com.omer.yemeksiparis.ui.adapter.YemeklerAdapter
import com.omer.yemeksiparis.ui.viewmodel.AnaSayfaFragmentViewModel
import com.omer.yemeksiparis.util.gecis_yap
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnaSayfaFragment : Fragment() {

    private lateinit var tasarim:FragmentAnaSayfaBinding
    private lateinit var viewModel:AnaSayfaFragmentViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View{
        tasarim=DataBindingUtil.inflate(inflater,R.layout.fragment_ana_sayfa,container,false)
        tasarim.anaSayfaFragment=this

        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarAnaSayfa)

        viewModel.yemekler_listesi.observe(viewLifecycleOwner){
            val adapter =YemeklerAdapter(requireContext(),it)
            tasarim.yemekleradapter=adapter
        }

        tasarim.fab.setOnClickListener {
            Navigation.gecis_yap(requireView(),R.id.urunSepeteGecis)
        }
        return tasarim.root
    }
    /* b.yemekCard.setOnClickListener {
            val gecis=AnaSayfaFragmentDirections.urunDetayGecis(yemek=yemek)
            Navigation.gecis_yap(it,gecis)
        }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val tempViewModel:AnaSayfaFragmentViewModel by viewModels()
        viewModel =tempViewModel

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }







    }




