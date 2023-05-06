package controller;


import view.TelaCadastro;
import view.TelaLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import service.ServiceLogin;
import view.TelaMudarSenha;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ana Luiza
 */
public class ControleLogin implements ActionListener, KeyListener {
    
   private final TelaCadastro telaCadastro;
   private final TelaLogin telaLogin;
   private  final TelaMudarSenha telaMudarSenha;
   private final ServiceLogin serviceLogin;
   
   public ControleLogin() {
       this.telaLogin = new TelaLogin(null, true);
       this.telaCadastro = new TelaCadastro(null, true);
       this.telaMudarSenha = new TelaMudarSenha(null, true);
       this.serviceLogin = new ServiceLogin(telaLogin, telaCadastro, telaMudarSenha);       
       addListeners();   
       this.telaLogin.setVisible(true);
    
   }

   private void addListeners(){
       //Listener da tela Cadastro
       this.telaCadastro.getBtn_cadastrar().addActionListener(this);
       this.telaCadastro.getBtn_limpar().addActionListener(this);
       this.telaCadastro.getBtn_sair().addActionListener(this);
       this.telaCadastro.getTxt_email().addKeyListener(this);
       this.telaCadastro.getTxt_nome().addKeyListener(this);
       this.telaCadastro.getTxt_senha().addKeyListener(this);
       //Listeners da tela de Login
       this.telaLogin.getBtnLogin().addActionListener(this);
       this.telaLogin.getBtnCriarConta().addActionListener(this);
       this.telaLogin.getBtnEsqueciSenha().addActionListener(this);
       //Listener da tela Mudar Senha
       this.telaMudarSenha.getBtn_concluir().addActionListener(this);
       this.telaMudarSenha.getBtn_limpa().addActionListener(this);
       this.telaMudarSenha.getBtn_volta().addActionListener(this);
       this.telaMudarSenha.getTxt_confirmaEmail().addActionListener(this);
       this.telaMudarSenha.getTxt_novaSenha().addActionListener(this);
   }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        //Tela Login
        if(e.getSource().equals(this.telaLogin.getBtnLogin())) {
            
            this.serviceLogin.acesso();
            
        }else if(e.getSource().equals(this.telaLogin.getBtnEsqueciSenha())) {
            
            this.serviceLogin.acessoMudarSenha();
            
        }else if(e.getSource().equals(this.telaLogin.getBtnCriarConta())) {
            
            this.serviceLogin.acessoCadastro();
            
        }
        //Tela Cadastro
        else if(e.getSource().equals(this.telaCadastro.getBtn_cadastrar())){
            
            this.serviceLogin.cadastrar();
            
        }else if(e.getSource().equals(this.telaCadastro.getBtn_limpar())){
            
            this.serviceLogin.limparTelaCadastro();
            
        }else if(e.getSource().equals(this.telaCadastro.getBtn_sair())){
            
            this.serviceLogin.sair();
            
        }
        //Tela mudar Senha
        else if(e.getSource().equals(this.telaMudarSenha.getBtn_concluir())){
             
            this.serviceLogin.mudarSenha();
             
        }else if(e.getSource().equals(this.telaMudarSenha.getBtn_limpa())){
          
            this.serviceLogin.limparTelaMudarSenha();
          
        }else if(e.getSource().equals(this.telaMudarSenha.getBtn_volta())){
          
            this.serviceLogin.voltar();
            
        }
        
    }
            
    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getSource().equals(telaLogin.getTxtEmail()) || 
                e.getSource().equals(telaLogin.getTxtSenha())) {
            if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    this.serviceLogin.acesso();
            }
        }else if(e.getSource().equals(telaCadastro.getTxt_email()) || 
            e.getSource().equals(telaCadastro.getTxt_nome()) ||
            e.getSource().equals(telaCadastro.getTxt_senha())){
            if(e.getKeyCode()== KeyEvent.VK_ENTER){
                this.serviceLogin.acessoCadastro();
            }
        }else if(e.getSource().equals(telaMudarSenha.getTxt_confirmaEmail()) || 
            e.getSource().equals(telaMudarSenha.getTxt_novaSenha())){
            if(e.getKeyCode()== KeyEvent.VK_ENTER){
                this.serviceLogin.acessoMudarSenha();
            }}
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
