package com.atharianr.viuit.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.atharianr.viuit.data.source.local.entity.DetailListEntity

@Database(
    entities = [DetailListEntity::class],
    version = 1,
    exportSchema = false
)

abstract class Database : RoomDatabase() {
    abstract fun dao(): Dao
}