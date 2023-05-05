/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import controller.ControlePrincipal;
import javax.swing.JOptionPane;
import model.Usuario;
import model.UsuarioDAO;
import view.TelaLogin;
import view.TelaMudarSenha;

/**
 *
 * @author rafael
 */
public class ServiceLogin {
    private TelaLogin telaLogin;
    private UsuarioDAO usuarioDAO;
    private Usuario usuario;
    private ControlePrincipal controlePrincipal;

    public ServiceLogin(TelaLogin telaLogin) {
        
        this.telaLogin = telaLogin;
        this.usuarioDAO = new UsuarioDAO();
        this.usuario = new Usuario();
        this.controlePrincipal = controlePrincipal;
        
    }
    
    public void acesso(){
        
        usuario = this.usuarioDAO.acesso(telaLogin.getTxtEmail().getText(), telaLogin.getTxtSenha().getText());
        
         if(usuario.getId()>0){
             
            this.telaLogin.dispose();
            this.controlePrincipal = new ControlePrincipal();
            
        } else{
             
            JOptionPane.showMessageDialog(telaLogin, "Usuário e/ou senha incorreto(s)","Acesso Negado", 0);
            
        }
    }
    
}
