package gestaoAPI.gestaoAPI.validacao.produto.validacaoPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestaoAPI.gestaoAPI.dtos.produto.ProdutoInputDTO;
import gestaoAPI.gestaoAPI.infra.exception.ValidacaoExcepetion;
import gestaoAPI.gestaoAPI.infra.token.UsuarioToken;
import gestaoAPI.gestaoAPI.repository.CategoriaRepository;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class ValidandoSeCategoriaExisteAoCriarProduto implements ValidarProdutoPost {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private UsuarioToken usuarioToken;

    @Override
    public void validar(ProdutoInputDTO dados, HttpServletRequest request) {
        var usuario = usuarioToken.funcionarioToken(request);
        if (! categoriaRepository.existeCategoriaNaLoja(dados.categoria(), usuario.getLoja().getId())) {
            throw new ValidacaoExcepetion("Categorio não existe");
        }
    }
}
