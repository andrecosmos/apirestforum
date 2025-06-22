package forum.vel.api.model.topico;

import forum.vel.api.model.curso.ListarCurso;
import forum.vel.api.model.usuario.ListarUsuario;

public record ListarTopico(Long id, String titulo, String mensagem, ListarUsuario autor, ListarCurso curso) {

    public ListarTopico(Topico topico){
        this(topico.getId(),topico.getTitulo(),topico.getMensagem(), new ListarUsuario(topico.getAutor()),new ListarCurso(topico.getCurso()));
    }


}
