package gestaoAPI.gestaoAPI.validacao.funcionario.ValidacaoPost;

import gestaoAPI.gestaoAPI.dtos.funcionario.FuncionarioInputDTO;
import jakarta.servlet.http.HttpServletRequest;

public interface ValidacaoFuncionarioPost {
    
    void validar(FuncionarioInputDTO dados, HttpServletRequest request);
}
