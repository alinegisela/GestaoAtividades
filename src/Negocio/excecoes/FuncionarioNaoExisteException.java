
package Negocio.excecoes;

public class FuncionarioNaoExisteException extends FuncionarioException{
    
    public FuncionarioNaoExisteException() {
        super("O funcionário não está cadastrado");
    }
    
}
