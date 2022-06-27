package com.atharianr.viuit.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.atharianr.viuit.data.source.remote.network.ApiService
import com.atharianr.viuit.data.source.remote.network.login.LoginRequest
import com.atharianr.viuit.data.source.remote.response.LoginResponse
import com.atharianr.viuit.data.source.remote.response.vo.ApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepository(private val apiService: ApiService) {
    fun login(loginRequest: LoginRequest): LiveData<ApiResponse<LoginResponse>> {
        val resultResponse = MutableLiveData<ApiResponse<LoginResponse>>()

        apiService.login(loginRequest)
            .enqueue(object : Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
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

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    resultResponse.postValue(
                        ApiResponse.error(
                            t.message.toString(),
                            LoginResponse("", "")
                        )
                    )
                }

            })

        return resultResponse
    }
}