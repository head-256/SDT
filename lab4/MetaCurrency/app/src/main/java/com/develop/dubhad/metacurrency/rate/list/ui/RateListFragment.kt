package com.develop.dubhad.metacurrency.rate.list.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.develop.dubhad.metacurrency.R
import kotlinx.android.synthetic.main.fragment_rate_list.*

class RateListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        return inflater.inflate(R.layout.fragment_rate_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = RateAdapter()
        rate_list_recycler_view.adapter = adapter
        adapter.submitList(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9))
    }
}
