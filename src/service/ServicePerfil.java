/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import controller.ControlePrincipal;
import java.beans.XMLDecoder;
import java.io.ByteArrayInputStream;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.Usuario;
import model.UsuarioDAO;
import view.TelaPerfil;
import view.TelaPrincipal;

/**
 *
 * @author rafael
 */
public class ServicePerfil {
    
    private final TelaPerfil telaPerfil;
    private final UsuarioDAO usuarioDAO;
    private final Usuario usuario;

    public ServicePerfil(TelaPerfil telaPerfil) {
        this.telaPerfil = telaPerfil;
        this.usuarioDAO = new UsuarioDAO();
        this.usuario = new Usuario();
    }
    
    public void trocarEmail(){
    
        this.usuario.setEmail(JOptionPane.showInputDialog(null, "Digite o novo email:"));
        this.usuarioDAO.alterarEmail(usuario);
        this.telaPerfil.getjLabelEmail().setText(usuario.getEmail());
        
    }
    
    public void trocarEndereco(){
    
        this.usuario.setEndereco(JOptionPane.showInputDialog(null, "Digite o novo endereço:"));
        this.usuarioDAO.alterarEndereco(usuario);
        this.telaPerfil.getjLabelEndereco().setText(usuario.getEndereco());
    
    }
    public void trocarSenha(){
    
        this.usuario.setSenha(JOptionPane.showInputDialog(null, "Digite a nova senha:"));
        this.usuarioDAO.alterarSenhaPerfil(usuario);
        this.telaPerfil.getjLabelSenha().setText(usuario.getSenha());
    
    }
    public void lista(){
    
    }
    
    public void voltar() {
        this.telaPerfil.setVisible(false);
        ControlePrincipal controlePrincipal = new ControlePrincipal();
    }
}
