package com.example.core_presistence_impl.preference

import android.content.Context
import com.example.core_persistence_api.preference.PreferenceManager
import javax.inject.Inject

class PreferenceManagerImpl @Inject constructor(
    context: Context
) : PreferenceManager {

    private val preferences = context.getSharedPreferences(PREF_APP_SCOPE, Context.MODE_PRIVATE)

    override var apiKey: String?
        get() = PREF_API_KEY.getStringOrNull()
        set(value) {
            with(preferences.edit()) {
                putString(PREF_API_KEY, value)
                apply()
            }
        }

    private fun String.getStringOrNull(): String? = preferences.getString(this, null)

    companion object {
        private const val PREF_APP_SCOPE = "PREF_APP_SCOPE"

        private const val PREF_API_KEY = "PREF_API_KEY"
    }
}