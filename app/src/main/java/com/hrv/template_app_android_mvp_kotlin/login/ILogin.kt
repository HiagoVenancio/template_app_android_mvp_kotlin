package com.hrv.template_app_android_mvp_kotlin.login

interface ILogin {

    interface View{
        fun mudarBotaoParaProgress()
        fun mudarProgressParaBotao()
        fun camposVazios()
        fun dadosIncorretos()
        fun sucessoAoLogar()
        fun salvarEstadoLogin()
    }


    interface Presenter{
        fun validarDadosLogin(usuario:String, senha:String)
    }

}