package fachada;

import Dados.Repositorio.RepositorioFuncionario;
import Dados.Repositorio.RepositorioPonto;
import Dados.Repositorio.RepositorioTarefa;
import Negocio.entidade.Endereco;
import Negocio.entidade.Funcionario;
import Negocio.GerenciadorFuncionario;
import Negocio.GerenciadorPonto;
import Negocio.GerenciadorTarefa;
import Negocio.Login;
import Negocio.entidade.Ponto;
import Negocio.entidade.Tarefa;
import Negocio.excecoes.FuncionarioJaExisteException;
import Negocio.excecoes.FuncionarioNaoExisteException;
import Negocio.excecoes.LoginIncorretoException;
import Negocio.excecoes.PontoCheioException;
import Negocio.excecoes.TarefaJaExisteException;
import Negocio.excecoes.TarefaNaoExisteException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class FachadaGerente {
    private final Funcionario usuario;
    private final GerenciadorFuncionario gerenciadorFuncionario;
    private final GerenciadorPonto gerenciadorPonto;
    private final GerenciadorTarefa gerenciadorTarefa;
    
    public FachadaGerente() {
        this.gerenciadorFuncionario = new GerenciadorFuncionario(Fachada.reposFuncionario);
        this.gerenciadorPonto = new GerenciadorPonto(Fachada.reposPonto);
        this.gerenciadorTarefa = new GerenciadorTarefa(Fachada.reposTarefa);
        this.usuario = this.gerenciadorFuncionario.buscaGerente();
    }
    
  
    //===================================FUNCIONARIO==========================================
    public void cadastrarFuncionario(String nome, String dataNascimento, String numIdentidade, String login) throws FuncionarioJaExisteException{
        Funcionario funcionario = new Funcionario(nome, dataNascimento, numIdentidade, login);
        this.gerenciadorFuncionario.funcionarioExiste(funcionario);
        //return resp;
    }
    
    public void atualizarEndereco(String nomeFuncionario, String rua, int numero, String bairro, String cidade, String estado) throws FuncionarioNaoExisteException{
        Funcionario funcionario = this.gerenciadorFuncionario.buscaFuncionarioNome(nomeFuncionario);
        Endereco endereco = new Endereco(rua, numero, bairro, cidade, estado);
        funcionario.setEndereco(endereco);
    }
    
    public Funcionario buscaFuncionarioNome(String nome) throws FuncionarioNaoExisteException{
       return this.gerenciadorFuncionario.buscaFuncionarioNome(nome);
    }
    //========================================================================================
    
    
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
    public void cadastrarTarefa(String nomeFuncionario, String descricao, String dataInicio, String dataTermino) throws FuncionarioNaoExisteException, TarefaJaExisteException {
        Funcionario responsavel = this.gerenciadorFuncionario.buscaFuncionarioNome(nomeFuncionario);
        Tarefa tarefa = new Tarefa(responsavel, descricao, dataInicio, dataTermino);
        this.gerenciadorTarefa.registraTarefa(tarefa);
    }
    
    public Tarefa[] buscarTarefaPendente(String nomeFuncionario) throws FuncionarioNaoExisteException, TarefaNaoExisteException {
        Funcionario resposavel = this.gerenciadorFuncionario.buscaFuncionarioNome(nomeFuncionario);
        Tarefa[] listaTarefa = this.gerenciadorTarefa.buscarTarefaPendente(resposavel);
        return listaTarefa;
    }
    
    public void editarTarefa(Tarefa tarefa) throws TarefaNaoExisteException{
        this.gerenciadorTarefa.editarTarefa(tarefa);
    }
    
    public void marcarFinalizadaGerente() {
        this.gerenciadorTarefa.marcarFinalizadaGerente();
    }
    
    public void marcarRefazer() {
        this.gerenciadorTarefa.marcarRefazer();
    }
    
    public void adicionarNotaGerente(String nota) {
        this.gerenciadorTarefa.adicionarNotaGerente(nota);
    }
    //========================================================================================
}
