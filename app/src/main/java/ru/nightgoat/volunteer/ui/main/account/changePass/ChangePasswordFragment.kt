package ru.nightgoat.volunteer.ui.main.account.changePass

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.frag_acc_edit_pass.*

import ru.nightgoat.volunteer.R
import ru.nightgoat.volunteer.ui.base.BaseFragment
import javax.inject.Inject

class ChangePasswordFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: ChangePasswordViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(ChangePasswordViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.frag_acc_edit_pass, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBackBtnClickListener()
    }

    private fun onBackBtnClickListener() {
        changePassword_toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

}
