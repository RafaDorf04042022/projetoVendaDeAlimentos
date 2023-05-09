/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import service.ServiceProduto;
import view.TelaProduto;
import view.TelaPrincipal;

/**
 *
 * @author Pedro Paz
 */
public class ControleAlimento implements ActionListener{
    private final ServiceProduto serviceAlimento;
    private final TelaProduto telaAlimentos;
    
    public ControleAlimento(TelaPrincipal telaPrincipal) {
        telaAlimentos = new TelaProduto(telaPrincipal, true);
        serviceAlimento = new ServiceProduto(telaAlimentos);
        addListeners();
        telaAlimentos.setVisible(true);
    }
    
    private void addListeners() {
        this.telaAlimentos.getBtnNovo().addActionListener(this);
        this.telaAlimentos.getBtnEditar().addActionListener(this);
        this.telaAlimentos.getBtnExcluir().addActionListener(this);
        this.telaAlimentos.getBtnVoltar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.telaAlimentos.getBtnNovo())) {
            serviceAlimento.salvar();
        }else if(e.getSource().equals(this.telaAlimentos.getBtnEditar())) {
            serviceAlimento.editar();
        }else if(e.getSource().equals(this.telaAlimentos.getBtnExcluir())) {
            serviceAlimento.excluir();
        }else if(e.getSource().equals(this.telaAlimentos.getBtnVoltar())) {
            serviceAlimento.voltar();
        }
    }
}
