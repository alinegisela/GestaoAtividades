
package Negocio.excecoes;


public class TarefaJaExisteException extends TarefaException{
    
    public TarefaJaExisteException() {
        super("Não é possível adicionar, essa tarefa já existe");
    }
    
}
