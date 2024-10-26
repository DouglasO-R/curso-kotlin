package br.com.douglasor.oliveiragames.services

import br.com.douglasor.oliveiragames.model.GameInfo
import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class FetchApi {
    fun getApiData(id: String): GameInfo {
        val url = "https://www.cheapshark.com/api/1.0/games?id=$id"


        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build()

        val responseApi = client.send(request, BodyHandlers.ofString())
        val json = responseApi.body()

        val gson = Gson()
        val myGameInfo = gson.fromJson(json, GameInfo::class.java)
        return myGameInfo
    }
}