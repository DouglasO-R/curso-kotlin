package br.com.douglasor.oliveiragames.model

interface Recommendation {
    val average:Double

    fun recommend(grade:Int)
}