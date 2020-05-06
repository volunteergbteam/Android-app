package ru.nightgoat.volunteer.ui.base

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import dagger.android.support.DaggerFragment

open abstract class BaseFragment : Fragment() {

    lateinit var sharedPreferences: SharedPreferences

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        sharedPreferences = context?.getSharedPreferences("settings", Context.MODE_PRIVATE)!!
    }
}