package gestaoAPI.gestaoAPI.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestaoAPI.gestaoAPI.domain.Categoria;
import gestaoAPI.gestaoAPI.domain.Produto;
import gestaoAPI.gestaoAPI.dtos.produto.ProdutoAlterarDTO;
import gestaoAPI.gestaoAPI.dtos.produto.ProdutoInputDTO;
import gestaoAPI.gestaoAPI.dtos.produto.ProdutoOutputDTO;
import gestaoAPI.gestaoAPI.repository.CategoriaRepository;
import gestaoAPI.gestaoAPI.repository.LojaRepository;
import gestaoAPI.gestaoAPI.repository.ProdutoRepository;
import jakarta.validation.Valid;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired LojaRepository lojaRepository;

    public List<ProdutoOutputDTO> ver() {
        var produtos = repository.findAll();
        return produtos.stream().map(ProdutoOutputDTO::new).collect(Collectors.toList());
    }

    public void criar(@Valid ProdutoInputDTO dados) {
        var loja = lojaRepository.getReferenceById(2l);
        
        var categoria = new Categoria();
        categoria.setTitulo(dados.categoria());
        categoriaRepository.save(categoria);
        
        var categoriaSalva = categoriaRepository.CategoriaPorNome(dados.categoria());
        var produto = new Produto(dados, categoriaSalva, loja);
        repository.save(produto);
    }
    
    public void alterar(@Valid ProdutoAlterarDTO dados, Long id){
        var produto = repository.getReferenceById(id);
        if (dados.categoria() != null) {
            var categoria = categoriaRepository.CategoriaPorNome(dados.categoria());
            produto.setCategoria(categoria);
        }
        produto.alterar(dados);
        repository.save(produto);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
