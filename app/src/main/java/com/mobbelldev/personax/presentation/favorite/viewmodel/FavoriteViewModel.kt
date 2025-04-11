package com.mobbelldev.personax.presentation.favorite.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobbelldev.personax.domain.model.FavoriteUser
import com.mobbelldev.personax.domain.usecases.GetFavoriteUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(getFavoriteUsersUseCase: GetFavoriteUsersUseCase) :
    ViewModel() {
    val userList: StateFlow<List<FavoriteUser>> = getFavoriteUsersUseCase().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
        initialValue = emptyList()
    )
}