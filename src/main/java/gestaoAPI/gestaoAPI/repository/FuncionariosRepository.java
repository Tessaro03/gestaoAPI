package gestaoAPI.gestaoAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gestaoAPI.gestaoAPI.domain.Funcionario;

public interface FuncionariosRepository extends JpaRepository<Funcionario, Long>{
    
}
