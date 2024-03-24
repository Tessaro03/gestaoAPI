package gestaoAPI.gestaoAPI.validacao.categoria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestaoAPI.gestaoAPI.dtos.categoria.CategoriaAlterarDTO;
import gestaoAPI.gestaoAPI.dtos.categoria.CategoriaInputDTO;
import gestaoAPI.gestaoAPI.validacao.categoria.validacaoDelete.ValidarCategoriaDelete;
import gestaoAPI.gestaoAPI.validacao.categoria.validacaoPatch.ValidarCategoriaPatch;
import gestaoAPI.gestaoAPI.validacao.categoria.validacaoPost.ValidarCategoriaPost;
import gestaoAPI.gestaoAPI.validacao.usuario.validacaoUsuario.ValidarUsuario;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class ValidacaoCategoria {
    
    @Autowired
    private List<ValidarCategoriaPost> validarPost;

    @Autowired
    private List<ValidarCategoriaPatch> validarPatch;

    @Autowired
    private List<ValidarUsuario> validarUsuario;

    @Autowired
    private List<ValidarCategoriaDelete> validarDelete;

    public void validadorPost(HttpServletRequest request, CategoriaInputDTO dados){
        validarUsuario.forEach(v -> v.validar(request));
        validarPost.forEach(v -> v.validar(request, dados));
    }

    public void validadorPatch(HttpServletRequest request, CategoriaAlterarDTO dados, Long id){
        validarUsuario.forEach(v -> v.validar(request));
        validarPatch.forEach(v -> v.validar(request, dados, id));
    }

    public void validadorDelete(HttpServletRequest request, Long id){
        validarUsuario.forEach(v -> v.validar(request));
        validarDelete.forEach(v -> v.validar(request, id));
    }

}
