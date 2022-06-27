package com.atharianr.viuit.ui.list

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.atharianr.viuit.databinding.ActivityListBinding
import com.atharianr.viuit.databinding.DialogDetailBinding
import com.atharianr.viuit.vo.Status
import org.koin.androidx.viewmodel.ext.android.viewModel


class ListActivity : AppCompatActivity() {

    private var _binding: ActivityListBinding? = null
    private val binding get() = _binding as ActivityListBinding

    private var _dialogBinding: DialogDetailBinding? = null
    private val dialogBinding get() = _dialogBinding as DialogDetailBinding

    private val listViewModel: ListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityListBinding.inflate(layoutInflater)
        _dialogBinding = DialogDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dialog = Dialog(this)
        dialog.setContentView(dialogBinding.root)

        val listAdapter = ListAdapter()

        listViewModel.getList().observe(this) {
            when (it.status) {
                Status.LOADING -> {
                    isLoading(true)
                }
                Status.SUCCESS -> {
                    isLoading(false)
                    showEmptyLayout(false)
                    if (it.data != null) {
                        listAdapter.setData(it.data)
                    }
                }
                Status.ERROR -> {
                    isLoading(false)
                    showEmptyLayout(true)
                    Toast.makeText(
                        this,
                        "Terjadi kesalahan...",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        with(binding) {
            refresh.setOnRefreshListener {
                listViewModel.getList().observe(this@ListActivity) {
                    when (it.status) {
                        Status.LOADING -> {
                            isLoading(true)
                            refresh.isRefreshing = true
                        }
                        Status.SUCCESS -> {
                            isLoading(false)
                            showEmptyLayout(false)
                            if (it.data != null) {
                                listAdapter.setData(it.data)
                            }
                            refresh.isRefreshing = false
                        }
                        Status.ERROR -> {
                            isLoading(false)
                            showEmptyLayout(true)
                            Toast.makeText(
                                this@ListActivity,
                                "Terjadi kesalahan...",
                                Toast.LENGTH_SHORT
                            ).show()
                            refresh.isRefreshing = false
                        }
                    }
                }
            }
        }

        with(binding.rvList) {
            this.layoutManager = LinearLayoutManager(context)
            this.setHasFixedSize(true)
            this.adapter = listAdapter
        }
    }

    private fun isLoading(state: Boolean) {
        binding.apply {
            if (state) {
                progressBar.visibility = View.VISIBLE
                rvList.visibility = View.GONE
            } else {
                progressBar.visibility = View.GONE
                rvList.visibility = View.VISIBLE
            }
        }
    }

    private fun showEmptyLayout(state: Boolean) {
        if (state) {
            binding.rvList.visibility = View.GONE
            binding.tvError.visibility = View.VISIBLE
        } else {
            binding.rvList.visibility = View.VISIBLE
            binding.tvError.visibility = View.GONE
        }
    }
}