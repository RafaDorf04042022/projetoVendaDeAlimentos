
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

//import view.TelaRecuperacao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import view.TelaRecuperacao;

/**
 *
 * @author Ana Luiza
 */
public class ControleTelaRecuperacao implements ActionListener, KeyListener{
     private final TelaRecuperacao telaRecuperacao;
  
    public ControleTelaRecuperacao() {
      this.telaRecuperacao = new TelaRecuperacao(null, true);
      addListeners();
      this.telaRecuperacao.setVisible(true);
    
   }

    private void addListeners(){
       this.telaRecuperacao.getBtn_concluir().addActionListener(this);
       this.telaRecuperacao.getBtn_limpa().addActionListener(this);
       this.telaRecuperacao.getBtn_volta().addActionListener(this);
       this.telaRecuperacao.getTxt_confirmaEmail().addActionListener(this);
       this.telaRecuperacao.getTxt_novaSenha().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource().equals(this.telaRecuperacao.getBtn_concluir())){
          //Colocar Service acesso
        }else if(e.getSource().equals(this.telaRecuperacao.getBtn_limpa())){
          //Colocar Service limpar
        }else if(e.getSource().equals(this.telaRecuperacao.getBtn_volta())){
          //Colocar Service sair
        }
    
    }


    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyPressed(KeyEvent e) {

}

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
