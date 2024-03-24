package gestaoAPI.gestaoAPI.validacao.categoria.validacaoPost;

import gestaoAPI.gestaoAPI.dtos.categoria.CategoriaInputDTO;
import jakarta.servlet.http.HttpServletRequest;

public interface ValidarCategoriaPost {
    
        void validar(HttpServletRequest request, CategoriaInputDTO dados);
    }
    
