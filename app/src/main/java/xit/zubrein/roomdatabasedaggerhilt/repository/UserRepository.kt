package xit.zubrein.roomdatabasedaggerhilt.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.withContext
import xit.zubrein.roomdatabasedaggerhilt.dao.UserDao
import xit.zubrein.roomdatabasedaggerhilt.model.User
import javax.inject.Inject

class UserRepository @Inject constructor(private val userDao: UserDao) {

    val getUserData: Flow<List<User>> = userDao.getUserData()

    suspend fun insert(user: User) = withContext(Dispatchers.IO)
    {
        val list : List<User> = userDao.findData(user.name)
        if(list.size > 0){
            userDao.updateData(user.name,user.age)
        }else{
            userDao.insert(user)
        }
    }

}