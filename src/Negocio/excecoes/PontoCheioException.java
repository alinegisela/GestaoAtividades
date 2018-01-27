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
public class PontoCheioException extends PontoException{
    
    public PontoCheioException() {
        super("O ponto já foi batido 4 vezes hoje");
    }
    
}
