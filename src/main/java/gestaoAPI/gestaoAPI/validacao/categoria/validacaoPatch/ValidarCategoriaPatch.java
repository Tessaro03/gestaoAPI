package gestaoAPI.gestaoAPI.validacao.categoria.validacaoPatch;

import gestaoAPI.gestaoAPI.dtos.categoria.CategoriaAlterarDTO;
import jakarta.servlet.http.HttpServletRequest;

public interface ValidarCategoriaPatch {
    
    void validar(HttpServletRequest request, CategoriaAlterarDTO dados, Long id);

}
