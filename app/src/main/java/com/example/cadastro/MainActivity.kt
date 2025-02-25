package com.example.cadastro

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cadastro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val activityMainBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private var contador = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(activityMainBinding.root)

        with(activityMainBinding){
            //Botao Salvar
            salvarBt.setOnClickListener {
                salvarFormulario()
            }

            limparBt.setOnClickListener {
                limparCampos()
            }
        }
    }

    private fun salvarFormulario(){
        with(activityMainBinding){
            val nome = nomeEt.text.toString()
            val telefone = telefoneEt.text.toString()
            val email = emailEt.text.toString()
            val ingressarListaEmails = emailCb.isChecked

            val sexoSelecionadoId = sexoRg.checkedRadioButtonId
            val sexo = if (sexoSelecionadoId != -1){
                findViewById<RadioButton>(sexoSelecionadoId).text.toString()
            }else{
                "Não informado"
            }

            val cidade = cidadeEt.text.toString()
            val uf = ufSp.selectedItem.toString()

            val formulario = Formulario(nome, telefone, email, ingressarListaEmails, sexo, cidade, uf)

            Toast.makeText(this@MainActivity, formulario.toString(), Toast.LENGTH_LONG).show()
        }
    }

    private fun limparCampos(){
        with(activityMainBinding){
            nomeEt.text.clear()
            telefoneEt.text.clear()
            emailEt.text.clear()
            emailCb.isChecked = false
            sexoRg.clearCheck()
            cidadeEt.text.clear()
            ufSp.setSelection(0)
        }
    }
}