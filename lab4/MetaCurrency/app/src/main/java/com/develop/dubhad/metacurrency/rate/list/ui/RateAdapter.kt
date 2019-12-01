package com.develop.dubhad.metacurrency.rate.list.ui

import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.develop.dubhad.metacurrency.R
import com.develop.dubhad.metacurrency.rate.base.models.domain.FullRate
import com.develop.dubhad.metacurrency.utils.DrawableUtil
import com.develop.dubhad.metacurrency.utils.FormatUtil
import com.develop.dubhad.metacurrency.utils.extensions.inflate
import kotlinx.android.synthetic.main.item_rate.view.*

class RateAdapter : ListAdapter<FullRate, RateAdapter.ViewHolder>(
    DIFF_CALLBACK
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            parent.inflate(
                R.layout.item_rate
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val rate = getItem(position)
        holder.bind(rate)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: FullRate) {
            with(itemView) {
                item_bank_title.text = item.bank.title
                item_rate_selling.text =
                    FormatUtil.getFormattedRate(item.sellingRate.minRate, item.sellingRate.maxRate)
                item_rate_selling.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    0,
                    0,
                    DrawableUtil.getArrow(item.sellingRate.tendency),
                    0
                )
                item_rate_buying.text =
                    FormatUtil.getFormattedRate(item.buyingRate.minRate, item.buyingRate.maxRate)
                item_rate_buying.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    0,
                    0,
                    DrawableUtil.getArrow(item.buyingRate.tendency),
                    0
                )
                setOnClickListener {
                    val destination =
                        RateListFragmentDirections.actionRateListFragmentToRateInfoFragment(item, item.bank.title)
                    findNavController().navigate(destination)
                }
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<FullRate>() {
            override fun areItemsTheSame(oldItem: FullRate, newItem: FullRate): Boolean {
                return oldItem.bank == newItem.bank
            }

            override fun areContentsTheSame(oldItem: FullRate, newItem: FullRate): Boolean {
                return oldItem == newItem
            }
        }
    }
}
