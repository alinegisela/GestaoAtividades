package Dados.Repositorio;

import Negocio.entidade.Funcionario;
import Negocio.entidade.Tarefa;

public class RepositorioTarefa {
    private final int capacidade = 50;
    private Tarefa[] listaTarefa;
    private int indiceTarefa = 0;
    
    public RepositorioTarefa() {
        this.listaTarefa = new Tarefa[capacidade];
        this.indiceTarefa = 0;
    }
    
    public boolean adicionarTarefa(Tarefa tarefa) {
        boolean resp = false;
        if (indiceTarefa <= 50) {
            listaTarefa[indiceTarefa] = tarefa;
            indiceTarefa++;
            resp = true;
        }
        
        //====TESTE
        if(resp){
            System.out.println("Tarefa cadastrada");
        }
        return resp;
    }
    
    public Tarefa[] buscarTarefaPendente(Funcionario funcionario) {
        int cont = 0;
        for(int i = 0; i < indiceTarefa; i++) {
            if (listaTarefa[i].getResponsavel().equals(funcionario) && listaTarefa[i].getMarcaFinalizadoGerente() == false) {
                System.out.println("é pra aplaudir de pé irmãos");
                cont ++;
            }
        }
        
        Tarefa[] tarefa = new Tarefa[cont];
        cont = 0;
        for(int i = 0; i < indiceTarefa; i++) {
            if (listaTarefa[i].getResponsavel().equals(funcionario) && listaTarefa[i].getMarcaFinalizadoGerente() == false) {
                System.out.println("adddd pro array");
                tarefa[cont] = listaTarefa[i];
                cont ++;
            }
        }
        return tarefa;
    }
    
    public Tarefa buscarTarefa(Tarefa tarefa){
        for(int i=0;i<indiceTarefa;i++){
            if(listaTarefa[i].equals(tarefa)){
                return tarefa;
            }
        }
        return null;
    }

    public Tarefa[] returnListaTarefa() {
        Tarefa[] lista = new Tarefa[indiceTarefa];
        for (int i = 0; i < this.indiceTarefa; i++) {
            lista[i] = this.listaTarefa[i];
        }
        return lista;
    }
    
    /*
    public Tarefa buscarTarefaFuncionario(Funcionario funcionario) {
        Tarefa tarefa = null;
        for(int i = 0; i < indiceTarefa; i++) {
            if (listaTarefa[i].getResposavel().equals(funcionario)) {
                tarefa = listaTarefa[i];
            }
        }
        return tarefa;
    }
    
    public Tarefa buscarTarefaFinalizada() {
        Tarefa tarefa = null;
        for(int i = 0; i < indiceTarefa; i++) {
            if (listaTarefa[i].getMarcaFinalizadoFuncionario() == true) {
                tarefa = listaTarefa[i];
            }
        }
        return tarefa;
    }
    */
    
    //metodo meramente de teste, para visualizar os objetos no repositorio.
    public void exibirObjetos() {
        for (int i = 0; i < indiceTarefa; i++) {
            System.out.printf("Objeto %d:\n%s\n\n", i+1, listaTarefa[i]);
        }
    }
}
