package com.example.weatherappmphasis.data.local.preferences

import android.content.Context
import androidx.core.content.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SavePref @Inject constructor(@ApplicationContext context: Context) {
    companion object {
        const val SAVE_FILE_PREFERENCES = "saveFilePreferences"
    }

    private object Key {
        const val CITY = "city"
    }

    private val sharedPreferences =
        context.getSharedPreferences(SAVE_FILE_PREFERENCES, Context.MODE_PRIVATE)

    var city: String?
        get() = sharedPreferences.getString(Key.CITY, null)
        set(value) = sharedPreferences.edit {
            putString(Key.CITY, value).commit()
        }
}