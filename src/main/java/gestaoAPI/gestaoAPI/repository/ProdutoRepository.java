package gestaoAPI.gestaoAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gestaoAPI.gestaoAPI.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
