package com.repository

import com.data.MyData
import com.network.RetrofitInstance
import retrofit2.Call


class MusicRepository {
    fun getSongs(query: String): Call<MyData> {
        return RetrofitInstance.api.getData(query)
    }
}
