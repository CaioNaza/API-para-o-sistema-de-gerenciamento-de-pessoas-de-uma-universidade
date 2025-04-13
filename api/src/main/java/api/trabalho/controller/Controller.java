package api.trabalho.controller;


import api.trabalho.DTO.PessoaDto;
import api.trabalho.entity.Pessoa;
import api.trabalho.repository.Repository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/pessoa")
public class Controller {

    private final Repository Repository;

    @Autowired
    public Controller(Repository pessoaRepository) {
        this.Repository = pessoaRepository;
    }

    @PostMapping
    public ResponseEntity<Pessoa> createProduct(@RequestBody PessoaDto productDto){
        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(productDto, pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(Repository.save(pessoa));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPessoa(@PathVariable UUID id) {
        Optional<Pessoa> pessoaOptional = Repository.findById(id);
        if (pessoaOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada!!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pessoaOptional.get());
    }

    @GetMapping("/all")
    public ResponseEntity<List<Pessoa>> getAllPessoas() {
        List<Pessoa> pessoas = Repository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(pessoas);
    }


}
