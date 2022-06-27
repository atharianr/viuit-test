package com.atharianr.viuit.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.atharianr.viuit.data.source.remote.network.ApiService
import com.atharianr.viuit.data.source.remote.response.ListResponse
import com.atharianr.viuit.data.source.remote.response.vo.ApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource(private val apiService: ApiService) {
    fun getList(): LiveData<ApiResponse<ListResponse>> {
        val resultResponse = MutableLiveData<ApiResponse<ListResponse>>()

        apiService.getList()
            .enqueue(object : Callback<ListResponse> {
                override fun onResponse(
                    call: Call<ListResponse>,
                    response: Response<ListResponse>
                ) {
                    if (response.isSuccessful) {
                        val body = response.body()
                        if (body != null) {
                            resultResponse.postValue(ApiResponse.success(body))
                        }
                    } else {
                        val body = response.body()
                        if (body != null) {
                            resultResponse.postValue(ApiResponse.error(response.message(), body))
                        }
                    }
                }

                override fun onFailure(call: Call<ListResponse>, t: Throwable) {
                    resultResponse.postValue(
                        ApiResponse.error(
                            t.message.toString(),
                            ListResponse(
                                listOf(),
                                listOf(),
                                listOf(),
                                listOf(),
                                listOf(),
                                listOf(),
                                listOf(),
                                listOf(),
                                listOf(),
                                listOf(),
                                listOf(),
                                listOf(),
                            )
                        )
                    )
                }

            })

        return resultResponse
    }
}