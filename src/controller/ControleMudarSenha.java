
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

//import view.TelaMudarSenha;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import service.ServiceMudarSenha;
import view.TelaMudarSenha;

/**
 *
 * @author Ana Luiza
 */
public class ControleMudarSenha implements ActionListener, KeyListener{
     private final TelaMudarSenha telaRecuperacao;
     private ServiceMudarSenha serviceMudarSenha;
     
    public ControleMudarSenha() {
      this.telaRecuperacao = new TelaMudarSenha(null, true);
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
             
             this.serviceMudarSenha.acesso();
             this.serviceMudarSenha.mudarSenha();
             
        }else if(e.getSource().equals(this.telaRecuperacao.getBtn_limpa())){
          
            this.serviceMudarSenha.limpar();
          
        }else if(e.getSource().equals(this.telaRecuperacao.getBtn_volta())){
          
            this.serviceMudarSenha.voltar();
            
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
