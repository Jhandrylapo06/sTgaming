/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.JuegoJpaController;
import java.util.List;

/**
 *
 * @author Usuario iTC
 */
public class Tienda extends javax.swing.JFrame {

    /**
     * Creates new form AnadirJuego
     */
    public Tienda(int id,int iduser) {
        initComponents();
        setResizable(false);
        setLocation(800, 200);
        
        Controlador.JuegoJpaController cjuego= new JuegoJpaController();
        List<Entidades.Juego> listaJ = cjuego.findJuegoEntities();
        for (int i = 0; i < listaJ.size(); i++) {
            if(id==listaJ.get(i).getIdJuego()){
                lblPrecioTotal.setText(listaJ.get(i).getPrecio());
            }
        }
    }

    private Tienda() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        JPProcesoCompra = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNumtarjeta = new javax.swing.JTextField();
        lblPrecioTotal = new javax.swing.JTextField();
        btnVisa = new javax.swing.JRadioButton();
        btnMastercard = new javax.swing.JRadioButton();
        btnDinerscllub = new javax.swing.JRadioButton();
        btnConfirmarCompra = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txtfVencimiento = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(6, 11, 25));

        JPProcesoCompra.setBackground(new java.awt.Color(6, 11, 25));
        JPProcesoCompra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Candara Light", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("PRECIO TOTAL A PAGAR");
        JPProcesoCompra.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, -1, -1));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Candara Light", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("PROCEDER A LA COMPRA");
        JPProcesoCompra.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, -1));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Candara Light", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setText("NUMERO DE TARJETA");
        JPProcesoCompra.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Candara Light", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setText("AUTHORIZED SIGNATURE");
        JPProcesoCompra.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, -1, -1));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Candara Light", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 204, 204));
        jLabel15.setText("AÑO DE VENCIMIENTO");
        JPProcesoCompra.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, -1, -1));

        txtCodigo.setBackground(new java.awt.Color(6, 11, 25));
        txtCodigo.setFont(new java.awt.Font("Candara Light", 0, 14)); // NOI18N
        txtCodigo.setForeground(new java.awt.Color(255, 255, 255));
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });
        JPProcesoCompra.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 460, -1));

        txtNumtarjeta.setBackground(new java.awt.Color(6, 11, 25));
        txtNumtarjeta.setFont(new java.awt.Font("Candara Light", 0, 14)); // NOI18N
        txtNumtarjeta.setForeground(new java.awt.Color(255, 255, 255));
        txtNumtarjeta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumtarjeta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumtarjetaKeyTyped(evt);
            }
        });
        JPProcesoCompra.add(txtNumtarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 460, -1));

        lblPrecioTotal.setEditable(false);
        lblPrecioTotal.setBackground(new java.awt.Color(6, 11, 25));
        lblPrecioTotal.setFont(new java.awt.Font("Candara Light", 0, 14)); // NOI18N
        lblPrecioTotal.setForeground(new java.awt.Color(255, 255, 255));
        lblPrecioTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblPrecioTotal.setText("99.99");
        lblPrecioTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblPrecioTotalActionPerformed(evt);
            }
        });
        JPProcesoCompra.add(lblPrecioTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 440, 460, -1));

        btnVisa.setBackground(new java.awt.Color(6, 11, 25));
        buttonGroup1.add(btnVisa);
        btnVisa.setForeground(new java.awt.Color(204, 204, 204));
        btnVisa.setText("VISA");
        btnVisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisaActionPerformed(evt);
            }
        });
        JPProcesoCompra.add(btnVisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, -1, -1));

        btnMastercard.setBackground(new java.awt.Color(6, 11, 25));
        buttonGroup1.add(btnMastercard);
        btnMastercard.setForeground(new java.awt.Color(204, 204, 204));
        btnMastercard.setText("MASTERCARD");
        btnMastercard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMastercardActionPerformed(evt);
            }
        });
        JPProcesoCompra.add(btnMastercard, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 360, -1, -1));

        btnDinerscllub.setBackground(new java.awt.Color(6, 11, 25));
        buttonGroup1.add(btnDinerscllub);
        btnDinerscllub.setForeground(new java.awt.Color(204, 204, 204));
        btnDinerscllub.setText("DINERSCLUB");
        JPProcesoCompra.add(btnDinerscllub, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 360, -1, -1));

        btnConfirmarCompra.setBackground(new java.awt.Color(6, 11, 25));
        btnConfirmarCompra.setFont(new java.awt.Font("Candara Light", 1, 28)); // NOI18N
        btnConfirmarCompra.setForeground(new java.awt.Color(204, 204, 204));
        btnConfirmarCompra.setText("CONFIMAR");
        btnConfirmarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarCompraActionPerformed(evt);
            }
        });
        JPProcesoCompra.add(btnConfirmarCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 510, 400, 70));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Candara Light", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 204, 204));
        jLabel16.setText("TIPO DE TARJETA");
        JPProcesoCompra.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, -1, -1));

        txtfVencimiento.setBackground(new java.awt.Color(6, 11, 25));
        txtfVencimiento.setFont(new java.awt.Font("Candara Light", 0, 14)); // NOI18N
        txtfVencimiento.setForeground(new java.awt.Color(255, 255, 255));
        txtfVencimiento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtfVencimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfVencimientoKeyTyped(evt);
            }
        });
        JPProcesoCompra.add(txtfVencimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 460, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPProcesoCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 1027, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPProcesoCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarCompraActionPerformed
        
        
        this.setVisible(false);
        
                
    }//GEN-LAST:event_btnConfirmarCompraActionPerformed

    private void btnVisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVisaActionPerformed

    private void btnMastercardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMastercardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMastercardActionPerformed

    private void lblPrecioTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblPrecioTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblPrecioTotalActionPerformed

    private void txtNumtarjetaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumtarjetaKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtNumtarjetaKeyTyped

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtCodigoKeyTyped

    private void txtfVencimientoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfVencimientoKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtfVencimientoKeyTyped

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
            java.util.logging.Logger.getLogger(Tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tienda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPProcesoCompra;
    private javax.swing.JButton btnConfirmarCompra;
    private javax.swing.JRadioButton btnDinerscllub;
    private javax.swing.JRadioButton btnMastercard;
    private javax.swing.JRadioButton btnVisa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JTextField lblPrecioTotal;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNumtarjeta;
    private javax.swing.JTextField txtfVencimiento;
    // End of variables declaration//GEN-END:variables
}
