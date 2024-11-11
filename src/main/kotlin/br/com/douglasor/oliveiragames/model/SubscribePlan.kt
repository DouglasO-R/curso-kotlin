package br.com.douglasor.oliveiragames.model

class SubscribePlan(
    type: String,
    val monthlyFee: Double,
    val gamesIncluded: Int
) : Plan(type) {
    override fun getValue(rent: Rent): Double {
        val totalGamesInMonth = rent.gamer.findGameByMonth(rent.period.startDate.monthValue).size + 1
        return if (totalGamesInMonth <= gamesIncluded) {
            0.0
        } else {
            super.getValue(rent)
        }
    }
}