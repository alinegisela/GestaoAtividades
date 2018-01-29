/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import fachada.FachadaConvidado;
import fachada.FachadaFuncionario;
import fachada.FachadaGerente;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Absinto
 */
public class Main extends Application {
    final FachadaConvidado fachConvidado = new FachadaConvidado();
    final FachadaFuncionario fachFuncionario = new FachadaFuncionario();
    final FachadaGerente fachGerente = new FachadaGerente();

    public FachadaConvidado getFachConvidado() {
        return fachConvidado;
    }

  
    public FachadaFuncionario getFachFuncionario() {
        return fachFuncionario;
    }


    public FachadaGerente getFachGerente() {
        return fachGerente;
    }

  
    @Override
    public void start(Stage stageAtual) throws IOException {
     
        
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stageAtual.setScene(new Scene(root, 500, 500));
        stageAtual.show();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
