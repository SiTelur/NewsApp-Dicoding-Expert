package com.lury.newsapp.core.data.datasource.remote

import android.util.Log
import com.lury.newsapp.core.data.datasource.remote.retrofit.ApiResponse
import com.lury.newsapp.core.data.datasource.remote.retrofit.ApiService
import com.lury.newsapp.core.data.model.response.ArticlesItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
    fun getNewsHeadline() : Flow<ApiResponse<List<ArticlesItem>>> = flow {
            try {
                val response = apiService.getTopHeadlines()
                val dataArray = response.articles
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.articles))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }

    }.flowOn(Dispatchers.IO)
}