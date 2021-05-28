package xit.zubrein.roomdatabasedaggerhilt.dagger

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import xit.zubrein.roomdatabasedaggerhilt.dao.UserDao
import xit.zubrein.roomdatabasedaggerhilt.database.UserDatabase
import xit.zubrein.roomdatabasedaggerhilt.repository.UserRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesUserDatabase(@ApplicationContext context: Context):UserDatabase
            = Room.databaseBuilder(context, UserDatabase::class.java,"UserDatabase").build()

    @Provides
    fun providesUserRepository(userDao: UserDao) : UserRepository
            = UserRepository(userDao)

    @Provides
    fun providesUserDao(userDatabase: UserDatabase):UserDao = userDatabase.userDao()

}