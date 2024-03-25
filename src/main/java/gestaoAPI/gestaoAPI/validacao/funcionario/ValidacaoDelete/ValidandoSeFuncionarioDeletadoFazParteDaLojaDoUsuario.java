package gestaoAPI.gestaoAPI.validacao.funcionario.ValidacaoDelete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestaoAPI.gestaoAPI.infra.exception.ValidacaoExcepetion;
import gestaoAPI.gestaoAPI.infra.token.UsuarioToken;
import gestaoAPI.gestaoAPI.repository.FuncionariosRepository;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class ValidandoSeFuncionarioDeletadoFazParteDaLojaDoUsuario implements ValidacaoFuncionarioDelete{

    @Autowired
    private UsuarioToken usuarioToken;

    @Autowired
    private FuncionariosRepository funcionariosRepository;


    @Override
    public void validar(Long id, HttpServletRequest request) {
        var funcionario = usuarioToken.funcionarioToken(request);
        var funcionarioDeletado = funcionariosRepository.getReferenceById(id);
        if (funcionarioDeletado.getLoja() != funcionario.getLoja()) {
            throw new ValidacaoExcepetion("Funcionario não pertence a loja do usuário");
        }
    }
    
}
