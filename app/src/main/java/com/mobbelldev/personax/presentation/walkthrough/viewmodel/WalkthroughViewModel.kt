package com.mobbelldev.personax.presentation.walkthrough.viewmodel

import androidx.lifecycle.ViewModel
import com.mobbelldev.personax.domain.usecases.IsLoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class WalkthroughViewModel @Inject constructor(isLoginUseCase: IsLoginUseCase) :
    ViewModel() {
    val isLogin: Flow<Boolean> = isLoginUseCase.invoke()
}