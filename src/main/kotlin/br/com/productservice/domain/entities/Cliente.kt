package br.com.productservice.domain.entities

import br.com.productservice.application.dto.ClienteRequest
import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import java.util.*
import javax.persistence.*

@Entity(name = "cliente")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator::class, property = "id")
data class Cliente(
        @Id
        @GeneratedValue(generator = "UUID", strategy = GenerationType.AUTO)
        val id: UUID? = UUID.randomUUID(),
        val nome: String,
        val cpf: String,
        val telefone: String,
        val endereco: String,
        val email: String,
        val tipo: String,
        @OneToMany(mappedBy = "cliente", cascade = [CascadeType.ALL])
        @JsonIgnore
        val pedidos: List<Pedido?>? = null
)

fun Cliente.toDomain() = ClienteRequest(
        id = this.id,
        nome = this.nome,
        cpf = this.cpf,
        telefone = this.telefone,
        endereco = this.endereco,
        email = this.email,
        tipo = this.tipo,
        pedidos = this.pedidos
)
