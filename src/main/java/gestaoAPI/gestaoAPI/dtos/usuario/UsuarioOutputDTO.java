package gestaoAPI.gestaoAPI.dtos.usuario;

import gestaoAPI.gestaoAPI.domain.Usuario;

public record UsuarioOutputDTO(
    Long id,
    String login,
    String email
) {

    public UsuarioOutputDTO(Usuario usuario){
        this(usuario.getId(), usuario.getLogin(), usuario.getEmail());
    }

}
