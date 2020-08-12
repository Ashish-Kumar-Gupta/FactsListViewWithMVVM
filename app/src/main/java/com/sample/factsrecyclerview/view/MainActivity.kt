package com.sample.factsrecyclerview.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.sample.factsrecyclerview.R
import com.sample.factsrecyclerview.api.RetrofitClient
import com.sample.factsrecyclerview.databinding.ActivityMainBinding
import com.sample.factsrecyclerview.model.Facts
import com.sample.factsrecyclerview.viewmodel.MainViewModel
import com.sample.factsrecyclerview.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private var mainViewModel: MainViewModel? = null
    private var linearLayoutManager: LinearLayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        linearLayoutManager = LinearLayoutManager(this)
        binding?.factsRecyclerView.apply {
            this?.layoutManager = linearLayoutManager
            this?.itemAnimator = DefaultItemAnimator()
        }

        mainViewModel = ViewModelProviders.of(
            this,
            MainViewModelFactory(RetrofitClient.getRetrofitClient())
        ).get(MainViewModel::class.java)

        binding?.viewModel = mainViewModel
        mainViewModel?.getFacts()?.observe(this, Observer<Facts> {
            mainViewModel?.toolbarTitleLiveData?.value = it.title
            mainViewModel?.factsLiveData?.value = it.rows
        })
        mainViewModel?.toolbarTitleLiveData?.observe(this, Observer {
            binding?.toolbarTitle = it
        })
        mainViewModel?.factsLiveData?.observe(this, Observer {
            mainViewModel?.setFactsAdapter(it)
        })
    }
}