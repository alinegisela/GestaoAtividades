
package fachada;

//classe criada para as funcionalidades de um usuário que não fez login

import Dados.Repositorio.RepositorioFuncionario;
import Negocio.GerenciadorFuncionario;
import Negocio.Login;
import Negocio.entidade.Funcionario;
import Negocio.excecoes.LoginIncorretoException;

public class FachadaConvidado {
    private final Login login;
    //private final RepositorioFuncionario repositorioFuncionario;
    private GerenciadorFuncionario gerenciadorFuncionario;
    
    public FachadaConvidado(){
        //this.repositorioFuncionario = repositorioFuncionario;
        this.login = new Login(Fachada.reposFuncionario);
    }
    
     //Entrar no sistema
    public Funcionario fazerLogin(String login, String senha) throws LoginIncorretoException{
        return this.login.fazerLogin(login, senha);
    }

    public Login getLogin() {
        return login;
    }
    
    
}
