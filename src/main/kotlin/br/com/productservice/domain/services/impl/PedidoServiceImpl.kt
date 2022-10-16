package br.com.productservice.domain.services.impl

import br.com.productservice.application.dto.PedidoRequest
import br.com.productservice.application.dto.toDomain
import br.com.productservice.domain.entities.Pedido
import br.com.productservice.domain.services.PedidoService
import br.com.productservice.resources.repositories.PedidoRepository
import br.com.productservice.resources.repositories.ProdutoRepository
import br.com.productservice.resources.userservice.client.ClienteServiceFeingClient
import org.springframework.stereotype.Service

@Service
class PedidoServiceImpl(private val repository: PedidoRepository,
                        private val clienteServiceFeingClient: ClienteServiceFeingClient,
                        private val produtoRepository: ProdutoRepository) : PedidoService {


    override fun registrarPedido(pedido: PedidoRequest): Pedido {
        val cliente = pedido.cliente.id?.let { clienteServiceFeingClient.listarPorId(it) }
        val produtos = produtoRepository.findAllById(pedido.produtos.map { it.id })
        val pedidoDomain = cliente?.let { pedido.toDomain(it, produtos) }

        return repository.save(pedidoDomain!!)

    }

    override fun listarPedidos() = repository.findAll()
}
