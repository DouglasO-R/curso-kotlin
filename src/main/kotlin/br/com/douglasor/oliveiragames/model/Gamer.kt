package br.com.douglasor.oliveiragames.model

import java.util.Scanner
import kotlin.random.Random

data class Gamer(var name: String, var email: String) {
    var birthDate: String? = null
    var user: String? = null
        set(value) {
            field = value
            if (internalId.isNullOrBlank()) {
                generateInternalId()
            }
        }
    var internalId: String? = null
        private set
    val searchedGames = mutableListOf<Game?>()

    constructor(name: String, email: String, birthDate: String, user: String) : this(name, email) {
        this.birthDate = birthDate
        this.user = user
        generateInternalId()
    }

    init {
        if (name.isBlank()) {
            throw IllegalArgumentException("nome esta em branco")
        }
        this.email = emailValidate()
    }

    override fun toString(): String {
        return "Gamer(nome='$name', email='$email', dataNascimento=$birthDate, usuario=$user, idInterno=$internalId)"
    }

    fun generateInternalId() {
        val number = Random.nextInt(1000)
        val tag = String.format("%04d", number)
        internalId = "$user#$tag"
    }

    fun emailValidate(): String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (regex.matches(email)) {
            return email
        } else {
            throw IllegalArgumentException("email Invalido")
        }
    }

    companion object {
        fun criarGamer(leitura: Scanner): Gamer {
            println("Boas vindas ao AluGames! Vamos fazer seu cadastro. Digite seu nome:")
            val nome = leitura.nextLine()
            println("Digite seu e-mail:")
            val email = leitura.nextLine()
            println("Deseja completar seu cadastro com usuário e data de nascimento? (S/N)")
            val opcao = leitura.nextLine()

            if (opcao.equals("s", true)) {
                println("Digite sua data de nascimento(DD/MM/AAAA):")
                val nascimento = leitura.nextLine()
                println("Digite seu nome de usuário:")
                val usuario = leitura.nextLine()

                return Gamer(nome, email, nascimento, usuario)
            } else {
                return Gamer (nome, email)
            }

        }
    }
}

