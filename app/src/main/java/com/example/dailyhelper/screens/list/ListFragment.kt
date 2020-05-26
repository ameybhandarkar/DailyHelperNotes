package com.example.dailyhelper.screens.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.dailyhelper.BaseFragment
import com.example.dailyhelper.R
import com.example.dailyhelper.databinding.FragmentListBinding

class ListFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentListBinding>(inflater,
            R.layout.fragment_list,container,false)

        binding.floatingActionButton.setOnClickListener { view ->
            this.findNavController().navigate(
                ListFragmentDirections
                    .actionListFragmentToToDoListFragment())
        }

        return binding.root
    }
}