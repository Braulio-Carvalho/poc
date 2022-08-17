package br.com.productservice.resources.repositories.specifications

import br.com.productservice.domain.entities.Produto
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class ProdutoSpecification {

 fun buscarPorNomeERangeDeDataEspecification(nome: String, dataInicio: LocalDate, dataFim: LocalDate): Specification<Produto> {
        return Specification { root, query, cb ->
            val nomePredicate = cb.like(cb.lower(root.get<String>("nome")), "%$nome%")
            val dataInicioPredicate = cb.greaterThanOrEqualTo(root.get<LocalDate>("dataCadastro"), dataInicio)
            val dataFimPredicate = cb.lessThanOrEqualTo(root.get<LocalDate>("dataCadastro"), dataFim)
            cb.and(nomePredicate, dataInicioPredicate, dataFimPredicate)
        }
    }
}