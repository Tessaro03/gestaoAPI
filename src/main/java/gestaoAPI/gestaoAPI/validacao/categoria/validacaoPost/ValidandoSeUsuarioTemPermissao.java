package gestaoAPI.gestaoAPI.validacao.categoria.validacaoPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestaoAPI.gestaoAPI.domain.Cargo;
import gestaoAPI.gestaoAPI.dtos.categoria.CategoriaInputDTO;
import gestaoAPI.gestaoAPI.infra.exception.ValidacaoExcepetion;
import gestaoAPI.gestaoAPI.infra.token.UsuarioToken;
import jakarta.servlet.http.HttpServletRequest;


@Service
public class ValidandoSeUsuarioTemPermissao implements ValidarCategoriaPost{

    @Autowired
    private UsuarioToken usuarioToken;


    @Override
    public void validar(HttpServletRequest request, CategoriaInputDTO dados) {
        var funcionario = usuarioToken.funcionarioToken(request);
        if (funcionario.getCargo() == Cargo.LOJISTA) {
            throw new ValidacaoExcepetion("Usúario não possui permissão para criar categoria");
        }
    }
    
}
