package br.com.douglasor.oliveiragames.main

import br.com.douglasor.oliveiragames.model.Gamer

fun main() {
    val douglas = Gamer("Douglas", "douglas@oliveira.com")
    println(douglas)

    val lucas = Gamer("Lucas", "lucas@ozorio.com", "19/05/1991", "luck7")
    println(lucas)

    douglas.let {
        it.birthDate = "29/08/1992"
        it.user = "oliveiraS3"
    }.also {
        println(douglas.internalId)
    }

    println(douglas)
    douglas.user = "doug"
    println(douglas)
}