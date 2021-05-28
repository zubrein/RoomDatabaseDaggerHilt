package xit.zubrein.roomdatabasedaggerhilt.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import xit.zubrein.roomdatabasedaggerhilt.model.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user:User)

    @Query("SELECT * FROM user ORDER BY id ASC")
    fun getUserData() : Flow<List<User>>

    @Query("Update user SET age = :age WHERE name = :name")
    suspend fun updateData(name:String , age:String)

    @Query("SELECT * FROM user WHERE name = :name")
    suspend fun findData(name:String) : List<User>

}