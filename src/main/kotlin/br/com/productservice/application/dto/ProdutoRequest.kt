package br.com.productservice.application.dto

import br.com.productservice.domain.entities.Pedido
import br.com.productservice.domain.entities.Produto
import br.com.productservice.domain.enums.Categoria
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

class ProdutoRequest(val id: UUID?,
                     var nome: String,
                     var categoria: Categoria,
                     var preco: BigDecimal,
                     var dataCadastro: LocalDate? = LocalDate.now(),
                     var dataFabricacao: LocalDate? = LocalDate.now(),
                     var descricao: String? = null,
                     var quantidade: Int,
                     val pedido: List<Pedido?>?)

fun ProdutoRequest.toDomain() = Produto(
        id = id,
        nome = nome,
        categoria = categoria,
        preco = preco,
        dataCadastro = dataCadastro,
        dataFabricacao = dataFabricacao,
        descricao = descricao,
        quantidade = quantidade,
        pedido = pedido
)


