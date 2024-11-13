package br.com.douglasor.oliveiragames.model

import br.com.douglasor.oliveiragames.utils.formatter
import com.google.gson.annotations.Expose

data class Game(@Expose val title: String,@Expose val thumbmail: String):Recommendation {
    var description: String? = null
    var price = 0.0
    private val recommendationList = mutableListOf<Int>()

    override val average: Double
        get() = recommendationList.average().formatter()

    constructor(title: String, thumbmail: String, price: Double, description: String) :
            this(title, thumbmail) {
        this.price = price
        this.description = description
    }

    override fun recommend(grade: Int) {
        recommendationList.add(grade)
    }

    override fun toString(): String {
        return "Meu Jogo: \n" +
                "Título: $title \n" +
                "Capa: $thumbmail \n" +
                "Descricao: $description \n" +
                "Preço: $price \n" +
                "Reputação: $average"
    }
}
