package com.xdzl.golden.mango.application.ui.fragments

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.xdzl.golden.mango.application.R
import com.xdzl.golden.mango.application.databinding.LoginFragmentBinding
import com.xdzl.golden.mango.application.viewmodel.LoginViewModel
import com.xdzl.golden.mango.application.utils.fixStatusBar
import com.xdzl.golden.mango.application.utils.fixStatusBarColor
import timber.log.Timber

class LoginFragment : Fragment() {
    lateinit var binding: LoginFragmentBinding
    lateinit var viewModel: LoginViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.login_fragment,
            container,
            false
        )
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        viewModel.isLogin.observe(viewLifecycleOwner,
            Observer {
                if (it) {
                    var action = LoginFragmentDirections.actionLoginFragmentToMainFragment()
                    action.loginStatus = viewModel.userId.value ?: ""
                    findNavController().navigate(action)
                }

            })
        fixStatusBar(this, binding.loginTopContainer)
        fixStatusBarColor(activity as Activity, true)
        binding.loginviewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

}