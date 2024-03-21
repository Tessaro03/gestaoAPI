package gestaoAPI.gestaoAPI.dtos.produto;

import gestaoAPI.gestaoAPI.domain.Produto;
import gestaoAPI.gestaoAPI.dtos.categoria.CategoriaOutputDTO;

public record ProdutoOutputDTO(
    Long id,
    String titulo,
    String descricao, 
    Double preco,
    CategoriaOutputDTO categoria
) {

    public ProdutoOutputDTO(Produto produto){
        this(produto.getId(), produto.getTitulo(), produto.getDescricao(), produto.getPreco(), new CategoriaOutputDTO(produto.getCategoria()) );
    }
}
