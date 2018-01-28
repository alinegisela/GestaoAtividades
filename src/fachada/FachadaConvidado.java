
package fachada;

//classe criada para as funcionalidades de um usuário que não fez login

import Dados.Repositorio.RepositorioFuncionario;
import Negocio.Login;
import Negocio.excecoes.LoginIncorretoException;

public class FachadaConvidado {
    private final Login login;
    
    public FachadaConvidado(){
        this.login = new Login(new RepositorioFuncionario());
    }
    
     //Entrar no sistema
    public void fazerLogin(String login, String senha) throws LoginIncorretoException{
        this.login.fazerLogin(login, senha);
    }
}
