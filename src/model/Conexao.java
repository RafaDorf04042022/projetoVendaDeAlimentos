/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Pedro Paz
 */
public class Conexao {
    
    private static Connection conexao;
    
    public static Connection getConexao() {
        if(conexao == null) {
            try{
                conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco",
                        "root", "ifbairece01");
            }catch(SQLException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados", "Erro", 0);
                System.out.println(ex);
            }
        }
        return conexao;
    }
    
}
