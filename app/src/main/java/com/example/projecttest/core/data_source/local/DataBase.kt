package com.example.projecttest.core.data_source.local

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.projecttest.model.CartItem

@Database(entities = [CartItem::class], version = 1)
abstract  class DataBase:RoomDatabase() {

     companion object  {
         private var DB_NAME = "item_database"
         private var INSTANCE: DataBase? = null
         open fun  getInstance(application: Application?): DataBase? {
             if (INSTANCE == null) {
                 INSTANCE = Room.databaseBuilder(
                     application!!,
                     DataBase::class.java,
                     DB_NAME
                 )
                     .allowMainThreadQueries()
                     .build()
             }
             return INSTANCE
         }
     }

    public abstract fun dao(): Daoo?

 }