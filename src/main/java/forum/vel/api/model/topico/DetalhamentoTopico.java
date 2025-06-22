package forum.vel.api.model.topico;

public record DetalhamentoTopico(String titulo, String mensagem) {


    public DetalhamentoTopico (Topico topico){
        this(topico.getTitulo(),topico.getMensagem());
    }
}
