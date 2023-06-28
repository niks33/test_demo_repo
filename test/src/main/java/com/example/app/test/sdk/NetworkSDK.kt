package com.example.app.test.sdk

import com.example.app.test.RequestBody
import com.example.app.test.ResponseBody
import com.example.app.test.RetrofitClientInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

public class NetworkSDK() {

    var listener: (()->Unit)? = null

    companion object {
        private lateinit var instance: NetworkSDK

        fun getInstance(): NetworkSDK {
            return instance;
        }
    }

    init {
        if (instance == null) {
            instance = this
        }
    }

    fun performTask(name: String, reason: String, callback: (result: String, Int) -> Unit) {
        GlobalScope.launch(Dispatchers.Default) {
            val responseBody=  RequestBody(name, reason)
            val response = RetrofitClientInstance().getInstance().performPostMsg("1234", responseBody)
            callback.invoke(response.message, response.queue)
        }
    }
}