package ru.nightgoat.volunteer.ui.login

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_login.*

import ru.nightgoat.volunteer.R

class LoginFragment : Fragment() {

    lateinit var sharedPreferences: SharedPreferences

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            activity?.moveTaskToBack(true)
        }
        sharedPreferences = context?.getSharedPreferences("settings", Context.MODE_PRIVATE)!!

        login_btn_enter.setOnClickListener {
            sharedPreferences.edit().putBoolean("logedIn", true).apply()
            activity?.finish()
        }

        login_btn_register.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_login_to_navigation_register)
        }

        login_text_cant_remember.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_login_to_navigation_recover)
        }
    }

}
