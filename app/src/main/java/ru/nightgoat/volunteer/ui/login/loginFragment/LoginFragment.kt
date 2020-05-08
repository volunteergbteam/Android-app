package ru.nightgoat.volunteer.ui.login.loginFragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_login.*

import ru.nightgoat.volunteer.R
import ru.nightgoat.volunteer.ui.base.BaseFragment
import javax.inject.Inject

class LoginFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: LoginViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(LoginViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            activity?.moveTaskToBack(true)
        }
        sharedPreferences = context?.getSharedPreferences("settings", Context.MODE_PRIVATE)!!
        onLoginBtnClickListener()
        onRegisterBtnClickListener()
        onCantRememberBtnClickListener()
    }

    private fun onCantRememberBtnClickListener() {
        login_text_cant_remember.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_login_to_navigation_recover)
        }
    }

    private fun onRegisterBtnClickListener() {
        login_btn_register.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_login_to_navigation_register)
        }
    }

    private fun onLoginBtnClickListener() {
        login_btn_enter.setOnClickListener {
            if (canLogin(login_edit_email.text.toString(), login_edit_pass.text.toString())) {
                sharedPreferences.edit().putBoolean("logedIn", true).apply()
                activity?.finish()
            }
            else {
                Toast.makeText(
                    requireContext(), getString(R.string.wrongEmailPass), Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun canLogin(email: String, password: String): Boolean {
        return true
    }

}
