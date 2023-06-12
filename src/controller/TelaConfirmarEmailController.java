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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
public class TelaConfirmarEmailController implements Initializable {
    private final ServiceLogin servicelogin = new ServiceLogin();

    @FXML
    private Button btnFechar;
    @FXML
    private TextField txtCodigo;
    @FXML
    private Button btnConfirmar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        servicelogin.createConexao();
    }    

    @FXML
    private void handleBtnFechar(ActionEvent event) throws IOException {
        abrirTelaMudarSenha();
    }

    @FXML
    private void handleBtnConfirmar(ActionEvent event) {
        if(Integer.toString(Sessao.getCodigoRecuperacao()).equals(txtCodigo.getText())) {
            servicelogin.alterarSenha(Sessao.getUsuarioLogado());
            AlertUtil.show("SUCESSO!", "Sua senha foi alterada com êxito.", Alert.AlertType.CONFIRMATION);
        }else {
            AlertUtil.show("ERRO", "Seu código é inválido, por favor tente novamente", Alert.AlertType.ERROR);
        }
    }
    
    private void abrirTelaMudarSenha() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/ComidinhasFX/view/TelaMudarSenha.fmxl"));
        Parent pane = loader.load();
        Launch.getStage().getScene().setRoot(pane);
        Launch.getStage().sizeToScene();
        Launch.getStage().centerOnScreen();
    }
}
