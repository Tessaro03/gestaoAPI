package gestaoAPI.gestaoAPI.validacao.categoria.validacaoPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestaoAPI.gestaoAPI.dtos.categoria.CategoriaInputDTO;
import gestaoAPI.gestaoAPI.infra.exception.ValidacaoExcepetion;
import gestaoAPI.gestaoAPI.infra.token.UsuarioToken;
import gestaoAPI.gestaoAPI.repository.FuncionariosRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ValidationException;

@Service
public class ValidandoSeUsuarioEFuncionario implements ValidarCategoriaPost{

    @Autowired
    private UsuarioToken usuarioToken;

    @Autowired
    private FuncionariosRepository repository;

    @Override
    public void validar(HttpServletRequest request, CategoriaInputDTO dados) {
        var usuario = usuarioToken.usuarioToken(request);
        
        if (! repository.existeFuncionarioIdUsuario(usuario.getId())) {
            throw new ValidacaoExcepetion("Usuário não faz parte de nenhuma loja");            
        }
        

    }
    
}
