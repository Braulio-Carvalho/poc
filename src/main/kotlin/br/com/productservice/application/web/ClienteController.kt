package br.com.productservice.application.web

import br.com.productservice.domain.entities.Cliente
import br.com.productservice.resources.userservice.client.ClienteServiceFeingClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/clientes")
class ClienteController(private val clienteServiceFeingClient: ClienteServiceFeingClient) {

    @GetMapping("/{id}")
    fun listarPorId(@PathVariable id: UUID): Cliente {
        return clienteServiceFeingClient.listarPorId(id)
    }
}
