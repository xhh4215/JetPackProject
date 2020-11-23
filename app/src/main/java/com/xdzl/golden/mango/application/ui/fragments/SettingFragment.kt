package com.xdzl.golden.mango.application.ui.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.xdzl.golden.mango.application.R
import com.xdzl.golden.mango.application.databinding.SettingFragmentBinding
import com.xdzl.golden.mango.application.viewmodel.SettingViewModel
import com.xdzl.golden.mango.application.utils.fixStatusBar

class SettingFragment : Fragment() {
    private lateinit var viewModel: SettingViewModel
    private lateinit var binding: SettingFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.setting_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SettingViewModel::class.java)

    }

}