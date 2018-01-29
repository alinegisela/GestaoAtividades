package Dados.UploadDownload;

import Dados.Repositorio.RepositorioPonto;
import Negocio.entidade.Ponto;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DownloadPonto {
    private final Ponto[] listaPonto;
    private BufferedWriter arq;
    
    public DownloadPonto(RepositorioPonto reposPonto) {
        this.listaPonto = reposPonto.returnListaPonto();
    }
    
    public void main() {
        try {
            criarPastas();
            
            for (Ponto listaPonto1 : listaPonto) {
                criarObjetoEscrita(listaPonto1);
                escreverArquivo(listaPonto1);
                arq.close();
            }            
        }
        catch(IOException e) {
            System.out.println("ERRO: ao escrever o arquivo");
            System.out.println(e.getMessage());
        }
    }
    
    private void criarPastas() {
        File diretorio = new File("ArquivoTXT/Ponto");
        diretorio.mkdirs();
    }
    
    private void criarObjetoEscrita(Ponto ponto) throws IOException {
        String nomeFuncionario = "ArquivoTXT/Ponto/Funcionario_" + ponto.getFuncionario().getNome() + ".txt";
        arq = new BufferedWriter(new FileWriter(nomeFuncionario, true));
    }
    
    private void escreverArquivo(Ponto ponto) throws IOException {
        arq.write(ponto.getFuncionario().getNome() + ";");
        arq.write(ponto.getFuncionario().getNumIdentidade() + ";");
        arq.write(ponto.getData() + ";");
        arq.write(ponto.getInicioExpediente() + ";");
        arq.write(ponto.getSaidaAlmoco() + ";");
        arq.write(ponto.getVoltaAlmoco() + ";");
        arq.write(ponto.getFimExpediente());
        arq.write("\n");
    }
}
