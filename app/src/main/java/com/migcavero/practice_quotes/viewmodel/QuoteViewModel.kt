package com.migcavero.practice_quotes.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.migcavero.practice_quotes.model.Quote

class QuoteViewModel: ViewModel() {
    private val mLiveQuotes: MutableLiveData<List<Quote>> = MutableLiveData()

    init {
        val quoteList = ArrayList<Quote>()
        quoteList.add(Quote("quote 1", "author 1"))
        quoteList.add(Quote("quote 2", "author 2"))
        mLiveQuotes.value = quoteList
    }

    fun getQuotes(): LiveData<List<Quote>>{
        return mLiveQuotes
    }
}