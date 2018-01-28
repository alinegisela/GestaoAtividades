/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Negocio.excecoes.LoginIncorretoException;
import fachada.FachadaFuncionario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
public class FXMLController implements Initializable {
    FachadaFuncionario fachadaFuncionario = new FachadaFuncionario();
    
    @FXML
    private Label msgErro;
    @FXML
    private TextField loginTxt, senhaTxt;
    @FXML
    private Button loginButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void handleLoginButton(ActionEvent event) throws IOException{
        try{
            fachadaFuncionario.fazerLogin(loginTxt.getText(), senhaTxt.getText());
            Parent root = FXMLLoader.load(getClass().getResource("InicioFuncionario.fxml"));
            loginButton.getScene().setRoot(root);
        }catch(LoginIncorretoException e){
            msgErro.setText(e.getMessage());
        }
        
        
        System.out.println(loginTxt.getText() + "  " + senhaTxt.getText());
       
    }

}
