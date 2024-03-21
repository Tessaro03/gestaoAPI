package gestaoAPI.gestaoAPI.dtos.categoria;

import gestaoAPI.gestaoAPI.domain.Categoria;

public record CategoriaOutputDTO(
    Long id,
    String titulo,
    String descricao
) {

    public CategoriaOutputDTO(Categoria categoria){
        this(categoria.getId(), categoria.getTitulo(), categoria.getDescricao());
    }
}
