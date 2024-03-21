package gestaoAPI.gestaoAPI.domain;


import java.util.List;

import gestaoAPI.gestaoAPI.dtos.categoria.CategoriaAlterarDTO;
import gestaoAPI.gestaoAPI.dtos.categoria.CategoriaInputDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Categoria")
@Table(name = "categorias")
@Getter
@NoArgsConstructor
@Setter
@EqualsAndHashCode(of = "id")
public class Categoria {

    public Categoria(CategoriaInputDTO dados, Loja loja) {
        this.titulo = dados.titulo();
        this.descricao = dados.descricao();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descricao;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Produto> produtos;

    @ManyToOne 
    @JoinColumn(name = "loja_id")
    private Loja loja;

    public void alterar(CategoriaAlterarDTO dados) {
        if (dados.descricao() != null) {
            this.descricao = dados.descricao();
        }
        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
    
    }
}
