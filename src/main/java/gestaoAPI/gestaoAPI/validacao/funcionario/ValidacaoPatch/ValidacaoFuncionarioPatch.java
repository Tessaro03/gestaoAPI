package gestaoAPI.gestaoAPI.validacao.funcionario.ValidacaoPatch;

import gestaoAPI.gestaoAPI.dtos.funcionario.FuncionarioAlterarDTO;
import jakarta.servlet.http.HttpServletRequest;

public interface ValidacaoFuncionarioPatch {

    void validar(HttpServletRequest request, FuncionarioAlterarDTO dados, Long id);
    
}
