package Dados.UploadDownload;

import Dados.Repositorio.RepositorioTarefa;
import Negocio.entidade.Tarefa;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class DownloadTarefa {
    private final Tarefa[] listaTarefa;
    private SimpleDateFormat sdf1;
    private BufferedWriter arq;
    
    public DownloadTarefa(RepositorioTarefa reposTarefa) {
        this.listaTarefa = reposTarefa.returnListaTarefa();
        sdf1= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    }
    
    public void main() {
        try {
            criarPastas();
            limparArquivoPendente();
            
            for (Tarefa listaTarefa1 : listaTarefa) {
                if (listaTarefa1.getMarcaFinalizadoGerente() == true) {
                    criarObjetoEscritaFinalizada(listaTarefa1);
                }
                else {
                    criarObjetoEscritaPendente(listaTarefa1);
                }
                escreverArquivo(listaTarefa1);
                arq.close();
            }            
        }
        catch(IOException e) {
            System.out.println("ERRO: ao escrever o arquivo");
            System.out.println(e.getMessage());
        }
    }
    
    private void criarPastas() {
        File diretorio1 = new File("ArquivoTXT/Tarefa/Finalizada");
        File diretorio2 = new File("ArquivoTXT/Tarefa/Pendente");
        diretorio1.mkdirs();
        diretorio2.mkdirs();
    }
    
    private void limparArquivoPendente() throws IOException {
        File file = new File("ArquivoTXT/Tarefa/Pendente");
        File[] listaFile = file.listFiles();
        for (File listaFile1 : listaFile) {
            String nomeFuncionario = "ArquivoTXT/Tarefa/Pendente/" + listaFile1;
            arq = new BufferedWriter(new FileWriter(nomeFuncionario, false));
            arq.write("");
            arq.close();
        }
    }
    
    private void criarObjetoEscritaFinalizada(Tarefa tarefa) throws IOException {
        String nomeFuncionario = "ArquivoTXT/Tarefa/Finalizada/Funcionario_" + tarefa.getResponsavel().getNome() + ".txt";
        arq = new BufferedWriter(new FileWriter(nomeFuncionario, true));
    }
    
    private void criarObjetoEscritaPendente(Tarefa tarefa) throws IOException {
        String nomeFuncionario = "ArquivoTXT/Tarefa/Pendente/Funcionario_" + tarefa.getResponsavel().getNome() + ".txt";
        arq = new BufferedWriter(new FileWriter(nomeFuncionario, true));
    }
    
    
    private void escreverArquivo(Tarefa tarefa) throws IOException {
        arq.write(tarefa.getResponsavel().getNome() + ";");
        arq.write(tarefa.getResponsavel().getNumIdentidade() + "\n");
        
        arq.write(tarefa.getDescricao() + ";");
        arq.write(tarefa.getDataInicio() + ";");
        arq.write(tarefa.getDataTermino() + ";");
        arq.write(tarefa.getIndiceTimeline() + ";");
        arq.write(tarefa.getMarcaFinalizadoFuncionario() + ";");
        arq.write(tarefa.getMarcaFinalizadoGerente() + "\n");
        
        for (int i = 0; i < 5; i++) {
            if (tarefa.getTimelineTarefa()[i] == null) {
                arq.write("null" + "\n");
            }
            else {
                if (tarefa.getTimelineTarefa()[i].getDataMarcaFuncionario() == null) {
                    arq.write("null" + ";");
                    arq.write("null" + ";");
                }
                else{
                    arq.write(sdf1.format(tarefa.getTimelineTarefa()[i].getDataMarcaFuncionario()) + ";");
                    arq.write(sdf1.format(tarefa.getTimelineTarefa()[i].getDataMarcaGerente()) + ";");
                }
                arq.write(tarefa.getTimelineTarefa()[i].getTag() + ";");
                arq.write(tarefa.getTimelineTarefa()[i].getNotaFuncionario() + ";");
                arq.write(tarefa.getTimelineTarefa()[i].getNotaGerente() + "\n");
            }
        }
    }
}
