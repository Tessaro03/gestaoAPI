package gestaoAPI.gestaoAPI.validacao.categoria.validacaoPatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestaoAPI.gestaoAPI.domain.Cargo;
import gestaoAPI.gestaoAPI.dtos.categoria.CategoriaAlterarDTO;
import gestaoAPI.gestaoAPI.infra.exception.ValidacaoExcepetion;
import gestaoAPI.gestaoAPI.infra.token.UsuarioToken;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class ValidandoSeUsuarioTemPermissaoParaAlterar implements ValidarCategoriaPatch {
    
 @Autowired
    private UsuarioToken usuarioToken;


    @Override
    public void validar(HttpServletRequest request, CategoriaAlterarDTO dados, Long id) {
        var funcionario = usuarioToken.funcionarioToken(request);
        if (funcionario.getCargo() == Cargo.LOJISTA) {
            throw new ValidacaoExcepetion("Usúario não possui permissão para alterar categoria");
        }
    }

}
