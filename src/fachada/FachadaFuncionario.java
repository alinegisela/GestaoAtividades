package fachada;

import Dados.RepositorioPonto;
import Dados.RepositorioTarefa;
import Negocio.Funcionario;
import Negocio.GerenciadorPonto;
import Negocio.GerenciadorTarefa;
import Negocio.Ponto;
import Negocio.Tarefa;
import Negocio.excecoes.PontoCheioException;
import Negocio.excecoes.TarefaNaoExisteException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class FachadaFuncionario {
    private final Funcionario usuario;
    private final GerenciadorPonto gerenciadorPonto;
    private final GerenciadorTarefa gerenciadorTarefa;
    
    public FachadaFuncionario(Funcionario usuario, RepositorioPonto reposPonto, RepositorioTarefa reposTarefa) {
        this.gerenciadorPonto = new GerenciadorPonto(reposPonto);
        this.gerenciadorTarefa = new GerenciadorTarefa(reposTarefa);
        this.usuario = usuario;
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
