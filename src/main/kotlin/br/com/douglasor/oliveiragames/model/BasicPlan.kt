package br.com.douglasor.oliveiragames.model

class BasicPlan(
    type: String
) : Plan(type) {

    override fun getValue(rent: Rent): Double {
        var price = super.getValue(rent)
        val discount = price * 0.1

        if(rent.gamer.average > 5){
            price -= discount
        }
        return price
    }
}
