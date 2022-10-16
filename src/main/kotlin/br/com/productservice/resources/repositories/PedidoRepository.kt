package br.com.productservice.resources.repositories

import br.com.productservice.domain.entities.Pedido
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PedidoRepository: JpaRepository<Pedido, UUID> {

    fun findByClienteId(clienteId: UUID): List<Pedido>

}
