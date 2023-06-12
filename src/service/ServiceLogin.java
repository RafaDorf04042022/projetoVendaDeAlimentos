/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import model.DAO.UsuarioDAO;
import model.database.ConnectionFactory;
import model.database.DatabaseMySQL;
import model.domain.Usuario;
import model.util.Sessao;

/**
 *
 * @author Pedro Paz
 */
public class ServiceLogin {
    
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
    private Usuario usuario;
    
    public void createConexao() {
        ConnectionFactory.createDatabase(new DatabaseMySQL());
    }
    
    public boolean checkAccess(String email, String senha) {
        return(usuarioDAO.acesso(email, senha).getId()>0);
    }
    
    public boolean checkUsuarioporNome(String nome) {
        usuario = usuarioDAO.pesquisarNome(nome);
        return usuario.getNomeLogin().equals(nome);
    }
    
    public boolean checkUsuarioporEmail(String email) {
        usuario = usuarioDAO.pesquisarporEmail(email);
        return usuario.getEmail().equals(email);
    }
    
    public void alterarSenha(String email) {
        usuario = usuarioDAO.pesquisarporEmail(email);
        usuarioDAO.alterarSenha(usuario);
    }
    
    public void enviarEmail(String novasenha) {
        Sessao.setUsuarioLogado(usuario.getEmail());
        usuario.setSenha(novasenha);
        gerarEmail();
    }
    
    private void gerarEmail() {
        
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.port", "465");
        
        Session sessao = Session.getDefaultInstance(prop,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication(){
                        return new PasswordAuthentication("seuemail@gmail.com", "suasenha");
                    }    
                });
        
        sessao.setDebug(true);
        
        try{
            Message msg = new MimeMessage(sessao);
            msg.setFrom(new InternetAddress("seuemail@gmail.com"));
            
            Address[] toUSer = InternetAddress.parse(this.usuario.getEmail());
            
            msg.setRecipients(Message.RecipientType.TO, toUSer);
            msg.setSubject("Recuperação de Senha - Sistema");
            msg.setText("Seu código de recuperação: " + this.gerarCodigoRecuperacao());
            
            Transport.send(msg);
            
            System.out.println("Código de recuperação enviado para seu e-mail!");
            
        } catch(MessagingException e){
            throw new RuntimeException(e);
        }
        
    }
    
    private int gerarCodigoRecuperacao() {
        int codigoRecuperacao = (int) (Math.random() * 1000000);
        Sessao.setCodigoRecuperacao(codigoRecuperacao);
        return codigoRecuperacao;
    }
}
