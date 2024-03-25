package gestaoAPI.gestaoAPI.validacao.funcionario.ValidacaoPatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestaoAPI.gestaoAPI.dtos.funcionario.FuncionarioAlterarDTO;
import gestaoAPI.gestaoAPI.infra.exception.ValidacaoExcepetion;
import gestaoAPI.gestaoAPI.infra.token.UsuarioToken;
import gestaoAPI.gestaoAPI.repository.FuncionariosRepository;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class ValidandoSeUsuarioPertenceALojaDoFuncionarioParaAlterar implements ValidacaoFuncionarioPatch{

    @Autowired 
    private UsuarioToken usuarioToken;

    @Autowired
    private FuncionariosRepository repository;

    @Override
    public void validar(HttpServletRequest request, FuncionarioAlterarDTO dados, Long id) {
        var funcionario = usuarioToken.funcionarioToken(request);
        var funcionarioAlterardo = repository.getReferenceById(id);
        if (funcionario.getLoja() !=  funcionarioAlterardo.getLoja()) {
            throw new ValidacaoExcepetion("Funcionario não pertence a loja");
        }
    }
}