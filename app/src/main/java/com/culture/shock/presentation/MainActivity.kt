package com.culture.shock.presentation

import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import com.culture.shock.R
import com.culture.shock.base.ui.BaseActivity
import com.culture.shock.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    private val appBarConfiguration by lazy {
        AppBarConfiguration(setOf(R.id.splash, R.id.auth, R.id.home))
    }
    private val navHostFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
    }
    private val navController by lazy {
        navHostFragment.navController
    }

    override fun initView() = NavigationUI.setupActionBarWithNavController(
        this@MainActivity,
        navController,
        appBarConfiguration
    )

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)
    }
}
