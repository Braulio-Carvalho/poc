package br.com.productservice.domain.services.impl

import br.com.productservice.domain.entities.Produto
import br.com.productservice.domain.exceptions.ProdutoNaoEncontradoException
import br.com.productservice.domain.services.ProdutoService
import br.com.productservice.resources.repositories.ProdutoRepository
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.*

@Service
class ProdutoServiceImpl(private val repository: ProdutoRepository) : ProdutoService {

    override fun listarTodosProdutos(): List<Produto> {
        return repository.findAll()
    }

    override fun listarProdutoPorId(id: UUID): Produto {
        return repository.findById(id).orElseThrow { ProdutoNaoEncontradoException() }
    }

    override fun listarProdutoPorNomeERange(
        nome: String?,
        dataInicial: LocalDate?,
        dataFinal: LocalDate?
    ): List<Produto?> {
        return repository.findByNomeAndDataCadastroBetween(nome, dataInicial, dataFinal)
    }

    fun filtroProduto(filtro: Produto){

        val matcherFilter = ExampleMatcher.matching()
            .withIgnoreCase()
            .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
            .withIgnoreNullValues()
            .withIgnorePaths("id")

        val example = Example.of(filtro)


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