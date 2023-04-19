package com.anshumandhal.fakestore.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ProductIdEntity::class],
    version = 1
)
abstract class ProductIdDatabase : RoomDatabase() {

    abstract val dao: ProductDao
}