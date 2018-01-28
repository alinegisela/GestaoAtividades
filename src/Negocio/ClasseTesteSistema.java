package Negocio;

import Negocio.entidade.Tarefa;
import Negocio.entidade.Funcionario;
import fachada.FachadaGerente;
import fachada.FachadaFuncionario;
import Dados.RepositorioFuncionario;
import Dados.RepositorioPonto;
import Dados.RepositorioTarefa;
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

        FachadaGerente fachGerente = new FachadaGerente(reposFuncionario, reposPonto, reposTarefa);

        try {
            fachGerente.cadastrarFuncionario("fulano", null, "0001");
            fachGerente.atualizarEndereco("fulano", "Sem nome", 0, "inicio", "da colina", "onde tem");

            fachGerente.cadastrarFuncionario("cigrano", null, "0002");
            fachGerente.atualizarEndereco("cigrano", "vida longa", 0, "perto de", "qualquer", "coisa");
        } catch (FuncionarioJaExisteException | FuncionarioNaoExisteException e) {
            System.out.println(e.getMessage());
        }

        Funcionario func = reposFuncionario.buscaFuncionarioNome("cigrano");
        FachadaFuncionario fachFuncionario = new FachadaFuncionario(func, reposPonto, reposTarefa);

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

        //depois revisar TimelineTarefa e Tarefa (pequenos detalhes de logica), para verificar se esta funcionando como esperado
    }
}
