package gestaoAPI.gestaoAPI.domain;

import gestaoAPI.gestaoAPI.dtos.funcionario.FuncionarioAlterarDTO;
import gestaoAPI.gestaoAPI.dtos.funcionario.FuncionarioInputDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity( name =  "Funcionario")
@Table(name =  "funcionarios")
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Funcionario {
    
    public Funcionario(@Valid FuncionarioInputDTO dados, Usuario usuario, Loja loja) {
        this.cargo = dados.cargo();
        this.loja = loja;
        this.usuario = usuario;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Cargo cargo;

    @ManyToOne
    @JoinColumn(name = "loja_id")
    private Loja loja;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public void alterar(@Valid FuncionarioAlterarDTO dados) {
        this.cargo = dados.cargo();
    }

}
