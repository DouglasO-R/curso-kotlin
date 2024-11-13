package br.com.douglasor.oliveiragames.model

import br.com.douglasor.oliveiragames.utils.formatter
import java.util.*
import kotlin.random.Random

data class Gamer(var name: String, var email: String) : Recommendation {
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
    val rentedGames: MutableList<Rent> = mutableListOf<Rent>()
    var plan: Plan = BasicPlan("BRONZE")
    val recommendedGames = mutableListOf<Game>()
    private val recommendationList = mutableListOf<Int>()

    override val average: Double
        get() = recommendationList.average().formatter()

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

    override fun recommend(grade: Int) {
        recommendationList.add(grade)
    }

    fun recommendGame(game:Game,score:Int){
        game.recommend(score)
        recommendedGames.add(game)
    }


    override fun toString(): String {
        return "Gamer:\n " +
                " Nome:$name\n" +
                " email:$email\n" +
                " dataNascimento:$birthDate\n" +
                " usuario:$user\n" +
                " idInterno:$internalId\n" +
                " Reputacao:${average}\n" +
                " Plan: $plan"
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

    fun rentGame(game: Game, period: Period): Rent {
        val rent = Rent(this, game, period)
        rentedGames.add(rent)

        return rent
    }

    fun findGameByMonth(month: Int): List<Game> {
        return rentedGames
            .filter { rented -> rented.period.startDate.monthValue == month }
            .map { rented -> rented.game }
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
                return Gamer(nome, email)
            }

        }
    }
}

