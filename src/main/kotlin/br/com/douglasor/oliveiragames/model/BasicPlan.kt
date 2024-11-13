package br.com.douglasor.oliveiragames.model

class BasicPlan(
    type: String
) : Plan(type) {

    override fun getValue(rent: Rent): Double {
        var price = super.getValue(rent)
        if(rent.gamer.average > 8){
            price -= price * 0.1
        }
        return price
    }
}
