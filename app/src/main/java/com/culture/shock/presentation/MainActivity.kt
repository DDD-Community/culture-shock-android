package com.culture.shock.presentation

import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import com.culture.shock.R
import com.culture.shock.base.ui.BaseActivity
import com.culture.shock.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    private val appBarConfiguration by lazy {
        AppBarConfiguration(setOf(R.id.splash, R.id.auth, R.id.mainTab))
    }
    private val navHostFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
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
