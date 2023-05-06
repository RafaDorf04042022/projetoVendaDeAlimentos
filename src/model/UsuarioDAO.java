/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Pedro Paz
 */
public class UsuarioDAO {
    public int cadastrar(Usuario usuario) {
        String sql = "INSERT * INTO usuario (nome, email, senha, endereco) VALUES (?, ?, ?, ?)";
        
        PreparedStatement pst;
        ResultSet st;
        int lastId = 0;
        
        try{
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, usuario.getNomeLogin());
            pst.setString(2, usuario.getEmail());
            pst.setString(3, usuario.getSenha());
            pst.setString(4, usuario.getEndereco());
            pst.execute();
            st = pst.getGeneratedKeys();
            
            if(st.next()) {
               lastId = st.getInt("id"); 
            }
            pst.close();
            st.close();
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return lastId;
    }
    
    public void alterar(Usuario usuario) {
        String sql = "UPDATE usuario SET nome = ?, email = ? WHERE id = ?";
        PreparedStatement pst;
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, usuario.getNomeLogin());
            pst.setString(2, usuario.getEmail());
            pst.setString(3, usuario.getEndereco());
            pst.setInt(4, usuario.getId());
            pst.execute();
            pst.close();
            
        }catch(SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public boolean excluir(Usuario usuario) {
        String sql = "DELETE FROM usuario WHERE id = ?";
        PreparedStatement pst;
        
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setInt(1, usuario.getId());
            pst.execute();
            pst.close();
        }catch(SQLException ex) {
            System.out.println(ex);
            return false;
        }
        return true;
    }
    
    public Usuario acesso(String email, String senha) {
        String sql = "SELECT * FROM usuario WHERE login = ? AND senha = md5(?)";
        Usuario usuario = new Usuario();
        
        PreparedStatement pst;
        ResultSet st;
        
        try{
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, email);
            pst.setString(2, senha);
            st = pst.executeQuery();
            
            while (st.next()) {
                usuario.setId(st.getInt("id"));
                usuario.setNomeLogin(st.getString("nome"));
                usuario.setEmail(st.getString("email"));
                usuario.setSenha(st.getString("senha"));
            }
            
            st.close();
            pst.close();
            
        }catch(SQLException ex) {
            throw new RuntimeException(ex);
        }
        
        return usuario;
    }
    
    public int nextId() {
        String sql = "SELECT AUTO_INCREMENT AS ID FROM INFORMATION_SCHEMA.TABLES " +
                "WHERE TABLE_SCHEMA = ? AND TABLE_NAME = ?";
        
        int id = 0;
        PreparedStatement pst;
        ResultSet st;
        
        try{
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, "bd_comidas");
            pst.setString(2, "usuario");
            st = pst.executeQuery();
            
            if(st.next()) {
                id = st.getInt("ID");
            }
            st.close();
            pst.close();
            
        }catch(SQLException ex) {
            System.out.println(ex);
        }
        return id;
    }
        
    public void alterarSenha(Usuario usuario) {
        String sql = "UPDATE usuario SET senha = md5(?) WHERE email LIKE ?";
        
        PreparedStatement pst;
        try{
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, usuario.getSenha());
            pst.setString(2, usuario.getEmail());
            pst.execute();
            pst.close();
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
            
    public void alterarEmail(Usuario usuario) {
        String sql = "UPDATE usuario SET email LIKE ?";
        
        PreparedStatement pst;
        try{
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, usuario.getEmail());
            pst.execute();
            pst.close();
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
            
    public void alterarSenhaPerfil(Usuario usuario) {
        String sql = "UPDATE usuario SET senha = md5(?)";
        
        PreparedStatement pst;
        try{
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, usuario.getSenha());
            pst.execute();
            pst.close();
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }  
     public void alterarEndereco(Usuario usuario) {
        String sql = "UPDATE usuario SET endereco = md5(?)";
        
        PreparedStatement pst;
        try{
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, usuario.getEndereco());
            pst.execute();
            pst.close();
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
}
