package br.com.productservice.resources.userservice.client

import br.com.productservice.domain.entities.Cliente
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import java.util.*


@FeignClient(name = "user-service", url = "localhost:8000")
interface ClienteServiceFeingClient {

    @GetMapping("clientes/{id}")
    fun listarPorId(@PathVariable id: UUID): Cliente

}
