/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import model.DAO.ProdutoDAO;
import model.database.ConnectionFactory;
import model.database.DatabaseMySQL;
import model.domain.Produto;

/**
 *
 * @author Pedro PAz
 */
public class ServiceProduto {
    
    private final ProdutoDAO produtoDAO = new ProdutoDAO();
    private Produto produto;
    
    public void createConexao() {
        ConnectionFactory.createDatabase(new DatabaseMySQL());
    }
    
    public boolean checkProdutoporId(int id) {
        produto = produtoDAO.pesquisarId(id);
        return produto.getId()==(id);
    }
}
