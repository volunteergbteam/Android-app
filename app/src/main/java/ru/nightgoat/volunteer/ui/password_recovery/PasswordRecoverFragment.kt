package ru.nightgoat.volunteer.ui.password_recovery

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_password_recover.*

import ru.nightgoat.volunteer.R

class PasswordRecoverFragment : Fragment() {

    companion object {
        fun newInstance() = PasswordRecoverFragment()
    }

    private lateinit var viewModel: PasswordRecoverViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_password_recover, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PasswordRecoverViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recover_toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }
}
