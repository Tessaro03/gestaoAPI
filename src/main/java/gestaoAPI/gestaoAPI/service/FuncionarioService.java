package gestaoAPI.gestaoAPI.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestaoAPI.gestaoAPI.domain.Funcionario;
import gestaoAPI.gestaoAPI.dtos.funcionario.FuncionarioInputDTO;
import gestaoAPI.gestaoAPI.dtos.funcionario.FuncionarioOutputDTO;
import gestaoAPI.gestaoAPI.repository.FuncionariosRepository;
import gestaoAPI.gestaoAPI.repository.LojaRepository;
import gestaoAPI.gestaoAPI.repository.UsuarioRepository;
import jakarta.validation.Valid;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionariosRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private LojaRepository lojaRepository;


    public List<FuncionarioOutputDTO> ver() {
        var funcionarios = repository.findAll();
        return funcionarios.stream().map(FuncionarioOutputDTO::new).collect(Collectors.toList());
    }

    public void criar(@Valid FuncionarioInputDTO dados) {
        var usuario = usuarioRepository.getReferenceById(dados.idUsuario());
        var loja = lojaRepository.getReferenceById(2l);

        var funcionario = new Funcionario(dados, usuario, loja);
        repository.save(funcionario);
    }
    
}
