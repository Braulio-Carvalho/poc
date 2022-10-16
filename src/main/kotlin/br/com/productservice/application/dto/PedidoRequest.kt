package br.com.productservice.application.dto

import br.com.productservice.domain.entities.Cliente
import br.com.productservice.domain.entities.Pedido
import br.com.productservice.domain.entities.Produto

data class PedidoRequest(
        val cliente: ClienteRequest,
        val produtos: List<ProdutoRequest>
)


fun PedidoRequest.toDomain(cliente: Cliente, produtos: MutableList<Produto>) = Pedido(
        cliente = cliente,
        produtos = produtos
)
