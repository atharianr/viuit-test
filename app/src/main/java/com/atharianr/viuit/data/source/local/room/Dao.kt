package com.atharianr.viuit.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.atharianr.viuit.data.source.local.entity.DetailListEntity

@Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(movies: List<DetailListEntity>)

    @Query("SELECT * FROM detail_list_entities")
    fun getList(): LiveData<List<DetailListEntity>>
}