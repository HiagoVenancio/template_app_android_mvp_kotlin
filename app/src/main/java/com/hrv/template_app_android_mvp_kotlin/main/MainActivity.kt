package com.hrv.template_app_android_mvp_kotlin.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hrv.template_app_android_mvp_kotlin.R
import com.hrv.template_app_android_mvp_kotlin.login.LoginActivity
import com.hrv.template_app_android_mvp_kotlin.utilitarios.SharedPreferencesConfig
import com.hrv.template_app_android_mvp_kotlin.utilitarios.Util
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), IMain.View {

    private lateinit var presenter: IMain.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this)

        btnLogout.setOnClickListener{
            presenter.logout()
        }
    }

    override fun sairDaAplicacao() {
        SharedPreferencesConfig.logout(this)
        val intent = Intent(this, LoginActivity::class.java)
        Util.limparActivitiesAnteriores(intent)
        startActivity(intent)
    }
}