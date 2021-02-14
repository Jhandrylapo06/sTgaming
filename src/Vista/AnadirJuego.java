/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ClasificacionJpaController;
import Controlador.JuegoJpaController;
import Controlador.ValoracionJpaController;
import Entidades.Clasificacion;
import Entidades.Juego;
import Entidades.Valoracion;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario iTC
 */
public class AnadirJuego extends javax.swing.JFrame {

    /**
     * Creates new form AnadirJuego
     */
    Controlador.JuegoJpaController cjuego = new JuegoJpaController();
    Controlador.ClasificacionJpaController cclasificacion=new ClasificacionJpaController();
    Controlador.ValoracionJpaController cvaloracion= new ValoracionJpaController();
    boolean verificar;
    
    Entidades.Juego juego = null;
    public AnadirJuego() {
        initComponents();
        setResizable(false);
        setLocation(800, 200);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        PanelNuevoJuego = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtPrecioJuego = new javax.swing.JTextField();
        txtTituloJuego = new javax.swing.JTextField();
        SPdes = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        txtRutaarchivo = new javax.swing.JTextField();
        SCRR = new javax.swing.JScrollPane();
        txtRequerimientosRe = new javax.swing.JTextArea();
        txtrutaportada = new javax.swing.JTextField();
        btnAccion = new javax.swing.JRadioButton();
        btnTerror = new javax.swing.JRadioButton();
        btnAventura = new javax.swing.JRadioButton();
        btnMultijugador = new javax.swing.JRadioButton();
        btnMundoAbierto = new javax.swing.JRadioButton();
        btnGuardarJuego = new javax.swing.JButton();
        SPRM = new javax.swing.JScrollPane();
        txtRequerimientosMin = new javax.swing.JTextArea();
        jLabel20 = new javax.swing.JLabel();
        txtrutaportada1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nuevo juego");
        setBackground(new java.awt.Color(6, 11, 25));

        PanelNuevoJuego.setBackground(new java.awt.Color(6, 11, 25));
        PanelNuevoJuego.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Candara Light", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("CLASIFICACION");
        PanelNuevoJuego.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 660, -1, -1));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Candara Light", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("NUEVO JUEGO");
        PanelNuevoJuego.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, -1));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Candara Light", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setText("TITULO");
        PanelNuevoJuego.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Candara Light", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setText("PRECIO$");
        PanelNuevoJuego.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, -1, -1));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Candara Light", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 204, 204));
        jLabel15.setText("DESCRIPCION");
        PanelNuevoJuego.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, -1, -1));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Candara Light", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 204, 204));
        jLabel16.setText("IMAGEN");
        PanelNuevoJuego.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, -1, -1));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Candara Light", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 204, 204));
        jLabel17.setText("REQUISITOS MINIMOS");
        PanelNuevoJuego.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, -1, -1));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Candara Light", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 204, 204));
        jLabel18.setText("REQUISITOS RECOMENDADOS");
        PanelNuevoJuego.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 430, -1, -1));

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Candara Light", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 204, 204));
        jLabel19.setText("ARCHIVO DE JUEGO");
        PanelNuevoJuego.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 610, -1, -1));

        txtPrecioJuego.setBackground(new java.awt.Color(6, 11, 25));
        txtPrecioJuego.setFont(new java.awt.Font("Candara Light", 0, 14)); // NOI18N
        txtPrecioJuego.setForeground(new java.awt.Color(255, 255, 255));
        txtPrecioJuego.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PanelNuevoJuego.add(txtPrecioJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 460, -1));

        txtTituloJuego.setBackground(new java.awt.Color(6, 11, 25));
        txtTituloJuego.setFont(new java.awt.Font("Candara Light", 0, 14)); // NOI18N
        txtTituloJuego.setForeground(new java.awt.Color(255, 255, 255));
        txtTituloJuego.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PanelNuevoJuego.add(txtTituloJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 460, -1));

        txtDescripcion.setBackground(new java.awt.Color(6, 11, 25));
        txtDescripcion.setColumns(20);
        txtDescripcion.setFont(new java.awt.Font("Candara Light", 0, 14)); // NOI18N
        txtDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setRows(5);
        txtDescripcion.setWrapStyleWord(true);
        SPdes.setViewportView(txtDescripcion);

        PanelNuevoJuego.add(SPdes, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 460, -1));

        txtRutaarchivo.setBackground(new java.awt.Color(6, 11, 25));
        txtRutaarchivo.setFont(new java.awt.Font("Candara Light", 0, 14)); // NOI18N
        txtRutaarchivo.setForeground(new java.awt.Color(255, 255, 255));
        txtRutaarchivo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PanelNuevoJuego.add(txtRutaarchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 610, 460, -1));

        txtRequerimientosRe.setBackground(new java.awt.Color(6, 11, 25));
        txtRequerimientosRe.setColumns(20);
        txtRequerimientosRe.setFont(new java.awt.Font("Candara Light", 0, 14)); // NOI18N
        txtRequerimientosRe.setForeground(new java.awt.Color(255, 255, 255));
        txtRequerimientosRe.setLineWrap(true);
        txtRequerimientosRe.setRows(5);
        txtRequerimientosRe.setText("Sistema Operativo:\nCPU: \nRAM:\nGráficos:\nDirectX 12\nConexión a internet ");
        txtRequerimientosRe.setWrapStyleWord(true);
        SCRR.setViewportView(txtRequerimientosRe);

        PanelNuevoJuego.add(SCRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 470, 350, 120));

        txtrutaportada.setBackground(new java.awt.Color(6, 11, 25));
        txtrutaportada.setFont(new java.awt.Font("Candara Light", 0, 14)); // NOI18N
        txtrutaportada.setForeground(new java.awt.Color(255, 255, 255));
        txtrutaportada.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PanelNuevoJuego.add(txtrutaportada, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 370, 460, -1));

        btnAccion.setBackground(new java.awt.Color(6, 11, 25));
        btnAccion.setForeground(new java.awt.Color(204, 204, 204));
        btnAccion.setText("Accion");
        btnAccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccionActionPerformed(evt);
            }
        });
        PanelNuevoJuego.add(btnAccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 720, -1, -1));

        btnTerror.setBackground(new java.awt.Color(6, 11, 25));
        btnTerror.setForeground(new java.awt.Color(204, 204, 204));
        btnTerror.setText("Terror");
        PanelNuevoJuego.add(btnTerror, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 720, -1, -1));

        btnAventura.setBackground(new java.awt.Color(6, 11, 25));
        btnAventura.setForeground(new java.awt.Color(204, 204, 204));
        btnAventura.setText("Aventura");
        PanelNuevoJuego.add(btnAventura, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 720, -1, -1));

        btnMultijugador.setBackground(new java.awt.Color(6, 11, 25));
        btnMultijugador.setForeground(new java.awt.Color(204, 204, 204));
        btnMultijugador.setText("Multijugador");
        PanelNuevoJuego.add(btnMultijugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 720, -1, -1));

        btnMundoAbierto.setBackground(new java.awt.Color(6, 11, 25));
        btnMundoAbierto.setForeground(new java.awt.Color(204, 204, 204));
        btnMundoAbierto.setText("Mundo abierto");
        PanelNuevoJuego.add(btnMundoAbierto, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 720, -1, -1));

        btnGuardarJuego.setBackground(new java.awt.Color(6, 11, 25));
        btnGuardarJuego.setFont(new java.awt.Font("Candara Light", 1, 28)); // NOI18N
        btnGuardarJuego.setForeground(new java.awt.Color(204, 204, 204));
        btnGuardarJuego.setText("GUARDAR");
        btnGuardarJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarJuegoActionPerformed(evt);
            }
        });
        PanelNuevoJuego.add(btnGuardarJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 770, 400, 70));

        txtRequerimientosMin.setBackground(new java.awt.Color(6, 11, 25));
        txtRequerimientosMin.setColumns(20);
        txtRequerimientosMin.setFont(new java.awt.Font("Candara Light", 0, 14)); // NOI18N
        txtRequerimientosMin.setForeground(new java.awt.Color(255, 255, 255));
        txtRequerimientosMin.setLineWrap(true);
        txtRequerimientosMin.setRows(5);
        txtRequerimientosMin.setText("Sistema Operativo:\nCPU: \nRAM:\nGráficos:\nDirectX 12\nConexión a internet ");
        txtRequerimientosMin.setWrapStyleWord(true);
        SPRM.setViewportView(txtRequerimientosMin);

        PanelNuevoJuego.add(SPRM, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 470, 350, 120));

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Candara Light", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(204, 204, 204));
        jLabel20.setText("IMAGEN");
        PanelNuevoJuego.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, -1, -1));

        txtrutaportada1.setBackground(new java.awt.Color(6, 11, 25));
        txtrutaportada1.setFont(new java.awt.Font("Candara Light", 0, 14)); // NOI18N
        txtrutaportada1.setForeground(new java.awt.Color(255, 255, 255));
        txtrutaportada1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PanelNuevoJuego.add(txtrutaportada1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 330, 460, -1));

        jButton1.setBackground(new java.awt.Color(6, 11, 25));
        jButton1.setFont(new java.awt.Font("Candara Light", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        PanelNuevoJuego.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 330, -1, 30));

        jButton2.setBackground(new java.awt.Color(6, 11, 25));
        jButton2.setFont(new java.awt.Font("Candara Light", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        PanelNuevoJuego.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 610, -1, 30));

        jButton3.setBackground(new java.awt.Color(6, 11, 25));
        jButton3.setFont(new java.awt.Font("Candara Light", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Buscar");
        PanelNuevoJuego.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 370, -1, 30));

        jScrollPane1.setViewportView(PanelNuevoJuego);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1027, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnGuardarJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarJuegoActionPerformed
        Entidades.Clasificacion clasi = new Clasificacion();
        String clasificacion = "";
        if (btnAccion.isSelected()) {
            clasificacion = "Accion";
        }
        if (btnAventura.isSelected()) {
            clasificacion = clasificacion + "Aventura";
        }
        if (btnMultijugador.isSelected()) {
            clasificacion = clasificacion + "Multijugador";
        }
        if (btnMundoAbierto.isSelected()) {
            clasificacion = clasificacion + "Mundo Abierto";
        }
        if (btnTerror.isSelected()) {
            clasificacion = clasificacion + "Terror";
        }
        clasi.setTipo(clasificacion);
        
        if (clasificacion.equals("")) {
            JOptionPane.showMessageDialog(null, "Porfavor Ingrese una clasificacion al Juego");
        } else {
            cclasificacion.create(clasi);
            Entidades.Valoracion valora = new Valoracion();
            valora.setValor("0.0");
            cvaloracion.create(valora);
            juego = new Juego(1, txtTituloJuego.getText(), txtDescripcion.getText(), "Null", "Null", txtRequerimientosMin.getText(), txtPrecioJuego.getText(),txtRequerimientosRe.getText(),txtRutaarchivo.getText(), clasi, valora);
            cjuego.create(juego);
            paginaInicio pi= new paginaInicio();
            pi.setVisible(true);
            verificar=true;
            this.setVisible(false);
        }
       
        
    }//GEN-LAST:event_btnGuardarJuegoActionPerformed
    public boolean verificador (boolean verificador){
        verificador=verificar;
        return verificador;
        
    }
    private void btnAccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAccionActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(AnadirJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnadirJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnadirJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnadirJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnadirJuego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelNuevoJuego;
    private javax.swing.JScrollPane SCRR;
    private javax.swing.JScrollPane SPRM;
    private javax.swing.JScrollPane SPdes;
    private javax.swing.JRadioButton btnAccion;
    private javax.swing.JRadioButton btnAventura;
    private javax.swing.JButton btnGuardarJuego;
    private javax.swing.JRadioButton btnMultijugador;
    private javax.swing.JRadioButton btnMundoAbierto;
    private javax.swing.JRadioButton btnTerror;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtPrecioJuego;
    private javax.swing.JTextArea txtRequerimientosMin;
    private javax.swing.JTextArea txtRequerimientosRe;
    private javax.swing.JTextField txtRutaarchivo;
    private javax.swing.JTextField txtTituloJuego;
    private javax.swing.JTextField txtrutaportada;
    private javax.swing.JTextField txtrutaportada1;
    // End of variables declaration//GEN-END:variables
}
