package com.lury.newsapp.presentation.listnews

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.map
import com.lury.newsapp.core.data.model.response.Resource
import com.lury.newsapp.core.domain.usecase.news.NewsUseCase
import com.lury.newsapp.presentation.model.NewsUi
import com.lury.newsapp.presentation.model.toNewsUi
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor(newsUseCase: NewsUseCase): ViewModel() {
    val getNewsHeadline : LiveData<Resource<List<NewsUi>>>  = newsUseCase.getNewsHeadline().asLiveData().map { data ->
        when (data){
            is Resource.Error -> Resource.Error(data.message.toString())
            is Resource.Loading -> Resource.Loading()
            is Resource.Success -> Resource.Success(data.data?.map { it.toNewsUi() } ?: emptyList())
        }
    }
}
