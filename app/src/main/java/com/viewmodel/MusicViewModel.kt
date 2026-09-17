package com.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.data.MyData
import com.repository.MusicRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MusicViewModel : ViewModel() {
    private val repository = MusicRepository()

    private val _musicData = MutableLiveData<MyData?>()
    val musicData: LiveData<MyData?> get() = _musicData

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    fun fetchSongs(query: String) {
        repository.getSongs(query).enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                if (response.isSuccessful) {
                    _musicData.value = response.body()
                } else {
                    _error.value = "Error: ${response.code()}"
                }
            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                _error.value = t.message
            }
        })
    }
}