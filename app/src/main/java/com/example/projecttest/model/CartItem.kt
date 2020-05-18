package com.example.projecttest.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.projecttest.core.model.ModelBase
@Entity
class CartItem : ModelBase() {
    @PrimaryKey(autoGenerate = true)
     var id = 0
     var itemName = ""
      var itemAmout = ""
}