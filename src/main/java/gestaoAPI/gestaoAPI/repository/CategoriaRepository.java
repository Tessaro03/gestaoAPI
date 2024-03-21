package gestaoAPI.gestaoAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import gestaoAPI.gestaoAPI.domain.Categoria;
import jakarta.validation.constraints.NotBlank;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

    @Query("SELECT c FROM Categoria c WHERE c.titulo = :categoria")
    Categoria CategoriaPorNome(@NotBlank String categoria);

    @Query("SELECT c FROM Categoria c WHERE c.loja.id = :idLoja")
    List<Categoria> buscarCategoriaPorIdLoja(Long idLoja);
    
}
