package com.migcavero.practice_quotes.model

import retrofit2.Call
import retrofit2.http.GET

interface QuotesApi {

    @GET("quotes.json")
    fun getQuotes(): Call<List<Quote>>

}