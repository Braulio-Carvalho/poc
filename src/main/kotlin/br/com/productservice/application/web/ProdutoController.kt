package br.com.productservice.application.web

import br.com.productservice.domain.entities.Produto
import br.com.productservice.domain.services.ProdutoService
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import java.util.UUID
import javax.websocket.server.PathParam

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
        @RequestParam(required = false) @PathParam("nome") nome: String
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
        @RequestParam nome: String,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) dataInicial: LocalDate,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) dataFinal: LocalDate
    ): List<Produto> {
        return produtoService.buscarPorNomeERangeDeData(nome, dataInicial, dataFinal)
    }
}