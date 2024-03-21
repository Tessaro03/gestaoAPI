package gestaoAPI.gestaoAPI.infra.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestaoAPI.gestaoAPI.domain.Loja;
import gestaoAPI.gestaoAPI.domain.Usuario;
import gestaoAPI.gestaoAPI.infra.security.SecurityFilter;
import gestaoAPI.gestaoAPI.repository.FuncionariosRepository;
import gestaoAPI.gestaoAPI.repository.LojaRepository;
import gestaoAPI.gestaoAPI.repository.UsuarioRepository;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class UsuarioToken {
    
    @Autowired
    TokenService tokenService;

    @Autowired
    SecurityFilter securityFilter;
    
    @Autowired
    private UsuarioRepository repository;

    

    public Usuario usuarioToken(HttpServletRequest request){
        var recuperarToken = securityFilter.recuperarToken(request);
        var login = tokenService.getSubject(recuperarToken);
        var usuario = repository.buscarUsuarioPorLogin(login);
        return usuario;
    }


}
