package gestaoAPI.gestaoAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gestaoAPI.gestaoAPI.dtos.produto.ProdutoAlterarDTO;
import gestaoAPI.gestaoAPI.dtos.produto.ProdutoInputDTO;
import gestaoAPI.gestaoAPI.service.ProdutoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    
    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity ver(){
        var produtos = service.ver();
        return ResponseEntity.ok().body(produtos);
    }

    @PostMapping
    public void criar(@RequestBody @Valid ProdutoInputDTO dados){
        service.criar(dados);
    }

    @PatchMapping("/{id}")
    public void alterar(@PathVariable Long id, @RequestBody @Valid ProdutoAlterarDTO dados){
        service.alterar(dados, id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }


    
}
