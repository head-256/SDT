package com.develop.dubhad.metacurrency.settings

import android.os.Bundle
import androidx.preference.ListPreference
import androidx.preference.PreferenceFragmentCompat
import com.develop.dubhad.metacurrency.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)

        val currencyListPref: ListPreference? = findPreference("currency")
        currencyListPref?.entries = listOf("USD", "EUR", "CAD").toTypedArray()
        currencyListPref?.entryValues = listOf("USD", "EUR", "CAD").toTypedArray()
    }
}
