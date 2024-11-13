package br.com.douglasor.oliveiragames.model

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
            if (rent.gamer.average > 5) {
                price -= (price * discountPerRecommendation)
            }
            price
        }
    }
}