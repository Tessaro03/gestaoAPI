package gestaoAPI.gestaoAPI.validacao.funcionario.ValidacaoDelete;

import jakarta.servlet.http.HttpServletRequest;

public interface ValidacaoFuncionarioDelete {
    
    public void validar(Long id, HttpServletRequest request);

}
