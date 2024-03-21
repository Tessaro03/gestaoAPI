package gestaoAPI.gestaoAPI.dtos.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroUsuario(
    @NotBlank
    String nome,

    @NotBlank
    String login,

    @NotBlank
    @Email
    String email,
    
    @NotBlank
    String senha
) {

}
