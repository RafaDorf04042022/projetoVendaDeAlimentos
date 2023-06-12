/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.Launch;
import model.util.AlertUtil;
import model.util.Sessao;
import service.ServiceLogin;

/**
 * FXML Controller class
 *
 * @author Pedro Paz
 */
public class TelaMudarSenhaController implements Initializable {
    
    private final ServiceLogin servicelogin = new ServiceLogin();

    @FXML
    private Button btn_voltar;
    @FXML
    private Button bnt_limpar;
    @FXML
    private PasswordField txt_novaSenha;
    @FXML
    private TextField txt_email;
    @FXML
    private Button btn_validarEmail;
    @FXML
    private PasswordField txt_novaSenhaConfirmacao;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        servicelogin.createConexao();
    }    

    @FXML
    private void handleBtnVoltar(ActionEvent event) throws IOException {
        voltarTelaLogin();
    }

    @FXML
    private void handleBtnLimpar(ActionEvent event) {
        txt_email.clear();
        txt_novaSenha.clear();
        txt_novaSenhaConfirmacao.clear();
    }

    @FXML
    private void handleBtnValidarEmail(ActionEvent event) throws IOException {
        
        if(txt_email.getText().isEmpty()) {
            AlertUtil.show("Email inválido", "Por favor insira um e-mail válido", Alert.AlertType.ERROR);
        }else if(txt_novaSenha.getText().isEmpty()){
            AlertUtil.show("Senha vazia", "Por favor insira sua nova senha", Alert.AlertType.ERROR);
        }else if(txt_novaSenhaConfirmacao.getText().isEmpty()) {
            AlertUtil.show("Confirmação de Senha", "Por favor digite novamente a sua nova senha para verificação", Alert.AlertType.ERROR);
        }else if(!txt_novaSenhaConfirmacao.getText().equals(txt_novaSenha.getText())) {
            AlertUtil.show("Confirmação de Senha", "As duas senhas não coincidem", Alert.AlertType.ERROR);
        }else {
            servicelogin.checkUsuarioporEmail(txt_email.getText());
            servicelogin.enviarEmail(txt_novaSenha.getText());
            abrirTelaConfirmarEmail();
        }

    }
    
    private void abrirTelaConfirmarEmail() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/mvcfx/view/TelaConfirmarEmail.fxml"));
        DialogPane dialogPane = fxmlLoader.load();
        Dialog dialog = new Dialog();
        dialog.setTitle("Alteração de Senha");
        dialog.setDialogPane(dialogPane);
        dialog.showAndWait();
    }
    
    private void voltarTelaLogin() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/ComidinhasFX/view/TelaLogin.fmxl"));
        Parent pane = loader.load();
        Launch.getStage().getScene().setRoot(pane);
        Launch.getStage().sizeToScene();
        Launch.getStage().centerOnScreen();
    }
}
