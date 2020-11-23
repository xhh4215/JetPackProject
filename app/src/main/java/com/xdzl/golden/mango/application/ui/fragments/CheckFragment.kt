package com.xdzl.golden.mango.application.ui.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.xdzl.golden.mango.application.R
import com.xdzl.golden.mango.application.databinding.CheckFragmentBinding
import com.xdzl.golden.mango.application.viewmodel.CheckViewModel
import com.xdzl.golden.mango.application.utils.fixStatusBar

class CheckFragment : Fragment() {


    private lateinit var viewModel: CheckViewModel
    private lateinit var binding: CheckFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.check_fragment, container, false)
         binding.checkCompany.setOnClickListener {
            binding.checkCompany.visibility = View.GONE
            binding.checkPlant.visibility = View.GONE
            binding.checkBindInfo.visibility = View.VISIBLE
            binding.checkBinding.visibility = View.VISIBLE

        }
        binding.checkPlant.setOnClickListener {
            binding.checkCompany.visibility = View.GONE
            binding.checkBindInfo.visibility = View.VISIBLE
            binding.checkBinding.visibility = View.VISIBLE
            binding.checkPlant.visibility = View.GONE
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CheckViewModel::class.java)

    }

}