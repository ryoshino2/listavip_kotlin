package br.com.listavip.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Convidado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0

    var nome: String? = null
    var email: String? = null
    var telefone: String? = null

    constructor(nome: String?, email: String?, telefone: String?) {
        this.nome = nome
        this.email = email
        this.telefone = telefone
    }

    constructor()

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun toString(): String {
        return "nome: " + nome + " - " + "email: " + email + " - " + "telefone: " + telefone
    }

}