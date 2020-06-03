package ru.nightgoat.volunteer.ui.login.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.edit
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_register.*
import ru.nightgoat.volunteer.R
import ru.nightgoat.volunteer.data.model.User
import ru.nightgoat.volunteer.extentions.popBackStack
import ru.nightgoat.volunteer.extentions.showShortToast
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
        observeLiveData()
    }

    private fun observeLiveData() {
        with(viewModel) {
            isRegisteredLiveData.observe(viewLifecycleOwner, Observer { isRegistered ->
                if (isRegistered) {
                    popBackStack()
                    showShortToast("На указанную почту отправлено письмо с подтверждением")
                }
                else {
                    showShortToast("Не получилось зарегистрироваться")
                }
            })
        }
    }

    private fun onRegisterBtnClickListener() {
        register_btn.setOnClickListener {
            if (isEmailValid &&
                isPasswordValid &&
                isPasswordsAreIdentical && checkNameIsNotEmpty()) {
                val user = User(
                    name = register_edit_name_first.text.toString(),
                    lastName = register_edit_name_second.text.toString(),
                    about = register_edit_about_me.text.toString(),
                    phone = null,
                    email = register_edit_email.text.toString(),
                    createdEvents = mutableMapOf()
                )
                addDataToSharedPreferences(user)
                createUser(user)
            } else {
                showShortToast("Что-то не заполнено!")
            }
        }
    }

    private fun addDataToSharedPreferences(user: User) {
        sharedPreferences.edit {
            putString("first_name", user.name)
            putString("second_name", user.lastName)
            putString("about", user.about)
            putString("phone", user.phone)
            putString("email", user.email)
        }
    }

    private fun createUser(user: User) = viewModel
        .createUser(user, register_edit_password_first.text.toString())

    private fun onBackBtnClickListener() {
        register_toolbar.setNavigationOnClickListener {
            popBackStack()
        }
    }

    private fun checkNameIsNotEmpty(): Boolean {
        if (register_edit_name_first.text.toString().isEmpty()) {
            register_textLayout_name.error = "Введите, пожалуйста, имя"
            return false
        }
        if (register_edit_name_second.text.toString().isEmpty()){
            register_textLayout_second_name.error = "Введите, пожалуйста, фамилию"
            return false
        }
        return true
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
