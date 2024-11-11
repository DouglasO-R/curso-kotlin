package org.example.br.com.douglasor.oliveiragames

import ageFormat
import br.com.douglasor.oliveiragames.model.Game
import br.com.douglasor.oliveiragames.model.Gamer
import br.com.douglasor.oliveiragames.services.FetchApi
import java.util.Scanner


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    val input = Scanner(System.`in`)
    val gamer = Gamer.criarGamer(input)
    println("Cadastro concluído com sucesso. Dados do gamer:")
    println(gamer)

    do {
        println("Informe o ID do jogo procurado")
        val id = input.nextLine()

        val fetchData = FetchApi()
        val gameData = fetchData.fetchGame(id)

        var myGame: Game? = null

        val response = runCatching {
            myGame = Game(
                gameData.info.title,
                gameData.info.thumb
            )
        }

        response.onFailure {
            println("Jogo inexistente. Tente outro id.")
        }

        response.onSuccess {
            println("Deseja inserir uma descrição personalizada? S/N")
            val option = input.nextLine()
            if (option.equals("s", true)) {
                println("Insira a descrição personalizado para o jogo:")
                val gameDescription = input.nextLine()
                myGame?.description = gameDescription
            } else {
                myGame?.description = myGame?.title
            }
            gamer.searchedGames.add(myGame)
        }

        println("Deseja buscar um novo jogo S/N")
        val newGame = input.nextLine()

    } while (newGame.equals("s", true))

    println("Busca finalizada com sucesso")
    println("Idade do gamer: " + gamer.birthDate?.ageFormat())

    println("Jogos buscados:")
    println(gamer.searchedGames)

    println("\n Jogos ordenados por título: ")
    gamer.searchedGames.sortBy {
        it?.title
    }

    gamer.searchedGames.forEach {
        println("Título: " + it?.title)
    }

    val jogosFiltrados = gamer.searchedGames.filter {
        it?.title?.contains("batman", true) ?: false
    }
    println("\n Jogos filtrados: ")
    println(jogosFiltrados)

    println("Deseja excluir algum jogo da lista original? S/N")
    val options = input.nextLine()
    if (options.equals("s", true)) {
        println(gamer.searchedGames)
        println("\nInforme a posição do jogo que deseja excluir: ")
        val position = input.nextInt()
        gamer.searchedGames.removeAt(position)
    }

    println("\n Lista atualizada:")
    println(gamer.searchedGames)

    println("Busca finalizada com sucesso.")

}