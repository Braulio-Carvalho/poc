package br.com.productservice.resources.repositories.specifications

import br.com.productservice.domain.entities.Produto
import org.springframework.data.jpa.domain.Specification

class ProdutoSpecification {


 fun findByNomeAndDateRange(nome: String, dataInicio: String, dataFim: String): Specification<Produto> {
        return Specification { root, query, cb ->
            val nomePredicate = cb.like(cb.lower(root.get<String>("nome")), "%$nome%")
            val dataInicioPredicate = cb.greaterThanOrEqualTo(root.get<String>("dataCadastro"), dataInicio)
            val dataFimPredicate = cb.lessThanOrEqualTo(root.get<String>("dataCadastro"), dataFim)
            cb.and(nomePredicate, dataInicioPredicate, dataFimPredicate)
        }
    }
}