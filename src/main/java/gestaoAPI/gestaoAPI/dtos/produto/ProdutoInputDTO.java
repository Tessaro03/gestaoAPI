package gestaoAPI.gestaoAPI.dtos.produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoInputDTO(
    
    @NotBlank
    String titulo,
    
    @NotBlank
    String descricao, 
    
    @NotNull
    Double preco, 
    
    @NotBlank
    String categoria
) {


}
