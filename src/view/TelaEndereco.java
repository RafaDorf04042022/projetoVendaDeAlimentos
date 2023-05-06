/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Heber
 */
public class TelaEndereco extends javax.swing.JDialog {

    /**
     * Creates new form TelaEnderecos
     */
    public TelaEndereco(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public JButton getjButtonEditar() {
        return jButtonEditar;
    }

    public JButton getjButtonExcluir() {
        return jButtonExcluir;
    }

    public JLabel getjLabelNomeDaCidade() {
        return jLabelNomeDaCidade;
    }

    public JLabel getjLabelNomeDaRua() {
        return jLabelNomeDaRua;
    }

    public JLabel getjLabelNomeDoBairro() {
        return jLabelNomeDoBairro;
    }

    public JLabel getjLabelNomeEndereço() {
        return jLabelNomeEndereço;
    }

    public JLabel getjLabelNomeUF() {
        return jLabelNomeUF;
    }

    public JLabel getjLabelNumero() {
        return jLabelNumero;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelNomeExibido = new javax.swing.JLabel();
        jLabelIndicadorNumero = new javax.swing.JLabel();
        jLabelRua = new javax.swing.JLabel();
        jLabelBairro = new javax.swing.JLabel();
        jLabelCidade = new javax.swing.JLabel();
        jLabelUF = new javax.swing.JLabel();
        jButtonExcluir = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jLabelNumero = new javax.swing.JLabel();
        jLabelNomeDaRua = new javax.swing.JLabel();
        jLabelNomeDoBairro = new javax.swing.JLabel();
        jLabelNomeDaCidade = new javax.swing.JLabel();
        jLabelNomeUF = new javax.swing.JLabel();
        jLabelNomeEndereço = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelNomeExibido.setText("Nome de exibição:");

        jLabelIndicadorNumero.setText("Numero:");

        jLabelRua.setText("Rua:");

        jLabelBairro.setText("Bairro:");

        jLabelCidade.setText("Cidade:");

        jLabelUF.setText("UF:");

        jButtonExcluir.setText("Excluir");

        jButtonEditar.setText("Editar");

        jLabelNumero.setText("00");

        jLabelNomeDaRua.setText("nome da rua");

        jLabelNomeDoBairro.setText("nome do bairro");

        jLabelNomeDaCidade.setText("nome da cidade");

        jLabelNomeUF.setText("nome do estado");

        jLabelNomeEndereço.setText("nome do endereço");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelNomeExibido)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelNomeEndereço))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCidade)
                            .addComponent(jLabelBairro)
                            .addComponent(jLabelUF)
                            .addComponent(jLabelRua))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNomeDaRua)
                            .addComponent(jLabelNomeUF)
                            .addComponent(jLabelNomeDoBairro)
                            .addComponent(jLabelNomeDaCidade))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonExcluir)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabelIndicadorNumero)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelNumero))))
                            .addComponent(jButtonEditar, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNomeExibido)
                    .addComponent(jLabelNomeEndereço))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRua)
                    .addComponent(jLabelIndicadorNumero)
                    .addComponent(jLabelNumero)
                    .addComponent(jLabelNomeDaRua))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelBairro)
                    .addComponent(jLabelNomeDoBairro))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCidade)
                    .addComponent(jButtonEditar)
                    .addComponent(jLabelNomeDaCidade))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUF)
                    .addComponent(jButtonExcluir)
                    .addComponent(jLabelNomeUF))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaEndereco dialog = new TelaEndereco(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JLabel jLabelBairro;
    private javax.swing.JLabel jLabelCidade;
    private javax.swing.JLabel jLabelIndicadorNumero;
    private javax.swing.JLabel jLabelNomeDaCidade;
    private javax.swing.JLabel jLabelNomeDaRua;
    private javax.swing.JLabel jLabelNomeDoBairro;
    private javax.swing.JLabel jLabelNomeEndereço;
    private javax.swing.JLabel jLabelNomeExibido;
    private javax.swing.JLabel jLabelNomeUF;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelRua;
    private javax.swing.JLabel jLabelUF;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
