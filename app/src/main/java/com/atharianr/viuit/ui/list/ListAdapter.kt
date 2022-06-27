package com.atharianr.viuit.ui.list

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.atharianr.viuit.data.source.local.entity.DetailListEntity
import com.atharianr.viuit.databinding.DialogDetailBinding
import com.atharianr.viuit.databinding.ItemsListBinding


class ListAdapter : RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    private var listData = ArrayList<DetailListEntity>()

    fun setData(data: List<DetailListEntity>) {
        this.listData.clear()
        this.listData.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemsListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int = listData.size

    class ViewHolder(private val binding: ItemsListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(data: DetailListEntity) {
            with(binding) {
                tvDate.text = data.date
                tvLabel.text = data.label
                tvNbVisits.text = "NB Visits: ${data.nbVisits}"

                btnDetail.setOnClickListener {
                    val builder = AlertDialog.Builder(itemView.rootView.context)
                    val dialogBinding =
                        DialogDetailBinding.inflate(LayoutInflater.from(itemView.rootView.context))

                    with(dialogBinding) {
                        tvDate.text = data.date
                        tvLabel.text = "Labels: " + data.label
                        tvNbVisits.text = "NB Visits: " + data.nbVisits.toString()
                        tvNbHits.text = "NB hits: " + data.nbHits.toString()
                        tvSumTimeSpent.text = "Time Spent: " + data.sumTimeSpent.toString()
                        tvNbHitsWithTimeGeneration.text =
                            "NB Hits Time Generation: " + data.nbHitsWithTimeGeneration.toString()
                        tvMinTimeGeneration.text = "Min Time Generation: " + data.minTimeGeneration
                        tvMaxTimeGeneration.text = "Max Time Generation: " + data.maxTimeGeneration
                        tvSumBandwidth.text = "Bandwidth: " + data.sumBandwidth.toString()
                        tvNbHitsWithBandwidth.text =
                            "NB Hits Bandwidth: " + data.nbHitsWithBandwidth.toString()
                        tvSumDailyNbUniqVisitors.text =
                            "Daily Unique Visitor: " + data.sumDailyEntryNbUniqVisitors.toString()
                        tvEntryNbVisits.text = "Entry NB Visits: " + data.entryNbVisits.toString()
                        tvEntryNbActions.text =
                            "Entry NB Actions: " + data.entryNbActions.toString()
                        tvEntrySumVisitLength.text =
                            "Entry Visit Length: " + data.entrySumVisitLength.toString()
                        tvEntryBounceCount.text =
                            "Entry Bounce Count: " + data.entryBounceCount.toString()
                        tvExitNbVisits.text = "Exit Nb Visits: " + data.exitNbVisits.toString()
                        tvSumDailyEntryNbUniqVisitors.text =
                            "Daily Entry Unique Visitors: " + data.sumDailyEntryNbUniqVisitors.toString()
                        tvSumDailyExitNbUniqVisitors.text =
                            "Daily Exit Unique Visitors: " + data.sumDailyExitNbUniqVisitors.toString()
                        tvAvgBandwidth.text = "Avg Bandwidth: " + data.avgBandwidth.toString()
                        tvAvgTimeOnPage.text = "Avg Time on Page: " + data.avgTimeOnPage.toString()
                        tvBounceRate.text = "Bounce Rate: " + data.bounceRate
                        tvExitRate.text = "Exit Rate: " + data.exitRate
                        tvAvgTimeGeneration.text =
                            "Avg Time Generation: " + data.avgTimeGeneration.toString()
                    }

                    builder.setView(dialogBinding.root)
                    builder.show()
                }
            }
        }
    }
}