package com.xdzl.golden.mango.application.ui.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.xdzl.golden.mango.application.R
import com.xdzl.golden.mango.application.databinding.SabotFragmentBinding
import com.xdzl.golden.mango.application.viewmodel.SabotViewModel
import com.xdzl.golden.mango.application.utils.fixStatusBar

class SabotFragment : Fragment() {


    private lateinit var viewModel: SabotViewModel

    private lateinit var binding: SabotFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.sabot_fragment, container, false
        )

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SabotViewModel::class.java)

    }

}