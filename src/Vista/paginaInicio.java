/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.CuentaJpaController;
import Controlador.JuegoJpaController;
import Controlador.ListaJuegosJpaController;
import Controlador.RolJpaController;
import Controlador.UsuarioJpaController;
import Controlador.ValoracionJpaController;
import Controlador.exceptions.NonexistentEntityException;
import Entidades.Juego;
import Entidades.Rol;
import java.awt.Color;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario iTC
 */
public class paginaInicio extends javax.swing.JFrame {

    Controlador.JuegoJpaController cjuego = new JuegoJpaController();
    Controlador.UsuarioJpaController cusuario = new UsuarioJpaController();
    Controlador.RolJpaController crol = new RolJpaController();
    Controlador.ListaJuegosJpaController clisjue = new ListaJuegosJpaController();
    Controlador.ValoracionJpaController cvaloracion = new ValoracionJpaController();
    Controlador.CuentaJpaController ccuenta = new CuentaJpaController();
    List<Entidades.Juego> listaJ = cjuego.findJuegoEntities();
    List<Entidades.Juego> listaedit = cjuego.findJuegoEntities();
    List<Entidades.Usuario> listauser = cusuario.findUsuarioEntities();
    List<Entidades.Cuenta> listacuentas = ccuenta.findCuentaEntities();
    List<Entidades.ListaJuegos> Misjuegosl = clisjue.findListaJuegosEntities();
    DefaultListModel modelo = new DefaultListModel();
    boolean verificador;

    /**
     * Creates new form INICIO
     */
    public paginaInicio() {

        // Codigo de ordenacion de valoraciones de juego para las tendencias (mayor a menor valorados)
        initComponents();
        setResizable(false);

        DefaultListModel modelousu = new DefaultListModel();
        for (int i = 0; i < listauser.size(); i++) {
            modelousu.addElement(listauser.get(i).getCuentauser().getNickname());
        }
        JListUsuarios.setModel(modelousu);
        JLMisjuegos.setVisible(true);

        for (int i = 0; i < listaJ.size(); i++) {
            modelo.addElement(listaJ.get(i).getNombre());
        }
        JlistJuegosadmin.setModel(modelo);
        JlistJuegosadmin.setVisible(true);
        //BUSCA LOS JUEGOS CON MAYOR VALORACION PARA LA PAGINA DE TENDENCIAS
        Entidades.Juego[] ListaT = new Entidades.Juego[9];
        double may = 0;
        double actual = 0;
        Entidades.Juego juego = new Juego();
        for (int i = 0; i < ListaT.length; i++) {
            may = 0;
            actual = 0;
            for (int j = 0; j < listaJ.size(); j++) {
                actual = Double.parseDouble(listaJ.get(j).getValoracion().getValor());
                if (actual >= may) {
                    juego = listaJ.get(j);

                    may = actual;
                }
            }

            ListaT[i] = juego;
            listaJ.remove(juego);
        }
        
        //AL INGRESAR DESPUES DE LOGUEARTE MUESTRA LOS JUEGOS MAYOR VALORADOS
        Icon iconot;
        
        iconot = new ImageIcon("C://Users/Usuario iTC/Documents/NetBeansProjects/sTgaming/src/Img/" + ListaT[0].getNombre()+ "Miniatura.jpg");
        lblMinT1.setIcon(iconot);
        lblNomT1.setText(ListaT[0].getNombre());
        lblValT1.setText(ListaT[0].getValoracion().getValor());
        
        iconot = new ImageIcon("C://Users/Usuario iTC/Documents/NetBeansProjects/sTgaming/src/Img/" + ListaT[1].getNombre()+ "Miniatura.jpg");
        lblMinT2.setIcon(iconot);
        lblNomT2.setText(ListaT[1].getNombre());
        lblValT2.setText(ListaT[1].getValoracion().getValor());
        
        iconot = new ImageIcon("C://Users/Usuario iTC/Documents/NetBeansProjects/sTgaming/src/Img/" + ListaT[2].getNombre()+ "Miniatura.jpg");
        lblMinT3.setIcon(iconot);
        lblNomT3.setText(ListaT[2].getNombre());
        lblValT3.setText(ListaT[2].getValoracion().getValor());
        
        iconot = new ImageIcon("C://Users/Usuario iTC/Documents/NetBeansProjects/sTgaming/src/Img/" + ListaT[3].getNombre()+ "Miniatura.jpg");
        lblMinT4.setIcon(iconot);
        lblNomT4.setText(ListaT[3].getNombre());
        lblValT4.setText(ListaT[3].getValoracion().getValor());
        
        iconot = new ImageIcon("C://Users/Usuario iTC/Documents/NetBeansProjects/sTgaming/src/Img/" + ListaT[4].getNombre()+ "Miniatura.jpg");
        lblMinT5.setIcon(iconot);
        lblNomT5.setText(ListaT[4].getNombre());
        lblValT5.setText(ListaT[4].getValoracion().getValor());
        
        iconot = new ImageIcon("C://Users/Usuario iTC/Documents/NetBeansProjects/sTgaming/src/Img/" + ListaT[5].getNombre()+ "Miniatura.jpg");
        mint6.setIcon(iconot);
        lblNomT6.setText(ListaT[5].getNombre());
        lblValT6.setText(ListaT[5].getValoracion().getValor());
        
        iconot = new ImageIcon("C://Users/Usuario iTC/Documents/NetBeansProjects/sTgaming/src/Img/" + ListaT[6].getNombre()+ "Miniatura.jpg");
        lblMinT7.setIcon(iconot);
        lblNomT7.setText(ListaT[6].getNombre());
        lblValT7.setText(ListaT[6].getValoracion().getValor());
        
        iconot = new ImageIcon("C://Users/Usuario iTC/Documents/NetBeansProjects/sTgaming/src/Img/" + ListaT[7].getNombre()+ "Miniatura.jpg");
        lblMinT8.setIcon(iconot);
        lblNomT8.setText(ListaT[7].getNombre());
        lblValT8.setText(ListaT[7].getValoracion().getValor());
        
        iconot = new ImageIcon("C://Users/Usuario iTC/Documents/NetBeansProjects/sTgaming/src/Img/" + ListaT[8].getNombre()+ "Miniatura.jpg");
        lblMinT9.setIcon(iconot);
        lblNomT9.setText(ListaT[8].getNombre());
        lblValT9.setText(ListaT[8].getValoracion().getValor());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        buttonGroup1 = new javax.swing.ButtonGroup();
        lblMinT6 = new javax.swing.JLabel();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel4 = new javax.swing.JLabel();
        pGeneral = new javax.swing.JPanel();
        JPMisjuegos = new javax.swing.JPanel();
        lblMisjuegos = new javax.swing.JLabel();
        SPMisjuegos = new javax.swing.JScrollPane();
        JLMisjuegos = new javax.swing.JList<>();
        JPApartadoTendencias = new javax.swing.JPanel();
        SPtendencias = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        JPtendencia1 = new javax.swing.JPanel();
        lblNomT1 = new javax.swing.JLabel();
        lblMinT1 = new javax.swing.JLabel();
        lblValT1 = new javax.swing.JLabel();
        JPtendencia2 = new javax.swing.JPanel();
        lblNomT2 = new javax.swing.JLabel();
        lblMinT2 = new javax.swing.JLabel();
        lblValT2 = new javax.swing.JLabel();
        JPtendencia3 = new javax.swing.JPanel();
        lblNomT3 = new javax.swing.JLabel();
        lblMinT3 = new javax.swing.JLabel();
        lblValT3 = new javax.swing.JLabel();
        JPtendencia4 = new javax.swing.JPanel();
        lblNomT4 = new javax.swing.JLabel();
        lblMinT4 = new javax.swing.JLabel();
        lblValT4 = new javax.swing.JLabel();
        JPtendencia5 = new javax.swing.JPanel();
        lblNomT5 = new javax.swing.JLabel();
        lblMinT5 = new javax.swing.JLabel();
        lblValT5 = new javax.swing.JLabel();
        JPtendencia6 = new javax.swing.JPanel();
        lblNomT6 = new javax.swing.JLabel();
        lblValT6 = new javax.swing.JLabel();
        mint6 = new javax.swing.JLabel();
        JPtendencia7 = new javax.swing.JPanel();
        lblNomT7 = new javax.swing.JLabel();
        lblMinT7 = new javax.swing.JLabel();
        lblValT7 = new javax.swing.JLabel();
        JPtendencia8 = new javax.swing.JPanel();
        lblNomT8 = new javax.swing.JLabel();
        lblMinT8 = new javax.swing.JLabel();
        lblValT8 = new javax.swing.JLabel();
        JPtendencia9 = new javax.swing.JPanel();
        lblNomT9 = new javax.swing.JLabel();
        lblMinT9 = new javax.swing.JLabel();
        lblValT9 = new javax.swing.JLabel();
        JPapartadoTienda = new javax.swing.JPanel();
        JPjuegosTienda = new javax.swing.JScrollPane();
        JPjuegoBuscado = new javax.swing.JPanel();
        JPBuscado1 = new javax.swing.JPanel();
        lblNombreB1 = new javax.swing.JLabel();
        lblMiniatura1 = new javax.swing.JLabel();
        lblPrecioB1 = new javax.swing.JLabel();
        lblValorB1 = new javax.swing.JLabel();
        JPBuscado2 = new javax.swing.JPanel();
        lblNombreB2 = new javax.swing.JLabel();
        lblMiniatura2 = new javax.swing.JLabel();
        lblPrecioB2 = new javax.swing.JLabel();
        lblValorB2 = new javax.swing.JLabel();
        JPBuscado3 = new javax.swing.JPanel();
        lblNombreB3 = new javax.swing.JLabel();
        lblMiniatura3 = new javax.swing.JLabel();
        lblPrecioB3 = new javax.swing.JLabel();
        lblValorB3 = new javax.swing.JLabel();
        JPBuscado4 = new javax.swing.JPanel();
        lblNombreB4 = new javax.swing.JLabel();
        lblMiniatura4 = new javax.swing.JLabel();
        lblPrecioB4 = new javax.swing.JLabel();
        lblValorB4 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        JPBuscado5 = new javax.swing.JPanel();
        lblNombreB5 = new javax.swing.JLabel();
        lblMiniatura5 = new javax.swing.JLabel();
        lblPrecioB5 = new javax.swing.JLabel();
        lblValorB5 = new javax.swing.JLabel();
        txtbuscar2 = new javax.swing.JTextField();
        btnBuscarJuegoT = new javax.swing.JButton();
        JPapartadoComprar = new javax.swing.JPanel();
        SPJuego = new javax.swing.JScrollPane();
        JPjuego = new javax.swing.JPanel();
        lblPortada = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        btnComprarJuego = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        SPRRe = new javax.swing.JScrollPane();
        jTextrecomendados = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        JPdescripcionjuego = new javax.swing.JScrollPane();
        jTextdescripcion = new javax.swing.JTextArea();
        JPrequisitosMi = new javax.swing.JScrollPane();
        jTextminimos = new javax.swing.JTextArea();
        lblPrecio = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblValoracion = new javax.swing.JLabel();
        JPvalorar = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        btnGuardarValor = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        btnComprarJuego1 = new javax.swing.JButton();
        jPApartadoAdmin = new javax.swing.JPanel();
        SCadministracion = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        PesstaañasAdmin = new javax.swing.JTabbedPane();
        Pjuegos = new javax.swing.JPanel();
        PAdministrarJuegos = new javax.swing.JPanel();
        SPjuegos = new javax.swing.JScrollPane();
        JlistJuegosadmin = new javax.swing.JList<>();
        btnAgregarJuego = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        JPAdminRol = new javax.swing.JPanel();
        JPadministrarRoles = new javax.swing.JPanel();
        SpUsers = new javax.swing.JScrollPane();
        JListUsuarios = new javax.swing.JList<>();
        txtbuscarusuario = new javax.swing.JTextField();
        btnBuscarUsuario = new javax.swing.JButton();
        btnAsignarAdmin = new javax.swing.JRadioButton();
        btnAsignarUser = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        JPmenu = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        lblTendencias = new javax.swing.JLabel();
        lblTienda = new javax.swing.JLabel();
        btnAdministrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        lblMinT6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1024, 780));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logo.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 130, 130));

        pGeneral.setMinimumSize(new java.awt.Dimension(1922, 780));
        pGeneral.setPreferredSize(new java.awt.Dimension(1922, 720));
        pGeneral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JPMisjuegos.setBackground(new java.awt.Color(0, 0, 0, 50));
        JPMisjuegos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        JPMisjuegos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMisjuegos.setFont(new java.awt.Font("Lucida Bright", 0, 28)); // NOI18N
        lblMisjuegos.setForeground(new java.awt.Color(255, 255, 255));
        lblMisjuegos.setText("Mis juegos");
        lblMisjuegos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMisjuegosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblMisjuegosMouseEntered(evt);
            }
        });
        JPMisjuegos.add(lblMisjuegos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 190, 50));

        JLMisjuegos.setBackground(new java.awt.Color(6, 11, 25));
        JLMisjuegos.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        JLMisjuegos.setForeground(new java.awt.Color(204, 204, 204));
        JLMisjuegos.setSelectionBackground(new java.awt.Color(102, 153, 255));
        SPMisjuegos.setViewportView(JLMisjuegos);

        JPMisjuegos.add(SPMisjuegos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 260, 380));

        pGeneral.add(JPMisjuegos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 310, 970));

        JPApartadoTendencias.setBackground(new java.awt.Color(0, 0, 0, 100));
        JPApartadoTendencias.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SPtendencias.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        SPtendencias.setToolTipText("");
        SPtendencias.setHorizontalScrollBar(null);

        jPanel5.setBackground(new java.awt.Color(6, 11, 25));
        jPanel5.setForeground(new java.awt.Color(27, 21, 21));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JPtendencia1.setBackground(new java.awt.Color(6, 11, 25));
        JPtendencia1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        JPtendencia1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNomT1.setBackground(new java.awt.Color(255, 255, 255));
        lblNomT1.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        lblNomT1.setForeground(new java.awt.Color(204, 204, 204));
        lblNomT1.setText("Call of Duty®: Black Ops III");
        JPtendencia1.add(lblNomT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 390, 110));

        lblMinT1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JPtendencia1.add(lblMinT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, 210));

        lblValT1.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        lblValT1.setForeground(new java.awt.Color(255, 255, 255));
        lblValT1.setText("V: 4.9/5");
        JPtendencia1.add(lblValT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 180, 100));

        jPanel5.add(JPtendencia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 780, 230));

        JPtendencia2.setBackground(new java.awt.Color(6, 11, 25));
        JPtendencia2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        JPtendencia2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNomT2.setBackground(new java.awt.Color(255, 255, 255));
        lblNomT2.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        lblNomT2.setForeground(new java.awt.Color(204, 204, 204));
        lblNomT2.setText("Call of Duty®: Black Ops II");
        JPtendencia2.add(lblNomT2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 370, 110));

        lblMinT2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JPtendencia2.add(lblMinT2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, 210));

        lblValT2.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        lblValT2.setForeground(new java.awt.Color(255, 255, 255));
        lblValT2.setText("V: 4.9/5");
        JPtendencia2.add(lblValT2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 180, 100));

        jPanel5.add(JPtendencia2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, 780, 230));

        JPtendencia3.setBackground(new java.awt.Color(6, 11, 25));
        JPtendencia3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        JPtendencia3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNomT3.setBackground(new java.awt.Color(255, 255, 255));
        lblNomT3.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        lblNomT3.setForeground(new java.awt.Color(204, 204, 204));
        lblNomT3.setText("Call of Duty®: Black Ops I");
        JPtendencia3.add(lblNomT3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 340, 110));

        lblMinT3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JPtendencia3.add(lblMinT3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, 210));

        lblValT3.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        lblValT3.setForeground(new java.awt.Color(255, 255, 255));
        lblValT3.setText("V: 4.8/5");
        JPtendencia3.add(lblValT3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 180, 100));

        jPanel5.add(JPtendencia3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 780, 230));

        JPtendencia4.setBackground(new java.awt.Color(6, 11, 25));
        JPtendencia4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        JPtendencia4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNomT4.setBackground(new java.awt.Color(255, 255, 255));
        lblNomT4.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        lblNomT4.setForeground(new java.awt.Color(204, 204, 204));
        lblNomT4.setText("Call of Duty®: Black Ops Cold War");
        JPtendencia4.add(lblNomT4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, -1, 110));

        lblMinT4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JPtendencia4.add(lblMinT4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, 210));

        lblValT4.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        lblValT4.setForeground(new java.awt.Color(255, 255, 255));
        lblValT4.setText("V: 4.8/5");
        JPtendencia4.add(lblValT4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, 180, 100));

        jPanel5.add(JPtendencia4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 250, 780, 230));

        JPtendencia5.setBackground(new java.awt.Color(6, 11, 25));
        JPtendencia5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        JPtendencia5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNomT5.setBackground(new java.awt.Color(255, 255, 255));
        lblNomT5.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        lblNomT5.setForeground(new java.awt.Color(204, 204, 204));
        lblNomT5.setText("Halo: The Master Chief Collection ");
        JPtendencia5.add(lblNomT5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 340, 110));

        lblMinT5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JPtendencia5.add(lblMinT5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, 210));

        lblValT5.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        lblValT5.setForeground(new java.awt.Color(255, 255, 255));
        lblValT5.setText("V: 4.7/5");
        JPtendencia5.add(lblValT5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 180, 100));

        jPanel5.add(JPtendencia5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 780, 230));

        JPtendencia6.setBackground(new java.awt.Color(6, 11, 25));
        JPtendencia6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        JPtendencia6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNomT6.setBackground(new java.awt.Color(255, 255, 255));
        lblNomT6.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        lblNomT6.setForeground(new java.awt.Color(204, 204, 204));
        lblNomT6.setText("Phasmophobia");
        JPtendencia6.add(lblNomT6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 340, 110));

        lblValT6.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        lblValT6.setForeground(new java.awt.Color(255, 255, 255));
        lblValT6.setText("V: 4.6/5");
        JPtendencia6.add(lblValT6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 180, 100));

        mint6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JPtendencia6.add(mint6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, 210));

        jPanel5.add(JPtendencia6, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 490, 780, 230));

        JPtendencia7.setBackground(new java.awt.Color(6, 11, 25));
        JPtendencia7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        JPtendencia7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNomT7.setBackground(new java.awt.Color(255, 255, 255));
        lblNomT7.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        lblNomT7.setForeground(new java.awt.Color(204, 204, 204));
        lblNomT7.setText("FarCry 5");
        JPtendencia7.add(lblNomT7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 340, 110));

        lblMinT7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JPtendencia7.add(lblMinT7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, 210));

        lblValT7.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        lblValT7.setForeground(new java.awt.Color(255, 255, 255));
        lblValT7.setText("V: 4.6/5");
        JPtendencia7.add(lblValT7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 180, 100));

        jPanel5.add(JPtendencia7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 730, 780, 230));

        JPtendencia8.setBackground(new java.awt.Color(6, 11, 25));
        JPtendencia8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        JPtendencia8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNomT8.setBackground(new java.awt.Color(255, 255, 255));
        lblNomT8.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        lblNomT8.setForeground(new java.awt.Color(204, 204, 204));
        lblNomT8.setText("Ark: Survival Evolved");
        JPtendencia8.add(lblNomT8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 340, 110));

        lblMinT8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JPtendencia8.add(lblMinT8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, 210));

        lblValT8.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        lblValT8.setForeground(new java.awt.Color(255, 255, 255));
        lblValT8.setText("V: 4.5/5");
        JPtendencia8.add(lblValT8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 180, 100));

        jPanel5.add(JPtendencia8, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 730, 780, 230));

        JPtendencia9.setBackground(new java.awt.Color(6, 11, 25));
        JPtendencia9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        JPtendencia9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNomT9.setBackground(new java.awt.Color(255, 255, 255));
        lblNomT9.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        lblNomT9.setForeground(new java.awt.Color(204, 204, 204));
        lblNomT9.setText("Call of Duty®: Black Ops IV");
        JPtendencia9.add(lblNomT9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 380, 110));

        lblMinT9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JPtendencia9.add(lblMinT9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, 210));

        lblValT9.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        lblValT9.setForeground(new java.awt.Color(255, 255, 255));
        lblValT9.setText("V: 4.0/5");
        JPtendencia9.add(lblValT9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 180, 100));

        jPanel5.add(JPtendencia9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 970, 780, 230));

        SPtendencias.setViewportView(jPanel5);

        JPApartadoTendencias.add(SPtendencias, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1610, 950));

        pGeneral.add(JPApartadoTendencias, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 1610, 950));

        JPapartadoTienda.setBackground(new java.awt.Color(0, 0, 0, 100));
        JPapartadoTienda.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JPjuegosTienda.setToolTipText("");
        JPjuegosTienda.setHorizontalScrollBar(null);

        JPjuegoBuscado.setBackground(new java.awt.Color(6, 11, 25));
        JPjuegoBuscado.setForeground(new java.awt.Color(27, 21, 21));
        JPjuegoBuscado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JPBuscado1.setBackground(new java.awt.Color(6, 11, 25));
        JPBuscado1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        JPBuscado1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JPBuscado1MouseClicked(evt);
            }
        });
        JPBuscado1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombreB1.setBackground(new java.awt.Color(255, 255, 255));
        lblNombreB1.setFont(new java.awt.Font("Candara Light", 1, 48)); // NOI18N
        lblNombreB1.setForeground(new java.awt.Color(204, 204, 204));
        lblNombreB1.setText("Call of Duty®: Black Ops Cold War");
        lblNombreB1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNombreB1MouseClicked(evt);
            }
        });
        JPBuscado1.add(lblNombreB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, -1, 110));

        lblMiniatura1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JPBuscado1.add(lblMiniatura1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, 210));

        lblPrecioB1.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        lblPrecioB1.setForeground(new java.awt.Color(255, 255, 255));
        lblPrecioB1.setText("PVP:99,99");
        JPBuscado1.add(lblPrecioB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 110, 180, 100));

        lblValorB1.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        lblValorB1.setForeground(new java.awt.Color(255, 255, 255));
        lblValorB1.setText("V: 4.8/5");
        JPBuscado1.add(lblValorB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 0, 180, 100));

        JPjuegoBuscado.add(JPBuscado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 1550, 230));

        JPBuscado2.setBackground(new java.awt.Color(6, 11, 25));
        JPBuscado2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        JPBuscado2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JPBuscado2MouseClicked(evt);
            }
        });
        JPBuscado2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombreB2.setBackground(new java.awt.Color(255, 255, 255));
        lblNombreB2.setFont(new java.awt.Font("Candara Light", 1, 48)); // NOI18N
        lblNombreB2.setForeground(new java.awt.Color(204, 204, 204));
        lblNombreB2.setText("Call of Duty®: Black Ops IV");
        lblNombreB2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNombreB2MouseClicked(evt);
            }
        });
        JPBuscado2.add(lblNombreB2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, -1, 110));

        lblMiniatura2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JPBuscado2.add(lblMiniatura2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, 210));

        lblPrecioB2.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        lblPrecioB2.setForeground(new java.awt.Color(255, 255, 255));
        lblPrecioB2.setText("PVP:69,99");
        JPBuscado2.add(lblPrecioB2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 110, 180, 100));

        lblValorB2.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        lblValorB2.setForeground(new java.awt.Color(255, 255, 255));
        lblValorB2.setText("V: 4.0/5");
        JPBuscado2.add(lblValorB2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 0, 180, 100));

        JPjuegoBuscado.add(JPBuscado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, 230));

        JPBuscado3.setBackground(new java.awt.Color(6, 11, 25));
        JPBuscado3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        JPBuscado3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JPBuscado3MouseClicked(evt);
            }
        });
        JPBuscado3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombreB3.setBackground(new java.awt.Color(255, 255, 255));
        lblNombreB3.setFont(new java.awt.Font("Candara Light", 1, 48)); // NOI18N
        lblNombreB3.setForeground(new java.awt.Color(204, 204, 204));
        lblNombreB3.setText("Call of Duty®: Black Ops III");
        lblNombreB3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNombreB3MouseClicked(evt);
            }
        });
        JPBuscado3.add(lblNombreB3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, -1, 110));

        lblMiniatura3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JPBuscado3.add(lblMiniatura3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, 210));

        lblPrecioB3.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        lblPrecioB3.setForeground(new java.awt.Color(255, 255, 255));
        lblPrecioB3.setText("79.99");
        JPBuscado3.add(lblPrecioB3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 110, 180, 100));

        lblValorB3.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        lblValorB3.setForeground(new java.awt.Color(255, 255, 255));
        lblValorB3.setText("V: 4.9/5");
        JPBuscado3.add(lblValorB3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 0, 180, 100));

        JPjuegoBuscado.add(JPBuscado3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, 1550, 230));

        JPBuscado4.setBackground(new java.awt.Color(6, 11, 25));
        JPBuscado4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        JPBuscado4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JPBuscado4MouseClicked(evt);
            }
        });
        JPBuscado4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombreB4.setBackground(new java.awt.Color(255, 255, 255));
        lblNombreB4.setFont(new java.awt.Font("Candara Light", 1, 48)); // NOI18N
        lblNombreB4.setForeground(new java.awt.Color(204, 204, 204));
        lblNombreB4.setText("Call of Duty®: Black Ops II");
        lblNombreB4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNombreB4MouseClicked(evt);
            }
        });
        JPBuscado4.add(lblNombreB4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, -1, 110));

        lblMiniatura4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JPBuscado4.add(lblMiniatura4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, 210));

        lblPrecioB4.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        lblPrecioB4.setForeground(new java.awt.Color(255, 255, 255));
        lblPrecioB4.setText("49,99");
        JPBuscado4.add(lblPrecioB4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 110, 180, 100));

        lblValorB4.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        lblValorB4.setForeground(new java.awt.Color(255, 255, 255));
        lblValorB4.setText("V: 4.9/5");
        JPBuscado4.add(lblValorB4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 0, 180, 100));

        jPanel14.setBackground(new java.awt.Color(6, 11, 25));
        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setBackground(new java.awt.Color(255, 255, 255));
        jLabel39.setFont(new java.awt.Font("Candara Light", 1, 48)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(204, 204, 204));
        jLabel39.setText("Call of Duty®: Black Ops Cold War");
        jPanel14.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, -1, 110));

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cold war 2_miniatura.jpg"))); // NOI18N
        jPanel14.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, 210));

        jLabel41.setText("jLabel4");
        jPanel14.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 110, 180, 100));

        jLabel42.setText("jLabel4");
        jPanel14.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 0, 180, 100));

        jPanel15.setBackground(new java.awt.Color(6, 11, 25));
        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel43.setBackground(new java.awt.Color(255, 255, 255));
        jLabel43.setFont(new java.awt.Font("Candara Light", 1, 48)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(204, 204, 204));
        jLabel43.setText("Call of Duty®: Black Ops Cold War");
        jPanel15.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, -1, 110));

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cold war 2_miniatura.jpg"))); // NOI18N
        jPanel15.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, 210));

        jLabel45.setText("jLabel4");
        jPanel15.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 110, 180, 100));

        jLabel46.setText("jLabel4");
        jPanel15.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 0, 180, 100));

        jPanel14.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 530, 1550, 230));

        JPBuscado4.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 780, 1550, 230));

        JPjuegoBuscado.add(JPBuscado4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 780, 1550, 230));

        JPBuscado5.setBackground(new java.awt.Color(6, 11, 25));
        JPBuscado5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        JPBuscado5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JPBuscado5MouseClicked(evt);
            }
        });
        JPBuscado5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombreB5.setBackground(new java.awt.Color(255, 255, 255));
        lblNombreB5.setFont(new java.awt.Font("Candara Light", 1, 48)); // NOI18N
        lblNombreB5.setForeground(new java.awt.Color(204, 204, 204));
        lblNombreB5.setText("Call of Duty®: Black Ops I");
        lblNombreB5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNombreB5MouseClicked(evt);
            }
        });
        JPBuscado5.add(lblNombreB5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, -1, 110));

        lblMiniatura5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JPBuscado5.add(lblMiniatura5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, 210));

        lblPrecioB5.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        lblPrecioB5.setForeground(new java.awt.Color(255, 255, 255));
        lblPrecioB5.setText("29,99");
        JPBuscado5.add(lblPrecioB5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 110, 180, 100));

        lblValorB5.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        lblValorB5.setForeground(new java.awt.Color(255, 255, 255));
        lblValorB5.setText("V: 4.8/5");
        JPBuscado5.add(lblValorB5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 0, 180, 100));

        JPjuegoBuscado.add(JPBuscado5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 1020, -1, 230));

        txtbuscar2.setBackground(new java.awt.Color(51, 51, 51));
        txtbuscar2.setFont(new java.awt.Font("Eras Light ITC", 0, 24)); // NOI18N
        txtbuscar2.setForeground(new java.awt.Color(204, 204, 204));
        txtbuscar2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscar2KeyReleased(evt);
            }
        });
        JPjuegoBuscado.add(txtbuscar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 50));

        btnBuscarJuegoT.setBackground(new java.awt.Color(6, 11, 25));
        btnBuscarJuegoT.setFont(new java.awt.Font("Candara Light", 1, 18)); // NOI18N
        btnBuscarJuegoT.setForeground(new java.awt.Color(102, 153, 255));
        btnBuscarJuegoT.setText("BUSCAR");
        btnBuscarJuegoT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarJuegoTActionPerformed(evt);
            }
        });
        JPjuegoBuscado.add(btnBuscarJuegoT, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 200, 50));

        JPjuegosTienda.setViewportView(JPjuegoBuscado);

        JPapartadoTienda.add(JPjuegosTienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1610, 970));

        pGeneral.add(JPapartadoTienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 1610, 970));

        JPapartadoComprar.setBackground(new java.awt.Color(0, 0, 0, 100));
        JPapartadoComprar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SPJuego.setToolTipText("");
        SPJuego.setHorizontalScrollBar(null);

        JPjuego.setBackground(new java.awt.Color(6, 11, 25));
        JPjuego.setForeground(new java.awt.Color(27, 21, 21));
        JPjuego.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPortada.setBackground(new java.awt.Color(7, 9, 32));
        lblPortada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cold war 2.jpg"))); // NOI18N
        JPjuego.add(lblPortada, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1570, 780));

        lblNombre.setBackground(new java.awt.Color(255, 255, 255));
        lblNombre.setFont(new java.awt.Font("Candara Light", 1, 48)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(204, 204, 204));
        lblNombre.setText("Call of Duty®: Black Ops Cold War");
        JPjuego.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 780, -1, 80));

        btnComprarJuego.setBackground(new java.awt.Color(6, 11, 25));
        btnComprarJuego.setFont(new java.awt.Font("Candara Light", 1, 48)); // NOI18N
        btnComprarJuego.setForeground(new java.awt.Color(204, 204, 204));
        btnComprarJuego.setText("COMPRAR");
        btnComprarJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarJuegoActionPerformed(evt);
            }
        });
        JPjuego.add(btnComprarJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 790, 360, 90));

        jLabel1.setText("Todos los derechos reservados");
        JPjuego.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 1660, -1, 30));

        jTextrecomendados.setEditable(false);
        jTextrecomendados.setBackground(new java.awt.Color(6, 11, 25));
        jTextrecomendados.setColumns(20);
        jTextrecomendados.setFont(new java.awt.Font("Maiandra GD", 0, 18)); // NOI18N
        jTextrecomendados.setForeground(new java.awt.Color(255, 255, 255));
        jTextrecomendados.setLineWrap(true);
        jTextrecomendados.setRows(5);
        jTextrecomendados.setText("Sistema Operativo: Windows 10 64-Bit\nCPU: Intel Core i5-2500K o AMD Ryzen R5 1600X\nRAM: 12 GB de RAM\nHDD (de lanzamiento): 175 GB\nGráficos: NVIDIA GeForce GTX 970 / GTX 1660 Super o Radeon R9 390 / AMD RX 580\nDirectX 12\nConexión a internet");
        jTextrecomendados.setWrapStyleWord(true);
        jTextrecomendados.setBorder(null);
        jTextrecomendados.setCaretColor(new java.awt.Color(6, 11, 25));
        jTextrecomendados.setSelectionColor(new java.awt.Color(6, 11, 25));
        SPRRe.setViewportView(jTextrecomendados);

        JPjuego.add(SPRRe, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 1260, 730, 300));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Candara Light", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Recomendados");
        JPjuego.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 1210, -1, -1));

        jTextdescripcion.setEditable(false);
        jTextdescripcion.setBackground(new java.awt.Color(6, 11, 25));
        jTextdescripcion.setColumns(20);
        jTextdescripcion.setFont(new java.awt.Font("Maiandra GD", 0, 18)); // NOI18N
        jTextdescripcion.setForeground(new java.awt.Color(255, 255, 255));
        jTextdescripcion.setLineWrap(true);
        jTextdescripcion.setRows(5);
        jTextdescripcion.setText("Call of Duty: Black Ops Cold War es un nueva entrega de la saga de acción bélica first person shooter a cargo de Treyarch junto a Raven y Activision para PC, PlayStation 4, Xbox One, PlayStation 5 y Xbox Series X que nos lleva a la convulsa época de la Guerra Fría. Como operador de élite, seguirás los pasos de una misteriosa figura llamada Perseus, cuya misión es desestabilizar el equilibrio de poder mundial y cambiar el curso de la historia. Adéntrate en esta conspiración global junto con los legendarios personajes Woods, Mason y Hudson, así como con un nuevo plantel de operadores dispuestos a detener una conspiración que lleva décadas urdiéndose. Además de la campaña, los jugadores llevarán un arsenal de armas y equipamiento de la Guerra Fría a la siguiente generación de los modos Multijugador y Zombis.");
        jTextdescripcion.setWrapStyleWord(true);
        jTextdescripcion.setBorder(null);
        jTextdescripcion.setCaretColor(new java.awt.Color(6, 11, 25));
        jTextdescripcion.setSelectionColor(new java.awt.Color(6, 11, 25));
        JPdescripcionjuego.setViewportView(jTextdescripcion);

        JPjuego.add(JPdescripcionjuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 970, 1510, 150));

        jTextminimos.setEditable(false);
        jTextminimos.setBackground(new java.awt.Color(6, 11, 25));
        jTextminimos.setColumns(20);
        jTextminimos.setFont(new java.awt.Font("Maiandra GD", 0, 18)); // NOI18N
        jTextminimos.setForeground(new java.awt.Color(255, 255, 255));
        jTextminimos.setLineWrap(true);
        jTextminimos.setRows(5);
        jTextminimos.setText("Sistema Operativo: Windows 7 64-Bit (SP1) o Windows 10 64-Bit (v.1803)\nCPU: Intel Core i3-4340 o AMD FX-6300\nRAM: 8 GB de RAM\nHDD: 50 GB (solo multijugador), 175 GB (todos los modos de juego)\nGráficos: NVIDIA GeForce GTX 670 / GeForce GTX 1650 o Radeon HD 7950\nDirectX 12\nConexión a internet ");
        jTextminimos.setWrapStyleWord(true);
        jTextminimos.setBorder(null);
        jTextminimos.setCaretColor(new java.awt.Color(6, 11, 25));
        jTextminimos.setSelectionColor(new java.awt.Color(6, 11, 25));
        JPrequisitosMi.setViewportView(jTextminimos);

        JPjuego.add(JPrequisitosMi, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1260, 730, 300));

        lblPrecio.setBackground(new java.awt.Color(255, 255, 255));
        lblPrecio.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        lblPrecio.setForeground(new java.awt.Color(204, 204, 204));
        lblPrecio.setText("Precio$:99,99");
        lblPrecio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        JPjuego.add(lblPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 820, 240, -1));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Candara Light", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("Minimos:");
        JPjuego.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1210, -1, -1));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Candara Light", 1, 40)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setText("Descripción:");
        JPjuego.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 910, -1, -1));

        lblValoracion.setBackground(new java.awt.Color(255, 255, 255));
        lblValoracion.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        lblValoracion.setForeground(new java.awt.Color(204, 204, 204));
        lblValoracion.setText("Valoracion: 4.8/5");
        lblValoracion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblValoracion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblValoracionMouseClicked(evt);
            }
        });
        JPjuego.add(lblValoracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 780, 240, -1));

        JPvalorar.setBackground(new java.awt.Color(6, 11, 25));
        JPvalorar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        JPvalorar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jRadioButton1.setBackground(new java.awt.Color(6, 11, 25));
        buttonGroup2.add(jRadioButton1);
        jRadioButton1.setForeground(new java.awt.Color(204, 204, 204));
        jRadioButton1.setText("1");
        JPvalorar.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jRadioButton2.setBackground(new java.awt.Color(6, 11, 25));
        buttonGroup2.add(jRadioButton2);
        jRadioButton2.setForeground(new java.awt.Color(204, 204, 204));
        jRadioButton2.setText("2");
        JPvalorar.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        jRadioButton3.setBackground(new java.awt.Color(6, 11, 25));
        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setForeground(new java.awt.Color(204, 204, 204));
        jRadioButton3.setText("3");
        JPvalorar.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, -1, -1));

        jRadioButton4.setBackground(new java.awt.Color(6, 11, 25));
        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setForeground(new java.awt.Color(204, 204, 204));
        jRadioButton4.setText("4");
        JPvalorar.add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, -1, -1));

        jRadioButton5.setBackground(new java.awt.Color(6, 11, 25));
        buttonGroup2.add(jRadioButton5);
        jRadioButton5.setForeground(new java.awt.Color(204, 204, 204));
        jRadioButton5.setText("5");
        JPvalorar.add(jRadioButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, -1, -1));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("Seleciona la valoración:");
        JPvalorar.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        btnGuardarValor.setBackground(new java.awt.Color(6, 11, 25));
        btnGuardarValor.setFont(new java.awt.Font("Candara Light", 1, 18)); // NOI18N
        btnGuardarValor.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarValor.setText("GUARDAR");
        btnGuardarValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarValorActionPerformed(evt);
            }
        });
        JPvalorar.add(btnGuardarValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 150, 60));

        JPjuego.add(JPvalorar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 860, 540, 100));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Candara Light", 1, 40)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setText("Requisitos:");
        JPjuego.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 1140, -1, -1));

        btnComprarJuego1.setBackground(new java.awt.Color(6, 11, 25));
        btnComprarJuego1.setFont(new java.awt.Font("Candara Light", 1, 48)); // NOI18N
        btnComprarJuego1.setForeground(new java.awt.Color(204, 204, 204));
        btnComprarJuego1.setText("COMPRAR");
        btnComprarJuego1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarJuego1ActionPerformed(evt);
            }
        });
        JPjuego.add(btnComprarJuego1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 790, 360, 90));

        SPJuego.setViewportView(JPjuego);

        JPapartadoComprar.add(SPJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1630, 980));

        pGeneral.add(JPapartadoComprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 1610, 970));

        jPApartadoAdmin.setBackground(new java.awt.Color(0, 0, 0, 100));
        jPApartadoAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SCadministracion.setToolTipText("");
        SCadministracion.setHorizontalScrollBar(null);

        jPanel6.setBackground(new java.awt.Color(6, 11, 25));
        jPanel6.setForeground(new java.awt.Color(27, 21, 21));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Candara Light", 1, 48)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("ADMINISTRACIÓN");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 40, -1, -1));

        PesstaañasAdmin.setBackground(new java.awt.Color(6, 11, 25));
        PesstaañasAdmin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PesstaañasAdmin.setForeground(new java.awt.Color(255, 255, 255));
        PesstaañasAdmin.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N

        Pjuegos.setBackground(new java.awt.Color(6, 11, 25));
        Pjuegos.setForeground(new java.awt.Color(27, 21, 21));
        Pjuegos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PAdministrarJuegos.setBackground(new java.awt.Color(6, 11, 25));
        PAdministrarJuegos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JlistJuegosadmin.setBackground(new java.awt.Color(6, 11, 25));
        JlistJuegosadmin.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        JlistJuegosadmin.setForeground(new java.awt.Color(255, 255, 255));
        JlistJuegosadmin.setToolTipText("");
        SPjuegos.setViewportView(JlistJuegosadmin);

        PAdministrarJuegos.add(SPjuegos, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 680, 540));

        btnAgregarJuego.setBackground(new java.awt.Color(6, 11, 25));
        btnAgregarJuego.setFont(new java.awt.Font("Candara Light", 1, 28)); // NOI18N
        btnAgregarJuego.setForeground(new java.awt.Color(204, 204, 204));
        btnAgregarJuego.setText("AGREGAR NUEVO JUEGO");
        btnAgregarJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarJuegoActionPerformed(evt);
            }
        });
        PAdministrarJuegos.add(btnAgregarJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 200, 400, 70));

        btnEliminar.setBackground(new java.awt.Color(6, 11, 25));
        btnEliminar.setFont(new java.awt.Font("Candara Light", 1, 28)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(204, 204, 204));
        btnEliminar.setText("DAR DE BAJA/ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        PAdministrarJuegos.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 470, 400, 70));

        btnEditar.setBackground(new java.awt.Color(6, 11, 25));
        btnEditar.setFont(new java.awt.Font("Candara Light", 1, 28)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(204, 204, 204));
        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        PAdministrarJuegos.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 330, 400, 70));

        txtbuscar.setBackground(new java.awt.Color(51, 51, 51));
        txtbuscar.setFont(new java.awt.Font("Eras Light ITC", 0, 18)); // NOI18N
        txtbuscar.setForeground(new java.awt.Color(204, 204, 204));
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });
        PAdministrarJuegos.add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 420, 50));

        btnBuscar.setBackground(new java.awt.Color(6, 11, 25));
        btnBuscar.setFont(new java.awt.Font("Candara Light", 1, 18)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(102, 153, 255));
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        PAdministrarJuegos.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 200, 50));

        jLabel3.setFont(new java.awt.Font("Candara Light", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Lista de juegos");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        PAdministrarJuegos.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 310, 40));

        Pjuegos.add(PAdministrarJuegos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1440, 670));

        PesstaañasAdmin.addTab("ADMINISTRAR JUEGOS", Pjuegos);

        JPAdminRol.setBackground(new java.awt.Color(6, 11, 25));
        JPAdminRol.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        JPAdminRol.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JPadministrarRoles.setBackground(new java.awt.Color(6, 11, 25));
        JPadministrarRoles.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JListUsuarios.setBackground(new java.awt.Color(6, 11, 25));
        JListUsuarios.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        JListUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        JListUsuarios.setToolTipText("");
        SpUsers.setViewportView(JListUsuarios);

        JPadministrarRoles.add(SpUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 680, 550));

        txtbuscarusuario.setBackground(new java.awt.Color(51, 51, 51));
        txtbuscarusuario.setFont(new java.awt.Font("Eras Light ITC", 0, 18)); // NOI18N
        txtbuscarusuario.setForeground(new java.awt.Color(204, 204, 204));
        txtbuscarusuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarusuarioKeyReleased(evt);
            }
        });
        JPadministrarRoles.add(txtbuscarusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 420, 50));

        btnBuscarUsuario.setBackground(new java.awt.Color(6, 11, 25));
        btnBuscarUsuario.setFont(new java.awt.Font("Candara Light", 1, 18)); // NOI18N
        btnBuscarUsuario.setForeground(new java.awt.Color(102, 153, 255));
        btnBuscarUsuario.setText("BUSCAR");
        btnBuscarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarUsuarioActionPerformed(evt);
            }
        });
        JPadministrarRoles.add(btnBuscarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 200, 50));

        btnAsignarAdmin.setBackground(new java.awt.Color(6, 11, 25));
        buttonGroup1.add(btnAsignarAdmin);
        btnAsignarAdmin.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        btnAsignarAdmin.setForeground(new java.awt.Color(255, 255, 255));
        btnAsignarAdmin.setText("ADMINISTRADOR");
        btnAsignarAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAsignarAdminMouseClicked(evt);
            }
        });
        btnAsignarAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarAdminActionPerformed(evt);
            }
        });
        JPadministrarRoles.add(btnAsignarAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 350, -1, -1));

        btnAsignarUser.setBackground(new java.awt.Color(6, 11, 25));
        buttonGroup1.add(btnAsignarUser);
        btnAsignarUser.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        btnAsignarUser.setForeground(new java.awt.Color(255, 255, 255));
        btnAsignarUser.setText("USUARIO");
        btnAsignarUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarUserActionPerformed(evt);
            }
        });
        JPadministrarRoles.add(btnAsignarUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 350, -1, -1));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("SELECIONA EL ROL DEL ESTE USUARIO");
        JPadministrarRoles.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 240, -1, -1));

        JPAdminRol.add(JPadministrarRoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1440, 670));

        PesstaañasAdmin.addTab("ADMINISTRAR ROLES", JPAdminRol);

        jPanel6.add(PesstaañasAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 1490, 760));

        SCadministracion.setViewportView(jPanel6);

        jPApartadoAdmin.add(SCadministracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1610, 950));

        pGeneral.add(jPApartadoAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 1610, 950));

        JPmenu.setBackground(new java.awt.Color(0, 0, 0, 50));
        JPmenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsuario.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(204, 204, 204));
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsuario.setText("eLJhandRy");
        lblUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblUsuarioMouseEntered(evt);
            }
        });
        JPmenu.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1700, 10, 220, 40));

        lblTendencias.setFont(new java.awt.Font("Lucida Bright", 0, 28)); // NOI18N
        lblTendencias.setForeground(new java.awt.Color(102, 153, 255));
        lblTendencias.setText("Tendencias");
        lblTendencias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTendenciasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblTendenciasMouseEntered(evt);
            }
        });
        JPmenu.add(lblTendencias, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, 170, 40));

        lblTienda.setFont(new java.awt.Font("Lucida Bright", 0, 28)); // NOI18N
        lblTienda.setForeground(new java.awt.Color(255, 255, 255));
        lblTienda.setText("Tienda");
        lblTienda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTiendaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblTiendaMouseEntered(evt);
            }
        });
        JPmenu.add(lblTienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 170, 40));

        btnAdministrar.setBackground(new java.awt.Color(6, 11, 25));
        btnAdministrar.setFont(new java.awt.Font("Candara Light", 1, 18)); // NOI18N
        btnAdministrar.setForeground(new java.awt.Color(102, 153, 255));
        btnAdministrar.setText("ADMINISTRAR");
        btnAdministrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAdministrarMouseClicked(evt);
            }
        });
        btnAdministrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministrarActionPerformed(evt);
            }
        });
        JPmenu.add(btnAdministrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1500, 20, 200, 50));

        jLabel2.setFont(new java.awt.Font("Candara Light", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Cerrar sesion");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        JPmenu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1750, 50, 120, -1));

        pGeneral.add(JPmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 80));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/FONDOA1.jpg"))); // NOI18N
        pGeneral.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 0, 1920, 970));

        getContentPane().add(pGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 1040));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblTiendaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTiendaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTiendaMouseEntered

    private void lblTendenciasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTendenciasMouseEntered

    }//GEN-LAST:event_lblTendenciasMouseEntered

    private void lblMisjuegosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMisjuegosMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblMisjuegosMouseEntered

    private void lblUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUsuarioMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblUsuarioMouseEntered

    private void lblTiendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTiendaMouseClicked
        try {
            Icon Imagenes;
            JPapartadoTienda.setVisible(true);
            jPApartadoAdmin.setVisible(false);
            JPApartadoTendencias.setVisible(false);
            lblTienda.setForeground(new java.awt.Color(102, 153, 255));
            lblTendencias.setForeground(new java.awt.Color(255, 255, 255));
            //CONSULTA INICIAL
            
            JPBuscado1.setVisible(false);
            JPBuscado2.setVisible(false);
            JPBuscado3.setVisible(false);
            JPBuscado4.setVisible(false);
            JPBuscado5.setVisible(false);
            List<Entidades.Juego> buscado = cjuego.Buscarjuego("a");
            int contador = 0;
            System.out.println(contador);
            for (int i = 0; i < buscado.size(); i++) {

                if (contador == 0) {
                    Imagenes = new ImageIcon("C://Users/Usuario iTC/Documents/NetBeansProjects/sTgaming/src/Img/" + buscado.get(0).getNombre() + "Miniatura.jpg");

                    JPBuscado1.setVisible(true);
                    lblNombreB1.setText(buscado.get(0).getNombre());
                    lblPrecioB1.setText("PVP:" + buscado.get(0).getPrecio());
                    lblValorB1.setText("V:" + buscado.get(0).getValoracion().getValor());
                    lblMiniatura1.setIcon(Imagenes);

                }
                if (contador == 1) {
                    Imagenes = new ImageIcon("C://Users/Usuario iTC/Documents/NetBeansProjects/sTgaming/src/Img/" + buscado.get(1).getNombre() + "Miniatura.jpg");

                    JPBuscado2.setVisible(true);
                    lblNombreB2.setText(buscado.get(1).getNombre());
                    lblPrecioB2.setText("PVP:" + buscado.get(1).getPrecio());
                    lblValorB2.setText("V:" + buscado.get(1).getValoracion().getValor());
                    lblMiniatura2.setIcon(Imagenes);

                }
                if (contador == 2) {
                    Imagenes = new ImageIcon("C://Users/Usuario iTC/Documents/NetBeansProjects/sTgaming/src/Img/" + buscado.get(2).getNombre() + "Miniatura.jpg");

                    JPBuscado3.setVisible(true);
                    lblNombreB3.setText(buscado.get(2).getNombre());
                    lblPrecioB3.setText("PVP:" + buscado.get(2).getPrecio());
                    lblValorB3.setText("V:" + buscado.get(2).getValoracion().getValor());
                    lblMiniatura3.setIcon(Imagenes);

                }
                if (contador == 3) {
                    Imagenes = new ImageIcon("C://Users/Usuario iTC/Documents/NetBeansProjects/sTgaming/src/Img/" + buscado.get(3).getNombre() + "Miniatura.jpg");

                    JPBuscado4.setVisible(true);
                    lblNombreB4.setText(buscado.get(3).getNombre());
                    lblPrecioB4.setText("PVP:" + buscado.get(3).getPrecio());
                    lblValorB4.setText("V:" + buscado.get(3).getValoracion().getValor());
                    lblMiniatura4.setIcon(Imagenes);

                }
                if (contador == 4) {
                    Imagenes = new ImageIcon("C://Users/Usuario iTC/Documents/NetBeansProjects/sTgaming/src/Img/" + buscado.get(4).getNombre() + "Miniatura.jpg");

                    JPBuscado5.setVisible(true);
                    lblNombreB5.setText(buscado.get(4).getNombre());
                    lblPrecioB5.setText("PVP:" + buscado.get(4).getPrecio());
                    lblValorB5.setText("V:" + buscado.get(4).getValoracion().getValor());
                    lblMiniatura5.setIcon(Imagenes);

                }
                contador++;
            }

        } catch (Exception e) {
        }

    }//GEN-LAST:event_lblTiendaMouseClicked

    private void btnAdministrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministrarActionPerformed
        //MUESTRA EL PANEL DE ADMINISTRACION
        JPApartadoTendencias.setVisible(false);
        JPapartadoTienda.setVisible(false);
        JPapartadoComprar.setVisible(false);
        jPApartadoAdmin.setVisible(true);
        lblTienda.setForeground(new java.awt.Color(255, 255, 255));
        lblTendencias.setForeground(new java.awt.Color(255, 255, 255));

    }//GEN-LAST:event_btnAdministrarActionPerformed

    private void btnAdministrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdministrarMouseClicked


    }//GEN-LAST:event_btnAdministrarMouseClicked

    private void btnAgregarJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarJuegoActionPerformed
        AnadirJuego nuevo = new AnadirJuego();
        nuevo.setVisible(true);


    }//GEN-LAST:event_btnAgregarJuegoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        JOptionPane.showConfirmDialog(null, "Estas seguro de dar de baja/eliminar este juego", "Confirmar", WIDTH);
        int id = 0;
        DefaultListModel modelo2 = new DefaultListModel();

        for (int i = 0; i < listaedit.size(); i++) {
            if (JlistJuegosadmin.getSelectedValue().equals(listaedit.get(i).getNombre())) {
                try {
                    id = listaedit.get(i).getIdJuego();

                    cjuego.destroy(id);
                    modelo.remove(i);
                    listaedit.remove(listaedit.get(i));

                    JlistJuegosadmin.setModel(modelo);
                    JlistJuegosadmin.setVisible(true);

                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(paginaInicio.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
        }


    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int id = 0;
        for (int i = 0; i < listaedit.size(); i++) {
            if (JlistJuegosadmin.getSelectedValue().equals(listaedit.get(i).getNombre())) {
                id = listaedit.get(i).getIdJuego();
                EditarJuego nuevo = new EditarJuego(id);
                nuevo.setVisible(true);
            }
        }

    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarUsuarioActionPerformed

    private void btnAsignarAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAsignarAdminMouseClicked


    }//GEN-LAST:event_btnAsignarAdminMouseClicked

    private void btnAsignarAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarAdminActionPerformed
        //CAMBIA EL ROL A ADMINISTRADOR
        Entidades.Usuario user;
        try {
            for (int i = 0; i < listauser.size(); i++) {
                
                if (listauser.get(i).getCuentauser().getNickname().equals(JListUsuarios.getSelectedValue())) {

                    try {
                        user = listauser.get(i);

                        user.getRoluser().setIdrol(2);

                        cusuario.edit(user);

                    } catch (Exception ex) {
                        Logger.getLogger(paginaInicio.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
            }
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "Rol ya asignado");
        }

    }//GEN-LAST:event_btnAsignarAdminActionPerformed

    private void btnAsignarUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarUserActionPerformed
        //CAMBIA EL ROL A USUARIO
        Entidades.Usuario user;
        try {
            for (int i = 0; i < listauser.size(); i++) {
                
                if (listauser.get(i).getCuentauser().getNickname().equals(JListUsuarios.getSelectedValue())) {
                    
                    try {
                        user = listauser.get(i);
                        

                        user.getRoluser().setIdrol(1);
                        
                        cusuario.edit(user);
                        

                    } catch (Exception ex) {
                        Logger.getLogger(paginaInicio.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
            }
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "Rol ya asignado");
        }
    }//GEN-LAST:event_btnAsignarUserActionPerformed

    private void JPBuscado1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPBuscado1MouseClicked
        //CUANDO TIPEE ALGO EN EL BUSCADOR FILTRARA LAS BUSQUEDAS
        Icon Imagenes;
        jPApartadoAdmin.setVisible(false);
        JPapartadoTienda.setVisible(false);
        JPApartadoTendencias.setVisible(false);
        List<Entidades.Juego> listaJuegos = cjuego.findJuegoEntities();

        List<Entidades.ListaJuegos> Misjuegos = clisjue.findListaJuegosEntities();

        for (int i = 0; i < listaJuegos.size(); i++) {
            if (lblNombreB1.getText().equals(listaJuegos.get(i).getNombre())) {
                Imagenes = new ImageIcon("C://Users/Usuario iTC/Documents/NetBeansProjects/sTgaming/src/Img/" + listaJuegos.get(i).getNombre() + "Portada.jpg");
                lblPortada.setIcon(Imagenes);
                lblNombre.setText(listaJuegos.get(i).getNombre());
                lblValoracion.setText("Valoracion: " + listaJuegos.get(i).getValoracion().getValor());
                lblPrecio.setText("Precio: " + listaJuegos.get(i).getPrecio());
                jTextdescripcion.setText(listaJuegos.get(i).getDescripcion());
                jTextminimos.setText(listaJuegos.get(i).getRequisitosMIn());
                jTextrecomendados.setText(listaJuegos.get(i).getRequisitosRec());

                for (int k = 0; k < listacuentas.size(); k++) {
                    if (lblUsuario.getText().equals(listacuentas.get(k).getNickname())) {
                        for (int h = 0; h < Misjuegos.size(); h++) {
                            if (Misjuegos.get(h).getCuenta().getIdCuenta() == listacuentas.get(k).getIdCuenta()) {
                                if (listaJuegos.get(i).getIdJuego() == Misjuegos.get(h).getJuegos().getIdJuego()) {
                                    System.out.println("idd" + listaJuegos.get(i).getIdJuego());
                                    System.out.println("id" + Misjuegos.get(h).getJuegos().getIdJuego());
                                    btnComprarJuego.setText("COMPRADO");
                                } else {
                                    btnComprarJuego.setText("COMPRAR");

                                }

                            }

                        }
                    }
                }

                JPapartadoComprar.setVisible(true);
                JPvalorar.setVisible(false);

            }
        }


    }//GEN-LAST:event_JPBuscado1MouseClicked

    private void btnBuscarJuegoTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarJuegoTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarJuegoTActionPerformed

    private void lblTendenciasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTendenciasMouseClicked
        jPApartadoAdmin.setVisible(false);
        JPapartadoTienda.setVisible(false);
        JPApartadoTendencias.setVisible(true);
        lblTienda.setForeground(new java.awt.Color(255, 255, 255));
        lblTendencias.setForeground(new java.awt.Color(102, 153, 255));


    }//GEN-LAST:event_lblTendenciasMouseClicked

    private void btnComprarJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarJuegoActionPerformed
        //PERMITE COMPRAR UN JUEGO EN CASO DEQUE AUN NO LO POSEAS
        if (btnComprarJuego.getText().equals("COMPRAR")) {
            int id = 0;
            int iduser = 0;
            List<Entidades.Juego> listajuegos = cjuego.findJuegoEntities();
            Controlador.CuentaJpaController ccuenta = new CuentaJpaController();
            List<Entidades.Cuenta> listadecuentas = ccuenta.findCuentaEntities();
            for (int i = 0; i < listajuegos.size(); i++) {
                if (lblNombre.getText().equals(listajuegos.get(i).getNombre())) {
                    id = listajuegos.get(i).getIdJuego();
                }
            }
            for (int i = 0; i < listadecuentas.size(); i++) {
                if (lblUsuario.getText().equals(listadecuentas.get(i).getNickname())) {
                    iduser = listadecuentas.get(i).getIdCuenta();
                }
            }
            Tienda tienda = new Tienda(id, iduser);
            tienda.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Ya has comprado este juego");
        }

    }//GEN-LAST:event_btnComprarJuegoActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        //BUSCA LOS JUEGOS EN LA BASE DE DATOS
        cjuego.Buscarjuego(txtbuscar.getText());

        DefaultListModel modelbus = new DefaultListModel();
        for (int i = 0; i < cjuego.Buscarjuego(txtbuscar.getText()).size(); i++) {
            modelbus.addElement(cjuego.Buscarjuego(txtbuscar.getText()).get(i).getNombre());
        }
        JlistJuegosadmin.setModel(modelbus);
        JlistJuegosadmin.setVisible(true);


    }//GEN-LAST:event_txtbuscarKeyReleased

    private void txtbuscarusuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarusuarioKeyReleased
        //BUSCA USUARIOS EN LA BASE DE DATOS
        cusuario.Buscarusuario(txtbuscarusuario.getText());

        DefaultListModel modelbus = new DefaultListModel();
        for (int i = 0; i < cusuario.Buscarusuario(txtbuscarusuario.getText()).size(); i++) {
            modelbus.addElement(cusuario.Buscarusuario(txtbuscarusuario.getText()).get(i).getCuentauser().getNickname());
        }
        JListUsuarios.setModel(modelbus);
        JListUsuarios.setVisible(true);


    }//GEN-LAST:event_txtbuscarusuarioKeyReleased

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        Login n = new Login();
        n.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void txtbuscar2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscar2KeyReleased
        //CUANDO SE TIPEA EN EL BUSCADOR ENCUENTRA LAS COINCIIDENCIAS EN LA BASE DE DATOS Y SE ASIGNAN LOS DATOS DECADA JUEGO ENCONTRADO
        try {
            Icon Imagenes;
            JPapartadoTienda.setVisible(true);
            jPApartadoAdmin.setVisible(false);
            JPApartadoTendencias.setVisible(false);
            lblTienda.setForeground(new java.awt.Color(102, 153, 255));
            lblTendencias.setForeground(new java.awt.Color(255, 255, 255));
            //CONSULTA INICIAL
            JPBuscado1.setVisible(false);
            JPBuscado2.setVisible(false);
            JPBuscado3.setVisible(false);
            JPBuscado4.setVisible(false);
            JPBuscado5.setVisible(false);
            List<Entidades.Juego> buscado = cjuego.Buscarjuego(txtbuscar2.getText());
            int contador = 0;
            System.out.println(contador);
            for (int i = 0; i < buscado.size(); i++) {
                
                if (contador == 0) {
                    Imagenes = new ImageIcon("C://Users/Usuario iTC/Documents/NetBeansProjects/sTgaming/src/Img/" + buscado.get(0).getNombre() + "Miniatura.jpg");
                    
                    JPBuscado1.setVisible(true);
                    lblNombreB1.setText(buscado.get(0).getNombre());
                    lblPrecioB1.setText("PVP:" + buscado.get(0).getPrecio());
                    lblValorB1.setText("V:" + buscado.get(0).getValoracion().getValor());
                    lblMiniatura1.setIcon(Imagenes);

                }
                if (contador == 1) {
                    Imagenes = new ImageIcon("C://Users/Usuario iTC/Documents/NetBeansProjects/sTgaming/src/Img/" + buscado.get(1).getNombre() + "Miniatura.jpg");
                   
                    JPBuscado2.setVisible(true);
                    lblNombreB2.setText(buscado.get(1).getNombre());
                    lblPrecioB2.setText("PVP:" + buscado.get(1).getPrecio());
                    lblValorB2.setText("V:" + buscado.get(1).getValoracion().getValor());
                    lblMiniatura2.setIcon(Imagenes);

                }
                if (contador == 2) {
                    Imagenes = new ImageIcon("C://Users/Usuario iTC/Documents/NetBeansProjects/sTgaming/src/Img/" + buscado.get(2).getNombre() + "Miniatura.jpg");
                    
                    JPBuscado3.setVisible(true);
                    lblNombreB3.setText(buscado.get(2).getNombre());
                    lblPrecioB3.setText("PVP:" + buscado.get(2).getPrecio());
                    lblValorB3.setText("V:" + buscado.get(2).getValoracion().getValor());
                    lblMiniatura3.setIcon(Imagenes);

                }
                if (contador == 3) {
                    Imagenes = new ImageIcon("C://Users/Usuario iTC/Documents/NetBeansProjects/sTgaming/src/Img/" + buscado.get(3).getNombre() + "Miniatura.jpg");
                    
                    JPBuscado4.setVisible(true);
                    lblNombreB4.setText(buscado.get(3).getNombre());
                    lblPrecioB4.setText("PVP:" + buscado.get(3).getPrecio());
                    lblValorB4.setText("V:" + buscado.get(3).getValoracion().getValor());
                    lblMiniatura4.setIcon(Imagenes);

                }
                if (contador == 4) {
                    Imagenes = new ImageIcon("C://Users/Usuario iTC/Documents/NetBeansProjects/sTgaming/src/Img/" + buscado.get(4).getNombre() + "Miniatura.jpg");
                    
                    JPBuscado5.setVisible(true);
                    lblNombreB5.setText(buscado.get(4).getNombre());
                    lblPrecioB5.setText("PVP:" + buscado.get(4).getPrecio());
                    lblValorB5.setText("V:" + buscado.get(4).getValoracion().getValor());
                    lblMiniatura5.setIcon(Imagenes);

                }
                contador++;
            }

        } catch (Exception e) {
        }

    }//GEN-LAST:event_txtbuscar2KeyReleased

    private void JPBuscado2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPBuscado2MouseClicked
        //LLEVA A LA PAGINA PARA COMPRAR JUEGO
        Icon Imagenes;
        jPApartadoAdmin.setVisible(false);
        JPapartadoTienda.setVisible(false);
        JPApartadoTendencias.setVisible(false);
        List<Entidades.Juego> listaJuegos = cjuego.findJuegoEntities();
        List<Entidades.ListaJuegos> Misjuegos = clisjue.findListaJuegosEntities();
        for (int i = 0; i < listaJuegos.size(); i++) {
            if (lblNombreB2.getText().equals(listaJuegos.get(i).getNombre())) {
                Imagenes = new ImageIcon("C://Users/Usuario iTC/Documents/NetBeansProjects/sTgaming/src/Img/" + listaJuegos.get(i).getNombre() + "Portada.jpg");
                lblPortada.setIcon(Imagenes);
                lblNombre.setText(listaJuegos.get(i).getNombre());
                lblValoracion.setText("Valoracion: " + listaJuegos.get(i).getValoracion().getValor());
                lblPrecio.setText("Precio: " + listaJuegos.get(i).getPrecio());
                jTextdescripcion.setText(listaJuegos.get(i).getDescripcion());
                jTextminimos.setText(listaJuegos.get(i).getRequisitosMIn());
                jTextrecomendados.setText(listaJuegos.get(i).getRequisitosRec());
                for (int k = 0; k < listacuentas.size(); k++) {
                    if (lblUsuario.getText().equals(listacuentas.get(k).getNickname())) {
                        for (int h = 0; h < Misjuegos.size(); h++) {
                            if (Misjuegos.get(h).getCuenta().getIdCuenta() == listacuentas.get(k).getIdCuenta()) {
                                if (listaJuegos.get(i).getIdJuego() == Misjuegos.get(h).getJuegos().getIdJuego()) {
                                    System.out.println("idd" + listaJuegos.get(i).getIdJuego());
                                    System.out.println("id" + Misjuegos.get(h).getJuegos().getIdJuego());
                                    btnComprarJuego.setText("COMPRADO");
                                } else {
                                    btnComprarJuego.setText("COMPRAR");

                                }

                            }

                        }
                    }
                }

                JPapartadoComprar.setVisible(true);
                JPvalorar.setVisible(false);

            }
        }
    }//GEN-LAST:event_JPBuscado2MouseClicked
    //TODOS LOS SIGUIENTES HACEN EL MISMO PROCESO
    private void JPBuscado3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPBuscado3MouseClicked
        Icon Imagenes;
        jPApartadoAdmin.setVisible(false);
        JPapartadoTienda.setVisible(false);
        JPApartadoTendencias.setVisible(false);
        List<Entidades.Juego> listaJuegos = cjuego.findJuegoEntities();
        List<Entidades.ListaJuegos> Misjuegos = clisjue.findListaJuegosEntities();
        for (int i = 0; i < listaJuegos.size(); i++) {
            if (lblNombreB3.getText().equals(listaJuegos.get(i).getNombre())) {
                Imagenes = new ImageIcon("C://Users/Usuario iTC/Documents/NetBeansProjects/sTgaming/src/Img/" + listaJuegos.get(i).getNombre() + "Portada.jpg");
                lblPortada.setIcon(Imagenes);
                lblNombre.setText(listaJuegos.get(i).getNombre());
                lblValoracion.setText("Valoracion: " + listaJuegos.get(i).getValoracion().getValor());
                lblPrecio.setText("Precio: " + listaJuegos.get(i).getPrecio());
                jTextdescripcion.setText(listaJuegos.get(i).getDescripcion());
                jTextminimos.setText(listaJuegos.get(i).getRequisitosMIn());
                jTextrecomendados.setText(listaJuegos.get(i).getRequisitosRec());
                for (int k = 0; k < listacuentas.size(); k++) {
                    if (lblUsuario.getText().equals(listacuentas.get(k).getNickname())) {
                        for (int h = 0; h < Misjuegos.size(); h++) {
                            if (Misjuegos.get(h).getCuenta().getIdCuenta() == listacuentas.get(k).getIdCuenta()) {
                                if (listaJuegos.get(i).getIdJuego() == Misjuegos.get(h).getJuegos().getIdJuego()) {
                                    System.out.println("idd" + listaJuegos.get(i).getIdJuego());
                                    System.out.println("id" + Misjuegos.get(h).getJuegos().getIdJuego());
                                    btnComprarJuego.setText("COMPRADO");
                                } else {
                                    btnComprarJuego.setText("COMPRAR");

                                }

                            }

                        }
                    }
                }
                JPapartadoComprar.setVisible(true);
                JPvalorar.setVisible(false);

            }
        }
    }//GEN-LAST:event_JPBuscado3MouseClicked

    private void JPBuscado4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPBuscado4MouseClicked
        Icon Imagenes;
        jPApartadoAdmin.setVisible(false);
        JPapartadoTienda.setVisible(false);
        JPApartadoTendencias.setVisible(false);
        List<Entidades.Juego> listaJuegos = cjuego.findJuegoEntities();
        List<Entidades.ListaJuegos> Misjuegos = clisjue.findListaJuegosEntities();
        for (int i = 0; i < listaJuegos.size(); i++) {
            if (lblNombreB4.getText().equals(listaJuegos.get(i).getNombre())) {
                Imagenes = new ImageIcon("C://Users/Usuario iTC/Documents/NetBeansProjects/sTgaming/src/Img/" + listaJuegos.get(i).getNombre() + "Portada.jpg");
                lblPortada.setIcon(Imagenes);
                lblNombre.setText(listaJuegos.get(i).getNombre());
                lblValoracion.setText("Valoracion: " + listaJuegos.get(i).getValoracion().getValor());
                lblPrecio.setText("Precio: " + listaJuegos.get(i).getPrecio());
                jTextdescripcion.setText(listaJuegos.get(i).getDescripcion());
                jTextminimos.setText(listaJuegos.get(i).getRequisitosMIn());
                jTextrecomendados.setText(listaJuegos.get(i).getRequisitosRec());
                JPapartadoComprar.setVisible(true);
                JPvalorar.setVisible(false);

            }
        }
    }//GEN-LAST:event_JPBuscado4MouseClicked

    private void JPBuscado5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPBuscado5MouseClicked
        Icon Imagenes;
        jPApartadoAdmin.setVisible(false);
        JPapartadoTienda.setVisible(false);
        JPApartadoTendencias.setVisible(false);
        List<Entidades.Juego> listaJuegos = cjuego.findJuegoEntities();
        List<Entidades.ListaJuegos> Misjuegos = clisjue.findListaJuegosEntities();
        for (int i = 0; i < listaJuegos.size(); i++) {
            if (lblNombreB5.getText().equals(listaJuegos.get(i).getNombre())) {
                Imagenes = new ImageIcon("C://Users/Usuario iTC/Documents/NetBeansProjects/sTgaming/src/Img/" + listaJuegos.get(i).getNombre() + "Portada.jpg");
                lblPortada.setIcon(Imagenes);
                lblNombre.setText(listaJuegos.get(i).getNombre());
                lblValoracion.setText("Valoracion: " + listaJuegos.get(i).getValoracion().getValor());
                lblPrecio.setText("Precio: " + listaJuegos.get(i).getPrecio());
                jTextdescripcion.setText(listaJuegos.get(i).getDescripcion());
                jTextminimos.setText(listaJuegos.get(i).getRequisitosMIn());
                jTextrecomendados.setText(listaJuegos.get(i).getRequisitosRec());
                for (int k = 0; k < listacuentas.size(); k++) {
                    if (lblUsuario.getText().equals(listacuentas.get(k).getNickname())) {
                        for (int h = 0; h < Misjuegos.size(); h++) {
                            if (Misjuegos.get(h).getCuenta().getIdCuenta() == listacuentas.get(k).getIdCuenta()) {
                                if (listaJuegos.get(i).getIdJuego() == Misjuegos.get(h).getJuegos().getIdJuego()) {
                                    System.out.println("idd" + listaJuegos.get(i).getIdJuego());
                                    System.out.println("id" + Misjuegos.get(h).getJuegos().getIdJuego());
                                    btnComprarJuego.setText("COMPRADO");
                                } else {
                                    btnComprarJuego.setText("COMPRAR");

                                }

                            }

                        }
                    }
                }
                JPapartadoComprar.setVisible(true);
                JPvalorar.setVisible(false);

            }
        }
    }//GEN-LAST:event_JPBuscado5MouseClicked

    private void lblNombreB1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNombreB1MouseClicked
        Icon Imagenes;
        jPApartadoAdmin.setVisible(false);
        JPapartadoTienda.setVisible(false);
        JPApartadoTendencias.setVisible(false);
        List<Entidades.Juego> listaJuegos = cjuego.findJuegoEntities();
        List<Entidades.ListaJuegos> Misjuegos = clisjue.findListaJuegosEntities();
        for (int i = 0; i < listaJuegos.size(); i++) {
            if (lblNombreB1.getText().equals(listaJuegos.get(i).getNombre())) {
                Imagenes = new ImageIcon("C://Users/Usuario iTC/Documents/NetBeansProjects/sTgaming/src/Img/" + listaJuegos.get(i).getNombre() + "Portada.jpg");
                lblPortada.setIcon(Imagenes);
                lblNombre.setText(listaJuegos.get(i).getNombre());
                lblValoracion.setText("Valoracion: " + listaJuegos.get(i).getValoracion().getValor());
                lblPrecio.setText("Precio: " + listaJuegos.get(i).getPrecio());
                jTextdescripcion.setText(listaJuegos.get(i).getDescripcion());
                jTextminimos.setText(listaJuegos.get(i).getRequisitosMIn());
                jTextrecomendados.setText(listaJuegos.get(i).getRequisitosRec());
                for (int k = 0; k < listacuentas.size(); k++) {
                    if (lblUsuario.getText().equals(listacuentas.get(k).getNickname())) {
                        for (int h = 0; h < Misjuegos.size(); h++) {
                            if (Misjuegos.get(h).getCuenta().getIdCuenta() == listacuentas.get(k).getIdCuenta()) {
                                if (listaJuegos.get(i).getIdJuego() == Misjuegos.get(h).getJuegos().getIdJuego()) {
                                    System.out.println("idd" + listaJuegos.get(i).getIdJuego());
                                    System.out.println("id" + Misjuegos.get(h).getJuegos().getIdJuego());
                                    btnComprarJuego.setText("COMPRADO");
                                } else {
                                    btnComprarJuego.setText("COMPRAR");

                                }

                            }

                        }
                    }
                }
                JPapartadoComprar.setVisible(true);
                JPvalorar.setVisible(false);

            }
        }
    }//GEN-LAST:event_lblNombreB1MouseClicked

    private void lblNombreB2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNombreB2MouseClicked
        Icon Imagenes;
        jPApartadoAdmin.setVisible(false);
        JPapartadoTienda.setVisible(false);
        JPApartadoTendencias.setVisible(false);
        List<Entidades.Juego> listaJuegos = cjuego.findJuegoEntities();
        List<Entidades.ListaJuegos> Misjuegos = clisjue.findListaJuegosEntities();
        for (int i = 0; i < listaJuegos.size(); i++) {
            if (lblNombreB2.getText().equals(listaJuegos.get(i).getNombre())) {
                Imagenes = new ImageIcon("C://Users/Usuario iTC/Documents/NetBeansProjects/sTgaming/src/Img/" + listaJuegos.get(i).getNombre() + "Portada.jpg");
                lblPortada.setIcon(Imagenes);
                lblNombre.setText(listaJuegos.get(i).getNombre());
                lblValoracion.setText("Valoracion: " + listaJuegos.get(i).getValoracion().getValor());
                lblPrecio.setText("Precio: " + listaJuegos.get(i).getPrecio());
                jTextdescripcion.setText(listaJuegos.get(i).getDescripcion());
                jTextminimos.setText(listaJuegos.get(i).getRequisitosMIn());
                jTextrecomendados.setText(listaJuegos.get(i).getRequisitosRec());
                for (int k = 0; k < listacuentas.size(); k++) {
                    if (lblUsuario.getText().equals(listacuentas.get(k).getNickname())) {
                        for (int h = 0; h < Misjuegos.size(); h++) {
                            if (Misjuegos.get(h).getCuenta().getIdCuenta() == listacuentas.get(k).getIdCuenta()) {
                                if (listaJuegos.get(i).getIdJuego() == Misjuegos.get(h).getJuegos().getIdJuego()) {
                                    System.out.println("idd" + listaJuegos.get(i).getIdJuego());
                                    System.out.println("id" + Misjuegos.get(h).getJuegos().getIdJuego());
                                    btnComprarJuego.setText("COMPRADO");
                                } else {
                                    btnComprarJuego.setText("COMPRAR");

                                }

                            }

                        }
                    }
                }
                JPapartadoComprar.setVisible(true);
                JPvalorar.setVisible(false);

            }
        }
    }//GEN-LAST:event_lblNombreB2MouseClicked

    private void lblNombreB3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNombreB3MouseClicked
        Icon Imagenes;
        jPApartadoAdmin.setVisible(false);
        JPapartadoTienda.setVisible(false);
        JPApartadoTendencias.setVisible(false);
        List<Entidades.Juego> listaJuegos = cjuego.findJuegoEntities();
        List<Entidades.ListaJuegos> Misjuegos = clisjue.findListaJuegosEntities();
        for (int i = 0; i < listaJuegos.size(); i++) {
            if (lblNombreB3.getText().equals(listaJuegos.get(i).getNombre())) {
                Imagenes = new ImageIcon("C://Users/Usuario iTC/Documents/NetBeansProjects/sTgaming/src/Img/" + listaJuegos.get(i).getNombre() + "Portada.jpg");
                lblPortada.setIcon(Imagenes);
                lblNombre.setText(listaJuegos.get(i).getNombre());
                lblValoracion.setText("Valoracion: " + listaJuegos.get(i).getValoracion().getValor());
                lblPrecio.setText("Precio: " + listaJuegos.get(i).getPrecio());
                jTextdescripcion.setText(listaJuegos.get(i).getDescripcion());
                jTextminimos.setText(listaJuegos.get(i).getRequisitosMIn());
                jTextrecomendados.setText(listaJuegos.get(i).getRequisitosRec());
                for (int k = 0; k < listacuentas.size(); k++) {
                    if (lblUsuario.getText().equals(listacuentas.get(k).getNickname())) {
                        for (int h = 0; h < Misjuegos.size(); h++) {
                            if (Misjuegos.get(h).getCuenta().getIdCuenta() == listacuentas.get(k).getIdCuenta()) {
                                if (listaJuegos.get(i).getIdJuego() == Misjuegos.get(h).getJuegos().getIdJuego()) {
                                    System.out.println("idd" + listaJuegos.get(i).getIdJuego());
                                    System.out.println("id" + Misjuegos.get(h).getJuegos().getIdJuego());
                                    btnComprarJuego.setText("COMPRADO");
                                } else {
                                    btnComprarJuego.setText("COMPRAR");

                                }

                            }

                        }
                    }
                }
                JPapartadoComprar.setVisible(true);
                JPvalorar.setVisible(false);

            }
        }
    }//GEN-LAST:event_lblNombreB3MouseClicked

    private void lblNombreB4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNombreB4MouseClicked
        Icon Imagenes;
        jPApartadoAdmin.setVisible(false);
        JPapartadoTienda.setVisible(false);
        JPApartadoTendencias.setVisible(false);
        List<Entidades.Juego> listaJuegos = cjuego.findJuegoEntities();
        List<Entidades.ListaJuegos> Misjuegos = clisjue.findListaJuegosEntities();
        for (int i = 0; i < listaJuegos.size(); i++) {
            if (lblNombreB4.getText().equals(listaJuegos.get(i).getNombre())) {
                Imagenes = new ImageIcon("C://Users/Usuario iTC/Documents/NetBeansProjects/sTgaming/src/Img/" + listaJuegos.get(i).getNombre() + "Portada.jpg");
                lblPortada.setIcon(Imagenes);
                lblNombre.setText(listaJuegos.get(i).getNombre());
                lblValoracion.setText("Valoracion: " + listaJuegos.get(i).getValoracion().getValor());
                lblPrecio.setText("Precio: " + listaJuegos.get(i).getPrecio());
                jTextdescripcion.setText(listaJuegos.get(i).getDescripcion());
                jTextminimos.setText(listaJuegos.get(i).getRequisitosMIn());
                jTextrecomendados.setText(listaJuegos.get(i).getRequisitosRec());
                for (int k = 0; k < listacuentas.size(); k++) {
                    if (lblUsuario.getText().equals(listacuentas.get(k).getNickname())) {
                        for (int h = 0; h < Misjuegos.size(); h++) {
                            if (Misjuegos.get(h).getCuenta().getIdCuenta() == listacuentas.get(k).getIdCuenta()) {
                                if (listaJuegos.get(i).getIdJuego() == Misjuegos.get(h).getJuegos().getIdJuego()) {
                                    System.out.println("idd" + listaJuegos.get(i).getIdJuego());
                                    System.out.println("id" + Misjuegos.get(h).getJuegos().getIdJuego());
                                    btnComprarJuego.setText("COMPRADO");
                                } else {
                                    btnComprarJuego.setText("COMPRAR");

                                }

                            }

                        }
                    }
                }
                JPapartadoComprar.setVisible(true);
                JPvalorar.setVisible(false);

            }
        }
    }//GEN-LAST:event_lblNombreB4MouseClicked

    private void lblNombreB5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNombreB5MouseClicked
        Icon Imagenes;
        jPApartadoAdmin.setVisible(false);
        JPapartadoTienda.setVisible(false);
        JPApartadoTendencias.setVisible(false);
        List<Entidades.Juego> listaJuegos = cjuego.findJuegoEntities();
        List<Entidades.ListaJuegos> Misjuegos = clisjue.findListaJuegosEntities();
        for (int i = 0; i < listaJuegos.size(); i++) {
            if (lblNombreB5.getText().equals(listaJuegos.get(i).getNombre())) {
                Imagenes = new ImageIcon("C://Users/Usuario iTC/Documents/NetBeansProjects/sTgaming/src/Img/" + listaJuegos.get(i).getNombre() + "Portada.jpg");
                lblPortada.setIcon(Imagenes);
                lblNombre.setText(listaJuegos.get(i).getNombre());
                lblValoracion.setText("Valoracion: " + listaJuegos.get(i).getValoracion().getValor());
                lblPrecio.setText("Precio: " + listaJuegos.get(i).getPrecio());
                jTextdescripcion.setText(listaJuegos.get(i).getDescripcion());
                jTextminimos.setText(listaJuegos.get(i).getRequisitosMIn());
                jTextrecomendados.setText(listaJuegos.get(i).getRequisitosRec());
                for (int k = 0; k < listacuentas.size(); k++) {
                    if (lblUsuario.getText().equals(listacuentas.get(k).getNickname())) {
                        for (int h = 0; h < Misjuegos.size(); h++) {
                            if (Misjuegos.get(h).getCuenta().getIdCuenta() == listacuentas.get(k).getIdCuenta()) {
                                if (listaJuegos.get(i).getIdJuego() == Misjuegos.get(h).getJuegos().getIdJuego()) {
                                    System.out.println("idd" + listaJuegos.get(i).getIdJuego());
                                    System.out.println("id" + Misjuegos.get(h).getJuegos().getIdJuego());
                                    btnComprarJuego.setText("COMPRADO");
                                } else {
                                    btnComprarJuego.setText("COMPRAR");

                                }

                            }

                        }
                    }
                }
                JPapartadoComprar.setVisible(true);
                JPvalorar.setVisible(false);

            }
        }
    }//GEN-LAST:event_lblNombreB5MouseClicked

    private void lblMisjuegosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMisjuegosMouseClicked
        List<Entidades.ListaJuegos> Misjuegos = clisjue.findListaJuegosEntities();
        DefaultListModel modelolista = new DefaultListModel();
        for (int i = 0; i < listacuentas.size(); i++) {
            if (lblUsuario.getText().equals(listacuentas.get(i).getNickname())) {
                for (int j = 0; j < Misjuegos.size(); j++) {
                    if (Misjuegos.get(j).getCuenta().getIdCuenta() == listacuentas.get(i).getIdCuenta()) {
                        modelolista.addElement(Misjuegos.get(j).getJuegos().getNombre());
                    }

                }
            }
        }
        JLMisjuegos.setModel(modelolista);
        JLMisjuegos.setVisible(true);


    }//GEN-LAST:event_lblMisjuegosMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        List<Entidades.Juego> juegos = cjuego.findJuegoEntities();
        DefaultListModel modelolista = new DefaultListModel();
        for (int i = 0; i < juegos.size(); i++) {

            modelolista.addElement(juegos.get(i).getNombre());

        }
        JlistJuegosadmin.setModel(modelolista);
        JlistJuegosadmin.setVisible(true);


    }//GEN-LAST:event_jLabel3MouseClicked

    private void btnComprarJuego1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarJuego1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnComprarJuego1ActionPerformed

    private void lblValoracionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblValoracionMouseClicked
        //MUESTRA LA SECCION DE VALORAR
        JPvalorar.setVisible(true);
    }//GEN-LAST:event_lblValoracionMouseClicked

    private void btnGuardarValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarValorActionPerformed
        //PERMITE VALORAR UN JUEGO
        double valoracion = 0;
        double resultado = 0;
        if (jRadioButton1.isSelected()) {
            valoracion = 1;
        } else if (jRadioButton2.isSelected()) {
            valoracion = 2;
        } else if (jRadioButton3.isSelected()) {
            valoracion = 3;
        } else if (jRadioButton4.isSelected()) {
            valoracion = 4;
        } else if (jRadioButton5.isSelected()) {
            valoracion = 5;
        } else {
            JOptionPane.showMessageDialog(null, "No ha selecionado una valoración");
        }
        if (valoracion != 0) {

            List<Entidades.Juego> listavalora = cjuego.findJuegoEntities();
             List<Entidades.Valoracion> valoraciones = cvaloracion.findValoracionEntities();
            for (int i = 0; i < listavalora.size(); i++) {

                if (lblNombre.getText().equals(listavalora.get(i).getNombre())) {

                    try {
                        if (Double.parseDouble(listavalora.get(i).getValoracion().getValor()) != 0.0) {

                            resultado = (valoracion + Double.parseDouble(listavalora.get(i).getValoracion().getValor())) / 2;
                            listavalora.get(i).getValoracion().setValor(Double.toString(resultado));
                            Entidades.Juego juego = new Juego();
                            juego = listavalora.get(i);
                            cjuego.edit(juego);
                            lblValoracion.setText("Valoracion: " + listavalora.get(i).getValoracion().getValor());
                            System.out.println("VAloracion2");

                        } else {
                            
                            resultado = valoracion;
                            listavalora.get(i).getValoracion().setValor(Double.toString(resultado));
                            for (int j = 0; j < valoraciones.size(); j++) {
                                if (listavalora.get(i).getValoracion().getIdvaloracion()==valoraciones.get(j).getIdvaloracion()) {
                                    cvaloracion.findValoracion(valoraciones.get(j).getIdvaloracion());
                                    
                                    
                                }
                            }
                            
                            lblValoracion.setText("Valoracion:" + listavalora.get(i).getValoracion().getValor());
                           

                        }

                    } catch (Exception ex) {
                        Logger.getLogger(paginaInicio.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            JPvalorar.setVisible(false);
        } else {
            JPvalorar.setVisible(false);

        }

    }//GEN-LAST:event_btnGuardarValorActionPerformed

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
            java.util.logging.Logger.getLogger(paginaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(paginaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(paginaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(paginaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new paginaInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JList<String> JLMisjuegos;
    private javax.swing.JList<String> JListUsuarios;
    private javax.swing.JPanel JPAdminRol;
    private javax.swing.JPanel JPApartadoTendencias;
    private javax.swing.JPanel JPBuscado1;
    private javax.swing.JPanel JPBuscado2;
    private javax.swing.JPanel JPBuscado3;
    private javax.swing.JPanel JPBuscado4;
    private javax.swing.JPanel JPBuscado5;
    private javax.swing.JPanel JPMisjuegos;
    private javax.swing.JPanel JPadministrarRoles;
    private javax.swing.JPanel JPapartadoComprar;
    private javax.swing.JPanel JPapartadoTienda;
    private javax.swing.JScrollPane JPdescripcionjuego;
    private javax.swing.JPanel JPjuego;
    private javax.swing.JPanel JPjuegoBuscado;
    private javax.swing.JScrollPane JPjuegosTienda;
    private javax.swing.JPanel JPmenu;
    private javax.swing.JScrollPane JPrequisitosMi;
    private javax.swing.JPanel JPtendencia1;
    private javax.swing.JPanel JPtendencia2;
    private javax.swing.JPanel JPtendencia3;
    private javax.swing.JPanel JPtendencia4;
    private javax.swing.JPanel JPtendencia5;
    private javax.swing.JPanel JPtendencia6;
    private javax.swing.JPanel JPtendencia7;
    private javax.swing.JPanel JPtendencia8;
    private javax.swing.JPanel JPtendencia9;
    public javax.swing.JPanel JPvalorar;
    private javax.swing.JList<String> JlistJuegosadmin;
    private javax.swing.JPanel PAdministrarJuegos;
    private javax.swing.JTabbedPane PesstaañasAdmin;
    private javax.swing.JPanel Pjuegos;
    private javax.swing.JScrollPane SCadministracion;
    private javax.swing.JScrollPane SPJuego;
    private javax.swing.JScrollPane SPMisjuegos;
    private javax.swing.JScrollPane SPRRe;
    private javax.swing.JScrollPane SPjuegos;
    private javax.swing.JScrollPane SPtendencias;
    private javax.swing.JScrollPane SpUsers;
    public javax.swing.JButton btnAdministrar;
    private javax.swing.JButton btnAgregarJuego;
    private javax.swing.JRadioButton btnAsignarAdmin;
    private javax.swing.JRadioButton btnAsignarUser;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarJuegoT;
    private javax.swing.JButton btnBuscarUsuario;
    public javax.swing.JButton btnComprarJuego;
    private javax.swing.JButton btnComprarJuego1;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardarValor;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPApartadoAdmin;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JTextArea jTextdescripcion;
    private javax.swing.JTextArea jTextminimos;
    private javax.swing.JTextArea jTextrecomendados;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblMinT1;
    private javax.swing.JLabel lblMinT2;
    private javax.swing.JLabel lblMinT3;
    private javax.swing.JLabel lblMinT4;
    private javax.swing.JLabel lblMinT5;
    private javax.swing.JLabel lblMinT6;
    private javax.swing.JLabel lblMinT7;
    private javax.swing.JLabel lblMinT8;
    private javax.swing.JLabel lblMinT9;
    private javax.swing.JLabel lblMiniatura1;
    private javax.swing.JLabel lblMiniatura2;
    private javax.swing.JLabel lblMiniatura3;
    private javax.swing.JLabel lblMiniatura4;
    private javax.swing.JLabel lblMiniatura5;
    private javax.swing.JLabel lblMisjuegos;
    private javax.swing.JLabel lblNomT1;
    private javax.swing.JLabel lblNomT2;
    private javax.swing.JLabel lblNomT3;
    private javax.swing.JLabel lblNomT4;
    private javax.swing.JLabel lblNomT5;
    private javax.swing.JLabel lblNomT6;
    private javax.swing.JLabel lblNomT7;
    private javax.swing.JLabel lblNomT8;
    private javax.swing.JLabel lblNomT9;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreB1;
    private javax.swing.JLabel lblNombreB2;
    private javax.swing.JLabel lblNombreB3;
    private javax.swing.JLabel lblNombreB4;
    private javax.swing.JLabel lblNombreB5;
    private javax.swing.JLabel lblPortada;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblPrecioB1;
    private javax.swing.JLabel lblPrecioB2;
    private javax.swing.JLabel lblPrecioB3;
    private javax.swing.JLabel lblPrecioB4;
    private javax.swing.JLabel lblPrecioB5;
    private javax.swing.JLabel lblTendencias;
    private javax.swing.JLabel lblTienda;
    public javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblValT1;
    private javax.swing.JLabel lblValT2;
    private javax.swing.JLabel lblValT3;
    private javax.swing.JLabel lblValT4;
    private javax.swing.JLabel lblValT5;
    private javax.swing.JLabel lblValT6;
    private javax.swing.JLabel lblValT7;
    private javax.swing.JLabel lblValT8;
    private javax.swing.JLabel lblValT9;
    private javax.swing.JLabel lblValorB1;
    private javax.swing.JLabel lblValorB2;
    private javax.swing.JLabel lblValorB3;
    private javax.swing.JLabel lblValorB4;
    private javax.swing.JLabel lblValorB5;
    private javax.swing.JLabel lblValoracion;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.MenuBar menuBar1;
    private javax.swing.JLabel mint6;
    private javax.swing.JPanel pGeneral;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtbuscar2;
    private javax.swing.JTextField txtbuscarusuario;
    // End of variables declaration//GEN-END:variables
}
