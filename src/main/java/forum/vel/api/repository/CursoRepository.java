package forum.vel.api.repository;

import forum.vel.api.model.curso.Curso;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CursoRepository extends JpaRepository <Curso, Long> {
    Optional<Curso> findByNomeAndCategoria(String nome, String categoria);
}
