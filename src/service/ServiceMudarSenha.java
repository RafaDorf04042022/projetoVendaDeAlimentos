/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import javax.swing.JOptionPane;
import model.Usuario;
import model.UsuarioDAO;
import view.TelaLogin;
import view.TelaMudarSenha;

/**
 *
 * @author rafael
 */
public class ServiceMudarSenha {
    private TelaMudarSenha telaMudarSenha;
    private UsuarioDAO usuarioDAO;
    private Usuario usuario;
    private TelaLogin telaLogin;

    public ServiceMudarSenha(TelaMudarSenha telaMudarSenha) {
        
        this.telaMudarSenha = telaMudarSenha;
        this.usuarioDAO = new UsuarioDAO();
        this.usuario = new Usuario();
        this.telaLogin = telaLogin;
        
    }
    public void acesso(){
        
            this.telaMudarSenha = new TelaMudarSenha(null, true);
    }
    
    public void mudarSenha(){
        this.usuario.setSenha(telaMudarSenha.getTxt_novaSenha().getText());
        this.usuarioDAO.alterarSenha(usuario);
    }
    
    public void limpar(){
    
        this.telaMudarSenha.getTxt_confirmaEmail().setText("");
        this.telaMudarSenha.getTxt_novaSenha().setText("");
        
    }
    
    public void voltar(){
    
        this.telaMudarSenha.dispose();
        this.telaLogin = new TelaLogin(null, true);
        
    }
}
