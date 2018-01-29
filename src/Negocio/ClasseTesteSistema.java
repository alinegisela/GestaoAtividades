package Negocio;

import Negocio.entidade.Tarefa;
import Negocio.entidade.Funcionario;
import fachada.FachadaGerente;
import fachada.FachadaFuncionario;
import Dados.Repositorio.RepositorioFuncionario;
import Dados.Repositorio.RepositorioPonto;
import Dados.Repositorio.RepositorioTarefa;
import Dados.UploadDownload.DownloadFuncionario;
import Dados.UploadDownload.DownloadPonto;
import Dados.UploadDownload.DownloadTarefa;
import Negocio.excecoes.FuncionarioJaExisteException;
import Negocio.excecoes.FuncionarioNaoExisteException;
import Negocio.excecoes.PontoCheioException;
import Negocio.excecoes.TarefaJaExisteException;
import Negocio.excecoes.TarefaNaoExisteException;



public class ClasseTesteSistema {

    public static void main(String[] args) throws FuncionarioNaoExisteException {
        RepositorioFuncionario reposFuncionario = new RepositorioFuncionario();
        RepositorioPonto reposPonto = new RepositorioPonto();
        RepositorioTarefa reposTarefa = new RepositorioTarefa();

        FachadaGerente fachGerente = new FachadaGerente();

        try {
            fachGerente.cadastrarFuncionario("fulano", null, "0001", "fulano");
            fachGerente.atualizarEndereco("fulano", "Sem nome", 0, "inicio", "da colina", "onde tem");
            
            fachGerente.cadastrarFuncionario("cigrano", null, "0002", "cicrano");
            fachGerente.atualizarEndereco("cigrano", "vida longa", 0, "perto de", "qualquer", "coisa");
        } catch (FuncionarioJaExisteException | FuncionarioNaoExisteException e) {
            System.out.println(e.getMessage());
        }

        Funcionario func = fachGerente.buscaFuncionarioNome("cigrano");
        FachadaFuncionario fachFuncionario = new FachadaFuncionario();
       
        try {
            fachGerente.cadastrarTarefa("fulano", "fazer tal", "20/01/2018", "21/01/2018");
            fachGerente.cadastrarTarefa("cigrano", "fazer tal2", "20/01/2018", "21/01/2018");
            fachGerente.cadastrarTarefa("cigrano", "fazer tal3", "22/01/2018", "23/01/2018");
        } catch (TarefaJaExisteException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            fachGerente.baterPonto();
            fachGerente.baterPonto();
            fachGerente.baterPonto();
            fachGerente.baterPonto();

            fachFuncionario.baterPonto();
            fachFuncionario.baterPonto();
            fachFuncionario.baterPonto();
            fachFuncionario.baterPonto();
        } catch (PontoCheioException e) {
            System.out.println(e.getMessage());
        }

        try {
            Tarefa[] listaTarefa = fachFuncionario.buscarTarefaPendente();
            System.out.println(listaTarefa.length);
            fachFuncionario.editarTarefa(listaTarefa[1]);
            fachGerente.editarTarefa(listaTarefa[1]);

            fachFuncionario.marcarFinalizadaFuncionario();
            fachGerente.marcarRefazer();
            fachFuncionario.adicionarNotaFuncionario("faltou material");
            fachFuncionario.marcarFinalizadaFuncionario();
            fachGerente.adicionarNotaGerente("poderia ficar melhor");
            fachGerente.marcarFinalizadaGerente();
        } catch (TarefaNaoExisteException e) {
            System.out.println(e.getMessage());
        }

        
        System.out.println("=================RepositorioFuncionario=================");
        reposFuncionario.exibirObjetos();
        System.out.println("=================RepositorioPonto=================");
        reposPonto.exibirObjetos();
        System.out.println("=================RepositorioTarefa=================");
        reposTarefa.exibirObjetos();

        
    }
}
