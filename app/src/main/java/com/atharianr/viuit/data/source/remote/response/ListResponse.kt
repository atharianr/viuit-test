package com.atharianr.viuit.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListResponse(
	@field:SerializedName("2017-03")
	val jsonMember201703: List<DataDetailResponse>,

	@field:SerializedName("2017-04")
	val jsonMember201704: List<DataDetailResponse>,

	@field:SerializedName("2017-05")
	val jsonMember201705: List<DataDetailResponse>,

	@field:SerializedName("2017-06")
	val jsonMember201706: List<DataDetailResponse>,

	@field:SerializedName("2019-07")
	val jsonMember201907: List<DataDetailResponse>,

	@field:SerializedName("2017-10")
	val jsonMember201710: List<DataDetailResponse>,

	@field:SerializedName("2017-11")
	val jsonMember201711: List<DataDetailResponse>,

	@field:SerializedName("2018-01")
	val jsonMember201801: List<DataDetailResponse>,

	@field:SerializedName("2017-12")
	val jsonMember201712: List<DataDetailResponse>,

	@field:SerializedName("2017-02")
	val jsonMember201702: List<DataDetailResponse>,

	@field:SerializedName("2017-08")
	val jsonMember201708: List<DataDetailResponse>,

	@field:SerializedName("2017-09")
	val jsonMember201709: List<DataDetailResponse>
)

data class DataDetailResponse(


	@field:SerializedName("max_time_generation")
	val maxTimeGeneration: String,

	@field:SerializedName("nb_hits_with_time_generation")
	val nbHitsWithTimeGeneration: Int,

	@field:SerializedName("sum_daily_exit_nb_uniq_visitors")
	val sumDailyExitNbUniqVisitors: Int,

	@field:SerializedName("min_bandwidth")
	val minBandwidth: Any,

	@field:SerializedName("avg_bandwidth")
	val avgBandwidth: Int,

	@field:SerializedName("min_time_generation")
	val minTimeGeneration: String,

	@field:SerializedName("sum_time_spent")
	val sumTimeSpent: Int,

	@field:SerializedName("bounce_rate")
	val bounceRate: String,

	@field:SerializedName("label")
	val label: String,

	@field:SerializedName("sum_daily_nb_uniq_visitors")
	val sumDailyNbUniqVisitors: Int,

	@field:SerializedName("entry_nb_actions")
	val entryNbActions: Int,

	@field:SerializedName("sum_daily_entry_nb_uniq_visitors")
	val sumDailyEntryNbUniqVisitors: Int,

	@field:SerializedName("nb_hits_with_bandwidth")
	val nbHitsWithBandwidth: Int,

	@field:SerializedName("entry_nb_visits")
	val entryNbVisits: Int,

	@field:SerializedName("max_bandwidth")
	val maxBandwidth: Any,

	@field:SerializedName("entry_sum_visit_length")
	val entrySumVisitLength: Int,

	@field:SerializedName("avg_time_on_page")
	val avgTimeOnPage: Int,

	@field:SerializedName("nb_visits")
	val nbVisits: Int,

	@field:SerializedName("nb_hits")
	val nbHits: Int,

	@field:SerializedName("entry_bounce_count")
	val entryBounceCount: Int,

	@field:SerializedName("exit_nb_visits")
	val exitNbVisits: Int,

	@field:SerializedName("exit_rate")
	val exitRate: String,

	@field:SerializedName("avg_time_generation")
	val avgTimeGeneration: Double,

	@field:SerializedName("sum_bandwidth")
	val sumBandwidth: Int
)
