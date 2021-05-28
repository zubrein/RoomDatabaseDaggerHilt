package xit.zubrein.roomdatabasedaggerhilt.database

import androidx.room.Database
import androidx.room.RoomDatabase
import xit.zubrein.roomdatabasedaggerhilt.dao.UserDao
import xit.zubrein.roomdatabasedaggerhilt.model.User

@Database(entities = [User::class],version = 1, exportSchema = false )
abstract  class UserDatabase : RoomDatabase(){
    abstract fun userDao():UserDao
}