/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import view.TelaCadastroEndereco;
import view.TelaEndereco;
import view.TelaPrincipal;

/**
 *
 * @author Heber
 */
public class ControleEndereco implements ActionListener, KeyListener{
    private TelaCadastroEndereco telaCadastroEndereco;
    private TelaEndereco telaEndereco;

    public ControleEndereco(TelaPrincipal telaPrincipal) {
        telaCadastroEndereco = new TelaCadastroEndereco(telaPrincipal, true);
        telaEndereco = new TelaEndereco(telaPrincipal, true);
        addListeners();
        telaEndereco.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //listeners da tela de cadastro de endereço
        if(e.getSource().equals(telaCadastroEndereco.getjButtonSalvar())){
            //service salvar endereço
        }
        //listeners da tela de cadastro de endereço
        if(e.getSource().equals(telaEndereco.getjButtonEditar())){
            //service para abrir a tela de cadastro (co os dados desse endereço)
        }
        if(e.getSource().equals(telaEndereco.getjButtonExcluir())){
            //service para excluir o endereço
        }
    }
    
    private void addListeners() {
        this.telaCadastroEndereco.getjButtonSalvar().addActionListener(this);
        this.telaCadastroEndereco.getjTextFieldNomeBairro().addKeyListener(this);
        this.telaCadastroEndereco.getjTextFieldNomeCidade().addKeyListener(this);
        this.telaCadastroEndereco.getjTextFieldNomeEndereço().addKeyListener(this);
        this.telaCadastroEndereco.getjTextFieldNomeEstado().addKeyListener(this);
        this.telaCadastroEndereco.getjTextFieldNomeRua().addKeyListener(this);
        this.telaCadastroEndereco.getjTextFieldNumero().addKeyListener(this);
        this.telaEndereco.getjButtonEditar().addActionListener(this);
        this.telaEndereco.getjButtonExcluir().addActionListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if  (
                (e.getSource().equals(telaCadastroEndereco.getjTextFieldNomeBairro())) ||
                (e.getSource().equals(telaCadastroEndereco.getjTextFieldNomeCidade())) ||
                (e.getSource().equals(telaCadastroEndereco.getjTextFieldNomeEndereço())) ||
                (e.getSource().equals(telaCadastroEndereco.getjTextFieldNomeEstado())) ||
                (e.getSource().equals(telaCadastroEndereco.getjTextFieldNomeRua())) ||
                (e.getSource().equals(telaCadastroEndereco.getjTextFieldNumero()))
            ){
            if(e.getKeyCode()==KeyEvent.VK_ENTER){
                //service para service cadastro endereço
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
    
}
