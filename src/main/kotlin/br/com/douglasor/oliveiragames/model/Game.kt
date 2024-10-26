package br.com.douglasor.oliveiragames.model

data class Game(val title:String,val thumbmail:String) {
    var description:String? = null

    override fun toString(): String {
        return "Meu Jogo: \n" +
                "Título: $title \n" +
                "Capa: $thumbmail \n" +
                "Descricao: $description"
    }
}
