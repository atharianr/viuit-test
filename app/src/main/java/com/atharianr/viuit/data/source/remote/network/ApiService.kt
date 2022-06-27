package com.atharianr.viuit.data.source.remote.network

import com.atharianr.viuit.data.source.remote.network.login.LoginRequest
import com.atharianr.viuit.data.source.remote.response.ListResponse
import com.atharianr.viuit.data.source.remote.response.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {
    @Headers(
        "Content-Type: application/x-www-form-urlencoded",
        "Accept: application/json"
    )
    @POST("web/test_programmer.php")
    fun login(@Body loginRequest: LoginRequest): Call<LoginResponse>

    @Headers(
        "Content-Type: application/x-www-form-urlencoded",
        "Accept: application/json"
    )
    @GET("web/test_programmer.php")
    fun getList(): Call<ListResponse>
}