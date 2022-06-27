package com.atharianr.viuit.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("rc")
	val rc: String?,

	@field:SerializedName("rd")
	val rd: String?
)
