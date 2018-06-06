package com.migcavero.practice_quotes.viewmodel

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.migcavero.practice_quotes.R
import com.migcavero.practice_quotes.model.Quote

class QuotesAdapter(quoteList: ArrayList<Quote>): RecyclerView.Adapter<QuotesAdapter.QuotesViewHolder>() {

    var mQuotesList: List<Quote> = quoteList

    fun setData(quoteList: List<Quote>){
        mQuotesList = quoteList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item_quote, parent, false)

        return QuotesViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuotesViewHolder, position: Int) {
        holder.mQuoteTextView.text = mQuotesList[position].quote
        holder.mAuthorTextView.text = mQuotesList[position].author
    }

    override fun getItemCount(): Int {
        return mQuotesList.size
    }

    class QuotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val mQuoteTextView: TextView = itemView.findViewById(R.id.quote_text_view)
        val mAuthorTextView: TextView = itemView.findViewById(R.id.author_text_view)
    }

}
