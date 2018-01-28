
package Negocio.excecoes;

public class FuncionarioJaExisteException extends FuncionarioException{
    
    public FuncionarioJaExisteException() {
        super("Não é possível fazer o cadastro, esse funcionário já existe");
    }
    
}
