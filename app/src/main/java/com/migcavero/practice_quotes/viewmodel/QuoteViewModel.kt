package com.migcavero.practice_quotes.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.migcavero.practice_quotes.model.Quote
import com.migcavero.practice_quotes.model.QuotesRepository

class QuoteViewModel: ViewModel() {
    private var mLiveQuotes: LiveData<List<Quote>>
    private val mQuotesRepository: QuotesRepository = QuotesRepository()

    init {
        mLiveQuotes = mQuotesRepository.getQuotesFromWeb()
    }

    fun getQuotes(): LiveData<List<Quote>>{
        return mLiveQuotes
    }
}