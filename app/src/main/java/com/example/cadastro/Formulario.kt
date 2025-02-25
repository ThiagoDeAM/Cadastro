package com.example.cadastro

data class Formulario(
    val nome: String,
    val telefone: String,
    val email: String,
    val ingressarListaEmails: Boolean,
    val sexo: String,
    val cidade: String,
    val uf: String
){
    override fun toString(): String {
        return "Nome:'$nome', " +
                "Telefone: '$telefone', " +
                "E-mail: '$email', " +
                "Ingressar na lista de e-mails: $ingressarListaEmails, " +
                "Sexo: '$sexo', " +
                "Cidade: '$cidade', " +
                "UF: '$uf'"
    }
}
