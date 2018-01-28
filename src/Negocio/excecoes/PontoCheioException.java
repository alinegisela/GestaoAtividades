
package Negocio.excecoes;

public class PontoCheioException extends PontoException{
    
    public PontoCheioException() {
        super("O ponto já foi batido 4 vezes hoje");
    }
    
}
