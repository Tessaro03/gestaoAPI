package gestaoAPI.gestaoAPI.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestaoAPI.gestaoAPI.domain.Produto;
import gestaoAPI.gestaoAPI.dtos.produto.ProdutoAlterarDTO;
import gestaoAPI.gestaoAPI.dtos.produto.ProdutoInputDTO;
import gestaoAPI.gestaoAPI.dtos.produto.ProdutoOutputDTO;
import gestaoAPI.gestaoAPI.infra.token.UsuarioToken;
import gestaoAPI.gestaoAPI.repository.CategoriaRepository;
import gestaoAPI.gestaoAPI.repository.LojaRepository;
import gestaoAPI.gestaoAPI.repository.ProdutoRepository;
import gestaoAPI.gestaoAPI.validacao.produto.ValidacaoProduto;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired LojaRepository lojaRepository;

    @Autowired
    private UsuarioToken usuarioToken;

    @Autowired
    public ValidacaoProduto validador;

    public List<ProdutoOutputDTO> ver(HttpServletRequest request) {
        var funcionario = usuarioToken.funcionarioToken(request);
        var produtos = repository.buscarProdutosPorIdLoja(funcionario.getLoja().getId());
        return produtos.stream().map(ProdutoOutputDTO::new).collect(Collectors.toList());
    }

    public void criar( ProdutoInputDTO dados, HttpServletRequest request) {
        validador.validadorPost(dados, request);
        var funcionario = usuarioToken.funcionarioToken(request);

        var loja = lojaRepository.getReferenceById(funcionario.getLoja().getId());
        var categoria = categoriaRepository.CategoriaPorNome(dados.categoria());
        var produto = new Produto(dados, categoria, loja);
        repository.save(produto);
    }
    
    public void alterar( ProdutoAlterarDTO dados, Long id, HttpServletRequest request){
        validador.validadorPatch(dados,  id,  request);
        var produto = repository.getReferenceById(id);
        if (dados.categoria() != null) {
            var categoria = categoriaRepository.CategoriaPorNome(dados.categoria());
            produto.setCategoria(categoria);
        }
        produto.alterar(dados);
        repository.save(produto);
    }

    public void deletar(Long id, HttpServletRequest request){
        validador.validadorDelete(id, request);
        repository.deleteById(id);
    }
}
