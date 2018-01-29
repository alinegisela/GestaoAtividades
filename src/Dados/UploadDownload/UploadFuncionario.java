package Dados.UploadDownload;

import Dados.Repositorio.RepositorioFuncionario;
import Negocio.entidade.Endereco;
import Negocio.entidade.Funcionario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UploadFuncionario {
    private RepositorioFuncionario reposFuncionario;
    private FileReader arq;
    private BufferedReader leitorArq;
    
    public UploadFuncionario() {
        this.reposFuncionario = new RepositorioFuncionario();
    }
    
    public RepositorioFuncionario main() {
        try {
            criarPastas();
            
            File file = new File("ArquivoTXT/Funcionario");
            File[] listaFile = file.listFiles();
            
            for (int i = 0; i < listaFile.length; i++){
                criarObjetoleitor(listaFile[i]);
                
                Funcionario funcionario = criarObjetoFuncionario();
                Endereco endereco = criarObjetoEndereco();
                
                funcionario.setEndereco(endereco);
                
                this.reposFuncionario.adicionar(funcionario);
                
                this.leitorArq.close();
                this.arq.close();
            }            
        }
        catch (IOException e) {
            System.out.println("ERRO: ao le do arquivo");
            System.out.println(e.getMessage());
        }
        return this.reposFuncionario;
    }
    
    private void criarPastas() throws IOException {
        File diretorio = new File("ArquivoTXT/Funcionario");
        
        if (diretorio.exists() == false) {
            diretorio.mkdirs();
            
            BufferedWriter escritor = new BufferedWriter(new FileWriter("ArquivoTXT/Funcionario/Funcionario_admin.txt", false));
            
            escritor.write("admin;null;0000;admin;admin;true\n");
            escritor.write("null;0;null;null;null");
            
            escritor.close();
        }
    }
    
    private void criarObjetoleitor(File file) throws IOException {
        String diretorio = "ArquivoTXT/Funcionario/" + file.getName();
        this.arq = new FileReader(diretorio);
        this.leitorArq = new BufferedReader(this.arq);
    }
    
    private Funcionario criarObjetoFuncionario() throws IOException {
        String linha = this.leitorArq.readLine();
        String[] dados = linha.split(";");
        
        Funcionario funcionario = new Funcionario(dados[0], dados[1], dados[2], dados[3]);
        funcionario.setSenha(dados[4]);
        funcionario.setEhGerente(Boolean.valueOf(dados[5]));
        
        return funcionario;
    }
    
    private Endereco criarObjetoEndereco() throws IOException {
        String linha = this.leitorArq.readLine();
        String[] dados = linha.split(";");
        
        Endereco endereco;
        endereco = new Endereco(dados[0], Integer.valueOf(dados[1]), dados[2], dados[3], dados[4]);
        
        return endereco;
    }
}
