package gestaoAPI.gestaoAPI.validacao.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestaoAPI.gestaoAPI.dtos.produto.ProdutoAlterarDTO;
import gestaoAPI.gestaoAPI.dtos.produto.ProdutoInputDTO;
import gestaoAPI.gestaoAPI.validacao.produto.validacaoPatch.ValidarProdutoPatch;
import gestaoAPI.gestaoAPI.validacao.produto.validacaoPost.ValidarProdutoPost;
import gestaoAPI.gestaoAPI.validacao.usuario.validacaoUsuario.ValidarUsuario;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class ValidacaoProduto {
    
    @Autowired
    private List<ValidarUsuario> validarUsuario;

    @Autowired
    private List<ValidarProdutoPost> validarPost;

    @Autowired
    private List<ValidarProdutoPatch> validarPatch;

    public void validadorPost(ProdutoInputDTO dados, HttpServletRequest request){
        validarUsuario.forEach(v -> v.validar(request));
        validarPost.forEach(v -> v.validar(dados, request));

    }

    public void validadorPatch(ProdutoAlterarDTO dados, Long id, HttpServletRequest request){
        validarUsuario.forEach(v -> v.validar(request));
        validarPatch.forEach(v -> v.validar( dados,  id,  request));

        }
}
