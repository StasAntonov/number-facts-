package com.example.numberfacts.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

typealias MovPagingClickListener = (Int) -> Unit

abstract class PagingData(
    val id: Int = -1,
    var position: Int = -1,
    var onClickListener: MovPagingClickListener? = null
)

class PagingAdapter <T : PagingData, VDB : ViewDataBinding>(
    private val bindingInflater: (LayoutInflater, ViewGroup, Boolean) -> VDB,
    private val onClickListener: MovPagingClickListener? = null
) : PagingDataAdapter<T, PagingAdapter.MovViewHolder>(MovDiffUtil()) {

    class MovDiffUtil<T : PagingData> : DiffUtil.ItemCallback<T>() {
        override fun areItemsTheSame(oldItem: T, newItem: T): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: T, newItem: T): Boolean =
            oldItem.hashCode() == newItem.hashCode()
    }

    class MovViewHolder(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun <T : PagingData> bind(item: T) = with(binding) {
            binding.setVariable(BR.viewData, item)
            executePendingBindings()
        }
    }

    override fun onBindViewHolder(holder: MovViewHolder, position: Int) {
        getItem(position)?.let { item ->
            item.position = position
            item.onClickListener = onClickListener
            holder.bind(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovViewHolder {
        val binding = bindingInflater(LayoutInflater.from(parent.context), parent, false)
        return MovViewHolder(binding)
    }

    fun getItemByPosition(position: Int): T? = getItem(position)
}