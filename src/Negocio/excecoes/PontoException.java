
package Negocio.excecoes;


public class PontoException extends Exception{
    private String msg;

    public PontoException(String msg) {
        super(msg);
        this.msg = msg;
    }

    @Override
    public String getMessage() {
        return msg;
    }
}
