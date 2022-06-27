package com.atharianr.viuit.data.source.local.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "detail_list_entities")
data class DetailListEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val date: String,

    val maxTimeGeneration: String,

    val nbHitsWithTimeGeneration: Int,

    val sumDailyExitNbUniqVisitors: Int,

    val avgBandwidth: Int,

    val minTimeGeneration: String,

    val sumTimeSpent: Int,

    val bounceRate: String,

    val label: String,

    val sumDailyNbUniqVisitors: Int,

    val entryNbActions: Int,

    val sumDailyEntryNbUniqVisitors: Int,

    val nbHitsWithBandwidth: Int,

    val entryNbVisits: Int,

    val entrySumVisitLength: Int,

    val avgTimeOnPage: Int,

    val nbVisits: Int,

    val nbHits: Int,

    val entryBounceCount: Int,

    val exitNbVisits: Int,

    val exitRate: String,

    val avgTimeGeneration: Double,

    val sumBandwidth: Int,

    ) : Parcelable