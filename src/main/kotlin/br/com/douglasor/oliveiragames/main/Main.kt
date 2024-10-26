package org.example.br.com.douglasor.oliveiragames

import br.com.douglasor.oliveiragames.model.Game
import br.com.douglasor.oliveiragames.model.GameInfo
import br.com.douglasor.oliveiragames.services.FetchApi
import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.Scanner


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    println("Informe o ID: ")
    val input = Scanner(System.`in`)
    val id = input.nextLine()

    val fetchData = FetchApi()
    val gameData = fetchData.getApiData(id)

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

        println("Busca finalizada com sucesso")
        println(myGame.toString())
    }


}