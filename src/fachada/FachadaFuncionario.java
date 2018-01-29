package fachada;

import Dados.Repositorio.RepositorioFuncionario;
import Dados.Repositorio.RepositorioPonto;
import Dados.Repositorio.RepositorioTarefa;
import Negocio.GerenciadorFuncionario;
import Negocio.entidade.Funcionario;
import Negocio.GerenciadorPonto;
import Negocio.GerenciadorTarefa;
import Negocio.entidade.Ponto;
import Negocio.entidade.Tarefa;
import Negocio.excecoes.PontoCheioException;
import Negocio.excecoes.TarefaNaoExisteException;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FachadaFuncionario {
    private Funcionario usuarioLogado; 
    private final GerenciadorPonto gerenciadorPonto;
    private final GerenciadorTarefa gerenciadorTarefa;
    
    public FachadaFuncionario() {
        this.gerenciadorPonto = new GerenciadorPonto(Fachada.reposPonto);
        this.gerenciadorTarefa = new GerenciadorTarefa(Fachada.reposTarefa);
    }

    public Funcionario getUsuario() {
        return usuarioLogado;
    }

    public void setUsuario(Funcionario usuario) {
        this.usuarioLogado = usuario;
    }
    
    
   
    //=======================================PONTO==========================================
    public void baterPonto() throws PontoCheioException {
        //tratar erro contra bater o ponto mais de 4 vezes
        String data = stringDataAtual();
        Ponto ponto = new Ponto(this.usuarioLogado, data);
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
    public List<Tarefa> buscarTarefaPendente() throws TarefaNaoExisteException {
        Tarefa[] listaTarefa = this.gerenciadorTarefa.buscarTarefaPendente(this.usuarioLogado);
        List<Tarefa> lista = Arrays.asList(listaTarefa);
        return lista;
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

    public GerenciadorPonto getGerenciadorPonto() {
        return gerenciadorPonto;
    }

    public GerenciadorTarefa getGerenciadorTarefa() {
        return gerenciadorTarefa;
    }
    
    
}
