package xit.zubrein.roomdatabasedaggerhilt.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User( var name:String, var age:String){
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}
