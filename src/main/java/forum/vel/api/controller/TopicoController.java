package forum.vel.api.controller;

import forum.vel.api.model.curso.Curso;
import forum.vel.api.model.curso.DadosCurso;
import forum.vel.api.model.topico.*;
import forum.vel.api.model.usuario.Usuario;
import forum.vel.api.repository.CursoRepository;
import forum.vel.api.repository.TopicoRepository;
import forum.vel.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("topico")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;


    @PostMapping
    @Transactional
    public ResponseEntity<DadosTopicoResponse> cadastrar(@RequestBody DadosTopico dados) {
        Usuario autor = usuarioRepository.findById(dados.idAutor())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        DadosCurso dadosCurso = dados.curso();

        Curso curso = cursoRepository.findByNomeAndCategoria(
                dadosCurso.nome(), dadosCurso.categoria()
        ).orElseGet(() -> {
            Curso novoCurso = new Curso(dadosCurso);
            return cursoRepository.save(novoCurso);
        });

        Topico topico = new Topico(dados, autor, curso);
        repository.save(topico);

        return ResponseEntity.created(URI.create("/topico/" + topico.getId()))
                .body(new DadosTopicoResponse(topico));
    }

    @GetMapping
    public ResponseEntity<Page<ListarTopico>> listar(@PageableDefault(size = 10, sort = {"titulo"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(ListarTopico::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity AtualizarTopico(@RequestBody AtualizaTopico dados){
        var topico = repository.getReferenceById(dados.id());
        topico.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DetalhamentoTopico(topico));
    }




    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);
        topico.excluir();
        return ResponseEntity.noContent().build();
    }





}
