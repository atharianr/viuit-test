package com.atharianr.viuit.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.atharianr.viuit.data.source.ListRepository
import com.atharianr.viuit.data.source.local.entity.DetailListEntity
import com.atharianr.viuit.vo.Resource

class ListViewModel(private val listRepository: ListRepository) : ViewModel() {
    fun getList(): LiveData<Resource<List<DetailListEntity>>> = listRepository.getList()
}