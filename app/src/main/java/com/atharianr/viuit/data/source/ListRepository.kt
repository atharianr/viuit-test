package com.atharianr.viuit.data.source

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import com.atharianr.viuit.data.source.local.LocalDataSource
import com.atharianr.viuit.data.source.local.entity.DetailListEntity
import com.atharianr.viuit.data.source.remote.RemoteDataSource
import com.atharianr.viuit.data.source.remote.response.ListResponse
import com.atharianr.viuit.data.source.remote.response.vo.ApiResponse
import com.atharianr.viuit.utils.AppExecutors
import com.atharianr.viuit.vo.Resource
import java.util.concurrent.Executors

class ListRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
) {
    @SuppressLint("VisibleForTests")
    private val appExecutors = AppExecutors(
        Executors.newSingleThreadExecutor(),
        Executors.newFixedThreadPool(AppExecutors.THREAD_COUNT),
        AppExecutors.MainThreadExecutor()
    )

    fun getList(): LiveData<Resource<List<DetailListEntity>>> {
        return object : NetworkBoundResource<List<DetailListEntity>, ListResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<List<DetailListEntity>> = localDataSource.getList()

            override fun shouldFetch(data: List<DetailListEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<ListResponse>> =
                remoteDataSource.getList()

            override fun saveCallResult(data: ListResponse) {
                val details = arrayListOf(
                    DetailListEntity(
                        0,
                        "2017-05",
                        data.jsonMember201705[0].maxTimeGeneration,
                        data.jsonMember201705[0].nbHitsWithTimeGeneration,
                        data.jsonMember201705[0].sumDailyExitNbUniqVisitors,
                        data.jsonMember201705[0].avgBandwidth,
                        data.jsonMember201705[0].minTimeGeneration,
                        data.jsonMember201705[0].sumTimeSpent,
                        data.jsonMember201705[0].bounceRate,
                        data.jsonMember201705[0].label,
                        data.jsonMember201705[0].sumDailyNbUniqVisitors,
                        data.jsonMember201705[0].entryNbActions,
                        data.jsonMember201705[0].sumDailyEntryNbUniqVisitors,
                        data.jsonMember201705[0].nbHitsWithBandwidth,
                        data.jsonMember201705[0].entryNbVisits,
                        data.jsonMember201705[0].entrySumVisitLength,
                        data.jsonMember201705[0].avgTimeOnPage,
                        data.jsonMember201705[0].nbVisits,
                        data.jsonMember201705[0].nbHits,
                        data.jsonMember201705[0].entryBounceCount,
                        data.jsonMember201705[0].exitNbVisits,
                        data.jsonMember201705[0].exitRate,
                        data.jsonMember201705[0].avgTimeGeneration,
                        data.jsonMember201705[0].sumBandwidth
                    ),
                    DetailListEntity(
                        1,
                        "2017-06",
                        data.jsonMember201706[0].maxTimeGeneration,
                        data.jsonMember201706[0].nbHitsWithTimeGeneration,
                        data.jsonMember201706[0].sumDailyExitNbUniqVisitors,
                        data.jsonMember201706[0].avgBandwidth,
                        data.jsonMember201706[0].minTimeGeneration,
                        data.jsonMember201706[0].sumTimeSpent,
                        data.jsonMember201706[0].bounceRate,
                        data.jsonMember201706[0].label,
                        data.jsonMember201706[0].sumDailyNbUniqVisitors,
                        data.jsonMember201706[0].entryNbActions,
                        data.jsonMember201706[0].sumDailyEntryNbUniqVisitors,
                        data.jsonMember201706[0].nbHitsWithBandwidth,
                        data.jsonMember201706[0].entryNbVisits,
                        data.jsonMember201706[0].entrySumVisitLength,
                        data.jsonMember201706[0].avgTimeOnPage,
                        data.jsonMember201706[0].nbVisits,
                        data.jsonMember201706[0].nbHits,
                        data.jsonMember201706[0].entryBounceCount,
                        data.jsonMember201706[0].exitNbVisits,
                        data.jsonMember201706[0].exitRate,
                        data.jsonMember201706[0].avgTimeGeneration,
                        data.jsonMember201706[0].sumBandwidth
                    ),
                    DetailListEntity(
                        2,
                        "2019-07",
                        data.jsonMember201907[0].maxTimeGeneration,
                        data.jsonMember201907[0].nbHitsWithTimeGeneration,
                        data.jsonMember201907[0].sumDailyExitNbUniqVisitors,
                        data.jsonMember201907[0].avgBandwidth,
                        data.jsonMember201907[0].minTimeGeneration,
                        data.jsonMember201907[0].sumTimeSpent,
                        data.jsonMember201907[0].bounceRate,
                        data.jsonMember201907[0].label,
                        data.jsonMember201907[0].sumDailyNbUniqVisitors,
                        data.jsonMember201907[0].entryNbActions,
                        data.jsonMember201907[0].sumDailyEntryNbUniqVisitors,
                        data.jsonMember201907[0].nbHitsWithBandwidth,
                        data.jsonMember201907[0].entryNbVisits,
                        data.jsonMember201907[0].entrySumVisitLength,
                        data.jsonMember201907[0].avgTimeOnPage,
                        data.jsonMember201907[0].nbVisits,
                        data.jsonMember201907[0].nbHits,
                        data.jsonMember201907[0].entryBounceCount,
                        data.jsonMember201907[0].exitNbVisits,
                        data.jsonMember201907[0].exitRate,
                        data.jsonMember201907[0].avgTimeGeneration,
                        data.jsonMember201907[0].sumBandwidth
                    ),
                    DetailListEntity(
                        3,
                        "2017-08",
                        data.jsonMember201708[0].maxTimeGeneration,
                        data.jsonMember201708[0].nbHitsWithTimeGeneration,
                        data.jsonMember201708[0].sumDailyExitNbUniqVisitors,
                        data.jsonMember201708[0].avgBandwidth,
                        data.jsonMember201708[0].minTimeGeneration,
                        data.jsonMember201708[0].sumTimeSpent,
                        data.jsonMember201708[0].bounceRate,
                        data.jsonMember201708[0].label,
                        data.jsonMember201708[0].sumDailyNbUniqVisitors,
                        data.jsonMember201708[0].entryNbActions,
                        data.jsonMember201708[0].sumDailyEntryNbUniqVisitors,
                        data.jsonMember201708[0].nbHitsWithBandwidth,
                        data.jsonMember201708[0].entryNbVisits,
                        data.jsonMember201708[0].entrySumVisitLength,
                        data.jsonMember201708[0].avgTimeOnPage,
                        data.jsonMember201708[0].nbVisits,
                        data.jsonMember201708[0].nbHits,
                        data.jsonMember201708[0].entryBounceCount,
                        data.jsonMember201708[0].exitNbVisits,
                        data.jsonMember201708[0].exitRate,
                        data.jsonMember201708[0].avgTimeGeneration,
                        data.jsonMember201708[0].sumBandwidth
                    ),
                    DetailListEntity(
                        4,
                        "2017-09",
                        data.jsonMember201709[0].maxTimeGeneration,
                        data.jsonMember201709[0].nbHitsWithTimeGeneration,
                        data.jsonMember201709[0].sumDailyExitNbUniqVisitors,
                        data.jsonMember201709[0].avgBandwidth,
                        data.jsonMember201709[0].minTimeGeneration,
                        data.jsonMember201709[0].sumTimeSpent,
                        data.jsonMember201709[0].bounceRate,
                        data.jsonMember201709[0].label,
                        data.jsonMember201709[0].sumDailyNbUniqVisitors,
                        data.jsonMember201709[0].entryNbActions,
                        data.jsonMember201709[0].sumDailyEntryNbUniqVisitors,
                        data.jsonMember201709[0].nbHitsWithBandwidth,
                        data.jsonMember201709[0].entryNbVisits,
                        data.jsonMember201709[0].entrySumVisitLength,
                        data.jsonMember201709[0].avgTimeOnPage,
                        data.jsonMember201709[0].nbVisits,
                        data.jsonMember201709[0].nbHits,
                        data.jsonMember201709[0].entryBounceCount,
                        data.jsonMember201709[0].exitNbVisits,
                        data.jsonMember201709[0].exitRate,
                        data.jsonMember201709[0].avgTimeGeneration,
                        data.jsonMember201709[0].sumBandwidth
                    ),
                    DetailListEntity(
                        5,
                        "2017-10",
                        data.jsonMember201710[0].maxTimeGeneration,
                        data.jsonMember201710[0].nbHitsWithTimeGeneration,
                        data.jsonMember201710[0].sumDailyExitNbUniqVisitors,
                        data.jsonMember201710[0].avgBandwidth,
                        data.jsonMember201710[0].minTimeGeneration,
                        data.jsonMember201710[0].sumTimeSpent,
                        data.jsonMember201710[0].bounceRate,
                        data.jsonMember201710[0].label,
                        data.jsonMember201710[0].sumDailyNbUniqVisitors,
                        data.jsonMember201710[0].entryNbActions,
                        data.jsonMember201710[0].sumDailyEntryNbUniqVisitors,
                        data.jsonMember201710[0].nbHitsWithBandwidth,
                        data.jsonMember201710[0].entryNbVisits,
                        data.jsonMember201710[0].entrySumVisitLength,
                        data.jsonMember201710[0].avgTimeOnPage,
                        data.jsonMember201710[0].nbVisits,
                        data.jsonMember201710[0].nbHits,
                        data.jsonMember201710[0].entryBounceCount,
                        data.jsonMember201710[0].exitNbVisits,
                        data.jsonMember201710[0].exitRate,
                        data.jsonMember201710[0].avgTimeGeneration,
                        data.jsonMember201710[0].sumBandwidth
                    ),
                    DetailListEntity(
                        6,
                        "2017-11",
                        data.jsonMember201711[0].maxTimeGeneration,
                        data.jsonMember201711[0].nbHitsWithTimeGeneration,
                        data.jsonMember201711[0].sumDailyExitNbUniqVisitors,
                        data.jsonMember201711[0].avgBandwidth,
                        data.jsonMember201711[0].minTimeGeneration,
                        data.jsonMember201711[0].sumTimeSpent,
                        data.jsonMember201711[0].bounceRate,
                        data.jsonMember201711[0].label,
                        data.jsonMember201711[0].sumDailyNbUniqVisitors,
                        data.jsonMember201711[0].entryNbActions,
                        data.jsonMember201711[0].sumDailyEntryNbUniqVisitors,
                        data.jsonMember201711[0].nbHitsWithBandwidth,
                        data.jsonMember201711[0].entryNbVisits,
                        data.jsonMember201711[0].entrySumVisitLength,
                        data.jsonMember201711[0].avgTimeOnPage,
                        data.jsonMember201711[0].nbVisits,
                        data.jsonMember201711[0].nbHits,
                        data.jsonMember201711[0].entryBounceCount,
                        data.jsonMember201711[0].exitNbVisits,
                        data.jsonMember201711[0].exitRate,
                        data.jsonMember201711[0].avgTimeGeneration,
                        data.jsonMember201711[0].sumBandwidth
                    ),
                    DetailListEntity(
                        7,
                        "2017-12",
                        data.jsonMember201712[0].maxTimeGeneration,
                        data.jsonMember201712[0].nbHitsWithTimeGeneration,
                        data.jsonMember201712[0].sumDailyExitNbUniqVisitors,
                        data.jsonMember201712[0].avgBandwidth,
                        data.jsonMember201712[0].minTimeGeneration,
                        data.jsonMember201712[0].sumTimeSpent,
                        data.jsonMember201712[0].bounceRate,
                        data.jsonMember201712[0].label,
                        data.jsonMember201712[0].sumDailyNbUniqVisitors,
                        data.jsonMember201712[0].entryNbActions,
                        data.jsonMember201712[0].sumDailyEntryNbUniqVisitors,
                        data.jsonMember201712[0].nbHitsWithBandwidth,
                        data.jsonMember201712[0].entryNbVisits,
                        data.jsonMember201712[0].entrySumVisitLength,
                        data.jsonMember201712[0].avgTimeOnPage,
                        data.jsonMember201712[0].nbVisits,
                        data.jsonMember201712[0].nbHits,
                        data.jsonMember201712[0].entryBounceCount,
                        data.jsonMember201712[0].exitNbVisits,
                        data.jsonMember201712[0].exitRate,
                        data.jsonMember201712[0].avgTimeGeneration,
                        data.jsonMember201712[0].sumBandwidth
                    ),
                    DetailListEntity(
                        8,
                        "2018-01",
                        data.jsonMember201801[0].maxTimeGeneration,
                        data.jsonMember201801[0].nbHitsWithTimeGeneration,
                        data.jsonMember201801[0].sumDailyExitNbUniqVisitors,
                        data.jsonMember201801[0].avgBandwidth,
                        data.jsonMember201801[0].minTimeGeneration,
                        data.jsonMember201801[0].sumTimeSpent,
                        data.jsonMember201801[0].bounceRate,
                        data.jsonMember201801[0].label,
                        data.jsonMember201801[0].sumDailyNbUniqVisitors,
                        data.jsonMember201801[0].entryNbActions,
                        data.jsonMember201801[0].sumDailyEntryNbUniqVisitors,
                        data.jsonMember201801[0].nbHitsWithBandwidth,
                        data.jsonMember201801[0].entryNbVisits,
                        data.jsonMember201801[0].entrySumVisitLength,
                        data.jsonMember201801[0].avgTimeOnPage,
                        data.jsonMember201801[0].nbVisits,
                        data.jsonMember201801[0].nbHits,
                        data.jsonMember201801[0].entryBounceCount,
                        data.jsonMember201801[0].exitNbVisits,
                        data.jsonMember201801[0].exitRate,
                        data.jsonMember201801[0].avgTimeGeneration,
                        data.jsonMember201801[0].sumBandwidth
                    ),
                )

                localDataSource.insertList(details)
            }
        }.asLiveData()
    }
}