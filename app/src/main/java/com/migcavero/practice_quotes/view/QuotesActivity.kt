package com.migcavero.practice_quotes.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.migcavero.practice_quotes.R
import com.migcavero.practice_quotes.viewmodel.QuoteViewModel
import com.migcavero.practice_quotes.viewmodel.QuotesAdapter
import kotlinx.android.synthetic.main.activity_quotes.*

class QuotesActivity : AppCompatActivity() {

    private var mQuotesAdapter: QuotesAdapter = QuotesAdapter(ArrayList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        quotes_recycler_view.layoutManager = LinearLayoutManager(this)
        quotes_recycler_view.adapter = mQuotesAdapter

        val quoteViewModel = ViewModelProviders.of(this).get(QuoteViewModel::class.java)
        quoteViewModel.getQuotes().observe(this, Observer { quotes ->
            mQuotesAdapter.setData(quotes!!)
        })
    }
}
