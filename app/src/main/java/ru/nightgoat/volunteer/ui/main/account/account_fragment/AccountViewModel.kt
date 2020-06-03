package ru.nightgoat.volunteer.ui.main.account.account_fragment

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import ru.nightgoat.volunteer.domain.Interactor
import ru.nightgoat.volunteer.data.model.User
import ru.nightgoat.volunteer.ui.base.BaseViewModel
import ru.nightgoat.volunteer.utils.USERS
import javax.inject.Inject

class AccountViewModel @Inject constructor(private val interactor: Interactor) : BaseViewModel() {

    private lateinit var auth: FirebaseAuth

    private val accountMutableLiveData = MutableLiveData<User>()

    val userLiveData: LiveData<User> = accountMutableLiveData

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate(){
        auth = Firebase.auth
        Firebase.database.reference.child(USERS).child(auth.currentUser!!.uid).addListenerForSingleValueEvent (
            object: ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {
                }

                override fun onDataChange(p0: DataSnapshot) {
                    accountMutableLiveData.value = p0.getValue<User>()
                }
            }
        )
    }
}