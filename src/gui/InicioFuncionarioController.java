package gui;

import Negocio.entidade.Tarefa;
import Negocio.excecoes.TarefaNaoExisteException;
import fachada.FachadaFuncionario;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class InicioFuncionarioController implements Initializable {
    @FXML
    private Label msgErro;
    @FXML
    private TableView<Tarefa> tableViewTarefa;
    @FXML
    private TableColumn<Tarefa, String> tableColumnDescricao;
    @FXML
    private TableColumn<Tarefa, String> tableColumnDataInicio;
    @FXML
    private TableColumn<Tarefa, String> tableColumnDataTermino;
    @FXML
    private TableColumn<Tarefa, String> tableColumnStatus;
    @FXML
    private Button marcarBtn;
    
    private List<Tarefa> listaTarefa = new ArrayList();
    private ObservableList<Tarefa> observableListTarefa;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
        caregarTableViewTarefa(Controller.main.getFachFuncionario());
    }   
    
    
    public void caregarTableViewTarefa(FachadaFuncionario fachada){
        try {
            /*Tarefa[] tarefas = fachada.buscarTarefaPendente();
            for(int i=0; i< fachada.buscarTarefaPendente().length;i++){
                System.out.println("oooiia o erro "+tarefas[i]);
                listaTarefa.add(tarefas[i]);
            }*/
            observableListTarefa = FXCollections.observableArrayList(fachada.buscarTarefaPendente());
            tableColumnDescricao.setCellValueFactory(new PropertyValueFactory<Tarefa, String>("descricao"));
            tableColumnDataInicio.setCellValueFactory(new PropertyValueFactory<Tarefa, String>("dataInicio"));
            tableColumnDataTermino.setCellValueFactory(new PropertyValueFactory<Tarefa, String>("dataTermino"));
            tableColumnStatus.setCellValueFactory(new PropertyValueFactory<Tarefa, String>("status"));
           
            tableViewTarefa.setItems(observableListTarefa);
        } 
        catch (TarefaNaoExisteException ex) {
            msgErro.setText(ex.getMessage());
        }
    }    
    
    public void handleMarcarButton(){
        Tarefa f = tableViewTarefa.getSelectionModel().getSelectedItem();
        Controller.main.fachFuncionario.getGerenciadorTarefa().setTarefa(f);
        
        Controller.main.fachFuncionario.marcarFinalizadaFuncionario();
        System.out.println(Controller.main.fachFuncionario.getGerenciadorTarefa().getTarefa().getStatus());
        tableViewTarefa.getColumns().get(0).setVisible(false);
        tableViewTarefa.getColumns().get(0).setVisible(true);
      // tableColumnStatus.setCellValueFactory(cellData -> cellData.getValue().getPStatus());
       
    }
}
