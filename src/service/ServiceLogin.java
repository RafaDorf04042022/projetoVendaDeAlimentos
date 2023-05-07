/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import controller.ControlePrincipal;
import javax.swing.JOptionPane;
import model.Usuario;
import model.UsuarioDAO;
import view.TelaCadastro;
import view.TelaLogin;
import view.TelaMudarSenha;

/**
 *
 * @author rafael
 */
public class ServiceLogin {
    private final TelaLogin telaLogin;
    private final UsuarioDAO usuarioDAO;
    private Usuario usuario;

    private final TelaCadastro telaCadastro;
    private final TelaMudarSenha telaMudarSenha;

    public ServiceLogin(TelaLogin telaLogin, TelaCadastro telaCadastro, TelaMudarSenha telaMudarSenha) {
        
        this.telaLogin = telaLogin;
        this.telaCadastro = telaCadastro;
        this.telaMudarSenha = telaMudarSenha;
        this.usuarioDAO = new UsuarioDAO();
        this.usuario = new Usuario();  
    }
//Login    
    public void acesso(){
        
        usuario = this.usuarioDAO.acesso(telaLogin.getTxtEmail().getText(), telaLogin.getTxtSenha().getText());
        
         if(usuario.getId()>0){
             
            this.telaLogin.dispose();
            ControlePrincipal controlePrincipal = new ControlePrincipal();
            
        } else{
             
            JOptionPane.showMessageDialog(telaLogin, "Usuário e/ou senha incorreto(s)","Acesso Negado", 0);
            
        }
    }
//Cadastro   
     public void acessoCadastro(){
        
        this.telaLogin.setVisible(false);
        this.telaCadastro.setVisible(true);    
    }
    
    public void cadastrar(){
    
        this.usuario.setNomeLogin(telaCadastro.getTxt_nome().getText());
        this.usuario.setEmail(telaCadastro.getTxt_email().getText());
        this.usuario.setSenha(telaCadastro.getTxt_senha().getText());
        this.usuarioDAO.cadastrar(usuario);
        this.telaCadastro.setVisible(false);
        this.telaLogin.setVisible(true);
        
    }
    
    public void limparTelaCadastro(){
    
       this.telaCadastro.getTxt_nome().setText("");
       this.telaCadastro.getTxt_email().setText("");
       this.telaCadastro.getTxt_senha().setText("");
        
    }
    
    public void sair(){
        
        this.telaCadastro.setVisible(false);
        this.telaLogin.setVisible(true);
    
    }
//Mudar Senha
     public void acessoMudarSenha(){
        
            this.telaLogin.setVisible(false);
            this.telaMudarSenha.setVisible(true);
            
    }
    
    public void mudarSenha(){
        this.usuario.setSenha(telaMudarSenha.getTxt_novaSenha().getText());
        this.usuarioDAO.alterarSenha(usuario);
    }
    
    public void limparTelaMudarSenha(){
    
        this.telaMudarSenha.getTxt_confirmaEmail().setText("");
        this.telaMudarSenha.getTxt_novaSenha().setText("");
        
    }
    
    public void voltar(){
    
        this.telaMudarSenha.setVisible(false);
        this.telaLogin.setVisible(true);
        
    }
}
