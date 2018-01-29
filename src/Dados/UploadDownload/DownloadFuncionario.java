package Dados.UploadDownload;

import Dados.Repositorio.RepositorioFuncionario;
import Negocio.entidade.Funcionario;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DownloadFuncionario {
    private final Funcionario[] listaFuncionario;
    private BufferedWriter arq;
    
    public DownloadFuncionario(RepositorioFuncionario reposFuncionario) {
        this.listaFuncionario = reposFuncionario.returnListaFuncionario();
    }
    
    public void main() {
        try {
            criarPastas();
            
            for (Funcionario listaFuncionario1 : listaFuncionario) {
                criarObjetoEscrita(listaFuncionario1);
                escreverArquivo(listaFuncionario1);
                arq.close();
            }            
        }
        catch(IOException e) {
            System.out.println("ERRO: ao escrever o arquivo");
            System.out.println(e.getMessage());
        }
    }
    
    private void criarPastas() {
        File diretorio = new File("ArquivoTXT/Funcionario");
        diretorio.mkdirs();
    }
    
    private void criarObjetoEscrita(Funcionario Funcionario) throws IOException {
        String nomeFuncionario = "ArquivoTXT/Funcionario/Funcionario_" + Funcionario.getNome() + ".txt";
        arq = new BufferedWriter(new FileWriter(nomeFuncionario, false));
    }
    
    private void escreverArquivo(Funcionario Funcionario) throws IOException {
        arq.write(Funcionario.getNome() + ";");
        arq.write(Funcionario.getDataNascimento() + ";");
        arq.write(Funcionario.getNumIdentidade() + ";");
        arq.write(Funcionario.getLogin() + ";");
        arq.write(Funcionario.getSenha() + ";");
        arq.write(Funcionario.isEhGerente() + "");
        arq.write("\n");
        if (Funcionario.getEndereco() == null) {
            arq.write("null");
        }
        else { //retirar depois o if e o else quando o funcionario admin passar ter endereco
            arq.write(Funcionario.getEndereco().getRua() + ";");
            arq.write(Funcionario.getEndereco().getNumero() + ";");
            arq.write(Funcionario.getEndereco().getBairro() + ";");
            arq.write(Funcionario.getEndereco().getCidade() + ";");
            arq.write(Funcionario.getEndereco().getEstado());
        }
        arq.write("\n");
    }
}
