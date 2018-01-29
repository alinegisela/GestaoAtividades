/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Dados.Repositorio.RepositorioFuncionario;
import Dados.Repositorio.RepositorioPonto;
import Dados.Repositorio.RepositorioTarefa;
import Negocio.entidade.Funcionario;
import Negocio.excecoes.FuncionarioJaExisteException;
import Negocio.excecoes.FuncionarioNaoExisteException;
import Negocio.excecoes.LoginIncorretoException;
import fachada.FachadaFuncionario;
import fachada.FachadaGerente;
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
public class CadastrarFuncionarioController implements Initializable {
    Main main = new Main();
    @FXML
    private Label msgErro;
    @FXML
    private TextField nomeTxt, dataNascTxt, numIdTxt, ruaTxt, numTxt, bairroTxt, cidadeTxt, estadoTxt,loginTxt;
    @FXML
    private Button cadastrarBtn;
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void handleCadastrarButton(ActionEvent event) throws IOException, FuncionarioJaExisteException, FuncionarioNaoExisteException{
        
        try{
            Parent root;
            
            main.getFachGerente().cadastrarFuncionario(nomeTxt.getText(), dataNascTxt.getText(), numIdTxt.getText(), loginTxt.getText());
            main.getFachGerente().atualizarEndereco(nomeTxt.getText(), ruaTxt.getText(), Integer.parseInt(numTxt.getText()), bairroTxt.getText(), cidadeTxt.getText(), estadoTxt.getText());
     
            
            root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            
            
            cadastrarBtn.getScene().setRoot(root);
        }catch(FuncionarioJaExisteException | FuncionarioNaoExisteException e){
            msgErro.setText(e.getMessage());
        }
       
    }
    
    
}
