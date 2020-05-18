package com.example.projecttest.core.data_source.dataManager

import io.reactivex.Flowable
import io.reactivex.Maybe



interface IDataManager {
   fun <T>getitems(): Flowable<List<T>?>?
    fun<T> insertCoupon(item: T?)
}