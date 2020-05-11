package ru.nightgoat.volunteer.ui.main.account.account_fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ru.nightgoat.volunteer.R

import kotlinx.android.synthetic.main.frag_acc.*
import ru.nightgoat.volunteer.ui.login.LoginActivity
import ru.nightgoat.volunteer.ui.base.BaseFragment
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
            with(findNavController()) {
                when (it.itemId) {
                    R.id.account_action_edit -> {
                        navigate(R.id.action_navigation_account_to_navigation_edit_account)
                        true
                    }
                    R.id.account_action_settings -> {
                        navigate(R.id.action_navigation_account_to_navigation_edit_account)
                        true
                    }
                    else -> false
                }
            }
        }
    }


    private fun observeLiveData() {
        viewModel.accountLiveData.observe(viewLifecycleOwner, Observer {
            account_text_name.text = it.name
            account_text_email.text = it.email
            account_text_about.text = it.about
            account_rating.rating = it.rating
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpToolbar()
        onExitBtnClickListener()
        onEditBtnClickListener()
        onEventsBtnClickListener()
    }

    private fun onEventsBtnClickListener() {
        account_btn_events_active.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_account_to_navigation_events)
        }
    }

    private fun onEditBtnClickListener() {

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
