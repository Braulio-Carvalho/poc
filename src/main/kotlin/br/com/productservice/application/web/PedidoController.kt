package br.com.productservice.application.web

import br.com.productservice.application.dto.PedidoRequest
import br.com.productservice.domain.services.PedidoService
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/pedidos")
class PedidoController(private val service: PedidoService) {

    @PostMapping("/cadastro")
    @ResponseStatus(HttpStatus.CREATED)
    fun registrarPedido(@RequestBody pedido: PedidoRequest) {
        service.registrarPedido(pedido)
    }

    @GetMapping
    @JsonSerialize
    fun listarPedidos() = service.listarPedidos()


}
