package gestaoAPI.gestaoAPI.validacao.categoria.validacaoPatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestaoAPI.gestaoAPI.dtos.categoria.CategoriaAlterarDTO;
import gestaoAPI.gestaoAPI.infra.token.UsuarioToken;
import gestaoAPI.gestaoAPI.repository.CategoriaRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ValidationException;

@Service
public class ValidandoSeCategoriaPertenceALojaDoUsuario implements ValidarCategoriaPatch {

    @Autowired
    private CategoriaRepository repository;

    @Autowired
    private UsuarioToken usuarioToken;

    @Override
    public void validar(HttpServletRequest request, CategoriaAlterarDTO dados, Long id) {
        var categoria = repository.getReferenceById(id);
        var funcionario = usuarioToken.funcionarioToken(request);
        if (funcionario.getLoja() != categoria.getLoja()) {
            throw new ValidationException("Usuario não faz parte da loja que pertence essa categoria");
        }
    }
    
}
