package gestaoAPI.gestaoAPI.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestaoAPI.gestaoAPI.domain.Loja;
import gestaoAPI.gestaoAPI.dtos.loja.LojaInputDTO;
import gestaoAPI.gestaoAPI.repository.LojaRepository;
import gestaoAPI.gestaoAPI.validacao.loja.ValidacaoLoja;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class LojaService {

    @Autowired
    private LojaRepository repository;

    @Autowired
    private ValidacaoLoja validador;


    public void criar(HttpServletRequest request, LojaInputDTO dados) {
        var loja = new Loja(dados);
        repository.save(loja);
    }

    public void alterar(HttpServletRequest request, Long id, LojaInputDTO dados) {
        validador.validadorUsuario(request, id);
        var loja = repository.getReferenceById(id);
        loja.alterar(dados);
        repository.save(loja);
    }
    
    public void deletar(HttpServletRequest request, Long id){
        validador.validadorUsuario(request, id);
        repository.deleteById(id);
    }
}
