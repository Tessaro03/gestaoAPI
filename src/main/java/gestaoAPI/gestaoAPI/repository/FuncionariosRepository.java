package gestaoAPI.gestaoAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import gestaoAPI.gestaoAPI.domain.Funcionario;

public interface FuncionariosRepository extends JpaRepository<Funcionario, Long>{

    @Query("SELECT f FROM Funcionario f WHERE f.usuario.id = :idUsuario")
    Funcionario buscarFuncionarioPorIdUsuario(Long idUsuario);
    
    @Query("SELECT f From Funcionario f WHERE f.loja.id = :idLoja")
    List<Funcionario> buscarFuncionariosPorIdLoja(Long idLoja);

    @Query("SELECT CASE WHEN COUNT(f) > 0 THEN true ELSE false END FROM Funcionario f WHERE f.usuario.id = :idUsuario")
    boolean existeFuncionarioIdUsuario(Long idUsuario);
}
