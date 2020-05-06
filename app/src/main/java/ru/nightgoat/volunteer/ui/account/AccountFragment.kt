package ru.nightgoat.volunteer.ui.account

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import ru.nightgoat.volunteer.R

import kotlinx.android.synthetic.main.fragment_account.*
import ru.nightgoat.volunteer.LoginActivity
import ru.nightgoat.volunteer.ui.base.BaseFragment

class AccountFragment : BaseFragment() {

    private lateinit var accountViewModel: AccountViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        accountViewModel =
                ViewModelProviders.of(this).get(AccountViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_account, container, false)
        observeLiveData()
        return root
    }

    private fun observeLiveData() {
        accountViewModel.accountLiveData.observe(viewLifecycleOwner, Observer {
            account_text_name.text = it.name
            account_text_email.text = it.email
            account_text_about.text = it.about
            account_rating.rating = it.rating
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onExitBtnClickListener()
        onEditBtnClickListener()
        onEventsBtnClickListener()
    }

    private fun onEventsBtnClickListener() {
        account_btn_tasks.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_account_to_navigation_events)
        }
    }

    private fun onEditBtnClickListener() {
        account_btn_edit.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_account_to_navigation_edit_account)
        }
    }

    private fun onExitBtnClickListener() {
        account_btn_exit.setOnClickListener {
            sharedPreferences.edit().putBoolean("logedIn", false).apply()
            activity?.let {
                startActivity(Intent(it, LoginActivity::class.java))
            }
        }
    }
}
