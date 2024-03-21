package gestaoAPI.gestaoAPI.dtos.funcionario;

import gestaoAPI.gestaoAPI.domain.Cargo;

public record FuncionarioInputDTO(

    Long idUsuario,
    Cargo cargo
    
) {


}
