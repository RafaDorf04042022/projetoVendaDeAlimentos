/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.beans.XMLDecoder;
import java.io.ByteArrayInputStream;
import javax.swing.JLabel;
import model.Usuario;
import model.UsuarioDAO;
import view.TelaProduto;
import view.TelaPerfil;
import view.TelaPrincipal;

/**
 *
 * @author rafael
 */
public class ServicePrincipal {
    
    private final Usuario usuario;
    private final TelaPerfil telaPerfil;
    private final TelaProduto telaAlimentos;
    private final TelaPrincipal telaPrincipal;

    public ServicePrincipal(TelaPerfil telaPerfil, TelaPrincipal telaPrincipal, TelaProduto telaAlimentos) {
        
        this.usuario = new Usuario();
        this.telaPerfil = telaPerfil;
        this.telaPrincipal = telaPrincipal;
        this.telaAlimentos = telaAlimentos;
        user();
        
    }
    
    public void acessoPerfil(){
    
        this.telaPrincipal.setVisible(false);
        this.telaPerfil.setVisible(true);
        
    }
    
    public void user(){
    
        this.telaPrincipal.setLblUsuario(fromString(usuario.getNomeLogin()));
    
    }
    
    
    JLabel fromString(String str) {
        
        XMLDecoder d = new XMLDecoder(new ByteArrayInputStream(str.getBytes()));
        JLabel label = (JLabel) d.readObject();
        d.close();
        return label;
        
    }
    
    public void acessoAlimento(){
        this.telaPrincipal.setVisible(false);
        this.telaAlimentos.setVisible(true);
    }
}
