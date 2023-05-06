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
    private TelaLogin telaLogin;
    private UsuarioDAO usuarioDAO;
    private Usuario usuario;

    private TelaCadastro telaCadastro;
    private TelaMudarSenha telaMudarSenha;

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
        
            this.telaCadastro = new TelaCadastro(null, true);
    }
    
    public void cadastrar(){
    
        this.usuario.setNomeLogin(telaCadastro.getTxt_nome().getText());
        this.usuario.setEmail(telaCadastro.getTxt_email().getText());
        this.usuario.setSenha(telaCadastro.getTxt_senha().getText());
        this.usuarioDAO.cadastrar(usuario);
        this.telaCadastro.dispose();
        this.telaLogin = new TelaLogin(null, true);
        
    }
    
    public void limparTelaCadastro(){
    
        this.telaCadastro.getTxt_nome().setText("");
        this.telaCadastro.getTxt_email().setText("");
        this.telaCadastro.getTxt_senha().setText("");
        
    }
    
    public void sair(){
        
        this.telaCadastro.dispose();
        this.telaLogin = new TelaLogin(null, true);
    
    }
//Mudar Senha
     public void acessoMudarSenha(){
        
            this.telaLogin.setVisible(false);
            //this.telaMudarSenha = new TelaMudarSenha(null, true);
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
