/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Dados.Repositorio.RepositorioFuncionario;
import Negocio.entidade.Funcionario;
import Negocio.excecoes.LoginIncorretoException;

/**
 *
 * @author Absinto
 */
public class Login {

    private final RepositorioFuncionario repositorioFuncionario;

    public Login(RepositorioFuncionario repositorioFuncionario) {
        this.repositorioFuncionario = repositorioFuncionario;
    }

    public void fazerLogin(String login, String senha) throws LoginIncorretoException {
        Funcionario funcionario = this.repositorioFuncionario.buscaFuncionarioLogin(login);

        if (funcionario == null || !funcionario.autenticar(login, senha)) {
            throw new LoginIncorretoException();
        }

    }
}
