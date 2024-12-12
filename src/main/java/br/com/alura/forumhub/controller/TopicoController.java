package br.com.alura.forumhub.controller;


import br.com.alura.forumhub.domain.topico.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarTopico(@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriBuilder){
        var topico = new Topico(dados);
        repository.save(topico);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTopico>> listar(@PageableDefault(size = 10, sort={"dataCriacao"}) Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosListagemTopico::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoTopico dados, @PathVariable Long id ){

        Optional<Topico> optionalTopico = repository.findById(id);

        if(optionalTopico.isPresent()){
            Topico topico = optionalTopico.get();
            topico.atualizarInformacoes(dados);
            return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
        }else {
            throw new RuntimeException("O ID: "+ id + " do Tópico não existe no banco de dados! ");
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id){
        Optional<Topico> optionalTopico = repository.findById(id);
        if(optionalTopico.isPresent()){
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }else {
            throw new RuntimeException("O ID: "+ id + " que tentou deletar não existe!");
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        Optional<Topico> optionalTopico = repository.findById(id);
        if(optionalTopico.isPresent()){
            var topico = repository.getReferenceById(id);
            return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
        }else{
            throw new RuntimeException("O ID: "+ id + " do Tópico que quer detalhar não existe!");
        }
    }

}
