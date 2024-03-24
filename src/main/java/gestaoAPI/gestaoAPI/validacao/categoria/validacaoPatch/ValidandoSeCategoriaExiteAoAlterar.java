package gestaoAPI.gestaoAPI.validacao.categoria.validacaoPatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestaoAPI.gestaoAPI.domain.Categoria;
import gestaoAPI.gestaoAPI.dtos.categoria.CategoriaAlterarDTO;
import gestaoAPI.gestaoAPI.infra.exception.ValidacaoExcepetion;
import gestaoAPI.gestaoAPI.infra.token.UsuarioToken;
import gestaoAPI.gestaoAPI.repository.CategoriaRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ValidationException;

@Service
public class ValidandoSeCategoriaExiteAoAlterar implements ValidarCategoriaPatch{

    @Autowired 
    private CategoriaRepository repository;

    @Autowired
    private UsuarioToken usuarioToken;

    @Override
    public void validar(HttpServletRequest request, CategoriaAlterarDTO dados, Long id) {
        var funcionario = usuarioToken.funcionarioToken(request);
        if (repository.existeCategoriaNaLoja(dados.titulo(), funcionario.getLoja().getId())) {
            throw new ValidacaoExcepetion("Já existe categoria com esse nome");
        }
    }
    
}
