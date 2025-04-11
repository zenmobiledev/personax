package com.mobbelldev.personax.presentation.favorite.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobbelldev.personax.domain.model.FavoriteUser
import com.mobbelldev.personax.domain.usecases.DeleteFavoriteUserUseCase
import com.mobbelldev.personax.domain.usecases.GetFavoriteUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    getFavoriteUsersUseCase: GetFavoriteUsersUseCase,
    private val deleteFavoriteUserUseCase: DeleteFavoriteUserUseCase,
) :
    ViewModel() {
    val userList: StateFlow<List<FavoriteUser>> = getFavoriteUsersUseCase().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
        initialValue = emptyList()
    )

    fun deleteFavoriteUser(user: FavoriteUser) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                deleteFavoriteUserUseCase(
                    favoriteUser = FavoriteUser(
                        id = user.id,
                        username = user.username.toString(),
                        email = user.email.toString(),
                        image = user.image.toString(),
                        isFavorite = false
                    )
                )
            }
        }
    }
}