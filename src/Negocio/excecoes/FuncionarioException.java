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
public class FuncionarioException extends Exception{
    private String msg;

    public FuncionarioException(String msg) {
        super(msg);
        this.msg = msg;
    }

    @Override
    public String getMessage() {
        return msg;
    }
}
