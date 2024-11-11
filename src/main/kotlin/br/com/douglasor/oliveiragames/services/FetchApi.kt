package br.com.douglasor.oliveiragames.services

import br.com.douglasor.oliveiragames.model.*
import br.com.douglasor.oliveiragames.utils.generateGame
import br.com.douglasor.oliveiragames.utils.generateGamer
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class FetchApi {
    private fun fetchData(url: String): String {
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build()

        val responseApi = client.send(request, BodyHandlers.ofString())
        val json = responseApi.body()
        return json
    }

    fun fetchGameById(id: String): GameInfo {
        val url = "https://www.cheapshark.com/api/1.0/games?id=$id"
        val json = fetchData(url)

        val gson = Gson()
        val myGameInfo = gson.fromJson(json, GameInfo::class.java)
        return myGameInfo
    }

    fun fetchGamer(): List<Gamer> {
        val url = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"
        val json = fetchData(url)

        val gson: Gson = Gson()
        val myGamerType = object : TypeToken<List<InfoGamerJson>>() {}.type
        val gamerInfoList: List<InfoGamerJson> = gson.fromJson(json, myGamerType)

        val gamerList = gamerInfoList.map { infoGamerJson -> infoGamerJson.generateGamer() }

        return gamerList
    }

    fun fetchGame(): List<Game> {
        val url = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"
        val json = fetchData(url)

        val gson: Gson = Gson()
        val myGameType = object : TypeToken<List<InfoGameJson>>() {}.type
        val gameInfoList: List<InfoGameJson> = gson.fromJson(json, myGameType)

        val gameList = gameInfoList.map { infoGameJson -> infoGameJson.generateGame() }

        return gameList
    }


}