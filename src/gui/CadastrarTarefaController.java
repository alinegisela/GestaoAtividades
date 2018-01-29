/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Negocio.excecoes.FuncionarioNaoExisteException;
import Negocio.excecoes.TarefaJaExisteException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Absinto
 */
public class CadastrarTarefaController implements Initializable {

    Main main = new Main();
    
    @FXML
    private Label msgErro;
    @FXML
    Button criarBtn;
    @FXML
    private TextField nomeTxt, descricaoTxt, inicioTxt, prazoTxt;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void handleCriarButton(ActionEvent event) throws IOException{
        try {
            main.fachGerente.cadastrarTarefa(nomeTxt.getText(), descricaoTxt.getText(), inicioTxt.getText(), prazoTxt.getText());
            Parent root;
            root = FXMLLoader.load(getClass().getResource("InicioGerente.fxml"));
            criarBtn.getScene().setRoot(root);
        } catch (FuncionarioNaoExisteException | TarefaJaExisteException ex) {
            msgErro.setText(ex.getMessage());
        }
    }
    
}
