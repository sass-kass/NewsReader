package com.example.rssnewsreader.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rssnewsreader.network.Feed
import com.example.rssnewsreader.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val dataSource: NewsRepository): ViewModel() {
    var currentNews: MutableLiveData<Feed> = MutableLiveData<Feed>()

    init {
        getNews()
    }

    fun getNews() {
        viewModelScope.launch(Dispatchers.IO) {
            currentNews.postValue(dataSource.getNews())
        }
    }
}