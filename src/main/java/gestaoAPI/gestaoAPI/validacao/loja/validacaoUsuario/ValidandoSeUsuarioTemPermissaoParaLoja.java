package gestaoAPI.gestaoAPI.validacao.loja.validacaoUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestaoAPI.gestaoAPI.domain.Cargo;
import gestaoAPI.gestaoAPI.infra.exception.ValidacaoExcepetion;
import gestaoAPI.gestaoAPI.infra.token.UsuarioToken;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class ValidandoSeUsuarioTemPermissaoParaLoja implements ValidadorLojaUsuario{

    @Autowired
    private UsuarioToken usuarioToken;

    @Override
    public void validar(HttpServletRequest request, Long id) {
        var funcionario = usuarioToken.funcionarioToken(request);
        if (funcionario.getCargo() != Cargo.GERAL) {
            throw new ValidacaoExcepetion("Usuario não tem permissão");
        }
    }
    


}
