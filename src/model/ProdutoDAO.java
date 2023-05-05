/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Pedro Paz
 */
public class ProdutoDAO {
    public int inserir(Produto produto) {
        String sql = "INSERT INTO produto (descricao, preco, nome) VALUES (?,?,?)";
        
            PreparedStatement pst;
            ResultSet st;
            int lastId = 0;
            
            try {
                pst = Conexao.getConexao().prepareStatement(sql);
                pst.setString(1, produto.getDescricao());
                pst.setFloat(2, produto.getPreco());
                pst.setString(3, produto.getNome());
                pst.execute();
                st = pst.getGeneratedKeys();
                if(st.next()) {
                    lastId = st.getInt("id");
                }
                pst.close();
                st.close();
            } catch(SQLException ex) {
                System.out.println(ex);
            }
            
            return lastId;
    }
    
    public void alterar(Produto produto) {
        String sql = "UPDATE produto SET descricao = ?, preco = ?, nome = ? WHERE id = ?";
        
        PreparedStatement pst;
        try{
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, produto.getDescricao());
            pst.setFloat(2, produto.getPreco());
            pst.setString(3, produto.getNome());
            pst.setInt(4, produto.getId());
            pst.execute();
            pst.close();
        }catch (SQLException ex){
            System.out.println(ex);
        }
        
    }
    
    public boolean excluir(Produto produto) {
        String sql = "DELETE FROM produto WHERE id = ?";
        PreparedStatement pst;
        
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setInt(1, produto.getId());
            pst.execute();
            pst.close();
            
        }catch (SQLException ex){
            System.out.println(ex);
            return false;
        }
        
        return true;
    }
    
    //Agora um método de pesquisa por Nome
    public ArrayList<Produto> pesquisar(String descricao) {
        String sql = "SELECT * FROM produto WHERE descricao LIKE ? ORDER BY descricao,preco,nome";
        
        ArrayList<Produto> lista = new ArrayList<>();
        
        PreparedStatement pst;
        ResultSet st;
        
        try{
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, "%" + descricao + "%");
            st = pst.executeQuery();
            
            while(st.next()) {
                Produto produto = new Produto();
                produto.setId(st.getInt("id"));
                produto.setDescricao(st.getString("descricao"));
                produto.setPreco(st.getFloat("preco"));
                produto.setNome(st.getString("nome"));
                lista.add(produto);
            }
            
            st.close();
            pst.close();
            
        }catch(SQLException ex){
            System.out.println(ex);
        }
        
        return lista;
    }
    
    //Pesquisa por ID
    public Produto pesquisar(int id) {
        String sql = "SELECT * FROM produto WHERE id = ?";
        
        Produto produto = new Produto();
        
        PreparedStatement pst;
        ResultSet st;
        
        try{
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setInt(1, id);
            st = pst.executeQuery();
            
            if(st.next()){
                produto.setId(st.getInt("id"));
                produto.setDescricao(st.getString("descricao"));
                produto.setPreco(st.getFloat("preco"));
                produto.setNome(st.getString("nome"));
            }
            st.close();
            pst.close();
            
        }catch(SQLException ex) {
            System.out.println(ex);
        }
        
        return produto;
    }
    
    //Método de listar produtos
    public ArrayList<Produto> listar() {
        String sql = "SELECT * FROM produto ORDER BY descricao, preco, nome";
        
        ArrayList<Produto> lista = new ArrayList<>();
        
        PreparedStatement pst;
        ResultSet st;
        
        try{
            pst = Conexao.getConexao().prepareStatement(sql);
            st = pst.executeQuery();
            
            while(st.next()) {
                Produto produto = new Produto();
                produto.setId(st.getInt("id"));
                produto.setDescricao(st.getString("descricao"));
                produto.setPreco(st.getFloat("preco"));
                produto.setNome(st.getString("nome"));
                lista.add(produto);
            }
            st.close();
            pst.close();
            
        }catch(SQLException ex){
            System.out.println(ex);
        }
        
        return lista;
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
            pst.setString(2, "produto");
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
    
}
