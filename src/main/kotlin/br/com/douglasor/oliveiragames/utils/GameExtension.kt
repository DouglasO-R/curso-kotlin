package br.com.douglasor.oliveiragames.utils

import br.com.douglasor.oliveiragames.model.Game
import br.com.douglasor.oliveiragames.model.InfoGameJson

fun InfoGameJson.generateGame(): Game{
    return Game(this.titulo,this.capa,this.preco,this.descricao)
}