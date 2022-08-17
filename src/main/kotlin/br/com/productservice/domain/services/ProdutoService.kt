package br.com.productservice.domain.services

import br.com.productservice.domain.entities.Produto
import java.time.LocalDate
import java.util.*


interface ProdutoService {

    fun listarTodosProdutos(): List<Produto>

    fun listarProdutoPorId(id: UUID): Produto

    fun listarProdutoPorNome(nome: String): List<Produto?>

    fun buscarPorNomeERangeDeData(nome: String, dataInicial: LocalDate, dataFinal: LocalDate): List<Produto>

    fun cadastrarProduto(produto: Produto): Produto

    fun atualizarProduto(id: UUID, produto: Produto): Produto

    fun deletarProdutoPorId(id: UUID)
}