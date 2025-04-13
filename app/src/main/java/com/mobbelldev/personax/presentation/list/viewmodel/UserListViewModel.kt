package com.mobbelldev.personax.presentation.list.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobbelldev.personax.domain.model.FavoriteUser
import com.mobbelldev.personax.domain.model.UsersItem
import com.mobbelldev.personax.domain.usecases.DeleteFavoriteUserUseCase
import com.mobbelldev.personax.domain.usecases.GetAllUsersUseCase
import com.mobbelldev.personax.domain.usecases.GetFavoriteUsersUseCase
import com.mobbelldev.personax.domain.usecases.InsertFavoriteUserUseCase
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
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val setLoginUseCase: SetLoginUseCase,
    private val getAllUsersUseCase: GetAllUsersUseCase,
    private val insertFavoriteUserUseCase: InsertFavoriteUserUseCase,
    private val deleteFavoriteUserUseCase: DeleteFavoriteUserUseCase,
    private val getFavoriteUsersUseCase: GetFavoriteUsersUseCase,
) : ViewModel() {
    private val _userList = MutableStateFlow<List<UsersItem?>>(emptyList())
    val userList: StateFlow<List<UsersItem?>> = _userList.asStateFlow()

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
            combine(
                getAllUsersUseCase(),
                getFavoriteUsersUseCase()
            ) { response, favorite ->
                val favoriteIds = favorite.map { it.id }.toSet()

                when (response) {
                    is Response.Loading -> _isLoading.value = true
                    is Response.Success -> {
                        _isLoading.value = false
                        val users = response.data?.users?.map { user ->
                            user?.copy(isFavorite = favoriteIds.contains(user.id))
                        } ?: emptyList()

                        withContext(Dispatchers.IO) {
                            _userList.value = users
                        }
                    }

                    is Response.Error -> {
                        _isLoading.value = false
                        _errorMessage.emit(response.message)
                    }
                }
            }.collect()
        }
    }

    fun insertFavoriteUser(user: UsersItem) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                insertFavoriteUserUseCase(
                    favoriteUser = FavoriteUser(
                        id = user.id ?: 0,
                        username = user.username.toString(),
                        email = user.email.toString(),
                        image = user.image.toString(),
                        isFavorite = true,
                    )
                )
            }
        }
    }

    fun deleteFavoriteUser(user: UsersItem) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                deleteFavoriteUserUseCase(
                    favoriteUser = FavoriteUser(
                        id = user.id ?: 0,
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