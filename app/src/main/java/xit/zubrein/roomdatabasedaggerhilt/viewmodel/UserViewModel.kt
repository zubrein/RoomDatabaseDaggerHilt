package xit.zubrein.roomdatabasedaggerhilt.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import xit.zubrein.roomdatabasedaggerhilt.model.User
import xit.zubrein.roomdatabasedaggerhilt.repository.UserRepository

class UserViewModel
@ViewModelInject
constructor(private val userRepository: UserRepository) : ViewModel()
{
    val getUserData: LiveData<List<User>> = userRepository.getUserData.flowOn(Dispatchers.Main)
            .asLiveData(context = viewModelScope.coroutineContext)

    fun insert(user:User){
        viewModelScope.launch {
            userRepository.insert(user)
        }
    }
}