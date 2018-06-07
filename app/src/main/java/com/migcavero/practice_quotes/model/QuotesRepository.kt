package com.migcavero.practice_quotes.model

import android.arch.lifecycle.LiveData
import retrofit2.Callback
import android.arch.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QuotesRepository {

    private val BASE_URL: String = "https://gist.githubusercontent.com/shreyasminocha/7d5dedafc1fe158f82563c1223855177/raw/228c1e9979499a25a9ba1b134fc7a04a07cc5fd1/"
    private var mQuotesApi: QuotesApi

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        mQuotesApi = retrofit.create(QuotesApi::class.java)
    }

    fun getQuotesFromWeb(): LiveData<List<Quote>> {
        // This is not an optimal implementation, we'll fix it below
        val quotesData = MutableLiveData<List<Quote>>()
        mQuotesApi.getQuotes().enqueue(object : Callback<List<Quote>> {
            override fun onFailure(call: Call<List<Quote>>?, t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<List<Quote>>?, response: Response<List<Quote>>) {
                // error case is left out for brevity
                quotesData.value = response.body()
            }
        })
        return quotesData
    }
}