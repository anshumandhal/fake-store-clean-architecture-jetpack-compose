package com.anshumandhal.fakestore.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProductIdEntity(

    @PrimaryKey val productId: Int
)
