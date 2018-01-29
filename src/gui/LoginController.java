/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Dados.Repositorio.RepositorioFuncionario;
import Dados.Repositorio.RepositorioPonto;
import Dados.Repositorio.RepositorioTarefa;
import Negocio.ClasseTesteSistema;
import Negocio.excecoes.FuncionarioJaExisteException;
import Negocio.excecoes.FuncionarioNaoExisteException;
import Negocio.excecoes.LoginIncorretoException;
import Negocio.excecoes.TarefaJaExisteException;
import fachada.FachadaConvidado;
import fachada.FachadaGerente;
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
public class LoginController implements Initializable {
   
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

    public void handleLoginButton(ActionEvent event) throws IOException, FuncionarioNaoExisteException{
      //=======DELETAR - APENAS PARA TESTE
        Controller.main.getFachConvidado();
        try {
            Controller.main.getFachGerente().cadastrarFuncionario("fulano", null, "0001", "fulano");
            Controller.main.getFachGerente().atualizarEndereco("fulano", "Sem nome", 0, "inicio", "da colina", "onde tem");
            
             Controller.main.getFachGerente().cadastrarTarefa("fulano", "fazer tal", "20/01/2018", "21/01/2018");
        } catch (FuncionarioJaExisteException | FuncionarioNaoExisteException e) {
            System.out.println(e.getMessage());
        } catch (TarefaJaExisteException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //===========
        
        try{
            Parent root;
     
            if(Controller.main.getFachConvidado().fazerLogin(loginTxt.getText(), senhaTxt.getText()).isEhGerente()){
                root = FXMLLoader.load(getClass().getResource("InicioGerente.fxml"));
            }else{
                Controller.main.getFachFuncionario().setUsuario(Controller.main.getFachConvidado().fazerLogin(loginTxt.getText(), senhaTxt.getText()));
                root = FXMLLoader.load(getClass().getResource("InicioFuncionario.fxml"));
            }
            
            loginButton.getScene().setRoot(root);
        }catch(LoginIncorretoException e){
            msgErro.setText(e.getMessage());
        }
       
    }

}
