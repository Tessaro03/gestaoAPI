package gestaoAPI.gestaoAPI.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestaoAPI.gestaoAPI.domain.Categoria;
import gestaoAPI.gestaoAPI.dtos.categoria.CategoriaAlterarDTO;
import gestaoAPI.gestaoAPI.dtos.categoria.CategoriaInputDTO;
import gestaoAPI.gestaoAPI.dtos.categoria.CategoriaOutputDTO;
import gestaoAPI.gestaoAPI.repository.CategoriaRepository;
import gestaoAPI.gestaoAPI.repository.LojaRepository;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    @Autowired
    private LojaRepository lojaRepository;

    public List<CategoriaOutputDTO> ver(HttpServletRequest request) {
        var categorias = repository.findAll();
        return categorias.stream().map(CategoriaOutputDTO::new).collect(Collectors.toList());
    }

    public void criar(CategoriaInputDTO dados) {
        var loja = lojaRepository.getReferenceById(2l);
        var categoria = new Categoria(dados, loja);
        repository.save(categoria);
    }

    public void alterar(Long id, CategoriaAlterarDTO dados) {
        var categoria = repository.getReferenceById(id);
        categoria.alterar(dados);
        repository.save(categoria);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
    



}
