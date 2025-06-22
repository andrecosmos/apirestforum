package forum.vel.api.model.usuario;

public record ListarUsuario(String nome, String email) {

    public ListarUsuario(Usuario usuario){
        this(usuario.getNome(),usuario.getEmail());

    }

}
