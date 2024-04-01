package gestaoAPI.gestaoAPI.validacao.loja;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestaoAPI.gestaoAPI.validacao.loja.validacaoUsuario.ValidadorLojaUsuario;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class ValidacaoLoja {
    
    @Autowired
    private List<ValidadorLojaUsuario> validador;

    public void validadorUsuario(HttpServletRequest request, Long id){
        validador.forEach(v -> v.validar(request, id));
    }

}
