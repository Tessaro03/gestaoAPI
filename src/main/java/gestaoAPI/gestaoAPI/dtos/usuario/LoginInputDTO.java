package gestaoAPI.gestaoAPI.dtos.usuario;

import jakarta.validation.constraints.NotBlank;

public record LoginInputDTO(

   @NotBlank
   String login,

   @NotBlank
   String senha
) {
    
}
