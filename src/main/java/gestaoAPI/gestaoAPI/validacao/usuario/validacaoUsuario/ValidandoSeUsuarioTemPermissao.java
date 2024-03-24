package gestaoAPI.gestaoAPI.validacao.usuario.validacaoUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import gestaoAPI.gestaoAPI.domain.Cargo;
import gestaoAPI.gestaoAPI.infra.exception.ValidacaoExcepetion;
import gestaoAPI.gestaoAPI.infra.token.UsuarioToken;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class ValidandoSeUsuarioTemPermissao implements ValidarUsuario{

    @Autowired
    private UsuarioToken usuarioToken;

    @Override
    public void validar(HttpServletRequest request) {
        var funcionario = usuarioToken.funcionarioToken(request);
        if (funcionario.getCargo() == Cargo.LOJISTA) {
            throw new ValidacaoExcepetion("Usuário não tem permissão");
        }
    }
    
}
