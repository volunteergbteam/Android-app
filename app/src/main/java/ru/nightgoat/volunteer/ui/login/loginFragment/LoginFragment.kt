package ru.nightgoat.volunteer.ui.login.loginFragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_login.*

import ru.nightgoat.volunteer.R
import ru.nightgoat.volunteer.extentions.navigateTo
import ru.nightgoat.volunteer.extentions.showShortToast
import ru.nightgoat.volunteer.ui.base.BaseFragment
import ru.nightgoat.volunteer.ui.login.LoginActivity
import ru.nightgoat.volunteer.ui.main.MainActivity
import javax.inject.Inject

class LoginFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var auth: FirebaseAuth

    private val viewModel: LoginViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(LoginViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        val currentUser = auth.currentUser
        updateUi(user = currentUser)
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
        onLoginBtnClickListener()
        onRegisterBtnClickListener()
        onCantRememberBtnClickListener()
    }

    private fun updateUi(user: FirebaseUser?) {
        login_progressBar?.visibility = View.INVISIBLE
        if (user != null && user.isEmailVerified){
            startActivity(Intent(activity, MainActivity::class.java))
        }
    }

    private fun onCantRememberBtnClickListener() {
        login_text_cant_remember.setOnClickListener {
            navigateTo(R.id.action_navigation_login_to_navigation_recover)
        }
    }

    private fun onRegisterBtnClickListener() {
        login_btn_register.setOnClickListener {
            navigateTo(R.id.action_navigation_login_to_navigation_register)
        }
    }

    private fun onLoginBtnClickListener() {
        login_btn_enter.setOnClickListener {
            if (login_edit_email.text.toString().isNotEmpty() && login_edit_pass.text.toString().isNotEmpty()) {
                login_progressBar.visibility = View.VISIBLE
                auth.signInWithEmailAndPassword(login_edit_email.text.toString(), login_edit_pass.text.toString())
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val user = auth.currentUser
                            updateUi(user)
                        } else {
                            showShortToast(getString(R.string.wrongEmailPass))
                            updateUi(null)
                        }
                    }
            }
        }
    }

}
