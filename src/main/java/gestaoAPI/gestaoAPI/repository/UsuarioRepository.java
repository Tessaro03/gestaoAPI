package gestaoAPI.gestaoAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import gestaoAPI.gestaoAPI.domain.Usuario;

/**
 * UsuarioRepository
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    UserDetails findByLogin(String login);

    
    @Query("SELECT u FROM Usuario u WHERE u.login = :login")
    Usuario buscarUsuarioPorLogin(String login);
}