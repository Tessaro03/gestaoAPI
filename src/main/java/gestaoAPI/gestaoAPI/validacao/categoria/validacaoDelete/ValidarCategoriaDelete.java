package gestaoAPI.gestaoAPI.validacao.categoria.validacaoDelete;

import jakarta.servlet.http.HttpServletRequest;

public interface ValidarCategoriaDelete {
    
    public void validar(HttpServletRequest request, Long id);
}
