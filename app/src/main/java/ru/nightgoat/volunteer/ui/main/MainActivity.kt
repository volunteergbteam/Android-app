package ru.nightgoat.volunteer.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import ru.nightgoat.volunteer.R
import ru.nightgoat.volunteer.ui.base.BaseActivity
import ru.nightgoat.volunteer.ui.login.LoginActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.main_nav_host_fragment)
        navView.setupWithNavController(navController)
    }
}
