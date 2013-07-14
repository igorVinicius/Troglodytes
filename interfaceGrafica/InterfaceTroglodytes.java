/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceGrafica;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class InterfaceTroglodytes extends javax.swing.JFrame {

    
    
    public InterfaceTroglodytes() {
        initComponents();
    }

    private void initComponents() {

        posicao17 = new javax.swing.JLabel();
        posicao00 = new javax.swing.JLabel();
        posicao01 = new javax.swing.JLabel();
        posicao02 = new javax.swing.JLabel();
        posicao03 = new javax.swing.JLabel();
        posicao04 = new javax.swing.JLabel();
        posicao05 = new javax.swing.JLabel();
        posicao06 = new javax.swing.JLabel();
        posicao10 = new javax.swing.JLabel();
        posicao11 = new javax.swing.JLabel();
        posicao12 = new javax.swing.JLabel();
        posicao13 = new javax.swing.JLabel();
        posicao14 = new javax.swing.JLabel();
        posicao15 = new javax.swing.JLabel();
        posicao20 = new javax.swing.JLabel();
        posicao21 = new javax.swing.JLabel();
        posicao22 = new javax.swing.JLabel();
        posicao23 = new javax.swing.JLabel();
        posicao24 = new javax.swing.JLabel();
        posicao25 = new javax.swing.JLabel();
        posicao26 = new javax.swing.JLabel();
        posicao30 = new javax.swing.JLabel();
        posicao31 = new javax.swing.JLabel();
        posicao32 = new javax.swing.JLabel();
        posicao33 = new javax.swing.JLabel();
        posicao34 = new javax.swing.JLabel();
        posicao35 = new javax.swing.JLabel();
        posicao40 = new javax.swing.JLabel();
        posicao41 = new javax.swing.JLabel();
        posicao42 = new javax.swing.JLabel();
        posicao43 = new javax.swing.JLabel();
        posicao44 = new javax.swing.JLabel();
        posicao45 = new javax.swing.JLabel();
        posicao46 = new javax.swing.JLabel();
        posicao50 = new javax.swing.JLabel();
        posicao51 = new javax.swing.JLabel();
        posicao52 = new javax.swing.JLabel();
        posicao53 = new javax.swing.JLabel();
        posicao54 = new javax.swing.JLabel();
        posicao55 = new javax.swing.JLabel();
        posicao60 = new javax.swing.JLabel();
        posicao61 = new javax.swing.JLabel();
        posicao62 = new javax.swing.JLabel();
        posicao63 = new javax.swing.JLabel();
        posicao64 = new javax.swing.JLabel();
        posicao65 = new javax.swing.JLabel();
        posicao66 = new javax.swing.JLabel();
        imagemDeFundo = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        jogarOnline = new javax.swing.JMenu();
        conectar = new javax.swing.JMenuItem();
        iniciarPartida = new javax.swing.JMenuItem();
        desconectar = new javax.swing.JMenuItem();
        sobre = new javax.swing.JMenu();

        posicao17.setIcon(new javax.swing.ImageIcon("C:\\Users\\Marco Antonio\\Desktop\\IMAGENS\\FEITO\\peca.png")); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Troglodytes");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(0, 153, 153));
        setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        posicao00.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        posicao00.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                posicao00MouseClicked(evt);
            }
        });
        
        
        getContentPane().add(posicao00);
        posicao00.setBounds(120, 80, -1, -1);

        posicao01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        posicao01.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                posicao01MouseClicked(evt);
            }
        });
        
        getContentPane().add(posicao01, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, -1, -1));

        posicao02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/trogo1.png"))); // NOI18N
        posicao02.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                posicao02MouseClicked(evt);
            }
        });
        getContentPane().add(posicao02, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, -1, -1));

        posicao03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        posicao03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                posicao03MouseClicked(evt);
            }
        });
        getContentPane().add(posicao03, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, -1, -1));

        posicao04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        getContentPane().add(posicao04, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, -1, -1));

        posicao05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        getContentPane().add(posicao05, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, -1, -1));

        posicao06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        getContentPane().add(posicao06, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, -1, -1));

        posicao10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        getContentPane().add(posicao10, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, -1, -1));

        posicao11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        getContentPane().add(posicao11, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, -1, -1));

        posicao12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        getContentPane().add(posicao12, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, -1, -1));

        posicao13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        getContentPane().add(posicao13, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, -1, -1));

        posicao14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        getContentPane().add(posicao14, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, -1, -1));

        posicao15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        getContentPane().add(posicao15, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, -1, -1));

        posicao20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        getContentPane().add(posicao20, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, -1, -1));

        posicao21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        getContentPane().add(posicao21, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, -1, -1));

        posicao22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        getContentPane().add(posicao22, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, -1, -1));

        posicao23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        getContentPane().add(posicao23, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, -1, -1));

        posicao24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        getContentPane().add(posicao24, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, -1, -1));

        posicao25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        getContentPane().add(posicao25, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, -1, -1));

        posicao26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        getContentPane().add(posicao26, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, -1, -1));

        posicao30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        getContentPane().add(posicao30, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, -1, -1));

        posicao31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        getContentPane().add(posicao31, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, -1, -1));

        posicao32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        getContentPane().add(posicao32, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, -1, -1));

        posicao33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        getContentPane().add(posicao33, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, -1, -1));

        posicao34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        getContentPane().add(posicao34, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, -1, -1));

        posicao35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        getContentPane().add(posicao35, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, -1, -1));

        posicao40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        getContentPane().add(posicao40, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, -1, -1));

        posicao41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        getContentPane().add(posicao41, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, -1, -1));

        posicao42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        getContentPane().add(posicao42, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, -1, -1));

        posicao43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        getContentPane().add(posicao43, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, -1, -1));

        posicao44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        getContentPane().add(posicao44, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, -1, -1));

        posicao45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        getContentPane().add(posicao45, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, -1, -1));

        posicao46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        getContentPane().add(posicao46, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, -1, -1));

        posicao50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        getContentPane().add(posicao50, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, -1, -1));

        posicao51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        getContentPane().add(posicao51, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, -1, -1));

        posicao52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        getContentPane().add(posicao52, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, -1, -1));

        posicao53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        getContentPane().add(posicao53, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, -1, -1));

        posicao54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        getContentPane().add(posicao54, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, -1, -1));

        posicao55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        getContentPane().add(posicao55, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, -1, -1));

        posicao60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        getContentPane().add(posicao60, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, -1, -1));

        posicao61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        getContentPane().add(posicao61, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, -1, -1));

        posicao62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/trogo2.png"))); // NOI18N
        posicao62.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                posicao62MouseClicked(evt);
            }
        });
        getContentPane().add(posicao62, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, -1, -1));

        posicao63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        getContentPane().add(posicao63, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 380, -1, -1));

        posicao64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        getContentPane().add(posicao64, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 380, -1, -1));

        posicao65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        getContentPane().add(posicao65, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 380, -1, -1));

        posicao66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.png"))); // NOI18N
        getContentPane().add(posicao66, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 380, -1, -1));

        imagemDeFundo.setIcon(new javax.swing.ImageIcon("C:\\Users\\Marco Antonio\\Desktop\\IMAGENS\\FEITO - Copia\\modelo.png")); // NOI18N
        // getContentPane().add(imagemDeFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 500));

        
        menu.setBackground(new java.awt.Color(204, 255, 204));
        menu.setBorder(new javax.swing.border.MatteBorder(null));

        jogarOnline.setIcon(new javax.swing.ImageIcon("C:\\Users\\Marco Antonio\\Desktop\\IMAGENS\\FEITO\\jogarOnline.png")); // NOI18N
        jogarOnline.setText("Jogar Online");
        jogarOnline.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        conectar.setFont(new java.awt.Font("Cambria", 1, 13)); // NOI18N
        conectar.setText("Conectar");
        conectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conectarActionPerformed(evt);
            }
        });
        jogarOnline.add(conectar);

        iniciarPartida.setFont(new java.awt.Font("Cambria", 1, 13)); // NOI18N
        iniciarPartida.setText("Iniciar Partida");
        iniciarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarPartidaActionPerformed(evt);
            }
        });
        jogarOnline.add(iniciarPartida);

        desconectar.setFont(new java.awt.Font("Cambria", 1, 13)); // NOI18N
        desconectar.setText("Desconectar");
        jogarOnline.add(desconectar);

        menu.add(jogarOnline);

        sobre.setIcon(new javax.swing.ImageIcon("C:\\Users\\Marco Antonio\\Desktop\\IMAGENS\\FEITO\\sobre.png")); // NOI18N
        sobre.setText("Sobre");
        sobre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        sobre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sobreMouseClicked(evt);
            }
        });
        menu.add(sobre);

        setJMenuBar(menu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void posicao01MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_posicao01MouseClicked
             
    }//GEN-LAST:event_posicao01MouseClicked

    private void posicao00MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_posicao00MouseClicked
        

    }//GEN-LAST:event_posicao00MouseClicked

    private void iniciarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarPartidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iniciarPartidaActionPerformed

    private void conectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conectarActionPerformed
      
    }//GEN-LAST:event_conectarActionPerformed

    private void sobreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sobreMouseClicked
        Sobre frame = new Sobre();  
        frame.setVisible(true);  
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }//GEN-LAST:event_sobreMouseClicked

    private void posicao03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_posicao03MouseClicked
    }//GEN-LAST:event_posicao03MouseClicked

    private void posicao02MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_posicao02MouseClicked
        Icon trog1Selecionado = new ImageIcon(getClass().getResource("/imagens/trog1Selecionado.png"));
        posicao02.setIcon(trog1Selecionado);	        
    }//GEN-LAST:event_posicao02MouseClicked

    private void posicao62MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_posicao62MouseClicked
        Icon trog2Selecionado = new ImageIcon(getClass().getResource("/imagens/trog2Selecionado.png"));
        posicao62.setIcon(trog2Selecionado);
    }//GEN-LAST:event_posicao62MouseClicked

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
            java.util.logging.Logger.getLogger(InterfaceTroglodytes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceTroglodytes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceTroglodytes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceTroglodytes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceTroglodytes().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem conectar;
    private javax.swing.JMenuItem desconectar;
    private javax.swing.JLabel imagemDeFundo;
    private javax.swing.JMenuItem iniciarPartida;
    private javax.swing.JMenu jogarOnline;
    private javax.swing.JMenuBar menu;
    private javax.swing.JLabel posicao00;
    private javax.swing.JLabel posicao01;
    private javax.swing.JLabel posicao02;
    private javax.swing.JLabel posicao03;
    private javax.swing.JLabel posicao04;
    private javax.swing.JLabel posicao05;
    private javax.swing.JLabel posicao06;
    private javax.swing.JLabel posicao10;
    private javax.swing.JLabel posicao11;
    private javax.swing.JLabel posicao12;
    private javax.swing.JLabel posicao13;
    private javax.swing.JLabel posicao14;
    private javax.swing.JLabel posicao15;
    private javax.swing.JLabel posicao17;
    private javax.swing.JLabel posicao20;
    private javax.swing.JLabel posicao21;
    private javax.swing.JLabel posicao22;
    private javax.swing.JLabel posicao23;
    private javax.swing.JLabel posicao24;
    private javax.swing.JLabel posicao25;
    private javax.swing.JLabel posicao26;
    private javax.swing.JLabel posicao30;
    private javax.swing.JLabel posicao31;
    private javax.swing.JLabel posicao32;
    private javax.swing.JLabel posicao33;
    private javax.swing.JLabel posicao34;
    private javax.swing.JLabel posicao35;
    private javax.swing.JLabel posicao40;
    private javax.swing.JLabel posicao41;
    private javax.swing.JLabel posicao42;
    private javax.swing.JLabel posicao43;
    private javax.swing.JLabel posicao44;
    private javax.swing.JLabel posicao45;
    private javax.swing.JLabel posicao46;
    private javax.swing.JLabel posicao50;
    private javax.swing.JLabel posicao51;
    private javax.swing.JLabel posicao52;
    private javax.swing.JLabel posicao53;
    private javax.swing.JLabel posicao54;
    private javax.swing.JLabel posicao55;
    private javax.swing.JLabel posicao60;
    private javax.swing.JLabel posicao61;
    private javax.swing.JLabel posicao62;
    private javax.swing.JLabel posicao63;
    private javax.swing.JLabel posicao64;
    private javax.swing.JLabel posicao65;
    private javax.swing.JLabel posicao66;
    private javax.swing.JMenu sobre;
    // End of variables declaration//GEN-END:variables
}
