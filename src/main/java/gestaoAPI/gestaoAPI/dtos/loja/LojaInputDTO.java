package gestaoAPI.gestaoAPI.dtos.loja;

import jakarta.validation.constraints.NotNull;

public record LojaInputDTO(
    
    @NotNull
    String nome

    ) {


}
