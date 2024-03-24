package gestaoAPI.gestaoAPI.validacao.produto.validacaoPost;

import gestaoAPI.gestaoAPI.dtos.produto.ProdutoInputDTO;
import jakarta.servlet.http.HttpServletRequest;

public interface ValidarProdutoPost {

    void validar(ProdutoInputDTO dados, HttpServletRequest request);
    
}
