/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import model.Usuario;
import model.UsuarioDAO;
import view.TelaCadastroEndereco;
import view.TelaEndereco;

/**
 *
 * @author Pedro Paz
 */
public class ServiceEndereco {
    private final TelaEndereco telaEndereco;
    private final TelaCadastroEndereco telaCadastroEndereco;
    private final UsuarioDAO usuarioDAO;
    private final Usuario usuario;
    
    public ServiceEndereco(TelaCadastroEndereco telaCadastroEndereco, TelaEndereco telaEndereco) {
        this.telaCadastroEndereco = telaCadastroEndereco;
        this.telaEndereco = telaEndereco;
        this.usuario = new Usuario();
        this.usuarioDAO = new UsuarioDAO();
    }
    
    public void salvarEndereco() {
        this.usuarioDAO.alterarEndereco(usuario);
    }
    
    public void excluirEndereco() {
        
    }
}
