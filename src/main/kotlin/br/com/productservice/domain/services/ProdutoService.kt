package br.com.productservice.domain.services

import br.com.productservice.domain.entities.Produto
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.time.LocalDate
import java.util.*


interface ProdutoService {

    fun listarTodosProdutos(): List<Produto>

    fun listarProdutoPorId(id: UUID): Produto

    fun listarProdutoPorNome(nome: String): List<Produto?>

    fun buscarPorNomeERangeDeData(nome: String?, dataInicial: LocalDate, dataFinal: LocalDate, pageable: Pageable): Page<Produto>

    fun buscarPorDataFabricacao(id: UUID?, dataFabricacao: LocalDate?): List<Produto>

    fun cadastrarProduto(produto: Produto): Produto

    fun atualizarProduto(id: UUID, produto: Produto): Produto

    fun deletarProdutoPorId(id: UUID)
}