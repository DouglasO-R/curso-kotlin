package br.com.douglasor.oliveiragames.model

import br.com.douglasor.oliveiragames.utils.formatter

class SubscribePlan(
    type: String,
    val monthlyFee: Double,
    val gamesIncluded: Int,
    val discountPerRecommendation: Double
) : Plan(type) {

    override fun getValue(rent: Rent): Double {
        val totalGamesInMonth = rent.gamer.findGameByMonth(rent.period.startDate.monthValue).size + 1

        return if (totalGamesInMonth <= gamesIncluded) {
            0.0
        } else {
            var price = super.getValue(rent)
            val discount = price * discountPerRecommendation

            if (rent.gamer.average > 5) {
                price -= discount
            }
            price
        }
    }
}