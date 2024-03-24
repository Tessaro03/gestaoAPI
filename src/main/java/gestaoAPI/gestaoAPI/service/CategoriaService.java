package gestaoAPI.gestaoAPI.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestaoAPI.gestaoAPI.domain.Categoria;
import gestaoAPI.gestaoAPI.dtos.categoria.CategoriaAlterarDTO;
import gestaoAPI.gestaoAPI.dtos.categoria.CategoriaInputDTO;
import gestaoAPI.gestaoAPI.dtos.categoria.CategoriaOutputDTO;
import gestaoAPI.gestaoAPI.infra.token.UsuarioToken;
import gestaoAPI.gestaoAPI.repository.CategoriaRepository;
import gestaoAPI.gestaoAPI.repository.LojaRepository;
import gestaoAPI.gestaoAPI.validacao.categoria.ValidacaoCategoria;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    @Autowired
    private LojaRepository lojaRepository;

    @Autowired
    private UsuarioToken usuarioToken;

    @Autowired
    private ValidacaoCategoria validador;

    public List<CategoriaOutputDTO> ver(HttpServletRequest request) {
        var funcionario = usuarioToken.funcionarioToken(request);
        var categorias = repository.buscarCategoriaPorIdLoja(funcionario.getLoja().getId());
        return categorias.stream().map(CategoriaOutputDTO::new).collect(Collectors.toList());
    }

    public void criar(CategoriaInputDTO dados, HttpServletRequest request) {
        validador.validadorPost(request, dados);
        var funcionario = usuarioToken.funcionarioToken(request);
        var loja = lojaRepository.getReferenceById(funcionario.getLoja().getId());
        var categoria = new Categoria(dados, loja);
        repository.save(categoria);
    }

    public void alterar(Long id, CategoriaAlterarDTO dados, HttpServletRequest request) {
        validador.validarPatch(request, dados, id);
        var categoria = repository.getReferenceById(id);
        categoria.alterar(dados);
        repository.save(categoria);
    }

    public void deletar(HttpServletRequest request,Long id) {
        repository.deleteById(id);
    }
    



}
