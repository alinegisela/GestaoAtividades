
package gui;

import Dados.Repositorio.RepositorioPonto;
import Dados.Repositorio.RepositorioTarefa;
import Negocio.entidade.Funcionario;
import Negocio.entidade.Tarefa;
import fachada.FachadaFuncionario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class InicioFuncionarioController implements Initializable {
    static Funcionario usuarioLogado;
    FachadaFuncionario fachada = new FachadaFuncionario(usuarioLogado, new RepositorioPonto(), new RepositorioTarefa());
    
    @FXML
    TableView<Tarefa> tabela;
    @FXML
    TableColumn<Tarefa, String> colTarefa;
    @FXML
    TableColumn<Tarefa, String> colInicio;
    @FXML
    TableColumn<Tarefa, String> colPrazo;
    @FXML
    TableColumn<Tarefa, String> colStatus;
    
    ObservableList<Tarefa> data = FXCollections.observableArrayList();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
