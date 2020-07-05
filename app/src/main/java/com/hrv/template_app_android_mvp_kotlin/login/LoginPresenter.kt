package com.hrv.template_app_android_mvp_kotlin.login

import android.os.Handler


class LoginPresenter(private val loginView: ILogin.View) : ILogin.Presenter {

    val mUsuario: String = "teste"
    val mSenha: String = "123"

    override fun validarDadosLogin(usuario: String, senha: String) {
        if (usuario.isEmpty() || senha.isEmpty()) {
            loginView.camposVazios()

        } else if (usuario.equals(mUsuario, true) && senha.equals(mSenha, true)) {
            loginView.mudarBotaoParaProgress()

            /*Simulando tempo para validação*/
            val handler = Handler()
            handler.postDelayed({
                loginView.mudarProgressParaBotao()
                loginView.salvarEstadoLogin()
                loginView.sucessoAoLogar()
            }, 1500)


        } else {
            loginView.dadosIncorretos()
        }
    }


}