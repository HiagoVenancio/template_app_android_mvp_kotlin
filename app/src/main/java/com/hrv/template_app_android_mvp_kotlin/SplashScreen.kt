package com.hrv.template_app_android_mvp_kotlin

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.hrv.template_app_android_mvp_kotlin.login.LoginActivity
import com.hrv.template_app_android_mvp_kotlin.main.MainActivity
import com.hrv.template_app_android_mvp_kotlin.utilitarios.SharedPreferencesConfig
import com.hrv.template_app_android_mvp_kotlin.utilitarios.Util

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        val logado = SharedPreferencesConfig.isLogado(this)

        val handler = Handler()
        handler.postDelayed({
            verificarSeEstaLogado(logado)
        }, 1500)


    }


    private fun verificarSeEstaLogado(logado: Boolean) {
        if (logado) {
            irParaMainAct()
        } else {
            irParaLoginAct()
        }
    }

    private fun irParaMainAct() {
        val intent =
            Intent(this, MainActivity::class.java)
        Util.limparActivitiesAnteriores(intent)
        startActivity(intent)
    }

    private fun irParaLoginAct() {
        val intent =
            Intent(this, LoginActivity::class.java)
        Util.limparActivitiesAnteriores(intent)
        startActivity(intent)
    }

}