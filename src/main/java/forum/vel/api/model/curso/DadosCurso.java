package forum.vel.api.model.curso;

public record DadosCurso(Long id , String nome, String categoria) {

    public DadosCurso(Curso curso) {
        this(curso.getId(), curso.getNome(), curso.getCategoria());
    }
}
