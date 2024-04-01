package gestaoAPI.gestaoAPI.validacao.loja.validacaoUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestaoAPI.gestaoAPI.infra.exception.ValidacaoExcepetion;
import gestaoAPI.gestaoAPI.infra.token.UsuarioToken;
import gestaoAPI.gestaoAPI.repository.FuncionariosRepository;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class ValidandoSeUsuarioPertenceAAlgumaLoja implements ValidadorLojaUsuario {

    @Autowired
    private UsuarioToken usuarioToken;

    @Autowired 
    private FuncionariosRepository repository;

    @Override
    public void validar(HttpServletRequest request, Long id) {
        var usuario = usuarioToken.usuarioToken(request);
        if (repository.existeFuncionarioIdUsuario(usuario.getId())) {
            throw new ValidacaoExcepetion("Usuário não pertence a nenhuma loja");
            
        }
    }
    
}
