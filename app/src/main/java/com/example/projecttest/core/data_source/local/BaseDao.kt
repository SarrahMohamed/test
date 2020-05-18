package com.example.projecttest.core.data_source.local

import androidx.room.*
import io.reactivex.Flowable


interface BaseDao <T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(obj: T?)
    @Update
    fun update(obj: T)
    @Query("")
    fun findAll(): Flowable<List<T>?>?
    @Delete
    fun delete(obj: T)
    @Query("")
    fun deleteAll() :Boolean
}