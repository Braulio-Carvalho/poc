package br.com.productservice.domain.entities

import br.com.productservice.domain.enums.Categoria
import com.fasterxml.jackson.annotation.JsonIgnore
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*
import javax.persistence.*

@Entity(name = "produto")
data class Produto(
        @Id
        @GeneratedValue(generator = "UUID", strategy = GenerationType.AUTO)
        val id: UUID? = UUID.randomUUID(),
        var nome: String,
        @Enumerated(EnumType.STRING)
        var categoria: Categoria,
        var preco: BigDecimal,
        @Column(name = "data_cadastro")
        var dataCadastro: LocalDate? = LocalDate.now(),
        @Column(name = "data_fabricacao")
        var dataFabricacao: LocalDate? = LocalDate.now(),
        var descricao: String? = null,
        @Column(name= "quantidade", nullable = true)
        var quantidade: Int,
        @ManyToMany(mappedBy = "produtos", cascade = [CascadeType.ALL])
        @Transient
        @JsonIgnore
        val pedido: List<Pedido?>?
)
