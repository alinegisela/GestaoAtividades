package fachada;

import Dados.Repositorio.RepositorioFuncionario;
import Dados.Repositorio.RepositorioPonto;
import Dados.Repositorio.RepositorioTarefa;
import Negocio.GerenciadorFuncionario;
import Negocio.entidade.Funcionario;
import Negocio.GerenciadorPonto;
import Negocio.GerenciadorTarefa;
import Negocio.Login;
import Negocio.entidade.Ponto;
import Negocio.entidade.Tarefa;
import Negocio.excecoes.LoginIncorretoException;
import Negocio.excecoes.PontoCheioException;
import Negocio.excecoes.TarefaNaoExisteException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class FachadaFuncionario {
    private Funcionario usuario; // tirei o final para poder ter o construtor vazio
    private final GerenciadorPonto gerenciadorPonto;
    private final GerenciadorTarefa gerenciadorTarefa;
    private final Login login;
    
    public FachadaFuncionario(Funcionario usuario, RepositorioPonto reposPonto, RepositorioTarefa reposTarefa) {
        this.gerenciadorPonto = new GerenciadorPonto(reposPonto);
        this.gerenciadorTarefa = new GerenciadorTarefa(reposTarefa);
        this.login = new Login(new RepositorioFuncionario());
        this.usuario = usuario;
    }
    
    //construtor vazio para inicializacao na GUI
    public FachadaFuncionario(){
        System.out.println("Inicializou o favuao");
        this.gerenciadorPonto = new GerenciadorPonto(new RepositorioPonto());
        this.gerenciadorTarefa = new GerenciadorTarefa(new RepositorioTarefa());
        this.login = new Login(new RepositorioFuncionario());
    }
    
    //Entrar no sistema
    public void fazerLogin(String login, String senha) throws LoginIncorretoException{
        this.login.fazerLogin(login, senha);
    }
    
    //=======================================PONTO==========================================
    public void baterPonto() throws PontoCheioException {
        //tratar erro contra bater o ponto mais de 4 vezes
        String data = stringDataAtual();
        Ponto ponto = new Ponto(this.usuario, data);
        this.gerenciadorPonto.baterPonto(ponto);
    }
    
    private String stringDataAtual() {
        Date d = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(d);

        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        return df.format(c.getTime());
    }
    //========================================================================================
    
    
    //=====================================TAREFA===============================================
    public Tarefa[] buscarTarefaPendente() throws TarefaNaoExisteException {
        Tarefa[] listaTarefa = this.gerenciadorTarefa.buscarTarefaPendente(this.usuario);
        return listaTarefa;
    }
    
    public void editarTarefa(Tarefa tarefa) throws TarefaNaoExisteException{
        this.gerenciadorTarefa.editarTarefa(tarefa);
    }
    
    public void marcarFinalizadaFuncionario() {
        this.gerenciadorTarefa.marcarFinalizadaFuncionario();
    }
    
    public void adicionarNotaFuncionario(String nota) {
        this.gerenciadorTarefa.adicionarNotaFuncionario(nota);
    }
    //========================================================================================
}
