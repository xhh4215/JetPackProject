package com.xdzl.golden.mango.application.ui.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.xdzl.golden.mango.application.R
import com.xdzl.golden.mango.application.databinding.OutInputFragmentBinding
import com.xdzl.golden.mango.application.viewmodel.OutInputViewModel
import com.xdzl.golden.mango.application.utils.fixStatusBar
import org.jetbrains.anko.support.v4.toast

class OutInputFragment : Fragment() {


    private lateinit var viewModel: OutInputViewModel
    private lateinit var binding: OutInputFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.out_input_fragment, container, false)
        viewModel = ViewModelProvider(this).get(OutInputViewModel::class.java)
        binding.outinputviewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        val args = OutInputFragmentArgs.fromBundle(requireArguments())
         when (args.outInFlag) {
            MainFragment.ACTION_INPUT -> {
                viewModel.setInputTitle()
            }
            MainFragment.ACTION_OUTPUT -> {
                viewModel.setOutputTitle()
            }
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(OutInputViewModel::class.java)
        // TODO: Use the ViewModel
    }

}