package gestaoAPI.gestaoAPI.validacao.categoria.validacaoPatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestaoAPI.gestaoAPI.dtos.categoria.CategoriaAlterarDTO;
import gestaoAPI.gestaoAPI.infra.exception.ValidacaoExcepetion;
import gestaoAPI.gestaoAPI.infra.token.UsuarioToken;
import gestaoAPI.gestaoAPI.repository.FuncionariosRepository;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class ValidandoSeUsuarioEFuncionarioParaAlterar implements ValidarCategoriaPatch {

    @Autowired
    private FuncionariosRepository repository;

    @Autowired
    private UsuarioToken usuarioToken;

    @Override
    public void validar(HttpServletRequest request, CategoriaAlterarDTO dados, Long id) {
        var usuario = usuarioToken.usuarioToken(request);
        if (repository.existeFuncionarioIdUsuario(usuario.getId())) {
            throw new ValidacaoExcepetion("Usuario não faz parte de nenhuma loja");
        }
    }
    
}
