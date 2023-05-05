
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.TelaPerfil;

public class ControlePerfil implements ActionListener{
    private final TelaPerfil telaPerfil;

    public ControlePerfil() {
        this.telaPerfil = new TelaPerfil(null, true);
        
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) { //incompleto
        if(e.getSource().equals(telaPerfil.getjButtonEditEmail())){
            JOptionPane.showMessageDialog(telaPerfil, "função de trocar email... ainda n implementado: classe ControlePerfil linha 26");
        }else if(e.getSource().equals(telaPerfil.getjButtonMudarSenha())){
            JOptionPane.showMessageDialog(telaPerfil, "função de trocar senha... ainda n implementado: classe ControlePerfil linha 28");
        }else if(e.getSource().equals(telaPerfil.getjListEnderecos())){
            JOptionPane.showMessageDialog(telaPerfil, "Tela de endereços... ainda n implementado: classe ControlePerfil linha 30");
        }
    }
    
}
