package com.hrv.template_app_android_mvp_kotlin.utilitarios

import android.content.Context
import android.preference.PreferenceManager

@Suppress("DEPRECATION")
class SharedPreferencesConfig {

    companion object {

        private const val KEY_LOGIN_PREFERENCE: String = "KEY_LOGIN"

        fun salvarEstadoLogin(context: Context?, value: Int) {
            val edit = PreferenceManager.getDefaultSharedPreferences(context)
            val editor1 = edit.edit()
            editor1.putInt(KEY_LOGIN_PREFERENCE, value)
            editor1.apply()
        }

        fun isLogado(context: Context?): Boolean {
            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            val valor = sharedPreferences.getInt(KEY_LOGIN_PREFERENCE, 0)
            return valor > 0
        }

        fun logout(context: Context?) {
            val edit = PreferenceManager.getDefaultSharedPreferences(context)
            val editor1 = edit.edit()
            editor1.remove(KEY_LOGIN_PREFERENCE)
            editor1.apply()
        }
    }
}