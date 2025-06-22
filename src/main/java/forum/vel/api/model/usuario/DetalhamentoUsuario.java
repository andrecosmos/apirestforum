package forum.vel.api.model.usuario;

import forum.vel.api.model.topico.Topico;

public record DetalhamentoUsuario(String nome,String email) {
        public DetalhamentoUsuario (Usuario usuario) {
            this(usuario.getNome(), usuario.getEmail());
        }
}
