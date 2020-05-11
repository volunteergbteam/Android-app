package ru.nightgoat.volunteer.ui.main.account.changeEmail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ru.nightgoat.volunteer.R

class ChangeEmailFragment : Fragment() {

    companion object {
        fun newInstance() = ChangeEmailFragment()
    }

    private lateinit var viewModel: ChangeEmailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.frag_acc_edit_email, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ChangeEmailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
