package com.example.jetpackcomposecc

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.jetpackcomposecc.models.Quote
import com.google.gson.Gson

object DataManager {

    var data = emptyArray<Quote>()
    var currentQuote: Quote? = null

    var currentPageType = mutableStateOf(PAGE_TYPE.QUOTE_LIST)
    var isDataLoaded = mutableStateOf(false)

    fun loadAssetFromFile(context: Context) {

        val inputStream = context.assets.open("quotes.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Quote>::class.java)
        isDataLoaded.value = true

    }

    fun switchPage(quote: Quote?) {
        if (currentPageType.value == PAGE_TYPE.QUOTE_LIST) {
            currentQuote = quote
            currentPageType.value = PAGE_TYPE.QUOTE_DETAIL
        } else {
            currentPageType.value = PAGE_TYPE.QUOTE_LIST
        }
    }

}