/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import model.Usuario;
import model.UsuarioDAO;
import view.TelaCadastro;
import view.TelaLogin;

/**
 *
 * @author rafael
 */
public class ServiceCadastro {
    
    private Usuario usuario;
    private UsuarioDAO usuarioDAO;
    private TelaCadastro telaCadastro;
    private TelaLogin telaLogin;

    public ServiceCadastro(TelaCadastro telaCadastro) {
        this.usuario = new Usuario();
        this.usuarioDAO = new UsuarioDAO();
        this.telaCadastro = telaCadastro;
        this.telaLogin = telaLogin;
    }
    
    public void cadastrar(){
    
        this.usuario.setNomeLogin(telaCadastro.getTxt_nome().getText());
        this.usuario.setEmail(telaCadastro.getTxt_email().getText());
        this.usuario.setSenha(telaCadastro.getTxt_senha().getText());
        this.usuarioDAO.cadastrar(usuario);
        this.telaCadastro.dispose();
        this.telaLogin = new TelaLogin(null, true);
        
    }
    
    public void limpar(){
    
        this.telaCadastro.getTxt_nome().setText("");
        this.telaCadastro.getTxt_email().setText("");
        this.telaCadastro.getTxt_senha().setText("");
        
    }
    
    public void sair(){
        
        this.telaCadastro.dispose();
        this.telaLogin = new TelaLogin(null, true);
    
    }
}
