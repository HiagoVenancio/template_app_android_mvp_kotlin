package com.hrv.template_app_android_mvp_kotlin.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.hrv.template_app_android_mvp_kotlin.main.MainActivity
import com.hrv.template_app_android_mvp_kotlin.R
import com.hrv.template_app_android_mvp_kotlin.utilitarios.SharedPreferencesConfig
import com.hrv.template_app_android_mvp_kotlin.utilitarios.Util
import kotlinx.android.synthetic.main.login_activity.*


@Suppress("UNREACHABLE_CODE")
class LoginActivity : AppCompatActivity(), ILogin.View {

    private lateinit var presenter: ILogin.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        presenter = LoginPresenter(this)

        btnLogin.setOnClickListener {
            presenter.validarDadosLogin(etUsuario.text.toString(), etSenha.text.toString())
        }
    }

    override fun mudarBotaoParaProgress() {
        btnLogin.visibility = View.GONE
        progressLogin.visibility = View.VISIBLE
    }

    override fun mudarProgressParaBotao() {
        btnLogin.visibility = View.VISIBLE
        progressLogin.visibility = View.GONE
    }

    override fun camposVazios() {
        Toast.makeText(this, "Campos Vazios", Toast.LENGTH_SHORT).show()
    }

    override fun dadosIncorretos() {
        Toast.makeText(this, "Dados Inválidos", Toast.LENGTH_SHORT).show()
    }

    override fun sucessoAoLogar() {
        val intent =
            Intent(this, MainActivity::class.java)
        Util.limparActivitiesAnteriores(intent)
        startActivity(intent)
    }

    override fun salvarEstadoLogin() {
        SharedPreferencesConfig.salvarEstadoLogin(this,1)

    }

}