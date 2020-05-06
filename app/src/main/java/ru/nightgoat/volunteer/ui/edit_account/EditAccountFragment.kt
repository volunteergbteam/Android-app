package ru.nightgoat.volunteer.ui.edit_account

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_edit_accout.*

import ru.nightgoat.volunteer.R

class EditAccountFragment : Fragment() {

    companion object {
        fun newInstance() = EditAccountFragment()
    }

    private lateinit var viewModel: EditAccoutViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edit_accout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(EditAccoutViewModel::class.java)
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
