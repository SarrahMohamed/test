package com.example.projecttest.core.data_source.dataManager

import com.example.projecttest.core.data_source.local.DataBase
import com.example.projecttest.model.CartItem
import io.reactivex.Flowable

open class DataManagerImp(dataBase:DataBase) :IDataManager{
    private val dataBase: DataBase? = dataBase

    override fun<CartItem> getitems(): Flowable<List<CartItem>?>?
   {
     return dataBase?.dao()?.findAll()
   }

    override fun <CartItem> insertCoupon(item: CartItem?) {
        dataBase?.dao()?.insert(item!! as com.example.projecttest.model.CartItem)

    }




}