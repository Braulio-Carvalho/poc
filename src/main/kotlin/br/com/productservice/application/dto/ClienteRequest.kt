package br.com.productservice.application.dto

import br.com.productservice.domain.entities.Cliente
import br.com.productservice.domain.entities.Pedido
import java.util.UUID

class ClienteRequest(
        val id: UUID? = null,
        val nome: String,
        val cpf: String,
        val telefone: String,
        val endereco: String,
        val email: String,
        val tipo: String,
        val pedidos: List<Pedido?>? = null
)

fun ClienteRequest.toDomain() = Cliente(
        id = id,
        nome = nome,
        cpf = cpf,
        telefone = telefone,
        endereco = endereco,
        email = email,
        tipo = tipo,
        pedidos = pedidos
)
