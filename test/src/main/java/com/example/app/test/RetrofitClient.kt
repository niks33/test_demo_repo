package com.example.app.test

import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

public interface RetrofitClient {

    @POST("5b687eeb-3c0a-410b-b22d-ec6f5e11a50d")
    suspend fun performPostMsg(
        @Header("X-KEY") key: String,
        @Body requestBody: RequestBody
    ):ResponseBody
}