/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceGrafica;

import javax.security.auth.callback.TextOutputCallback;
import javax.swing.JTextField;

/**
 *
 * @author Marco Antonio
 */
public class Sobre extends javax.swing.JFrame {

    /**
     * Creates new form Sobre
     */
    public Sobre() {
        initComponents();
    }

    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logoUfsc = new javax.swing.JLabel();
        nomeAPS = new javax.swing.JLabel();
        nomeTrogo = new javax.swing.JLabel();
        nomeAutores = new javax.swing.JLabel();
        nomeMarco = new javax.swing.JLabel();
        nomePedro = new javax.swing.JLabel();
        nomeTurma = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sobre");

        logoUfsc.setIcon(new javax.swing.ImageIcon("C:\\Users\\Marco Antonio\\Desktop\\IMAGENS\\FEITO\\ufsc.png")); // NOI18N

        nomeAPS.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        nomeAPS.setText("Análise e Projeto de Sistemas");

        nomeTrogo.setFont(new java.awt.Font("Cambria", 1, 20)); // NOI18N
        nomeTrogo.setText("Troglodytes");

        nomeAutores.setFont(new java.awt.Font("Calibri", 2, 14)); // NOI18N
        nomeAutores.setText("Autores: Igor Vinicius Tibúrcio");

        nomeMarco.setFont(new java.awt.Font("Calibri", 2, 14)); // NOI18N
        nomeMarco.setText("Marco Antônio Burgin Gomes da Cunha");

        nomePedro.setFont(new java.awt.Font("Calibri", 2, 14)); // NOI18N
        nomePedro.setText("Pedro Maurício Sanches");

        nomeTurma.setFont(new java.awt.Font("Calibri", 2, 14)); // NOI18N
        nomeTurma.setText("Turma 2013/1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(logoUfsc, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomeAPS)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(nomeTrogo))
                    .addComponent(nomeMarco)
                    .addComponent(nomeAutores)
                    .addComponent(nomePedro)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(nomeTurma)))
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nomeAPS)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(nomeTrogo)
                        .addGap(18, 18, 18)
                        .addComponent(nomeAutores)
                        .addGap(4, 4, 4)
                        .addComponent(nomeMarco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomePedro))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(logoUfsc)))
                .addGap(18, 18, 18)
                .addComponent(nomeTurma)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
            java.util.logging.Logger.getLogger(Sobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sobre().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel logoUfsc;
    private javax.swing.JLabel nomeAPS;
    private javax.swing.JLabel nomeAutores;
    private javax.swing.JLabel nomeMarco;
    private javax.swing.JLabel nomePedro;
    private javax.swing.JLabel nomeTrogo;
    private javax.swing.JLabel nomeTurma;
    // End of variables declaration//GEN-END:variables
}