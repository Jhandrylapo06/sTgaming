/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorCodigo;
import Controlador.CuentaJpaController;
import Controlador.RolJpaController;
import Controlador.UsuarioJpaController;
import Entidades.Cuenta;
import Entidades.Rol;
import Entidades.Usuario;
import com.sun.mail.imap.IMAPMessage;
import java.awt.JobAttributes;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario iTC
 */
public class Registro extends javax.swing.JFrame {

    Controlador.CuentaJpaController CCuenta = new CuentaJpaController();
    Controlador.RolJpaController Crol = new RolJpaController();
    Controlador.UsuarioJpaController Cusuario = new UsuarioJpaController();
    /**
     * Creates new form Registro
     */
    int codigo = (int) Math.floor(Math.random() * 5000 + 1);
    Controlador.ControladorCodigo ccod = new ControladorCodigo();

    public Registro() {
        initComponents();
        setResizable(false);
        setLocation(800, 200);
        jpanelConfirmar.setVisible(false);
        TextPrompt codigp = new TextPrompt("Escriba el codigo", txtcodConf);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel7 = new javax.swing.JLabel();
        JPRegistro = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPaneldatos = new javax.swing.JPanel();
        txtCorreoUs = new javax.swing.JTextField();
        txtTag = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPasCon = new javax.swing.JPasswordField();
        txtPasUS = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        btnGuardar = new javax.swing.JLabel();
        txtNombreUs = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        txtApellidoUs = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jpanelConfirmar = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtcodConf = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 297, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );

        jLabel7.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JPRegistro.setBackground(new java.awt.Color(6, 11, 25));
        JPRegistro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(6, 11, 25));

        jLabel3.setBackground(new java.awt.Color(6, 11, 25));
        jLabel3.setFont(new java.awt.Font("Candara Light", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("BIENVENIDO");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        JPRegistro.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 230, -1));

        jPaneldatos.setBackground(new java.awt.Color(6, 11, 25));
        jPaneldatos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPaneldatos.setForeground(new java.awt.Color(0, 0, 0));
        jPaneldatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCorreoUs.setBackground(new java.awt.Color(6, 11, 25));
        txtCorreoUs.setForeground(new java.awt.Color(255, 255, 255));
        txtCorreoUs.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCorreoUs.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCorreoUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoUsActionPerformed(evt);
            }
        });
        jPaneldatos.add(txtCorreoUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 350, 30));

        txtTag.setBackground(new java.awt.Color(6, 11, 25));
        txtTag.setForeground(new java.awt.Color(255, 255, 255));
        txtTag.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTag.setToolTipText("Este nombre se mostrara en la pagina principal");
        txtTag.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTagActionPerformed(evt);
            }
        });
        jPaneldatos.add(txtTag, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 350, 30));

        jLabel4.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Confirmar contraseña");
        jPaneldatos.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        jLabel6.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Tag/Nick");
        jPaneldatos.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel8.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Correo electronico");
        jPaneldatos.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        txtPasCon.setBackground(new java.awt.Color(6, 11, 25));
        txtPasCon.setForeground(new java.awt.Color(255, 255, 255));
        txtPasCon.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPasCon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtPasCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasConActionPerformed(evt);
            }
        });
        jPaneldatos.add(txtPasCon, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 350, 30));

        txtPasUS.setBackground(new java.awt.Color(6, 11, 25));
        txtPasUS.setForeground(new java.awt.Color(255, 255, 255));
        txtPasUS.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPasUS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPaneldatos.add(txtPasUS, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 350, 30));

        jLabel9.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("Contraseña");
        jPaneldatos.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        jSeparator3.setBackground(new java.awt.Color(102, 102, 102));
        jPaneldatos.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 350, 10));

        jSeparator4.setBackground(new java.awt.Color(102, 102, 102));
        jPaneldatos.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 350, 10));

        jSeparator5.setBackground(new java.awt.Color(102, 102, 102));
        jPaneldatos.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 350, 10));

        jSeparator6.setBackground(new java.awt.Color(102, 102, 102));
        jPaneldatos.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 350, 10));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/save.png"))); // NOI18N
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });
        jPaneldatos.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 110, 110));

        txtNombreUs.setBackground(new java.awt.Color(6, 11, 25));
        txtNombreUs.setForeground(new java.awt.Color(255, 255, 255));
        txtNombreUs.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombreUs.setToolTipText("La siguiente informacion solo la podras ver tu");
        txtNombreUs.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtNombreUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreUsActionPerformed(evt);
            }
        });
        txtNombreUs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreUsKeyTyped(evt);
            }
        });
        jPaneldatos.add(txtNombreUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 350, 30));

        jLabel15.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 204, 204));
        jLabel15.setText("Nombre");
        jPaneldatos.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jSeparator7.setBackground(new java.awt.Color(102, 102, 102));
        jPaneldatos.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 350, 10));

        txtApellidoUs.setBackground(new java.awt.Color(6, 11, 25));
        txtApellidoUs.setForeground(new java.awt.Color(255, 255, 255));
        txtApellidoUs.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtApellidoUs.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtApellidoUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoUsActionPerformed(evt);
            }
        });
        txtApellidoUs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoUsKeyTyped(evt);
            }
        });
        jPaneldatos.add(txtApellidoUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 350, 30));

        jLabel16.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 204, 204));
        jLabel16.setText("Apellido");
        jPaneldatos.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jSeparator8.setBackground(new java.awt.Color(102, 102, 102));
        jPaneldatos.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 350, 10));

        JPRegistro.add(jPaneldatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 530, 480));

        jpanelConfirmar.setBackground(new java.awt.Color(6, 11, 25));
        jpanelConfirmar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jpanelConfirmar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(6, 11, 25));
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("Se envio un codigo de confirmacion al correo electronico ingresado.");
        jpanelConfirmar.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, 20));

        jLabel11.setBackground(new java.awt.Color(6, 11, 25));
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText(" Revise su bandeja de entrada y posteriormente ingrese el codigo.");
        jpanelConfirmar.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel12.setBackground(new java.awt.Color(6, 11, 25));
        jLabel12.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Confirmación de correo electronico");
        jpanelConfirmar.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 450, 50));
        jpanelConfirmar.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 460, 20));

        txtcodConf.setBackground(new java.awt.Color(6, 11, 25));
        txtcodConf.setFont(new java.awt.Font("Candara Light", 0, 24)); // NOI18N
        txtcodConf.setForeground(new java.awt.Color(255, 255, 255));
        txtcodConf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcodConf.setBorder(null);
        txtcodConf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodConfActionPerformed(evt);
            }
        });
        txtcodConf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodConfKeyTyped(evt);
            }
        });
        jpanelConfirmar.add(txtcodConf, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 380, 70));

        jLabel14.setBackground(new java.awt.Color(6, 11, 25));
        jLabel14.setFont(new java.awt.Font("Felix Titling", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("CONFIRMAR");
        jLabel14.setToolTipText("");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jpanelConfirmar.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, -1, -1));

        btnConfirmar.setBackground(new java.awt.Color(6, 11, 25));
        btnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/confirmar).png"))); // NOI18N
        btnConfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfirmarMouseClicked(evt);
            }
        });
        jpanelConfirmar.add(btnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, -1, 110));

        JPRegistro.add(jpanelConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 530, 390));

        jLabel5.setText("Todos los derechos reservados");
        JPRegistro.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 550, -1, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCorreoUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoUsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoUsActionPerformed

    private void txtTagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTagActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTagActionPerformed

    private void txtPasConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasConActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasConActionPerformed

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        //FILTRO PARA QUE SE INGRESEN DATOS VALIDOS
        try {
            List<Usuario> listausuarios = Cusuario.findUsuarioEntities();
            boolean e = false;
            boolean c = true;

            //comprueba que el tag no este registrado
            for (int i = 0; i < listausuarios.size(); i++) {
                if (listausuarios.get(i).getCuentauser().getNickname().equals(txtTag.getText())) {
                    e = true;
                    JOptionPane.showMessageDialog(null, "El tag ya se encuentra registrado, ingresa otro");
                    break;
                }

            }
            //comprueba que el correo no este registrado

            for (int i = 0; i < listausuarios.size(); i++) {
                if (listausuarios.get(i).getCorreo().equals(txtCorreoUs.getText())) {
                    e = true;
                    JOptionPane.showMessageDialog(null, "El correo ingresado ya se encuentra registrado, ingresa otro");

                }

            }
            if (txtPasUS.getText().equals(txtPasCon.getText())) {
                c = false;
                if (txtPasUS.getText().length() < 8) {
                    JOptionPane.showMessageDialog(null, "Las contraseñas debe contener almenos 8 caracteres");
                    c = true;

                }
            } else {
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden, verificar");
            }

            if (e == false && c == false) {
                try {
                    //envio de codigo a correo
                    Properties prop = new Properties();
                    prop.setProperty("mail.smtp.host", "smtp.gmail.com");
                    prop.setProperty("mail.smtp.starttls.enable", "true");
                    prop.setProperty("mail.smtp.port", "587");
                    prop.setProperty("mail.smtp.auth", "true");

                    Session sesion = Session.getDefaultInstance(prop);

                    String Remitente = "sstgaming9@gmail.com";
                    String contra = "proyectofinal123";
                    String correoenviar = txtCorreoUs.getText();
                    String asunto = "CODIGO DE CONFIRMACION";
                    String codigoenvio = String.valueOf(codigo);

                    MimeMessage mensaje = new MimeMessage(sesion);
                    mensaje.setFrom(new InternetAddress(Remitente));

                    mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(correoenviar));
                    mensaje.setSubject(asunto);
                    mensaje.setText(codigoenvio);

                    Transport t = sesion.getTransport("smtp");
                    t.connect(Remitente, contra);
                    t.sendMessage(mensaje, mensaje.getRecipients(Message.RecipientType.TO));
                    t.close();
                    jPaneldatos.setVisible(false);
                    jpanelConfirmar.setVisible(true);
                } catch (MessagingException ex) {
                    Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "VERIFICAR EL CORREO INGRESADO");
                }

            }

        } catch (Exception e) {
            System.out.println("hubo un error");
        }

    }//GEN-LAST:event_btnGuardarMouseClicked

    private void txtcodConfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodConfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodConfActionPerformed

    private void btnConfirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmarMouseClicked
       
        //COMPRUEBA QUE EL CODIGO QUE SE INGRESA SEA IGUAL QUE EL QUE SE ENVIO
        try {
            System.out.println("codigo=" + codigo
                    + "");
            if (ccod.comprobarcodigo(Integer.parseInt(txtcodConf.getText()), codigo) == true) {

                this.setVisible(false);
                Login log = new Login();
                log.setVisible(true);

                Entidades.Cuenta cuenta = new Cuenta(1, txtTag.getText(), txtPasUS.getText());
                Entidades.Rol rool = new Rol(1, "user");
                Entidades.Usuario usuario = new Usuario(txtNombreUs.getText(), txtApellidoUs.getText(), txtCorreoUs.getText(), cuenta, rool);

                CCuenta.create(cuenta);

                Crol.create(rool);

                Cusuario.create(usuario);

            } else {
                JOptionPane.showMessageDialog(null, "El codigo que ingreso no es correcto, por favor verificar");
            }

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error");
            Login n = new Login();
            this.setVisible(false);
            n.setVisible(true);
        }

    }//GEN-LAST:event_btnConfirmarMouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked

    }//GEN-LAST:event_jLabel14MouseClicked

    private void txtNombreUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreUsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreUsActionPerformed

    private void txtApellidoUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoUsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoUsActionPerformed

    private void txtcodConfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodConfKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtcodConfKeyTyped

    private void txtNombreUsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreUsKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < ' ' || c > ' ')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreUsKeyTyped

    private void txtApellidoUsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoUsKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < ' ' || c > ' ')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtApellidoUsKeyTyped

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
            java.util.logging.Logger.getLogger(Registro.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPRegistro;
    private javax.swing.JLabel btnConfirmar;
    private javax.swing.JLabel btnGuardar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPaneldatos;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JPanel jpanelConfirmar;
    private javax.swing.JTextField txtApellidoUs;
    private javax.swing.JTextField txtCorreoUs;
    private javax.swing.JTextField txtNombreUs;
    private javax.swing.JPasswordField txtPasCon;
    private javax.swing.JPasswordField txtPasUS;
    private javax.swing.JTextField txtTag;
    private javax.swing.JTextField txtcodConf;
    // End of variables declaration//GEN-END:variables
}
