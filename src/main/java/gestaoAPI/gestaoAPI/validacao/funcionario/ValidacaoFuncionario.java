package gestaoAPI.gestaoAPI.validacao.funcionario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestaoAPI.gestaoAPI.dtos.funcionario.FuncionarioAlterarDTO;
import gestaoAPI.gestaoAPI.dtos.funcionario.FuncionarioInputDTO;
import gestaoAPI.gestaoAPI.validacao.funcionario.ValidacaoDelete.ValidacaoFuncionarioDelete;
import gestaoAPI.gestaoAPI.validacao.funcionario.ValidacaoPatch.ValidacaoFuncionarioPatch;
import gestaoAPI.gestaoAPI.validacao.funcionario.ValidacaoPost.ValidacaoFuncionarioPost;
import gestaoAPI.gestaoAPI.validacao.funcionario.ValidacaoUsuario.ValidacaoFuncionarioUsuario;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class ValidacaoFuncionario {
    
    @Autowired
    private List<ValidacaoFuncionarioPost> validarPost;

    @Autowired
    private List<ValidacaoFuncionarioUsuario> validarUsuario;

    @Autowired
    private List<ValidacaoFuncionarioPatch> validarPatch;

    @Autowired
    private List<ValidacaoFuncionarioDelete> validarDelete;

    public void validadorPost(FuncionarioInputDTO dados, HttpServletRequest request){
        validarUsuario.forEach(v -> v.validar(request));
        validarPost.forEach(v -> v.validar(dados, request));
    }

    public void validadorPatch(HttpServletRequest request, FuncionarioAlterarDTO dados, Long id){
        validarUsuario.forEach(v -> v.validar(request));
        validarPatch.forEach(v -> validadorPatch(request, dados, id));
    }

    public void validadorDelete(HttpServletRequest request, Long id){
        validarDelete.forEach(v -> v.validar(id, request));
    }
}
