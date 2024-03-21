package gestaoAPI.gestaoAPI.controller;

import java.util.List;

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
import jakarta.validation.Valid;
import gestaoAPI.gestaoAPI.dtos.loja.LojaInputDTO;
import gestaoAPI.gestaoAPI.dtos.loja.LojaOutputDTO;
import gestaoAPI.gestaoAPI.service.LojaService;

@RestController
@RequestMapping("/loja")
public class LojaController {

    @Autowired
    private LojaService service;

    @GetMapping
    public ResponseEntity ver(){
        List<LojaOutputDTO> lojas = service.ver();
        return ResponseEntity.ok().body(lojas);
    }

    @PostMapping
    public void criar(@Valid @RequestBody LojaInputDTO dados){
        service.criar(dados);
    }

    @PatchMapping("/{id}")
    public void alterar(@PathVariable Long id,@Valid @RequestBody LojaInputDTO dados){
        service.alterar(id, dados);
    }

    @DeleteMapping("/{id}")
    private void deletar(@PathVariable Long id){
        service.deletar(id);
    }
    
}
