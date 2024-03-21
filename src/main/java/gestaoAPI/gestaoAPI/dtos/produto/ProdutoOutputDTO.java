package gestaoAPI.gestaoAPI.dtos.produto;

import gestaoAPI.gestaoAPI.domain.Produto;

public record ProdutoOutputDTO(
    Long id,
    String titulo,
    String descricao, 
    Double preco,
    String categoria
) {

    public ProdutoOutputDTO(Produto produto){
        this(produto.getId(), produto.getTitulo(), produto.getDescricao(), produto.getPreco(), produto.getCategoria().getTitulo());
    }
}
