package br.com.douglasor.oliveiragames.model

data class Game(val title: String, val thumbmail: String) {
    var description: String? = null
    var price = 0.0

    constructor(title: String, thumbmail: String, price: Double, description: String) :
            this(title, thumbmail) {
        this.price = price
        this.description = description
    }

    override fun toString(): String {
        return "Meu Jogo: \n" +
                "Título: $title \n" +
                "Capa: $thumbmail \n" +
                "Descricao: $description" +
                "Preco: ${price}"
    }
}
