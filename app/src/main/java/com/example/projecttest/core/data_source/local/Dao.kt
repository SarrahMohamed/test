package com.example.projecttest.core.data_source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.projecttest.core.model.ModelBase
import com.example.projecttest.model.CartItem
import io.reactivex.Flowable


@Dao
interface Daoo :BaseDao<CartItem>{
    @Query("SELECT * FROM CartItem")
    fun getItems(): Flowable<List<CartItem>?>?
    @Query("SELECT * FROM CartItem")
   override fun findAll() : Flowable<List<CartItem>?>?
}
