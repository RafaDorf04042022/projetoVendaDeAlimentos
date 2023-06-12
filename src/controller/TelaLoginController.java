/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import main.Launch;
import javafx.scene.control.Alert;
import model.util.AlertUtil;
import service.ServiceLogin;

/**
 * FXML Controller class
 *
 * @author Pedro Paz
 */
public class TelaLoginController implements Initializable {

    private final ServiceLogin servicelogin = new ServiceLogin();
    
    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private ImageView img_LogoTD;
    @FXML
    private PasswordField txt_senha;
    @FXML
    private TextField txt_email;
    @FXML
    private Button btm_entrar;
    @FXML
    private Button btn_cadastre;
    @FXML
    private Button btn_redefinir;
    @FXML
    private Button btn_sair;
    @FXML
    private Button btn_limpar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        servicelogin.createConexao();
    }    

    @FXML
    private void btnEntrar(ActionEvent event) throws IOException {
        if(validarCampos()) {
            if(servicelogin.checkAccess(txt_email.getText(), txt_senha.getText())){
                abrirTelaPrincipal();
            }else{
                AlertUtil.show("Acesso Negado!", "E-mail de login e/ou senha incorreto(s)", Alert.AlertType.ERROR);
            }
        }else{
            AlertUtil.show("Erro ao logar", "Por favor preencha os campos para conseguir entrar no sistema", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void btnCadastrar(ActionEvent event) throws IOException {
        abrirTelaCadastro();
    }

    @FXML
    private void btnMudarSenha(ActionEvent event) throws IOException {
        abrirTelaMudarSenha();
    }

    @FXML
    private void btnSair(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void btnLimpar(ActionEvent event) {
        txt_email.clear();
        txt_senha.clear();
    }
    
    private void abrirTelaPrincipal() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/ComidinhasFX/view/TelaPrincipal.fmxl"));
        Parent pane = loader.load();
        Launch.getStage().getScene().setRoot(pane);
        Launch.getStage().sizeToScene();
        Launch.getStage().centerOnScreen();
    }
    
    private void abrirTelaMudarSenha() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/ComidinhasFX/view/TelaMudarSenha.fmxl"));
        Parent pane = loader.load();
        Launch.getStage().getScene().setRoot(pane);
        Launch.getStage().sizeToScene();
        Launch.getStage().centerOnScreen();
    }
    
    private void abrirTelaCadastro() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/ComidinhasFX/view/TelaCadastro.fxml"));
        Parent pane = loader.load();
        Launch.getStage().getScene().setRoot(pane);
        Launch.getStage().sizeToScene();
        Launch.getStage().centerOnScreen();
    }
    
    private boolean validarCampos() {
        if(txt_email.getText().isEmpty()) return false;
        else if(txt_senha.getText().isEmpty()) return false;
        else return true;
    }
    
}
