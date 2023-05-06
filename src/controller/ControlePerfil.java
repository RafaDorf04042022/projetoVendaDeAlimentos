
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.TelaPerfil;
import view.TelaPrincipal;

public class ControlePerfil implements ActionListener{
    private final TelaPerfil telaPerfil;

    public ControlePerfil(TelaPrincipal telaPrincipal) {
        this.telaPerfil = new TelaPerfil(telaPrincipal, true);
        addListeners();
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) { //incompleto
        if(e.getSource().equals(telaPerfil.getjButtonEditEmail())){
            //service para tela de trocar email
        }
        if(e.getSource().equals(telaPerfil.getjButtonMudarSenha())){
            //service para tela de trocar senha
        }
        if(e.getSource().equals(telaPerfil.getjButtonEditarEndereco())){
            //service para Tela de endereços
        }
    }

    private void addListeners() {
        this.telaPerfil.getjButtonEditEmail().addActionListener(this);
        this.telaPerfil.getjButtonMudarSenha().addActionListener(this);
        this.telaPerfil.getjButtonEditarEndereco().addActionListener(this);
    }
    
}
