package br.com.productservice.domain.entities

import br.com.productservice.domain.enums.Categoria
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Produto(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID = UUID.randomUUID(),
    var nome: String,
    var categoria: Categoria,
    var preco: BigDecimal,
    val dataCadastro: LocalDate? = LocalDate.now(),
    var dataFabricacao: LocalDate,
    var descricao: String
)
