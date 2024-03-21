package gestaoAPI.gestaoAPI.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestaoAPI.gestaoAPI.domain.Usuario;
import gestaoAPI.gestaoAPI.dtos.usuario.DadosCadastroUsuario;
import gestaoAPI.gestaoAPI.dtos.usuario.UsuarioOutputDTO;
import gestaoAPI.gestaoAPI.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<UsuarioOutputDTO> ver() {
        var usuarios = repository.findAll();
        return usuarios.stream().map(UsuarioOutputDTO::new).collect(Collectors.toList());
    }

    public void criar( DadosCadastroUsuario dados) {
        var usuario = new Usuario(dados);
        repository.save(usuario);
    }
    
}
