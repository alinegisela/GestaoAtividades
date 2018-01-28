
package Negocio.excecoes;


public class TarefaNaoExisteException extends TarefaException{
    
    public TarefaNaoExisteException() {
        super("Não existe nenhuma tarefa associada a esse funcionário");
    }
    
}
