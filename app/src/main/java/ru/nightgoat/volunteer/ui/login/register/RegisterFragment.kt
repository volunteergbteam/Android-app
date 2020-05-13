package ru.nightgoat.volunteer.ui.login.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_register.*
import ru.nightgoat.volunteer.R
import ru.nightgoat.volunteer.data.network.model.Account
import ru.nightgoat.volunteer.ui.base.BaseFragment
import ru.nightgoat.volunteer.utils.isValidEmail
import ru.nightgoat.volunteer.utils.isValidPassword
import javax.inject.Inject

class RegisterFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var isEmailValid = false
    private var isPasswordValid = false
    private var isPasswordsAreIdentical = false

    private val viewModel: RegisterViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(RegisterViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBackBtnClickListener()
        onRegisterBtnClickListener()
        emailTextWatcher()
        passwordTextWatcher()
        passwordSecondTextWatcher()
    }

    private fun onRegisterBtnClickListener() {
        if (isEmailValid &&
            isPasswordValid &&
            isPasswordsAreIdentical) {
            val account = Account(
                firstName = register_edit_name_first.text.toString(),
                secondName = register_edit_name_second.text.toString(),
                email = register_edit_email.text.toString(),
                city = register_edit_city.text.toString(),
                about = register_edit_about_me.text.toString(),
                rating = 0f
            )
            account.password = register_edit_password_first.text.toString()
            register(account)
        }
    }

    @Suppress("UNUSED_PARAMETER")
    private fun register(account: Account) {
    }

    private fun onBackBtnClickListener() {
        register_toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun emailTextWatcher() {
        register_edit_email.addTextChangedListener {
            if(!isValidEmail(register_edit_email.text.toString())){
                register_textLayout_email.error = "Неверный email"
                isEmailValid = false
            } else {
                register_textLayout_email.isErrorEnabled = false
                isEmailValid = true
            }
        }
    }

    private fun passwordTextWatcher() {
        register_edit_password_first.addTextChangedListener {
            if(!isValidPassword(register_edit_password_first.text.toString())){
                register_textLayout_first_password.error =
                    "Пароль должен быть не короче 8 символов и содержать хотя бы " +
                            "1 маленькую букву, " +
                            "1 заглавную букву, " +
                            "1 цифру, " +
                            "1 символ и " +
                            "не иметь пробелов"
                isPasswordValid = false
            } else {
                register_textLayout_first_password.isErrorEnabled = false
                isPasswordValid = true
            }
        }
    }

    private fun passwordSecondTextWatcher() {
        register_edit_password_second.addTextChangedListener {
            if (it.toString() != register_edit_password_first.text.toString()){
                register_textLayout_second_password.error = "Пароли не совпадают"
                isPasswordsAreIdentical = false
            } else {
                isPasswordsAreIdentical = true
                register_textLayout_second_password.isErrorEnabled = false
            }
        }
    }
}
