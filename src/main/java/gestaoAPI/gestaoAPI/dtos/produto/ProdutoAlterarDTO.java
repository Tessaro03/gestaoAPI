package gestaoAPI.gestaoAPI.dtos.produto;

public record ProdutoAlterarDTO(

    String titulo,
    String descricao,
    Double preco,
    String categoria
) 
{
}
