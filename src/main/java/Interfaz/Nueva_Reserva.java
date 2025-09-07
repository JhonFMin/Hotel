package Interfaz;

import Nodos.Logica;
import Objetos.Cliente;
import java.awt.Color;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JTextField;

// Importamos la clase para los diálogos personalizados
import Interfaz.DialogoPersonalizado;

public class Nueva_Reserva extends javax.swing.JFrame {

    private final Logica logicaHotel;

    public Nueva_Reserva(Logica logicaHotel) {
        setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        this.logicaHotel = logicaHotel;
        personalizarInterfaz();

        cerrarsesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarsesionMouseClicked(evt);
            }
        });
    }

    private void personalizarInterfaz() {
        estilizarCampoFecha((JTextField) FechaDIngreso.getDateEditor().getUiComponent());
        estilizarCampoFecha((JTextField) FechaDSalida.getDateEditor().getUiComponent());
    }

    private void estilizarCampoFecha(JTextField editor) {
        Color fondoOscuro = new Color(15, 22, 36);
        editor.setBackground(fondoOscuro);
        editor.setForeground(Color.WHITE);
        editor.setBorder(null);
        editor.setCaretColor(new Color(255, 59, 107));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FechaDSalida = new com.toedter.calendar.JDateChooser();
        FechaDIngreso = new com.toedter.calendar.JDateChooser();
        nombre = new javax.swing.JTextField();
        telefono = new javax.swing.JTextField();
        direccion = new javax.swing.JTextField();
        gmail = new javax.swing.JTextField();
        documento = new javax.swing.JTextField();
        tipodocumento = new javax.swing.JComboBox<>();
        Registrar = new javax.swing.JButton();
        cerrarsesion = new javax.swing.JPanel();
        menuButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FechaDSalida.setBackground(new java.awt.Color(15, 22, 36));
        FechaDSalida.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        getContentPane().add(FechaDSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 510, 200, 40));

        FechaDIngreso.setBackground(new java.awt.Color(15, 22, 36));
        FechaDIngreso.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        getContentPane().add(FechaDIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 510, 200, 40));

        nombre.setBackground(new java.awt.Color(15, 22, 36));
        nombre.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        nombre.setForeground(new java.awt.Color(255, 255, 255));
        nombre.setBorder(null);
        getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, 350, 20));

        telefono.setBackground(new java.awt.Color(15, 22, 36));
        telefono.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        telefono.setForeground(new java.awt.Color(255, 255, 255));
        telefono.setBorder(null);
        getContentPane().add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, 350, 20));

        direccion.setBackground(new java.awt.Color(15, 22, 36));
        direccion.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        direccion.setForeground(new java.awt.Color(255, 255, 255));
        direccion.setBorder(null);
        getContentPane().add(direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 510, 350, 20));

        gmail.setBackground(new java.awt.Color(15, 22, 36));
        gmail.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        gmail.setForeground(new java.awt.Color(255, 255, 255));
        gmail.setBorder(null);
        getContentPane().add(gmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 440, 350, 20));

        documento.setBackground(new java.awt.Color(15, 22, 36));
        documento.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        documento.setForeground(new java.awt.Color(255, 255, 255));
        documento.setBorder(null);
        getContentPane().add(documento, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 360, 350, 20));

        tipodocumento.setBackground(new java.awt.Color(255, 59, 107));
        tipodocumento.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        tipodocumento.setForeground(new java.awt.Color(15, 23, 36));
        tipodocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CC", "CE", "Pasaporte" }));
        tipodocumento.setBorder(null);
        getContentPane().add(tipodocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 280, 220, 30));

        Registrar.setBorderPainted(false);
        Registrar.setContentAreaFilled(false);
        Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 670, 80, 80));

        cerrarsesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cerrarsesion.setOpaque(false);
        cerrarsesion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(cerrarsesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 660, 80, 80));

        menuButton.setBorderPainted(false);
        menuButton.setContentAreaFilled(false);
        menuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButtonActionPerformed(evt);
            }
        });
        getContentPane().add(menuButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 660, 100, 90));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\USUARIO\\Documents\\NetBeansProjects\\Hotel\\src\\main\\java\\Interfaz\\Sources\\Nueva Reserva.png")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        Menu menu = new Menu(this.logicaHotel);
        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
    }

    private void RegistrarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String nombreCliente = nombre.getText().trim();
            String celularCliente = telefono.getText().trim();
            String emailCliente = gmail.getText().trim();
            String direccionCliente = direccion.getText().trim();
            String tipoDoc = (String) tipodocumento.getSelectedItem();
            String numDoc = documento.getText().trim();
            Date fechaIngresoUtil = FechaDIngreso.getDate();
            Date fechaSalidaUtil = FechaDSalida.getDate();

            if (nombreCliente.isEmpty() || celularCliente.isEmpty() || emailCliente.isEmpty()
                    || direccionCliente.isEmpty() || numDoc.isEmpty() || fechaIngresoUtil == null || fechaSalidaUtil == null) {
                DialogoPersonalizado.mostrar(this, "Campos Vacíos", "Por favor, complete todos los campos.", DialogoPersonalizado.TIPO_ADVERTENCIA);
                return;
            }

            String idCompleto = tipoDoc.trim() + "-" + numDoc;
            LocalDate fechaIngreso = fechaIngresoUtil.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate fechaSalida = fechaSalidaUtil.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            if (!logicaHotel.validarFechas(fechaIngreso, fechaSalida)) {
                DialogoPersonalizado.mostrar(this, "Error de Fechas", "La fecha de salida debe ser posterior a la de ingreso.", DialogoPersonalizado.TIPO_ERROR);
                return;
            }

            if (logicaHotel.getHabitacionesDisponibles() <= 0) {
                DialogoPersonalizado.mostrar(this, "Hotel Lleno", "Lo sentimos, no hay habitaciones disponibles.", DialogoPersonalizado.TIPO_INFORMACION);
                return;
            }

            Cliente nuevoCliente = new Cliente(idCompleto, nombreCliente, celularCliente, emailCliente, direccionCliente, fechaIngreso, fechaSalida);
            int habitacionAsignada = logicaHotel.realizarCheckInAutomatico(nuevoCliente);

            if (habitacionAsignada != -1) {
                DialogoPersonalizado.mostrar(this, "Reserva Exitosa", "¡Reserva creada con éxito!<br>Cliente: " + nombreCliente + "<br>Habitación: " + habitacionAsignada, DialogoPersonalizado.TIPO_EXITO);

                this.dispose();
                Reservas ventanaReservas = new Reservas(this.logicaHotel);
                ventanaReservas.setVisible(true);
                ventanaReservas.setLocationRelativeTo(null);
            } else {
                DialogoPersonalizado.mostrar(this, "Error de Reserva", "Ocurrió un error al asignar una habitación.", DialogoPersonalizado.TIPO_ERROR);
            }
        } catch (Exception e) {
            DialogoPersonalizado.mostrar(this, "Error General", "Ocurrió un error:<br>" + e.getMessage(), DialogoPersonalizado.TIPO_ERROR);
        }
    }
	
    private void cerrarsesionMouseClicked(java.awt.event.MouseEvent evt) {
        this.dispose();
        Reservas formReservas = new Reservas(this.logicaHotel);
        formReservas.setVisible(true);
        formReservas.setLocationRelativeTo(null);
    }
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nueva_Reserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new Nueva_Reserva(new Logica()).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser FechaDIngreso;
    private com.toedter.calendar.JDateChooser FechaDSalida;
    private javax.swing.JButton Registrar;
    private javax.swing.JPanel cerrarsesion;
    private javax.swing.JTextField direccion;
    private javax.swing.JTextField documento;
    private javax.swing.JTextField gmail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton menuButton;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField telefono;
    private javax.swing.JComboBox<String> tipodocumento;
    // End of variables declaration//GEN-END:variables
}