package gestaoAPI.gestaoAPI.validacao.funcionario.ValidacaoUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestaoAPI.gestaoAPI.domain.Cargo;
import gestaoAPI.gestaoAPI.infra.token.UsuarioToken;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class ValidandoSeFuncionarioTemPermissaoParaFuncionario implements ValidacaoFuncionarioUsuario{
    
    @Autowired
    private UsuarioToken usuarioToken;

    @Override
    public void validar(HttpServletRequest request) {
        var funcionario = usuarioToken.funcionarioToken(request);
        if (funcionario.getCargo() != Cargo.GERAL) {
            throw new UnsupportedOperationException("Usuário não tem permissão");
        }
    }
    
}
