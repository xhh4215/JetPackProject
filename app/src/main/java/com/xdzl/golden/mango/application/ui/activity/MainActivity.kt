package com.xdzl.golden.mango.application.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.xdzl.golden.mango.application.R
import com.xdzl.golden.mango.application.databinding.ActivityLoginBinding
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    lateinit var binding: ActivityLoginBinding
    lateinit var navController: NavController
    lateinit var drawerLayout: DrawerLayout
    lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        drawerLayout = binding.drawerlayout
        setSupportActionBar(binding.mainTitleBackground)
        navController = this.findNavController(R.id.Navigation_Fragment)
        appBarConfiguration = AppBarConfiguration(setOf(R.id.sabotFragment), drawerLayout)
        NavigationUI.setupWithNavController(
            binding.mainTitleBackground,
            navController,
            drawerLayout
        )
        //设置抽屉菜单
        NavigationUI.setupWithNavController(binding.navgationView, navController)
        //设置底部导航菜单
        NavigationUI.setupWithNavController(binding.bottomnavigationview, navController)

        binding.bottomnavigationview.setOnNavigationItemSelectedListener(this)
    }

    /***
     * 设置地步导航栏的点击
     */
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.main_check -> {
                toast("main_check")
//                navController.navigate(R.id.action_mainFragment_to_checkFragment)
                true

            }
            R.id.main_sabot -> {
                toast("main_sabot")

//                navController.navigate(R.id.action_mainFragment_to_sabotFragment)
                true
            }
            R.id.main_input -> {
                toast("main_input")

//                navController.navigate(R.id.action_mainFragment_to_outInputFragment)
                true

            }
            else -> {
                true
            }
        }
        return true
    }

}