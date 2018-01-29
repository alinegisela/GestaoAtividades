/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import Dados.Repositorio.RepositorioFuncionario;
import Dados.Repositorio.RepositorioPonto;
import Dados.Repositorio.RepositorioTarefa;

/**
 *
 * @author Absinto
 */
public class Fachada {
    public static final RepositorioFuncionario reposFuncionario = new RepositorioFuncionario();
    public static final RepositorioTarefa reposTarefa = new RepositorioTarefa();
    public static final RepositorioPonto reposPonto = new RepositorioPonto();


}
