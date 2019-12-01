package com.develop.dubhad.metacurrency.rate.list.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.preference.PreferenceManager
import com.develop.dubhad.metacurrency.R
import com.develop.dubhad.metacurrency.base.models.Status
import com.develop.dubhad.metacurrency.rate.list.viewmodels.RateListViewModel
import com.develop.dubhad.metacurrency.utils.di.Injectable
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_rate_list.*
import javax.inject.Inject

class RateListFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: RateListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.fragment_rate_list, container, false)

        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(RateListViewModel::class.java)

        val prefs = PreferenceManager.getDefaultSharedPreferences(requireActivity())
        val cur = prefs.getString("currency", "EUR") ?: "EUR"

        requireActivity().toolbar.title = cur

        viewModel.fetchLastRates(cur)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = RateAdapter()
        rate_list_recycler_view.adapter = adapter
        subscribeUi(adapter)
    }

    private fun subscribeUi(adapter: RateAdapter) {
        viewModel.resource.observe(viewLifecycleOwner, Observer { resource ->
            when (resource.status) {
                Status.SUCCESS -> {
                    adapter.submitList(resource.data)
                }
            }
        })
    }
}
