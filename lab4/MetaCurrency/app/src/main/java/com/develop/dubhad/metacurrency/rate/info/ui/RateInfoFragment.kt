package com.develop.dubhad.metacurrency.rate.info.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.develop.dubhad.metacurrency.R
import com.develop.dubhad.metacurrency.utils.DrawableUtil
import com.develop.dubhad.metacurrency.utils.FormatUtil
import com.develop.dubhad.metacurrency.utils.GraphUtil
import com.develop.dubhad.metacurrency.utils.di.Injectable
import com.develop.dubhad.metacurrency.utils.extensions.load
import kotlinx.android.synthetic.main.fragment_rate_info.*

class RateInfoFragment : Fragment(), Injectable {

    val args: RateInfoFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        setHasOptionsMenu(true)

        return inflater.inflate(R.layout.fragment_rate_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fullRate = args.rate

        bank_title.text = fullRate.bank.title
        currency_code.text = fullRate.currency.id
        currency_name.text = fullRate.currency.title
        rate_selling.text =
            FormatUtil.getFormattedRate(fullRate.sellingRate.minRate, fullRate.sellingRate.maxRate)
        rate_buying.text =
            FormatUtil.getFormattedRate(fullRate.buyingRate.minRate, fullRate.buyingRate.maxRate)

        rate_selling.setCompoundDrawablesRelativeWithIntrinsicBounds(
            0,
            0,
            DrawableUtil.getArrow(fullRate.sellingRate.tendency),
            0
        )
        rate_buying.setCompoundDrawablesRelativeWithIntrinsicBounds(
            0,
            0,
            DrawableUtil.getArrow(fullRate.buyingRate.tendency),
            0
        )
        if (fullRate.sellingRate.isBest) {
            best_rate_selling.visibility = View.VISIBLE
        }
        if (fullRate.buyingRate.isBest) {
            best_rate_buying.visibility = View.VISIBLE
        }

        graph1.load(GraphUtil.getWeeklyGraph("BYN", fullRate.currency.id, fullRate.bank.id))
        graph2.load(GraphUtil.getWeeklyGraph(fullRate.currency.id, "BYN", fullRate.bank.id))
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.fragment_rate_info, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_show_stats) {
            if (graph1.visibility == View.GONE) {
                graph1.visibility = View.VISIBLE
                graph2.visibility = View.VISIBLE
            } else {
                graph1.visibility = View.GONE
                graph2.visibility = View.GONE
            }
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
