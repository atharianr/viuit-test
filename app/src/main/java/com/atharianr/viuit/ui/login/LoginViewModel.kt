package com.atharianr.viuit.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.atharianr.viuit.data.source.remote.LoginRepository
import com.atharianr.viuit.data.source.remote.network.login.LoginRequest
import com.atharianr.viuit.data.source.remote.response.LoginResponse
import com.atharianr.viuit.data.source.remote.response.vo.ApiResponse

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {
    fun login(loginRequest: LoginRequest): LiveData<ApiResponse<LoginResponse>> =
        loginRepository.login(loginRequest)
}