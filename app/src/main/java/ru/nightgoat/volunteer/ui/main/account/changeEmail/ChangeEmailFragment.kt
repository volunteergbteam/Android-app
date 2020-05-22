package ru.nightgoat.volunteer.ui.main.account.changeEmail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.frag_acc_edit_email.*

import ru.nightgoat.volunteer.R
import ru.nightgoat.volunteer.ui.base.BaseFragment
import javax.inject.Inject

class ChangeEmailFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: ChangeEmailViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(ChangeEmailViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.frag_acc_edit_email, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBackBtnClickListener()
    }

    private fun onBackBtnClickListener() {
        changeEmail_toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

}
