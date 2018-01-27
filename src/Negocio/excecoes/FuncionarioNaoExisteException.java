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
public class FuncionarioNaoExisteException extends FuncionarioException{
    
    public FuncionarioNaoExisteException() {
        super("O funcionário não está cadastrado");
    }
    
}
