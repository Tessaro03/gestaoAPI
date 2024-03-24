package gestaoAPI.gestaoAPI.validacao.categoria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestaoAPI.gestaoAPI.domain.Funcionario;
import gestaoAPI.gestaoAPI.dtos.categoria.CategoriaAlterarDTO;
import gestaoAPI.gestaoAPI.dtos.categoria.CategoriaInputDTO;
import gestaoAPI.gestaoAPI.validacao.categoria.validacaoPatch.ValidarCategoriaPatch;
import gestaoAPI.gestaoAPI.validacao.categoria.validacaoPost.ValidarCategoriaPost;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class ValidacaoCategoria {
    
    @Autowired
    private List<ValidarCategoriaPost> validarPost;

    @Autowired
    private List<ValidarCategoriaPatch> validarPatch;

    public void validadorPost(HttpServletRequest request, CategoriaInputDTO dados){
        validarPost.forEach(v -> v.validar(request, dados));
    }

    public void validarPatch(HttpServletRequest request, CategoriaAlterarDTO dados, Long id){
        validarPatch.forEach(v -> v.validar(request, dados, id));
    }
}
