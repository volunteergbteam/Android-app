package ru.nightgoat.volunteer.ui.login

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.core.app.ActivityCompat
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import ru.nightgoat.volunteer.R
import ru.nightgoat.volunteer.ui.base.BaseActivity
import ru.nightgoat.volunteer.ui.main.MainActivity

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!isPermissionsGranted()) requestPermissions()
        setContentView(R.layout.activity_login)
    }

    private fun isPermissionsGranted() : Boolean {
        return ActivityCompat.checkSelfPermission(
            applicationContext, Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(
            applicationContext, Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermissions() {
        ActivityCompat.requestPermissions(
            this, arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ), 100
        )
    }
}
