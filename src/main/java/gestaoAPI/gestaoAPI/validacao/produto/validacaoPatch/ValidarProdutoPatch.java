package gestaoAPI.gestaoAPI.validacao.produto.validacaoPatch;

import gestaoAPI.gestaoAPI.dtos.produto.ProdutoAlterarDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

public interface ValidarProdutoPatch {
   
    void validar( ProdutoAlterarDTO dados, Long id, HttpServletRequest request);
}
