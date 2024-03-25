package gestaoAPI.gestaoAPI.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestaoAPI.gestaoAPI.domain.Funcionario;
import gestaoAPI.gestaoAPI.dtos.funcionario.FuncionarioAlterarDTO;
import gestaoAPI.gestaoAPI.dtos.funcionario.FuncionarioInputDTO;
import gestaoAPI.gestaoAPI.dtos.funcionario.FuncionarioOutputDTO;
import gestaoAPI.gestaoAPI.infra.token.UsuarioToken;
import gestaoAPI.gestaoAPI.repository.FuncionariosRepository;
import gestaoAPI.gestaoAPI.repository.LojaRepository;
import gestaoAPI.gestaoAPI.repository.UsuarioRepository;
import gestaoAPI.gestaoAPI.validacao.funcionario.ValidacaoFuncionario;
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

    @Autowired
    private ValidacaoFuncionario validador;


    public List<FuncionarioOutputDTO> ver(HttpServletRequest request) {
        var funcionario = usuarioToken.funcionarioToken(request);
        var funcionarios = repository.buscarFuncionariosPorIdLoja(funcionario.getLoja().getId());
        return funcionarios.stream().map(FuncionarioOutputDTO::new).collect(Collectors.toList());
    }

    public void criar(@Valid FuncionarioInputDTO dados, HttpServletRequest request) {
        validador.validadorPost(dados, request);
        var funcionarioLogado = usuarioToken.funcionarioToken(request);
        var contratado = usuarioRepository.getReferenceById(dados.idUsuario());
        var loja = lojaRepository.getReferenceById(funcionarioLogado.getLoja().getId());
        var funcionarioNovo = new Funcionario(dados, contratado, loja);
        repository.save(funcionarioNovo);
    }

    public void alterar(HttpServletRequest request, FuncionarioAlterarDTO dados, Long id) {
        validador.validadorPatch(request, dados, id);
        var funcionario = repository.getReferenceById(id);
        funcionario.alterar(dados);
    }
    
    public void deletar(HttpServletRequest request, Long id){
        validador.validadorDelete(request, id);
        repository.deleteById(id);
    }

}
