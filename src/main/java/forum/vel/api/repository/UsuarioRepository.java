package forum.vel.api.repository;


import forum.vel.api.model.usuario.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Page<Usuario> findAll(Pageable paginacao);



    UserDetails findByEmail(String username);
}

