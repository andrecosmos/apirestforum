package forum.vel.api.model.topico;

public record DadosTopicoResponse(Long id, String titulo, String mensagem, String nomeAutor, String nomeCurso) {
    public DadosTopicoResponse(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(),
                topico.getAutor().getNome(), topico.getCurso().getNome());
    }
}

