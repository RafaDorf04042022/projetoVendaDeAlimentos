
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import service.ServicePerfil;
import view.TelaPerfil;
import view.TelaPrincipal;

public class ControlePerfil implements ActionListener{
    
    private final TelaPerfil telaPerfil;
    private final ServicePerfil servicePerfil;

    public ControlePerfil(TelaPrincipal telaPrincipal) {
        this.telaPerfil = new TelaPerfil(telaPrincipal, true);
        this.servicePerfil = new ServicePerfil(telaPerfil);
        addListeners();
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) { //incompleto
        if(e.getSource().equals(telaPerfil.getjButtonEditEmail())){
            this.servicePerfil.trocarEmail();
        }
        else if(e.getSource().equals(telaPerfil.getjButtonMudarSenha())){
            this.servicePerfil.trocarSenha();
        }
        else if(e.getSource().equals(telaPerfil.getjButtonEditarEndereco())){
            this.servicePerfil.trocarEndereco();
        }
    }

    private void addListeners() {
        this.telaPerfil.getjButtonEditEmail().addActionListener(this);
        this.telaPerfil.getjButtonMudarSenha().addActionListener(this);
        this.telaPerfil.getjButtonEditarEndereco().addActionListener(this);
    }
    
}
