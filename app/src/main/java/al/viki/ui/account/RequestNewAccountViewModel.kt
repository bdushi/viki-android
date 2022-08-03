package al.viki.ui.account

import al.bruno.core.Result
import al.bruno.core.State
import al.bruno.core.data.source.AuthorityRepository
import al.bruno.core.data.source.RequestAccountRepository
import al.bruno.core.data.source.model.Authority
import al.bruno.core.data.source.model.request.RequestAccount
import al.viki.model.AuthorityUi
import android.view.View
import android.widget.AdapterView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RequestNewAccountViewModel @Inject constructor(
    private val authorityRepository: AuthorityRepository,
    private val requestAccountRepository: RequestAccountRepository
) : ViewModel(), AdapterView.OnItemSelectedListener {

    val email = MutableStateFlow("")
    private var authorityUi: AuthorityUi? = null

    // Backing property to avoid state updates from other classes
    private val _request = MutableStateFlow<State<Boolean>>(State.Success(false))

    // The UI collects from this StateFlow to get its state updates
    val request: StateFlow<State<Boolean>> = _request

    // Backing property to avoid state updates from other classes
    private val _authorities = MutableStateFlow<State<List<AuthorityUi>>>(State.Success(listOf()))

    // The UI collects from this StateFlow to get its state updates
    val authorities: StateFlow<State<List<AuthorityUi>>> = _authorities

    init {
        authorities()
    }

    private fun authorities() {
        viewModelScope.launch(Dispatchers.IO) {
            _authorities.value = State.Loading
            when (val response = authorityRepository.authorities()) {
                is Result.Error -> _authorities.value = State.Error(response.error)
                is Result.Success -> _authorities.value = State.Success(response.data.map {
                    AuthorityUi(
                        it.id,
                        it.authority,
                        it.description
                    )
                })
                is Result.Unauthorized -> _authorities.value = State.Unauthorized
            }
        }
    }

    fun requestNewAccount() {
        viewModelScope.launch(Dispatchers.IO) {
            authorityUi?.let {
                when (val response = requestAccountRepository
                    .requestAccount(
                        RequestAccount(
                            email.value,
                            Authority(
                                it.id,
                                it.authority,
                                it.description
                            )
                        )
                    )) {
                    is Result.Error -> {
                        _request.value = State.Error(response.error)
                    }
                    is Result.Success -> {
                        _request.value = State.Success(response.data)
                    }
                    Result.Unauthorized -> {
                        _request.value = State.Unauthorized
                    }
                }
            }
        }
    }

    override fun onItemSelected(
        adapterView: AdapterView<*>?,
        view: View?,
        position: Int,
        p3: Long
    ) {
        authorityUi = adapterView?.getItemAtPosition(position) as AuthorityUi
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}