package gestaoAPI.gestaoAPI.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import gestaoAPI.gestaoAPI.domain.Loja;

public interface LojaRepository extends JpaRepository<Loja, Long>{

     
    
}
