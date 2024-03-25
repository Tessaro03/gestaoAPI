package gestaoAPI.gestaoAPI.validacao.produto.validacaoDelete;

import jakarta.servlet.http.HttpServletRequest;

public interface ValidarProdutoDelete {
    
    void validar(HttpServletRequest request,Long id);

}
