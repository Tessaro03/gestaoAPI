package gestaoAPI.gestaoAPI.validacao.produto.validacaoPatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestaoAPI.gestaoAPI.dtos.produto.ProdutoAlterarDTO;
import gestaoAPI.gestaoAPI.infra.exception.ValidacaoExcepetion;
import gestaoAPI.gestaoAPI.infra.token.UsuarioToken;
import gestaoAPI.gestaoAPI.repository.CategoriaRepository;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class ValidandoSeCategoriaExisteAoAlterarProduto implements ValidarProdutoPatch{

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private UsuarioToken usuarioToken;


    @Override
    public void validar( ProdutoAlterarDTO dados, Long id, HttpServletRequest request) {
        var usuario = usuarioToken.funcionarioToken(request);
        if (! categoriaRepository.existeCategoriaNaLoja(dados.categoria(), usuario.getLoja().getId())) {
            throw new ValidacaoExcepetion("Categorio não existe");
        }
    }
    
}
