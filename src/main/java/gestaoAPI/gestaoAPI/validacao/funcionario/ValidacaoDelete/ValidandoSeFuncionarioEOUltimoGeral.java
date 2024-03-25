package gestaoAPI.gestaoAPI.validacao.funcionario.ValidacaoDelete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestaoAPI.gestaoAPI.infra.exception.ValidacaoExcepetion;
import gestaoAPI.gestaoAPI.infra.token.UsuarioToken;
import gestaoAPI.gestaoAPI.repository.FuncionariosRepository;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class ValidandoSeFuncionarioEOUltimoGeral  implements ValidacaoFuncionarioDelete{


    @Autowired
    private UsuarioToken usuarioToken;

    @Autowired
    private FuncionariosRepository funcionariosRepository;

    @Override
    public void validar(Long id, HttpServletRequest request) {
        var funcionario = usuarioToken.funcionarioToken(request);
        var funcionarioDeletado = funcionariosRepository.getReferenceById(id);
        if (funcionario == funcionarioDeletado) {
            if (funcionariosRepository.funcionarioUltimoGeral(funcionario.getId())) {
                throw new ValidacaoExcepetion("Funcionario deve atribuir o cargo 'Geral' a outro funcionario antes de se deletar");
            }
        }
    }
    
}
