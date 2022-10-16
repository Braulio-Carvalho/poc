package br.com.productservice.application.web

import br.com.productservice.domain.entities.Produto
import br.com.productservice.domain.services.ProdutoService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.query.Param
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.time.LocalDate
import java.util.*

@RestController
@RequestMapping("/produtos")
class ProdutoController(val produtoService: ProdutoService) {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    fun listar(@PathVariable id: UUID) = produtoService.listarProdutoPorId(id)

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    fun listarProdutos() = produtoService.listarTodosProdutos()

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("listar-por-nome")
    fun listarProdutosPorNome(
        @RequestParam(required = false) @Param("nome") nome: String
    ) = produtoService.listarProdutoPorNome(nome)

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun cadastrar(@RequestBody produto: Produto) = produtoService.cadastrarProduto(produto)

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("{id}")
    fun atualizar(@PathVariable id: UUID, @RequestBody produto: Produto) = produtoService.atualizarProduto(id, produto)

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    fun deletar(@PathVariable id: UUID) = produtoService.deletarProdutoPorId(id)

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/filtro")
    fun buscarPorNomeERangeDeData(
            @RequestParam(defaultValue = "") nome: String?,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) dataInicial: LocalDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) dataFinal: LocalDate,
            pageable: Pageable
    ): Page<Produto> {
        return produtoService.buscarPorNomeERangeDeData(nome, dataInicial, dataFinal, pageable)
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/fabricacao")
    fun buscarPorFabricacao(
            @RequestParam(required = false) id: UUID?,
            @RequestParam(required = false, defaultValue = "") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) dataFabricacao: LocalDate?
    ): List<Produto> {
        return produtoService.buscarPorDataFabricacao(id, dataFabricacao)
    }
}