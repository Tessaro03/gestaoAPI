package gestaoAPI.gestaoAPI.validacao.funcionario.ValidacaoPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestaoAPI.gestaoAPI.dtos.funcionario.FuncionarioInputDTO;
import gestaoAPI.gestaoAPI.repository.FuncionariosRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ValidationException;

@Service
public class ValidandoSeFuncionarioJaEFuncionario implements ValidacaoFuncionarioPost{

    @Autowired
    private FuncionariosRepository funcionariosRepository;

    @Override
    public void validar(FuncionarioInputDTO dados, HttpServletRequest request) {
        if (funcionariosRepository.existeFuncionarioIdUsuario(dados.idUsuario())) {
            throw new ValidationException("Funcionario já faz parte de uma loja");            
        }
    }
    
}
