package br.com.productservice.domain.exceptions

class ProdutoNaoEncontradoException : RuntimeException() {
    override val message: String?
        get() = "Produto não encontrado"
}