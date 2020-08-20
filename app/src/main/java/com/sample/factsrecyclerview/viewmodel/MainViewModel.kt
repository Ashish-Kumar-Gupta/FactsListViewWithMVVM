package com.sample.factsrecyclerview.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.sample.factsrecyclerview.R
import com.sample.factsrecyclerview.api.RemoteSourceImpl
import com.sample.factsrecyclerview.model.Fact
import com.sample.factsrecyclerview.view.adapter.FactsRecyclerViewAdapter
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val remoteSourceImpl: RemoteSourceImpl): ViewModel() {
    var toolbarTitleLiveData: MutableLiveData<String>? = null
    var factsLiveData: MutableLiveData<List<Fact>>? = null
    private var factsRecyclerViewAdapter: FactsRecyclerViewAdapter? = null

    init {
        toolbarTitleLiveData = MutableLiveData()
        factsLiveData = MutableLiveData()
        factsRecyclerViewAdapter = FactsRecyclerViewAdapter(R.layout.facts_recycler_view_row, this)
    }

    fun getFacts() = liveData(Dispatchers.IO) {
        emit(remoteSourceImpl.getFacts())
    }

    fun getFactsAdapter() = factsRecyclerViewAdapter!!

    fun setFactsAdapter(factsList: List<Fact>) {
        this.factsRecyclerViewAdapter?.setFacts(factsList)
        this.factsRecyclerViewAdapter?.notifyDataSetChanged()
    }

    fun getFactAtPosition(position: Int): Fact {
        return factsLiveData?.value?.get(position)!!
    }

    fun getPicassoInstance() = Picasso.get()
}