package gestaoAPI.gestaoAPI.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestaoAPI.gestaoAPI.domain.Loja;
import gestaoAPI.gestaoAPI.dtos.loja.LojaInputDTO;
import gestaoAPI.gestaoAPI.dtos.loja.LojaOutputDTO;
import gestaoAPI.gestaoAPI.repository.LojaRepository;

@Service
public class LojaService {

    @Autowired
    private LojaRepository repository;

    public List<LojaOutputDTO> ver() {
        var lojas = repository.findAll();
        return lojas.stream().map(LojaOutputDTO::new).collect(Collectors.toList());
    }

    public void criar(LojaInputDTO dados) {
        var loja = new Loja(dados);
        repository.save(loja);
    }

    public void alterar(Long id, LojaInputDTO dados) {
        var loja = repository.getReferenceById(id);
        loja.alterar(dados);
        repository.save(loja);
    }
    
    public void deletar(Long id){
        repository.deleteById(id);
    }
}
