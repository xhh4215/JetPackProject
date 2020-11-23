package com.xdzl.golden.mango.application.ui.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.xdzl.golden.mango.application.R
import com.xdzl.golden.mango.application.databinding.OutInputListFragmentBinding
import com.xdzl.golden.mango.application.viewmodel.OutInputListViewModel
import com.xdzl.golden.mango.application.utils.fixStatusBar

class OutInputListFragment : Fragment() {

    private lateinit var viewModel: OutInputListViewModel
    private lateinit var binding: OutInputListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.out_input_list_fragment, container, false)
         return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(OutInputListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}