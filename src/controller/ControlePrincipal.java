/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Sessao;
import model.Usuario;
import view.TelaPrincipal;

/**
 *
 * @author Pedro Paz
 */
public class ControlePrincipal implements ActionListener{
    
    private final TelaPrincipal telaPrincipal;
    
    public ControlePrincipal(Usuario usuario) {
        this.telaPrincipal = new TelaPrincipal();
        this.telaPrincipal.getLblUsuario().setText(usuario.getNomeLogin());
        addListeners();
        this.telaPrincipal.setVisible(true);
    }
    
        public ControlePrincipal() {
        this.telaPrincipal = new TelaPrincipal();
        addListeners();
        this.telaPrincipal.setVisible(true);
    }
    
    private void addListeners() {
        this.telaPrincipal.getMenuItemPerfil().addActionListener(this);
        this.telaPrincipal.getMenuItemAlimento().addActionListener(this);
        this.telaPrincipal.getjButtonSair().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.telaPrincipal.getMenuItemPerfil())) {
            this.telaPrincipal.dispose();
            ControlePerfil controlePerfil = new ControlePerfil(telaPrincipal);            
        }else if(e.getSource().equals(this.telaPrincipal.getMenuItemAlimento())) {
            this.telaPrincipal.dispose();
            ControleAlimento controleAlimento = new ControleAlimento(telaPrincipal);
        }else if(e.getSource().equals(this.telaPrincipal.getjButtonSair())){
            this.telaPrincipal.dispose();
            ControleLogin controleLogin = new ControleLogin();
        }
    }
    
}
