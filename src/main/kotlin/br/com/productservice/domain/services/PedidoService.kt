package br.com.productservice.domain.services

import br.com.productservice.application.dto.PedidoRequest
import br.com.productservice.domain.entities.Pedido

interface PedidoService {

    fun registrarPedido(pedido: PedidoRequest): Pedido

    fun listarPedidos(): List<Pedido>
}
