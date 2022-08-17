package br.com.productservice.domain.services.impl

import br.com.productservice.domain.entities.Produto
import br.com.productservice.domain.exceptions.ProdutoNaoEncontradoException
import br.com.productservice.domain.services.ProdutoService
import br.com.productservice.resources.repositories.ProdutoRepository
import br.com.productservice.resources.repositories.specifications.ProdutoSpecification
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.*

@Service
class ProdutoServiceImpl(
    private val repository: ProdutoRepository,
    private val specification: ProdutoSpecification) : ProdutoService {

    override fun listarTodosProdutos(): List<Produto> {
        return repository.findAll()
    }

    override fun listarProdutoPorId(id: UUID): Produto {
        return repository.findById(id).orElseThrow { ProdutoNaoEncontradoException() }
    }

    override fun listarProdutoPorNome(nome: String): List<Produto?> {
        return repository.findByNome(nome)
    }

    override fun buscarPorNomeERangeDeData(nome: String, dataInicial: LocalDate, dataFinal: LocalDate): List<Produto>{
        return repository.findAll(specification.buscarPorNomeERangeDeDataEspecification(nome, dataInicial, dataFinal))
    }

    override fun cadastrarProduto(produto: Produto): Produto {
        return repository.save(produto)
    }

    override fun atualizarProduto(id: UUID, produto: Produto): Produto {
        try {
            val produtoExistente =
                repository.findById(id).orElseThrow { ProdutoNaoEncontradoException() }
            produtoExistente.nome = produto.nome
            produtoExistente.categoria = produto.categoria
            produtoExistente.preco = produto.preco
            produtoExistente.dataFabricacao = produto.dataFabricacao
            produtoExistente.descricao = produto.descricao
            return repository.saveAndFlush(produtoExistente)
        } catch (e: Exception) {
            throw ProdutoNaoEncontradoException()
        }
    }

    override fun deletarProdutoPorId(id: UUID) {
        val produtoExistente =
            repository.findById(id).orElseThrow { IllegalArgumentException("Produto não encontrado") }
        repository.delete(produtoExistente)
    }
}