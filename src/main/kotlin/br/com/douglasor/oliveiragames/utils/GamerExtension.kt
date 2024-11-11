package br.com.douglasor.oliveiragames.utils

import br.com.douglasor.oliveiragames.model.Gamer
import br.com.douglasor.oliveiragames.model.InfoGamerJson

fun InfoGamerJson.generateGamer():Gamer{
    return Gamer(
        this.nome,
        this.email,
        this.dataNascimento,
        this.usuario
    )
}