package br.com.productservice.resources.repositories.specifications

import br.com.productservice.domain.entities.Produto
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.util.UUID

@Component
class ProdutoSpecification {

 fun buscarPorNomeERangeDeDataEspecification(nome: String?, dataInicio: LocalDate, dataFim: LocalDate): Specification<Produto> {
        return Specification { root, _, cb ->
            val nomePredicate = cb.like(cb.lower(root.get<String>("nome")), "%$nome%")
            val dataInicioPredicate = cb.greaterThanOrEqualTo(root.get<LocalDate>("dataCadastro"), dataInicio)
            val dataFimPredicate = cb.lessThanOrEqualTo(root.get<LocalDate>("dataCadastro"), dataFim)
            cb.and(nomePredicate, dataInicioPredicate, dataFimPredicate)
        }
    }
    fun buscarPorDataDeFabricacao(dataFabricacao: LocalDate?): Specification<Produto>? {
        return Specification { root, _, cb ->
            val dataF = cb.equal(root.get<LocalDate>("dataFabricacao"), dataFabricacao)
            cb.and(dataF)
        }
    }

    fun buscarPorId(id: UUID?): Specification<Produto>? {
        return Specification { root, _, cb ->
            val idPredicate = cb.equal(root.get<UUID>("id"), id)
            cb.and(idPredicate)
        }
    }


}