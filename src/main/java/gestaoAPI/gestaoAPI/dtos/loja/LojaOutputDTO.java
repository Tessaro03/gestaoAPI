package gestaoAPI.gestaoAPI.dtos.loja;

import gestaoAPI.gestaoAPI.domain.Loja;

public record LojaOutputDTO(
    Long id,
    String nome
) {
    public LojaOutputDTO(Loja loja){
        this(loja.getId(), loja.getNome());
    }

}
