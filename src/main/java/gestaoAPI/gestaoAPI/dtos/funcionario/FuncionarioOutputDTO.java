package gestaoAPI.gestaoAPI.dtos.funcionario;

import gestaoAPI.gestaoAPI.domain.Funcionario;
import gestaoAPI.gestaoAPI.dtos.loja.LojaOutputDTO;
import gestaoAPI.gestaoAPI.dtos.usuario.UsuarioOutputDTO;

public record FuncionarioOutputDTO(
    Long id,
    String cargo,
    LojaOutputDTO loja,
    UsuarioOutputDTO usuario

) {

    public FuncionarioOutputDTO(Funcionario funcionario){
        this(funcionario.getId(), funcionario.getCargo().toString(), new LojaOutputDTO(funcionario.getLoja()), new UsuarioOutputDTO(funcionario.getUsuario()));
    }
}
