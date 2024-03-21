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

import gestaoAPI.gestaoAPI.dtos.categoria.CategoriaAlterarDTO;
import gestaoAPI.gestaoAPI.dtos.categoria.CategoriaInputDTO;
import gestaoAPI.gestaoAPI.service.CategoriaService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    
    @Autowired
    private CategoriaService service;


    @GetMapping
    public ResponseEntity ver(HttpServletRequest request){
        var categorias = service.ver(request);
        return ResponseEntity.ok().body(categorias);
    }

    @PostMapping
    public void criar(HttpServletRequest request, @RequestBody @Valid CategoriaInputDTO dados){
        service.criar(dados);
    }

    @PatchMapping("/{id}")
    public void alterar(@PathVariable Long id,@RequestBody @Valid CategoriaAlterarDTO dados){
        service.alterar(id, dados);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }

}
