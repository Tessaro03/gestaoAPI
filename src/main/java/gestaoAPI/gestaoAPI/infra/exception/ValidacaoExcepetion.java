package gestaoAPI.gestaoAPI.infra.exception;

public class ValidacaoExcepetion extends RuntimeException{
    
    public ValidacaoExcepetion(String mensagem){
        super(mensagem);
    }
}
