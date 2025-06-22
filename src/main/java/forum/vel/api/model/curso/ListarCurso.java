package forum.vel.api.model.curso;

public record ListarCurso(String nome, String categoria) {

    public ListarCurso(Curso curso){
        this(curso.getNome(),curso.getCategoria());
    }
}
