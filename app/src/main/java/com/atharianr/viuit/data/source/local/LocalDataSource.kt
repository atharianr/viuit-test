package com.atharianr.viuit.data.source.local

import androidx.lifecycle.LiveData
import com.atharianr.viuit.data.source.local.entity.DetailListEntity
import com.atharianr.viuit.data.source.local.room.Dao

class LocalDataSource(private val dao: Dao) {
    fun insertList(details: List<DetailListEntity>) = dao.insertList(details)
    fun getList(): LiveData<List<DetailListEntity>> = dao.getList()
}