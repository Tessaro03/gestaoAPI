package gestaoAPI.gestaoAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import gestaoAPI.gestaoAPI.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{


    @Query("SELECT p FROM Produto p WHERE p.loja.id = :idLoja")
    List<Produto> buscarProdutosPorIdLoja(Long idLoja);
    
}
