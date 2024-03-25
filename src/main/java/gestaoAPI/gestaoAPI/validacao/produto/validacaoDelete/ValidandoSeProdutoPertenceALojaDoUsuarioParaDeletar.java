package gestaoAPI.gestaoAPI.validacao.produto.validacaoDelete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestaoAPI.gestaoAPI.infra.exception.ValidacaoExcepetion;
import gestaoAPI.gestaoAPI.infra.token.UsuarioToken;
import gestaoAPI.gestaoAPI.repository.ProdutoRepository;
import jakarta.servlet.http.HttpServletRequest;


@Service
public class ValidandoSeProdutoPertenceALojaDoUsuarioParaDeletar implements ValidarProdutoDelete {

    @Autowired
    private UsuarioToken usuarioToken;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public void validar(HttpServletRequest request, Long id) {
        
        var funcionario = usuarioToken.funcionarioToken(request);
        var produto = produtoRepository.getReferenceById(id);
        if (produto.getLoja() != funcionario.getLoja()) {
            throw new ValidacaoExcepetion("Produto não pertence a loja do Usuário");
        }
    }

    
}