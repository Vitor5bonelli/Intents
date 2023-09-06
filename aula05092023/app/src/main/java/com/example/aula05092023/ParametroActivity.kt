package com.example.aula05092023

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aula05092023.databinding.ActivityMainBinding
import com.example.aula05092023.databinding.ActivityParametroBinding

class ParametroActivity : AppCompatActivity() {
    private val apb by lazy {
        ActivityParametroBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(apb.root)
        supportActionBar?.subtitle = "ParametroActivity"

        val parametroRecebido : String = intent.getStringExtra(MainActivity.PARAMETRO_EXTRA) ?: ""
        apb.parametroEt.setText(parametroRecebido)

        intent.getStringExtra(MainActivity.PARAMETRO_EXTRA)?.let{ parametro ->
            apb.parametroEt.setText(parametro)
        }

        val parametroRetorno = apb.parametroEt.text.toString()

        apb.enviarParametroBt.setOnClickListener {
            val intentRetorno = Intent()
            intentRetorno.putExtra(MainActivity.PARAMETRO_EXTRA, apb.parametroEt.text.toString())
            setResult(RESULT_OK, intentRetorno)
            finish()
        }
    }
}