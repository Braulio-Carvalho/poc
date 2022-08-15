package br.com.productservice.resources.repositories

import br.com.productservice.domain.entities.Produto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.time.LocalDate
import java.util.*

@Repository
interface ProdutoRepository : JpaRepository<Produto, UUID>, JpaSpecificationExecutor<Produto> {

    fun findByNome(nome: String): List<Produto?>

    fun findByNomeAndDataCadastroBetween(
        nome: String?,
        dataInicial: LocalDate?,
        dataFinal: LocalDate?
    ): List<Produto>

    @Query("select p from Produto p where p.nome like ?1 and p.dataCadastro between ?2 and ?3")
    fun findByNomeLikeAndDataCadastroBetween(
        nome: String?,
        dataCadastroStart: LocalDate?,
        dataCadastroEnd: LocalDate?
    ): List<Produto>

}
