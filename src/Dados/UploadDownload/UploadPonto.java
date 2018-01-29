package Dados.UploadDownload;

import Dados.Repositorio.RepositorioPonto;
import java.io.File;

public class UploadPonto {
    private RepositorioPonto reposPonto;
    
    public UploadPonto() {
        this.reposPonto = new RepositorioPonto();
    }
    
    public RepositorioPonto main() {
        criarPastas();
        return this.reposPonto;
    }
    
    private void criarPastas(){
        File diretorio = new File("ArquivoTXT/Ponto");
        if (diretorio.exists() == false) {
            diretorio.mkdirs();
        }
    }
}
