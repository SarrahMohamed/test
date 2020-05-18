package com.example.projecttest

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projecttest.core.data_source.dataManager.IDataManager
import com.example.projecttest.core.data_source.dataManager.DataManagerImp

import com.example.projecttest.core.data_source.local.DataBase
import com.example.projecttest.model.CartItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {
    var dispos :CompositeDisposable? = null
var dataManager : DataManagerImp? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        dataManager =  DataManagerImp(DataBase.getInstance(application)!!)
        dispos  = CompositeDisposable()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addToRoomBtn.setOnClickListener {
       var item : CartItem = CartItem()
            item.itemName = ed1.text.toString()
            item.itemAmout = ed2.text.toString()
            dataManager?.insertCoupon(item)
            Toast.makeText(applicationContext,"done",Toast.LENGTH_LONG)
        }
        getFromRoomBtn.setOnClickListener {
            dispos?.add(
                dataManager!!.getitems()
                !!.observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe {
                        Log.i("sara",""+it!!.size)
                        t1.text = it!![it.size-1].itemName
                        t2.text = it!![it.size-1].itemAmout

                    }
            )
        }

    }


}


