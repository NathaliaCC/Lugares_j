package com.example.lugares_j.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.lugares_j.model.Lugar

@Database (entities =[Lugar::class], version = 1, exportSchema = false)
abstract class LugarDataBase: RoomDatabase() {

    abstract fun lugarDao() : LugarDao

    companion object{
        @Volatile
        private var INSTANCE: LugarDataBase? = null

        fun getDatabase(context: Context) : LugarDataBase{
            val local = INSTANCE
            if(local !=null){
                return local
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LugarDataBase::class.java,
                    "Lugar_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}