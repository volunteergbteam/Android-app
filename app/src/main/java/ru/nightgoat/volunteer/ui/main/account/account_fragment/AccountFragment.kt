package ru.nightgoat.volunteer.ui.main.account.account_fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ru.nightgoat.volunteer.R

import kotlinx.android.synthetic.main.frag_acc.*
import ru.nightgoat.volunteer.ui.login.LoginActivity
import ru.nightgoat.volunteer.ui.base.BaseFragment
import java.util.*
import javax.inject.Inject

class AccountFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: AccountViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(AccountViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.frag_acc, container, false)
        observeLiveData()
        return root
    }

    private fun setUpToolbar() {
        account_toolbar.inflateMenu(R.menu.fragment_account_toolbar_menu)
        account_toolbar.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.account_action_edit -> {
                        navigateTo(R.id.action_navigation_account_to_navigation_edit_account)
                        true
                    }
                    R.id.account_action_settings -> {
                        true
                    }
                    else -> false
                }
        }
    }

    private fun observeLiveData() {
        viewModel.accountLiveData.observe(viewLifecycleOwner, Observer {
            account_text_name.text = it.firstName.plus(" ").plus(it.secondName)
            account_text_email.text = it.email
            account_text_city.text = it.city
            account_text_about.text = it.about
            account_rating.rating = it.rating
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpToolbar()
        onExitBtnClickListener()
        onActiveEventsBtnClickListener()
        onMyEventsBtnClickListener()
    }

    private fun onMyEventsBtnClickListener() {
        account_btn_events_mine.setOnClickListener {
            navigateTo(R.id.action_navigation_account_to_navigation_events_my)
        }
    }

    private fun onActiveEventsBtnClickListener() {
        account_btn_events_active.setOnClickListener {
            navigateTo(R.id.action_navigation_account_to_navigation_events_active)
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
