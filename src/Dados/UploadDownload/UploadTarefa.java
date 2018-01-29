package Dados.UploadDownload;

import Dados.Repositorio.RepositorioFuncionario;
import Dados.Repositorio.RepositorioTarefa;
import Negocio.entidade.Funcionario;
import Negocio.entidade.Tarefa;
import Negocio.entidade.TimelineTarefa;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UploadTarefa {
    /* ======COMENTEI APENAS PARA RODAR O SISTEMA
    
    private RepositorioFuncionario reposFuncionario;
    private RepositorioTarefa reposTarefa;
    private SimpleDateFormat sdf1;
    private FileReader arq;
    private BufferedReader leitorArq;
    
    public UploadTarefa(RepositorioFuncionario reposFuncionario) {
        this.reposTarefa = new RepositorioTarefa();
        this.reposFuncionario = reposFuncionario;
        sdf1= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    }
    
    public RepositorioTarefa main(){
        try {
            criarPastas();
            
            File file = new File("ArquivoTXT/Tarefa/Pendente");
            File[] listaFile = file.listFiles();
            
            for (int i = 0; i < listaFile.length; i++){
                criarObjetoleitor(listaFile[i]);
                
                Funcionario funcionario = buscarFuncionario();
                Tarefa tarefa = criarObjetoTarefa();
                TimelineTarefa[] timeline = criarObjetoTimelineTarefa();
                
                tarefa.setResponsavel(funcionario);
                tarefa.setTimelineTarefa(timeline);
                
                this.reposTarefa.adicionarTarefa(tarefa);
                
                this.leitorArq.close();
                this.arq.close();
            }            
        }
        catch (IOException | ParseException e) {
            System.out.println("ERRO: ao le do arquivo");
            System.out.println(e.getMessage());
        }
        return this.reposTarefa;
    }
    
    private void criarPastas(){
        File diretorio1 = new File("ArquivoTXT/Tarefa/Finalizada");
        File diretorio2 = new File("ArquivoTXT/Tarefa/Pendente");
        
        if (diretorio1.exists() == false) {
            diretorio1.mkdirs();
        }
        if (diretorio2.exists() == false) {
            diretorio2.mkdirs();
        }
    }
    
    private void criarObjetoleitor(File file) throws IOException {
        String diretorio = "ArquivoTXT/Tarefa/Pendente/" + file.getName();
        this.arq = new FileReader(diretorio);
        this.leitorArq = new BufferedReader(this.arq);
    }
    
    private Funcionario buscarFuncionario() throws IOException {
        String linha = this.leitorArq.readLine();
        String[] dados = linha.split(";");
        
        Funcionario funcionario = this.reposFuncionario.buscaFuncionarioNome(dados[0]);
        
        return funcionario;
    }
    
    private Tarefa criarObjetoTarefa() throws IOException {
        String linha = this.leitorArq.readLine();
        String[] dados = linha.split(";");
        
        Tarefa tarefa = new Tarefa(null, dados[0], dados[1], dados[2]);
        tarefa.setIndiceTimeline(Integer.valueOf(dados[3]));
        tarefa.setMarcaFinalizadoFuncionario(Boolean.valueOf(dados[4]));
        tarefa.setMarcaFinalizadoGerente(Boolean.valueOf(dados[5]));
        
        return tarefa;
    }
    
    private TimelineTarefa[] criarObjetoTimelineTarefa() throws IOException, ParseException {
        TimelineTarefa[] listaTimeline = new TimelineTarefa[5];
        TimelineTarefa timeline;
        String linha;
        String[] dados;
        
        for (int i =0; i < 5; i++){
            linha = this.leitorArq.readLine();
            
            dados = linha.split(";");
            
            if (dados.length == 1) {
                timeline = null;
            }
            else {
                timeline = new TimelineTarefa();
                
                if (dados[0].equals("null")) {
                    timeline.setDataMarcaFuncionario(null);
                }
                else {
                    timeline.setDataMarcaFuncionario(sdf1.parse(dados[0]));
                }
                if (dados[1].equals("null")) {
                    timeline.setDataMarcaFuncionario(null);
                }
                else {
                    timeline.setDataMarcaGerente(sdf1.parse(dados[1]));
                }
                timeline.setTag(dados[2]);
                timeline.setNotaFuncionario(dados[3]);
                timeline.setNotaGerente(dados[4]);
            }
            listaTimeline[i] = timeline;
        }
        
        return listaTimeline;
    }
*/
}
