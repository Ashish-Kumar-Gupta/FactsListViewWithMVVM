package com.sample.factsrecyclerview.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.sample.factsrecyclerview.BR
import com.sample.factsrecyclerview.model.Fact
import com.sample.factsrecyclerview.viewmodel.MainViewModel

class FactsRecyclerViewAdapter(@LayoutRes private val layoutId: Int, private val mainViewModel: MainViewModel): RecyclerView.Adapter<FactsRecyclerViewAdapter.FactViewHolder>() {
    private var factsList: List<Fact>? = null

    class FactViewHolder(viewDataBinding: ViewDataBinding): RecyclerView.ViewHolder(viewDataBinding.root) {
        private val viewDataBinding = viewDataBinding

        fun bind(mainViewModel: MainViewModel, position: Int) {
//            mainViewModel.fetchDogBreedImagesAt(position)
            viewDataBinding.setVariable(BR.viewModel, mainViewModel)
            viewDataBinding.setVariable(BR.position, position)
            viewDataBinding.executePendingBindings()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return getItemViewTypeForPosition()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FactViewHolder {
        return FactViewHolder(DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(parent.context), viewType, parent, false))
    }

    override fun getItemCount(): Int {
        if (factsList != null) {
            return factsList?.size!!
        }
        return 0
    }

    override fun onBindViewHolder(holder: FactViewHolder, position: Int) {
        holder.bind(mainViewModel, position)
    }

    fun setFacts(factsList: List<Fact>) {
        this.factsList = factsList
    }

    private fun getItemViewTypeForPosition(): Int {
        return layoutId
    }
}