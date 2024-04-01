package gestaoAPI.gestaoAPI.validacao.loja.validacaoUsuario;

import org.springframework.beans.factory.annotation.Autowired;

import gestaoAPI.gestaoAPI.infra.exception.ValidacaoExcepetion;
import gestaoAPI.gestaoAPI.infra.token.UsuarioToken;
import jakarta.servlet.http.HttpServletRequest;

public class ValidandoSeUsuarioPertenceALojaDoId implements ValidadorLojaUsuario{

    @Autowired
    private UsuarioToken usuarioToken;

    @Override
    public void validar(HttpServletRequest request, Long id) {
        var funcionario = usuarioToken.funcionarioToken(request);
        if (funcionario.getLoja().getId() != id) {
            throw new ValidacaoExcepetion("Usuario não pertence a essa loja");
        }        
    }
    
}
