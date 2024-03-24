package gestaoAPI.gestaoAPI.validacao.categoria.validacaoPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestaoAPI.gestaoAPI.dtos.categoria.CategoriaInputDTO;
import gestaoAPI.gestaoAPI.infra.exception.ValidacaoExcepetion;
import gestaoAPI.gestaoAPI.infra.token.UsuarioToken;
import gestaoAPI.gestaoAPI.repository.CategoriaRepository;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class ValidandoSeCategoriaExisteAoCriar implements ValidarCategoriaPost {
    
    @Autowired
    private CategoriaRepository repository;

    @Autowired
    private UsuarioToken usuarioToken;

    @Override
    public void validar(HttpServletRequest request, CategoriaInputDTO dados) {
        var funcionario = usuarioToken.funcionarioToken(request);
        if (repository.existeCategoriaNaLoja(dados.titulo(), funcionario.getLoja().getId())) {
            throw new ValidacaoExcepetion("Categoria já existe");
        }
    
    } 



}
