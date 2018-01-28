package fachada;

import Dados.RepositorioFuncionario;
import Dados.RepositorioPonto;
import Dados.RepositorioTarefa;
import Negocio.entidade.Endereco;
import Negocio.entidade.Funcionario;
import Negocio.GerenciadorFuncionario;
import Negocio.GerenciadorPonto;
import Negocio.GerenciadorTarefa;
import Negocio.entidade.Ponto;
import Negocio.entidade.Tarefa;
import Negocio.excecoes.FuncionarioJaExisteException;
import Negocio.excecoes.FuncionarioNaoExisteException;
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
    
    public FachadaGerente(RepositorioFuncionario reposFuncionario, RepositorioPonto reposPonto, RepositorioTarefa reposTarefa) {
        this.gerenciadorFuncionario = new GerenciadorFuncionario(reposFuncionario);
        this.gerenciadorPonto = new GerenciadorPonto(reposPonto);
        this.gerenciadorTarefa = new GerenciadorTarefa(reposTarefa);
        this.usuario = this.gerenciadorFuncionario.buscaGerente();
    }
    
    
    //===================================FUNCIONARIO==========================================
    public void cadastrarFuncionario(String nome, String dataNascimento, String numIdentidade) throws FuncionarioJaExisteException{
        Funcionario funcionario = new Funcionario(nome, dataNascimento, numIdentidade);
        this.gerenciadorFuncionario.funcionarioExiste(funcionario);
        //return resp;
    }
    
    public void atualizarEndereco(String nomeFuncionario, String rua, int numero, String bairro, String cidade, String estado) throws FuncionarioNaoExisteException{
        Funcionario funcionario = this.gerenciadorFuncionario.buscaFuncionarioNome(nomeFuncionario);
        Endereco endereco = new Endereco(rua, numero, bairro, cidade, estado);
        funcionario.setEndereco(endereco);
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
        Funcionario resposavel = this.gerenciadorFuncionario.buscaFuncionarioNome(nomeFuncionario);
        Tarefa tarefa = new Tarefa(resposavel, descricao, dataInicio, dataTermino);
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
