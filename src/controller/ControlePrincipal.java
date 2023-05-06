/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.TelaPrincipal;

/**
 *
 * @author Pedro Paz
 */
public class ControlePrincipal implements ActionListener{
    private final TelaPrincipal telaPrincipal;
    
    public ControlePrincipal() {
        this.telaPrincipal = new TelaPrincipal();
        addListeners();
        this.telaPrincipal.setVisible(true);
    }
    
    private void addListeners() {
        this.telaPrincipal.getMenuItemPerfil().addActionListener(this);
        this.telaPrincipal.getMenuItemAlimento().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.telaPrincipal.getMenuItemPerfil())) {
            ControlePerfil controlePerfil = new ControlePerfil(telaPrincipal);
        }
    }
    
}
