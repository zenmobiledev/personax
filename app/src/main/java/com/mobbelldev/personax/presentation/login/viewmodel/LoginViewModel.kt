package com.mobbelldev.personax.presentation.login.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobbelldev.personax.domain.usecases.SetLoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val setLoginUseCase: SetLoginUseCase,
) : ViewModel() {
    fun setLogin(isLogin: Boolean) {
        viewModelScope.launch {
            setLoginUseCase(
                isLogin = isLogin
            )
        }
    }
}