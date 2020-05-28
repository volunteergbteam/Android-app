package ru.nightgoat.volunteer.ui.base

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import dagger.android.support.DaggerFragment

abstract class BaseFragment : DaggerFragment() {

    lateinit var sharedPreferences: SharedPreferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences = context?.getSharedPreferences("settings", Context.MODE_PRIVATE)!!

    }
}