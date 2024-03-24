package gestaoAPI.gestaoAPI.validacao.produto.validacaoPatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestaoAPI.gestaoAPI.dtos.produto.ProdutoAlterarDTO;
import gestaoAPI.gestaoAPI.infra.exception.ValidacaoExcepetion;
import gestaoAPI.gestaoAPI.infra.token.UsuarioToken;
import gestaoAPI.gestaoAPI.repository.ProdutoRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Service
public class ValidandoSeProdutoPertenceALojaDoUsuraioAoAlterar implements ValidarProdutoPatch{

    @Autowired
    private UsuarioToken usuarioToken;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public void validar( ProdutoAlterarDTO dados, Long id, HttpServletRequest request) {
        var funcionario = usuarioToken.funcionarioToken(request);
        var produto = produtoRepository.getReferenceById(id);
        if (produto.getLoja() != funcionario.getLoja()) {
            throw new ValidacaoExcepetion("Produto não pertence a loja do Usuário");
        }
    }
    
}
