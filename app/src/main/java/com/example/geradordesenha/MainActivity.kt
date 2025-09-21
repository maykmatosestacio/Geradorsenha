package com.example.geradordesenha

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.geradordesenha.R
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Encontrar o TextView no layout
        val textViewSenha = findViewById<TextView>(R.id.textViewSenha)

        // Gerar a senha ao iniciar o app
        val senhaGerada = gerarSenha()

        // Exibir a senha no TextView
        textViewSenha.text = "Sua senha é: $senhaGerada"
    }

    private fun gerarSenha(): String {
        // Obter a data atual
        val calendar = Calendar.getInstance()
        val diaAtual = calendar.get(Calendar.DAY_OF_MONTH)
        val mesAtual = calendar.get(Calendar.MONTH) + 1 // Mês começa em 0
        val anoAtual = calendar.get(Calendar.YEAR)

        // Calcular a senha usando a fórmula
        val senhaNumerica = (30676 * diaAtual * mesAtual) + anoAtual

        // Converter o número para String e retornar
        return senhaNumerica.toString()
    }
}