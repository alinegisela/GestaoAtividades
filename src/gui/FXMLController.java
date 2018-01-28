/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Absinto
 */
public class FXMLController implements Initializable {
    
    @FXML
    private TextField matriculaTxt, senhaTxt;
    @FXML
    private Button loginButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void handleLoginButton(ActionEvent event) throws IOException {
        System.out.println("c");
        Parent root = FXMLLoader.load(getClass().getResource("InicioFuncionario.fxml"));
        System.out.println(matriculaTxt.getText() + "  " + senhaTxt.getText());
        loginButton.getScene().setRoot(root);
    }

}
