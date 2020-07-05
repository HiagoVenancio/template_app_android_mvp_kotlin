package com.hrv.template_app_android_mvp_kotlin.main

import android.content.Context


class MainPresenter(private val view: IMain.View) : IMain.Presenter {

    override fun logout() {
        view.sairDaAplicacao()
    }

}