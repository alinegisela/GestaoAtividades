/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.excecoes;

/**
 *
 * @author Absinto
 */
public class TarefaNaoExisteException extends TarefaException{
    
    public TarefaNaoExisteException() {
        super("Não existe nenhuma tarefa associada a esse funcionário");
    }
    
}
