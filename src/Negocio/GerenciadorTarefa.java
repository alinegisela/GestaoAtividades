package Negocio;

import Negocio.entidade.Funcionario;
import Negocio.entidade.Tarefa;
import Dados.Repositorio.RepositorioTarefa;
import Negocio.excecoes.TarefaJaExisteException;
import Negocio.excecoes.TarefaNaoExisteException;

public class GerenciadorTarefa {
    private final RepositorioTarefa repositorioTarefa;
    private Tarefa tarefa;
    
    public GerenciadorTarefa(RepositorioTarefa repositorioTarefa) {
        this.repositorioTarefa = repositorioTarefa;
    }
    
    public void registraTarefa(Tarefa tarefa) throws TarefaJaExisteException{
        if(this.repositorioTarefa.buscarTarefa(tarefa) == null){
            this.repositorioTarefa.adicionarTarefa(tarefa);
        }else{
            throw new TarefaJaExisteException();
        }
    }
    
    public Tarefa[] buscarTarefaPendente(Funcionario funcionario) throws TarefaNaoExisteException{
        Tarefa[] listaTarefa = repositorioTarefa.buscarTarefaPendente(funcionario);
        
        //existe pelo menos uma tarefa associada ao funcionário
        if(listaTarefa != null){
            System.out.println("======== " + listaTarefa[0]);
            return listaTarefa;
        }else{
            throw new TarefaNaoExisteException();
        }
    }
    
    //tem que recuperar do repositório
    public void editarTarefa(Tarefa tarefa) throws TarefaNaoExisteException{
        this.tarefa = tarefa;
    }
    
     //tem que recuperar tarefa do repositório
    public void marcarFinalizadaFuncionario() {
        if (this.tarefa.getMarcaFinalizadoFuncionario() == false) {
            this.tarefa.setMarcaFinalizadoFuncionario(true);
            System.out.println("marquei");
        }
        
    }
    
    public void marcarFinalizadaGerente() {
        if (this.tarefa.getMarcaFinalizadoFuncionario() == true && this.tarefa.getMarcaFinalizadoGerente() == false) {
            this.tarefa.setMarcaFinalizadoGerente(true);
            this.tarefa.mudarTagTimeline("Finalizado");
        }
    }
    
    public void marcarRefazer() {
        if (this.tarefa.getMarcaFinalizadoFuncionario() == true && this.tarefa.getMarcaFinalizadoGerente() == false) {
            tarefa.setMarcaFinalizadoFuncionario(false);
            this.tarefa.mudarTagTimeline("Refazer");
        }
    }
    
    public void adicionarNotaFuncionario(String nota) {
        this.tarefa.adicionarNotaFuncionario(nota);
    }
    
    public void adicionarNotaGerente(String nota) {
        this.tarefa.adicionarNotaGerente(nota);
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }
    
    
    
    
}
