package br.com.productservice.domain.entities

import java.time.LocalDate
import java.util.*
import javax.persistence.*

@Entity(name = "pedido")
data class Pedido(
        @Id
        @GeneratedValue(generator = "UUID", strategy = GenerationType.AUTO)
        val id: UUID? = UUID.randomUUID(),
        @Column(name = "data_pedido")
        val data_pedido: LocalDate = LocalDate.now(),
        @ManyToOne
        @JoinColumn(name = "cliente_id", nullable = false)
        var cliente: Cliente,
        @ManyToMany(cascade = [CascadeType.ALL])
        @JoinTable(name = "pedido_produto",
                joinColumns = [JoinColumn(name = "pedido_id")],
                inverseJoinColumns = [JoinColumn(name = "produto_id")])
        var produtos: List<Produto>
)
