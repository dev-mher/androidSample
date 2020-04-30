package com.example.features.app.presentation

import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.base.BaseActivity
import com.example.base.BasePresenter
import com.example.features.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class AppActivity : BaseActivity<BasePresenter<*>>() {

    override val layoutResource: Int = R.layout.activity_app

    override val presenter: BasePresenter<*>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bottomNavView: BottomNavigationView = findViewById(R.id.bottom_nav_view)

        val navController = findNavController(R.id.nav_host_fragment)

        /*val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.navigation_translate_menu, R.id.navigation_history_menu)
        )
        setupActionBarWithNavController(navController)*/
        bottomNavView.setupWithNavController(navController)
    }
}