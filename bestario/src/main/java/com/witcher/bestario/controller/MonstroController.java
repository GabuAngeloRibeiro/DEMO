package com.witcher.bestario.controller;

import com.witcher.bestario.controller.form.AtualizacaoMonstroForm;
import com.witcher.bestario.controller.form.MonstroForm;
import com.witcher.bestario.repository.MonstroRepository;
import com.witcher.bestario.controller.dto.MonstroDto;
import com.witcher.bestario.modelos.Monstro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/monstro")
public class MonstroController {

    @Autowired
    private MonstroRepository monstroRepository;


    @GetMapping
    public List<MonstroDto> lista(String nomeMonstro){
        if (nomeMonstro == null){
            List<Monstro> monstros = monstroRepository.findAll();
            return MonstroDto.converter(monstros);
        }else {
            List<Monstro> monstros = monstroRepository.findByNomeMonstro(nomeMonstro);
            return MonstroDto.converter(monstros);
        }

    }


    @GetMapping("/{id}")
    public ResponseEntity<MonstroDto> detalhar(@PathVariable Long id) {
        Optional<Monstro> monstro = monstroRepository.findById(id);
        if (monstro.isPresent()) {
            return ResponseEntity.ok(new MonstroDto(monstro.get()));
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping
    @Transactional
    public ResponseEntity<MonstroDto> cadastrar(@RequestBody @Valid MonstroForm form, UriComponentsBuilder uriBuilder){
        Monstro monstro = form.converter();
        monstroRepository.save(monstro);

        URI uri = uriBuilder.path("/monstro/{id}").buildAndExpand(monstro.getId()).toUri();
        return ResponseEntity.created(uri).body(new MonstroDto(monstro));

    }


    @PutMapping("/{id}")
    @Transactional

    public ResponseEntity<MonstroDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoMonstroForm form) {
        Optional<Monstro> optional = monstroRepository.findById(id);
        if (optional.isPresent()) {
            Monstro monstro = form.atualizar(id,monstroRepository);
            return ResponseEntity.ok(new MonstroDto(monstro));
        }
        return  ResponseEntity.notFound().build();

    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id) {
        Optional<Monstro> optional = monstroRepository.findById(id);
        if (optional.isPresent()) {
            monstroRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
            return  ResponseEntity.notFound().build();
    }

}
