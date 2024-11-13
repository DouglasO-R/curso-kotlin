package br.com.douglasor.oliveiragames.model

import br.com.douglasor.oliveiragames.utils.formatter


data class Rent(
    val gamer:Gamer,
    val game:Game,
    val period: Period,
    ){

    val rentPrice:Double = gamer.plan.getValue(this).formatter()

    override fun toString(): String = "Aluguel do ${game.title} por ${gamer.name} pelo valor $rentPrice"
}
