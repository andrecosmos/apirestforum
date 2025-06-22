package forum.vel.api.model.usuario;

public record DadosUsuario(Long id, String nome, String email, String senha, boolean ativo) {

    public DadosUsuario(Usuario usuario){
        this(usuario.getId(),usuario.getNome(),usuario.getEmail(),usuario.getSenha(),usuario.getAtivo());
    }




}
