package br.com.productservice.domain.services

import br.com.productservice.domain.entities.Produto
import java.time.LocalDate
import java.util.*


interface ProdutoService {

    fun listarTodosProdutos(): List<Produto>

    fun listarProdutoPorId(id: UUID): Produto

    fun listarProdutoPorNomeERange(
        nome: String?,
        dataCadastroStart: LocalDate?,
        dataCadastroEnd: LocalDate?
    ): List<Produto?>

    fun cadastrarProduto(produto: Produto): Produto

    fun atualizarProduto(id: UUID, produto: Produto): Produto

    fun deletarProdutoPorId(id: UUID)
}