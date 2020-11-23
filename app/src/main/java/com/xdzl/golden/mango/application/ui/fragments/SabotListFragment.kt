package com.xdzl.golden.mango.application.ui.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.xdzl.golden.mango.application.R
import com.xdzl.golden.mango.application.databinding.SabotListFragmentBinding
import com.xdzl.golden.mango.application.viewmodel.SabotListViewModel
import com.xdzl.golden.mango.application.utils.fixStatusBar

class SabotListFragment : Fragment() {
    private lateinit var viewModel: SabotListViewModel
    private lateinit var binding: SabotListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.sabot_list_fragment, container, false)
         return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SabotListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}