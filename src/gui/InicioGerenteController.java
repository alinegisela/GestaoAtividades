/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Negocio.excecoes.FuncionarioNaoExisteException;
import Negocio.excecoes.LoginIncorretoException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Absinto
 */
public class InicioGerenteController implements Initializable {
    Main main = new Main();
    
    @FXML
    private Button criarNovaBtn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void handleCriarNovaButton(ActionEvent event) throws IOException{
        
            Parent root;
            root = FXMLLoader.load(getClass().getResource("CadastrarTarefa.fxml"));
            criarNovaBtn.getScene().setRoot(root);
        
    }
    
}
