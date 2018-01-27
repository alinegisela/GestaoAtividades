package Negocio;

import Dados.RepositorioFuncionario;
import Negocio.excecoes.FuncionarioJaExisteException;
import Negocio.excecoes.FuncionarioNaoExisteException;

public class GerenciadorFuncionario {
    private final RepositorioFuncionario repositorioFuncionario;
    
    public GerenciadorFuncionario(RepositorioFuncionario repositorioFuncionario) {
        this.repositorioFuncionario = repositorioFuncionario;
    }
    
    public void funcionarioExiste(Funcionario funcionario) throws FuncionarioJaExisteException{
        boolean resp = this.repositorioFuncionario.funcionarioExiste(funcionario.getNumIdentidade());
        if (!resp) {
            this.repositorioFuncionario.adicionar(funcionario);
        }else{
            throw new FuncionarioJaExisteException();
        }
        
        //return resp;
    }
    
    public Funcionario buscaFuncionarioNome(String nome) throws FuncionarioNaoExisteException{
        Funcionario funcionario = this.repositorioFuncionario.buscaFuncionarioNome(nome);
        
        if(funcionario != null ){
            return funcionario;
        }else{
            throw new FuncionarioNaoExisteException();
        }
    }
    
    public Funcionario buscaGerente() {
        Funcionario funcionario = this.repositorioFuncionario.buscaGerente();
        return funcionario;
    }
}
