package forum.vel.api.model.topico;

import forum.vel.api.model.curso.DadosCurso;
import forum.vel.api.model.usuario.DadosUsuario;

public record DadosTopico(
        String titulo,
        String mensagem,
        Long idAutor,
        DadosCurso curso,
        DadosUsuario autor
) {

}
