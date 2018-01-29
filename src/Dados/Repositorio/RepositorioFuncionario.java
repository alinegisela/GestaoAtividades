package Dados.Repositorio;

import Negocio.entidade.Funcionario;

public  class RepositorioFuncionario {
    private static final int capacidade = 50;
    private  static Funcionario[] listaFuncionario;
    private static int indiceFuncionario;

    public RepositorioFuncionario() {
       listaFuncionario = new Funcionario[capacidade];
        indiceFuncionario = 0;
        Funcionario admin = new Funcionario("admin", null, "0000", "admin");   //o primeiro usuario sem vai ser o admin do sistema
        admin.setEhGerente(true);
        adicionar(admin);                                             //depois modificar para o admin não ser inicializado aqui
    }
    
    public boolean adicionar(Funcionario funcionario) {
        funcionario.setSenha("123");
        boolean resp = false;
        if (indiceFuncionario <= capacidade) {
            listaFuncionario[indiceFuncionario] = funcionario;
            indiceFuncionario++;
            resp = true;
        }
        return resp;
    }
    
    public boolean funcionarioExiste(String numIdentidade) {
        boolean resp = false;
        for (int i = 0; i < indiceFuncionario; i++) {
            if (listaFuncionario[i].getNumIdentidade().equals(numIdentidade)) {
                resp = true;
                break;
            }
        }
        return resp;
    }
                    
    public Funcionario buscaFuncionarioNome(String nome) {
        Funcionario funcionario = null;
        for (int i = 0; i < indiceFuncionario; i++) {
            if (listaFuncionario[i].getNome().equals(nome)) {
                funcionario = listaFuncionario[i];
                break;
            }
        }
        return funcionario;
    }
    
    //Usado para realizar o login do funcionário
    public Funcionario buscaFuncionarioLogin(String login) {
        Funcionario funcionario = null;
        System.out.println(indiceFuncionario);
        for (int i = 0; i < indiceFuncionario; i++) {
            System.out.println("Esse é o login: "+listaFuncionario[i].getLogin());
            if (listaFuncionario[i].getLogin().equals(login)) {
                funcionario = listaFuncionario[i];
                break;
            }
        }
        return funcionario;
    }
    
    public Funcionario buscaGerente() {
        Funcionario funcionario = null;
        for (int i = 0; i < indiceFuncionario; i++) {
            if (this.listaFuncionario[i].isEhGerente()) {
                funcionario = this.listaFuncionario[i];
                break;
            }
        }
        return funcionario;
    }
    
    public Funcionario[] returnListaFuncionario() {
        Funcionario[] lista = new Funcionario[indiceFuncionario];
        for (int i = 0; i < this.indiceFuncionario; i++) {
            lista[i] = this.listaFuncionario[i];
        }
        return lista;
    }
    
    /*
    public Funcionario[] retornListaFuncionarios() {
        Funcionario[] listaFuncionarios = new Funcionario[indiceFuncionario];
        for (int i = 0; i < indiceFuncionario; i++) {
            listaFuncionarios[i] = listaFuncionario[i];
        }
        return listaFuncionarios;
    }
    */

    //metodo meramente de teste, para visualizar os objetos no repositorio.
    public void exibirObjetos() {
        for (int i = 0; i < indiceFuncionario; i++) {
            System.out.printf("Objeto %d:\n%s\n\n", i+1, listaFuncionario[i]);
        }
    }
}
