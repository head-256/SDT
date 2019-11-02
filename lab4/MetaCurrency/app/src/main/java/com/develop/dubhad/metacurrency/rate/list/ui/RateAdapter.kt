package com.develop.dubhad.metacurrency.rate.list.ui

import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.develop.dubhad.metacurrency.R
import com.develop.dubhad.metacurrency.utils.extensions.inflate
import kotlinx.android.synthetic.main.item_rate.view.*

class RateAdapter : ListAdapter<Int, RateAdapter.ViewHolder>(
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
        val item = getItem(position)
        holder.bind()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind() {
            with(itemView) {
                item_bank_title.text = "Альфа-банк"
                item_rate_selling.text = "2.033±0.002"
                item_rate_buying.text = "2.033±0.002"
                setOnClickListener {
                    val destination =
                        RateListFragmentDirections.actionRateListFragmentToRateInfoFragment()
                    findNavController().navigate(destination)
                }
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Int>() {
            override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }
    }
}
