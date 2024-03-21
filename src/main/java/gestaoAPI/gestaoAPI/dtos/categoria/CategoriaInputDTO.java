package gestaoAPI.gestaoAPI.dtos.categoria;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CategoriaInputDTO(
    
    @NotBlank
    String titulo,
    @NotBlank
    String descricao
) {


}
