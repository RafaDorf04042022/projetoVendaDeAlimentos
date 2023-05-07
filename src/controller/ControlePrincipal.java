/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import service.ServicePrincipal;
import view.TelaAlimentos;
import view.TelaPerfil;
import view.TelaPrincipal;

/**
 *
 * @author Pedro Paz
 */
public class ControlePrincipal implements ActionListener{
    
    private final ServicePrincipal servicePrincipal;
    private final TelaPrincipal telaPrincipal;
    private final TelaAlimentos telaAlimentos;
    private final TelaPerfil telaPerfil;
    
    public ControlePrincipal() {
        this.telaPrincipal = new TelaPrincipal();
        this.telaPerfil = new TelaPerfil(null, true);
        this.telaAlimentos = new TelaAlimentos(null, true);
        this.servicePrincipal = new ServicePrincipal(telaPerfil, telaPrincipal, telaAlimentos);
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
            this.servicePrincipal.acessoPerfil();
        }else if(e.getSource().equals(this.telaPrincipal.getMenuItemAlimento())) {
            this.servicePrincipal.acessoAlimento();
            ControlePerfil controlePerfil = new ControlePerfil(telaPrincipal);
        }else if(e.getSource().equals(this.telaPrincipal.getjButtonSair())){
            // função de sair
        }
    }
    
}
