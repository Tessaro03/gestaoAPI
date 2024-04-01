package gestaoAPI.gestaoAPI.validacao.loja.validacaoUsuario;

import jakarta.servlet.http.HttpServletRequest;

public interface ValidadorLojaUsuario {
    
    void validar(HttpServletRequest request, Long id);
}
