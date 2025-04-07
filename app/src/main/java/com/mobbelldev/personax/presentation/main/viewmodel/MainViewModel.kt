package com.mobbelldev.personax.presentation.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobbelldev.personax.domain.model.User
import com.mobbelldev.personax.domain.usecases.GetAllUsersUseCase
import com.mobbelldev.personax.domain.usecases.SetLoginUseCase
import com.mobbelldev.personax.utils.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val setLoginUseCase: SetLoginUseCase,
    private val getAllUsersUseCase: GetAllUsersUseCase,
) : ViewModel() {
    private val _userData = MutableStateFlow<User?>(null)
    val userData: StateFlow<User?> = _userData.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _errorMessage = MutableSharedFlow<String>()
    val errorMessage: SharedFlow<String> = _errorMessage.asSharedFlow()

    init {
        getAllUsers()
    }

    fun setLogin(isLogin: Boolean) {
        viewModelScope.launch {
            setLoginUseCase(
                isLogin = isLogin
            )
        }
    }

    private fun getAllUsers() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                getAllUsersUseCase.invoke().collect { result ->
                    when (result) {
                        is Response.Error -> {
                            _isLoading.value = false
                            _errorMessage.emit(result.message)
                        }

                        is Response.Loading -> _isLoading.value = true
                        is Response.Success -> {
                            _isLoading.value = false
                            result.data?.let {
                                _userData.value = it
                            }
                        }
                    }
                }
            }
        }
    }
}