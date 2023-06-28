package com.example.app.test

import retrofit2.Retrofit

class RetrofitClientInstance {

    lateinit var retrofit: Retrofit

    fun getInstance(): RetrofitClient{
        retrofit = Retrofit.Builder().baseUrl("https://webhook.site/").build()
        return retrofit.create(RetrofitClient::class.java)
    }

}

