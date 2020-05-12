package ru.nightgoat.volunteer.ui.main.account.edit_account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.frag_acc_edit.*
import ru.nightgoat.volunteer.R
import ru.nightgoat.volunteer.ui.base.BaseFragment
import javax.inject.Inject

class EditAccountFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: EditAccountViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(EditAccountViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.frag_acc_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBackBtnClickListener()
        onSaveBtnClickListener()
    }

    private fun onSaveBtnClickListener() {
        editAcc_btn_save.setOnClickListener {
            saveAccount()
            findNavController().popBackStack()
        }
    }

    private fun saveAccount() {
    }

    private fun onBackBtnClickListener() {
        editAcc_toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }
}
