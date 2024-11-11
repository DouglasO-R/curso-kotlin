package br.com.douglasor.oliveiragames.main

import br.com.douglasor.oliveiragames.services.FetchApi

fun main(){
    val gameApi = FetchApi()
    val gamerList = gameApi.fetchGamer()
    val game = gameApi.fetchGame("151")

    println(game)
    println(gamerList)
}