package forum.vel.api.repository;

import forum.vel.api.model.topico.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository <Topico , Long> {


    Page<Topico> findAllByAtivoTrue(Pageable paginacao);
}
