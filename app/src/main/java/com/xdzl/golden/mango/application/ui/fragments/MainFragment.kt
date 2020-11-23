package com.xdzl.golden.mango.application.ui.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.onNavDestinationSelected
import com.xdzl.golden.mango.application.R
import com.xdzl.golden.mango.application.adapter.RecycleViewAdapter
import com.xdzl.golden.mango.application.adapter.RecycleViewListener
import com.xdzl.golden.mango.application.databinding.MainFragmentBinding
import com.xdzl.golden.mango.application.entity.HandleResponse
import com.xdzl.golden.mango.application.entity.RecyclerViewResponse
import com.xdzl.golden.mango.application.utils.fixStatusBar
import com.xdzl.golden.mango.application.viewmodel.MainViewModel
import com.xdzl.golden.mango.application.viewmodel.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.find

class MainFragment : Fragment() {
    companion object {
        const val ACTION_INPUT = "input"
        const val ACTION_OUTPUT = "output"
    }

    lateinit var viewModel: MainViewModel
    lateinit var viewModelFactory: MainViewModelFactory
    lateinit var binding: MainFragmentBinding
    lateinit var adapter: RecycleViewAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)

        var status = MainFragmentArgs.fromBundle(requireArguments()).loginStatus
        viewModelFactory = MainViewModelFactory(status)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.isLogin.observe(viewLifecycleOwner, Observer {
            if (it) {
                viewModel.initList()
                requireActivity().main_title_background.visibility = View.VISIBLE
                requireActivity().bottomnavigationview.visibility = View.VISIBLE
                fixStatusBar(this, requireActivity().main_title_background)
                adapter = RecycleViewAdapter(RecycleViewListener {
                    Toast.makeText(requireContext(), "recycleView的点击事件", Toast.LENGTH_SHORT).show()
                })
                binding.recycleViewList.adapter = adapter
                viewModel.handleData.observe(viewLifecycleOwner, Observer { HandleResponse ->
                    HandleResponse?.let {
                        adapter.submitList(HandleResponse.data)
                    }
                })
            } else {
                val action = MainFragmentDirections.actionMainFragmentToLoginFragment()
                action.loginStatus = it
                findNavController().navigate(action)

            }
        })

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_file, menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item,
            requireView().findNavController()
        ) || super.onOptionsItemSelected(item)
    }
}