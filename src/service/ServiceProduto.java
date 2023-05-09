/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Produto;
import model.ProdutoDAO;
import view.TelaProduto;
import view.TelaPrincipal;

/**
 *
 * @author Pedro Paz
 */
public class ServiceProduto {
    private final TelaProduto telaAlimentos;
    private final Produto produto;
    private final ProdutoDAO produtoDAO;
    private int id;
    
    public ServiceProduto(TelaProduto telaAlimentos) {
        this.telaAlimentos = telaAlimentos;
        this.produto = new Produto();
        this.produtoDAO= new ProdutoDAO();
    }
    
    public void listar() {
        this.produtoDAO.listar();
    }
    
    private void listaDados(ArrayList<Produto> listaprodutos) {
        telaAlimentos.limparTabela();
        for(int i=0;i<listaprodutos.size();i++) {
            telaAlimentos.adicionaItem(
                listaprodutos.get(i).getId(),
                listaprodutos.get(i).getDescricao(),
                listaprodutos.get(i).getPreco());
        }
    }
    public void salvar() {
        if(validaCampos()) {
            Produto p = new Produto();
            
            p.setNome(this.telaAlimentos.getTxtNome().getText());
            p.setPreco(Float.parseFloat(this.telaAlimentos.getTxtPreco().getText()));
            p.setDescricao(this.telaAlimentos.getTxtDescricao().getText());
            
            produtoDAO.inserir(p);
            
        }else{
            JOptionPane.showMessageDialog(telaAlimentos, "Preencha todos os campos!","Erro",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private boolean validaCampos() {
        if(this.telaAlimentos.getTxtNome().getText().equals("")) {
            return false;
        } else if(this.telaAlimentos.getTxtPreco().getText().equals("")) {
            return false;
        } else if(this.telaAlimentos.getTxtDescricao().getText().equals("")) {
            return false;
        } else {
            return true;
        }
    }
    
    public void editar() {
        int item = telaAlimentos.getTblProdutos().getSelectedRow();
        if(item>=0) {
            this.id = (int)telaAlimentos.getModelo().getValueAt(item, 0);
            Produto p = produtoDAO.pesquisar(this.id);
            produtoDAO.alterar(p);
        } else {
            JOptionPane.showMessageDialog(telaAlimentos, "Selecione um item");
        }
    }
    
    public void excluir() {
        int item = telaAlimentos.getTblProdutos().getSelectedRow();
        if(item>=0) {
            if(JOptionPane.showConfirmDialog(telaAlimentos, "Deseja realmente excluir?", "Confirmação de exclusão", 
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
                Produto produto = new Produto();
                produto.setId((int)telaAlimentos.getModelo().getValueAt(item, 0));
                if(produtoDAO.excluir(produto)) {
                    telaAlimentos.getModelo().removeRow(item);
                }
            }
        } else {
            JOptionPane.showMessageDialog(telaAlimentos, "Selecione um item");
        }
    }
    
    public void voltar() {
        this.telaAlimentos.setVisible(false);
        TelaPrincipal telaPrincipal = new TelaPrincipal();
    }
}
