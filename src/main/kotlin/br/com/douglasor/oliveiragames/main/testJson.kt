package br.com.douglasor.oliveiragames.main

import br.com.douglasor.oliveiragames.model.Period
import br.com.douglasor.oliveiragames.model.SubscribePlan
import br.com.douglasor.oliveiragames.services.FetchApi
import java.time.LocalDate

fun main() {
    val gameApi = FetchApi()
    val gamerList = gameApi.fetchGamer()
    val gameList = gameApi.fetchGame()

    val gamer = gamerList.get(5)
    val game1 = gameList.get(15)
    val game2 = gameList[2]
    val game3 = gameList[3]
    val game4 = gameList[8]
    val game5 = gameList[2]
    val game6 = gameList[1]

    val rentalPeriod = Period(LocalDate.now(), LocalDate.now().plusDays(7))
    val rentalPeriod2 = Period(LocalDate.now(), LocalDate.now().plusDays(3))
    val rentalPeriod3 = Period(LocalDate.now(), LocalDate.now().plusDays(2))
    val rentalPeriod7 = Period(LocalDate.now(), LocalDate.now().plusDays(1))
    val rentalPeriod8 = Period(LocalDate.now(), LocalDate.now().plusDays(9))
    val rentalPeriod9 = Period(LocalDate.now(), LocalDate.now().plusDays(6))
    val rentalPeriod4 = Period(LocalDate.of(2024, 10, 5), LocalDate.of(2024, 10, 8))
    val rentalPeriod5 = Period(LocalDate.of(2024, 11, 1), LocalDate.of(2024, 11, 1).plusDays(2))
    val rentalPeriod6 = Period(LocalDate.of(2024, 10, 15), LocalDate.of(2024, 10, 20))


    gamer.rentGame(game1, rentalPeriod)
    gamer.rentGame(game2, rentalPeriod2)
    gamer.rentGame(game3, rentalPeriod3)
    gamer.rentGame(game4, rentalPeriod4)
    gamer.rentGame(game6, rentalPeriod6)
    gamer.rentGame(game5, rentalPeriod5)

//    println(gamer.rentedGames)
//    println(gamer.findGameByMonth(10))

    val gamer2 = gamerList[2]
    gamer2.plan = SubscribePlan("GOLD", 9.90, 1,0.50)

    gamer2.rentGame(game1, rentalPeriod)
    gamer2.rentGame(game2, rentalPeriod2)
    gamer2.rentGame(game3, rentalPeriod3)
    gamer2.rentGame(game4, rentalPeriod4)
    gamer2.rentGame(game6, rentalPeriod6)
    gamer2.rentGame(game5, rentalPeriod5)

//    println(gamer.rentedGames)

    gamer2.recommend(10)
    gamer2.recommend(8)
    gamer2.recommend(8)
    gamer2.recommend(9)


    gamer.recommend(10)
    gamer.recommend(8)
    gamer.recommend(8)
    gamer.recommend(9)

    println(gamer2.rentedGames)
    println(gamer.rentedGames)

}