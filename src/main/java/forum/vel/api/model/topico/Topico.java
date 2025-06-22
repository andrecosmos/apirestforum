package forum.vel.api.model.topico;

import forum.vel.api.model.curso.Curso;
import forum.vel.api.model.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private StatusTopico status = StatusTopico.NAO_RESPONDIDO;

    @ManyToOne
    private Usuario autor;

    @ManyToOne
    private Curso curso;

    private Boolean ativo;


    public Topico(DadosTopico dados, Usuario autor, Curso curso) {
        this.ativo = true;
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.autor = autor;
        this.curso = curso;
        this.status = StatusTopico.NAO_RESPONDIDO;
        this.dataCriacao = LocalDateTime.now();
    }


    public void atualizarInformacoes(AtualizaTopico dados) {
        if (dados.id() != null) {
            this.mensagem = dados.mensagem();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
