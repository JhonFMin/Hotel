package Interfaz;

import Nodos.Logica;
import Objetos.Cliente;
import java.awt.Color;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author USUARIO
 */
public class Nueva_Reserva extends javax.swing.JFrame {

    // La lógica del hotel que maneja todos los datos
    private Logica logicaHotel;

    /**
     * Constructor principal que recibe la lógica del hotel.
     */
    public Nueva_Reserva(Logica logicaHotel) {
        setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        this.logicaHotel = logicaHotel;
        personalizarInterfaz();
    }

    // AÑADIDO: Un constructor por defecto para el diseñador de NetBeans, pero el principal es el de arriba.
    public Nueva_Reserva() {
        setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        // Inicializamos una nueva lógica si la ventana se abre de forma independiente
        this.logicaHotel = new Logica(); 
        personalizarInterfaz();
    }

    /**
     * Aplica estilos personalizados a los componentes de la interfaz.
     */
    private void personalizarInterfaz() {
        // Estiliza los campos de fecha para que coincidan con el tema oscuro
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
        jLabel1 = new javax.swing.JLabel();
        Registrar = new javax.swing.JButton();
        menu = new javax.swing.JButton();
        cerrarsesion = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FechaDSalida.setBackground(new java.awt.Color(15, 22, 36));
        FechaDSalida.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        FechaDSalida.setForeground(new java.awt.Color(15, 22, 36));
        FechaDSalida.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        FechaDSalida.setOpaque(false);
        getContentPane().add(FechaDSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 510, 200, 40));

        FechaDIngreso.setBackground(new java.awt.Color(15, 22, 36));
        FechaDIngreso.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        FechaDIngreso.setForeground(new java.awt.Color(15, 22, 36));
        FechaDIngreso.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        FechaDIngreso.setOpaque(false);
        getContentPane().add(FechaDIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 510, 200, 40));

        nombre.setBackground(new java.awt.Color(15, 22, 36));
        nombre.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        nombre.setForeground(new java.awt.Color(255, 255, 255));
        nombre.setBorder(null);
        nombre.setCaretColor(new java.awt.Color(255, 59, 107));
        nombre.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        nombre.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        nombre.setSelectionColor(new java.awt.Color(255, 255, 255));
        getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, 350, 20));

        telefono.setBackground(new java.awt.Color(15, 22, 36));
        telefono.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        telefono.setForeground(new java.awt.Color(255, 255, 255));
        telefono.setBorder(null);
        telefono.setCaretColor(new java.awt.Color(255, 59, 107));
        telefono.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        telefono.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        telefono.setSelectionColor(new java.awt.Color(255, 255, 255));
        getContentPane().add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, 350, 20));

        direccion.setBackground(new java.awt.Color(15, 22, 36));
        direccion.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        direccion.setForeground(new java.awt.Color(255, 255, 255));
        direccion.setBorder(null);
        direccion.setCaretColor(new java.awt.Color(255, 59, 107));
        direccion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        direccion.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        direccion.setSelectionColor(new java.awt.Color(255, 255, 255));
        getContentPane().add(direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 510, 350, 20));

        gmail.setBackground(new java.awt.Color(15, 22, 36));
        gmail.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        gmail.setForeground(new java.awt.Color(255, 255, 255));
        gmail.setBorder(null);
        gmail.setCaretColor(new java.awt.Color(255, 59, 107));
        gmail.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        gmail.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        gmail.setSelectionColor(new java.awt.Color(255, 255, 255));
        getContentPane().add(gmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 440, 350, 20));

        documento.setBackground(new java.awt.Color(15, 22, 36));
        documento.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        documento.setForeground(new java.awt.Color(255, 255, 255));
        documento.setBorder(null);
        documento.setCaretColor(new java.awt.Color(255, 59, 107));
        documento.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        documento.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        documento.setSelectionColor(new java.awt.Color(255, 255, 255));
        getContentPane().add(documento, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 360, 350, 20));

        tipodocumento.setBackground(new java.awt.Color(255, 59, 107));
        tipodocumento.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        tipodocumento.setForeground(new java.awt.Color(15, 23, 36));
        tipodocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CC", "CE", "Pasaporte" }));
        tipodocumento.setBorder(null);
        tipodocumento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tipodocumento.setOpaque(false);
        tipodocumento.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(tipodocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 280, 220, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\USUARIO\\Documents\\NetBeansProjects\\Hotel\\src\\main\\java\\Interfaz\\Sources\\Nueva Reserva.png")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Registrar.setBorderPainted(false);
        Registrar.setContentAreaFilled(false);
        // CORREGIDO: Se añade el ActionListener para el botón registrar
        Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 670, 80, 80));

        menu.setBorderPainted(false);
        menu.setContentAreaFilled(false);
        menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActionPerformed(evt);
            }
        });
        getContentPane().add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 660, 120, 100));

        cerrarsesion.setBackground(new java.awt.Color(255, 255, 255));
        cerrarsesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cerrarsesion.setDoubleBuffered(false);
        cerrarsesion.setEnabled(false);
        cerrarsesion.setFocusable(false);
        cerrarsesion.setOpaque(false);
        cerrarsesion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(cerrarsesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 660, 80, 80));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuActionPerformed(java.awt.event.ActionEvent evt) {                                     
        this.dispose();
        // Se asume que existe una ventana 'Menu' a la que volver
        Menu menuPrincipal = new Menu(); // Se debe asegurar que esta ventana también reciba la lógica
        menuPrincipal.setVisible(true);
        menuPrincipal.setLocationRelativeTo(null);
    }                                    

    // MÉTODO COMPLETAMENTE CORREGIDO
    private void RegistrarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try {
            // --- 1. Recolección de Datos ---
            String nombreCliente = nombre.getText().trim();
            String celularCliente = telefono.getText().trim();
            String emailCliente = gmail.getText().trim();
            String direccionCliente = direccion.getText().trim();
            
            String tipoDoc = (String) tipodocumento.getSelectedItem();
            String numDoc = documento.getText().trim();
            
            Date fechaIngresoUtil = FechaDIngreso.getDate();
            Date fechaSalidaUtil = FechaDSalida.getDate();

            // --- 2. Validación de Campos Vacíos ---
            if (nombreCliente.isEmpty() || celularCliente.isEmpty() || emailCliente.isEmpty() || 
                direccionCliente.isEmpty() || numDoc.isEmpty() || fechaIngresoUtil == null || fechaSalidaUtil == null) {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Campos Vacíos", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            // --- 3. Procesamiento y Validación de Datos ---
            String idCompleto = tipoDoc + "-" + numDoc;

            LocalDate fechaIngreso = fechaIngresoUtil.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate fechaSalida = fechaSalidaUtil.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            if (!logicaHotel.validarFechas(fechaIngreso, fechaSalida)) {
                JOptionPane.showMessageDialog(this, "La fecha de salida debe ser posterior a la fecha de ingreso.", "Error de Fechas", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // CORREGIDO: Se llama al método correcto para verificar disponibilidad
            if (logicaHotel.getHabitacionesDisponibles() <= 0) {
                JOptionPane.showMessageDialog(this, "Lo sentimos, no hay habitaciones disponibles en este momento.", "Hotel Lleno", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            // --- 4. Creación del Cliente y Registro ---
            // CORREGIDO: Se usa el constructor completo y correcto de la clase Cliente
            Cliente nuevoCliente = new Cliente(idCompleto, nombreCliente, celularCliente, emailCliente, direccionCliente, fechaIngreso, fechaSalida);
            
            int habitacionAsignada = logicaHotel.realizarCheckInAutomatico(nuevoCliente);

            if (habitacionAsignada != -1) {
                JOptionPane.showMessageDialog(this, "¡Reserva creada con éxito!\nCliente: " + nombreCliente + "\nHabitación asignada: " + habitacionAsignada, "Reserva Exitosa", JOptionPane.INFORMATION_MESSAGE);
                
                // Regresar al menú principal o a la ventana de reservas
                this.dispose();
                Menu menuPrincipal = new Menu(); // Se debe asegurar que esta ventana también reciba la lógica
                menuPrincipal.setVisible(true);
                menuPrincipal.setLocationRelativeTo(null);
            } else {
                JOptionPane.showMessageDialog(this, "Ocurrió un error inesperado al intentar asignar una habitación.", "Error de Reserva", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error general: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
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

        // CORREGIDO: Se crea la lógica primero y se pasa a la ventana
        java.awt.EventQueue.invokeLater(() -> {
            Logica logicaDelHotel = new Logica();
            new Nueva_Reserva(logicaDelHotel).setVisible(true);
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
    private javax.swing.JButton menu;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField telefono;
    private javax.swing.JComboBox<String> tipodocumento;
    // End of variables declaration//GEN-END:variables
}