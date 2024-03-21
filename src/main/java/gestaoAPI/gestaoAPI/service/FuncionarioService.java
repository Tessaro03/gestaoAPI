package gestaoAPI.gestaoAPI.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestaoAPI.gestaoAPI.domain.Funcionario;
import gestaoAPI.gestaoAPI.dtos.funcionario.FuncionarioInputDTO;
import gestaoAPI.gestaoAPI.dtos.funcionario.FuncionarioOutputDTO;
import gestaoAPI.gestaoAPI.infra.token.UsuarioToken;
import gestaoAPI.gestaoAPI.repository.FuncionariosRepository;
import gestaoAPI.gestaoAPI.repository.LojaRepository;
import gestaoAPI.gestaoAPI.repository.UsuarioRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionariosRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private LojaRepository lojaRepository;

    @Autowired
    private UsuarioToken usuarioToken;


    public List<FuncionarioOutputDTO> ver(HttpServletRequest request) {
        var funcionario = usuarioToken.funcionarioToken(request);
        var funcionarios = repository.buscarFuncionariosPorIdLoja(funcionario.getLoja().getId());
        return funcionarios.stream().map(FuncionarioOutputDTO::new).collect(Collectors.toList());
    }

    public void criar(@Valid FuncionarioInputDTO dados, HttpServletRequest request) {
        var funcionarioLogado = usuarioToken.funcionarioToken(request);

        var contratado = usuarioRepository.getReferenceById(dados.idUsuario());
        var loja = lojaRepository.getReferenceById(funcionarioLogado.getLoja().getId());

        var funcionarioNovo = new Funcionario(dados, contratado, loja);
        repository.save(funcionarioNovo);
    }
    
}
