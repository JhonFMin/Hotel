package Interfaz;

import Nodos.Logica;
import Objetos.Cliente;
import Objetos.Habitacion;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.time.format.DateTimeFormatter;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

public class Reservas extends javax.swing.JFrame {

    private final Logica logicaHotel;
    private DefaultTableModel modeloTabla;

    public Reservas(Logica logicaHotel) {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        this.logicaHotel = logicaHotel;
        personalizarTabla();
        actualizarTabla();
        configurarSeleccionTabla();
    }

    // AÑADIDO: Constructor por defecto para que el diseñador de NetBeans funcione.
    public Reservas() {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        this.logicaHotel = new Logica(); 
        personalizarTabla();
        actualizarTabla();
        configurarSeleccionTabla();
    }
    
    // MÉTODO COMPLETAMENTE REDISEÑADO
    private void personalizarTabla() {
        // --- COLORES PRINCIPALES ---
        Color colorFondo = new Color(30, 39, 46);
        Color colorTexto = new Color(223, 223, 223);
        Color colorCabeceraFondo = new Color(45, 52, 54);
        Color colorCabeceraTexto = new Color(193, 170, 97); // Dorado
        Color colorGrid = new Color(60, 60, 60);
        Color colorSeleccionFondo = new Color(193, 170, 97); // Dorado
        Color colorSeleccionTexto = Color.BLACK;
        Color colorFilaAlterna = new Color(40, 49, 56);

        // --- ESTILOS BÁSICOS DE LA TABLA ---
        Tabla.setBackground(colorFondo);
        Tabla.setForeground(colorTexto);
        Tabla.setGridColor(colorGrid);
        Tabla.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        Tabla.setRowHeight(35);
        Tabla.setSelectionBackground(colorSeleccionFondo);
        Tabla.setSelectionForeground(colorSeleccionTexto);
        Tabla.setShowVerticalLines(false); // Opcional: para un look más limpio

        // --- ESTILO DE LA CABECERA (HEADER) ---
        JTableHeader header = Tabla.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 16));
        header.setOpaque(false);
        header.setBackground(colorCabeceraFondo);
        header.setForeground(colorCabeceraTexto);
        header.setReorderingAllowed(false); // Evita que se puedan mover las columnas
        
        // --- ESTILO DEL SCROLLPANE QUE CONTIENE LA TABLA ---
        jScrollPane1.getViewport().setBackground(colorFondo); // Fondo del área visible
        jScrollPane1.setBorder(BorderFactory.createEmptyBorder()); // Sin borde

        // --- RENDERIZADOR PERSONALIZADO PARA FILAS (ESTILO CEBRA) ---
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Configura el padding y la alineación
                setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
                setHorizontalAlignment(JLabel.CENTER);

                // Lógica de colores para filas alternas (estilo cebra)
                if (!isSelected) {
                    setBackground(row % 2 == 0 ? colorFondo : colorFilaAlterna);
                }
                
                return this;
            }
        };

        // Aplicar el renderizador a todas las columnas
        for (int i = 0; i < Tabla.getColumnCount(); i++) {
            Tabla.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
    }


    public void actualizarTabla() {
        modeloTabla = (DefaultTableModel) Tabla.getModel();
        modeloTabla.setRowCount(0);

        Habitacion[] habitaciones = logicaHotel.obtenerTodasLasHabitaciones();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (Habitacion hab : habitaciones) {
            Object[] fila = new Object[6];
            fila[0] = hab.getNumero();

            if (hab.estaDisponible()) {
                fila[1] = "Disponible";
                fila[2] = "—";
                fila[3] = "—";
                fila[4] = "—";
                fila[5] = "—";
            } else {
                fila[1] = "Ocupada";
                Cliente cliente = hab.getCliente();
                if (cliente != null) {
                    fila[2] = cliente.getNombre();
                    fila[3] = cliente.getId();
                    fila[4] = cliente.getFechaIngreso().format(formatter);
                    fila[5] = cliente.getFechaSalida().format(formatter);
                }
            }
            modeloTabla.addRow(fila);
        }
    }
    
    // ... El resto de tu código (initComponents, botones, etc.) ...

    //<editor-fold defaultstate="collapsed" desc="Generated Code">
    private void configurarSeleccionTabla() {
        jButton4.setEnabled(false);
        jButton1.setEnabled(false);
        ListSelectionModel selectionModel = Tabla.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    boolean filaSeleccionada = Tabla.getSelectedRow() != -1;
                    jButton4.setEnabled(filaSeleccionada);
                    jButton1.setEnabled(filaSeleccionada);
                }
            }
        });
    }
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        exitBtn = new javax.swing.JPanel();
        exitTxt = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 190, 90));

        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 190, 90));

        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 140, 180, 90));

        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 140, 180, 90));

        exitBtn.setBackground(new java.awt.Color(255, 255, 255));
        exitBtn.setOpaque(false);

        exitTxt.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        exitTxt.setForeground(new java.awt.Color(255, 0, 0));
        exitTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitTxt.setText("X");
        exitTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout exitBtnLayout = new javax.swing.GroupLayout(exitBtn);
        exitBtn.setLayout(exitBtnLayout);
        exitBtnLayout.setHorizontalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );
        exitBtnLayout.setVerticalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)
        );

        getContentPane().add(exitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 10, 30, 30));

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "# Habitación", "Estado", "Nombre", "Identificación", "Fecha de ingreso", "Fecha de Salida"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 1350, 500));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\USUARIO\\Documents\\NetBeansProjects\\Hotel\\src\\main\\java\\Interfaz\\Sources\\Recepcion.png")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>
    private void exitTxtMouseClicked(java.awt.event.MouseEvent evt) {
     this.dispose();
        Menu ventanaMenu = new Menu(this.logicaHotel);
        ventanaMenu.setVisible(true);
        ventanaMenu.setLocationRelativeTo(null);
    }
    private void exitTxtMouseEntered(java.awt.event.MouseEvent evt) {
        exitBtn.setBackground(Color.red);
        exitTxt.setForeground(Color.white);
    }
    private void exitTxtMouseExited(java.awt.event.MouseEvent evt) {
        exitBtn.setBackground(Color.white);
        exitTxt.setForeground(Color.black);
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        Nueva_Reserva nuevares = new Nueva_Reserva(this.logicaHotel);
        nuevares.setVisible(true);
        nuevares.setLocationRelativeTo(null);
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // Asumiendo que existe una ventana 'Buscar'
        // Buscar buscar = new Buscar(this.logicaHotel);
        // buscar.setVisible(true);
        // buscar.setLocationRelativeTo(null);
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = Tabla.getSelectedRow();
        if (selectedRow != -1) {
            int numeroHabitacion = (int) Tabla.getValueAt(selectedRow, 0);
             // Asumiendo que existe una ventana 'Modificar_Reserva'
            // Modificar_Reserva modificarres = new Modificar_Reserva(this.logicaHotel, numeroHabitacion);
            // modificarres.setVisible(true);
            // modificarres.setLocationRelativeTo(null);
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        int selectedRow = Tabla.getSelectedRow();
        if (selectedRow != -1) {
            int numeroHabitacion = (int) Tabla.getValueAt(selectedRow, 0);
            String nombreCliente = String.valueOf(Tabla.getValueAt(selectedRow, 2));

            if (nombreCliente == null || nombreCliente.isEmpty() || nombreCliente.equals("—")) {
                JOptionPane.showMessageDialog(this, "Esta habitación no tiene una reserva activa para eliminar.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Estás seguro de que deseas eliminar la reserva de '" + nombreCliente + "' en la habitación " + numeroHabitacion + "?\nEsta acción equivale a un Check-Out.",
                "Confirmar Eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
            );

            if (confirmacion == JOptionPane.YES_OPTION) {
                Cliente clienteSaliente = logicaHotel.realizarCheckOut(numeroHabitacion);

                if (clienteSaliente != null) {
                    JOptionPane.showMessageDialog(this, "Reserva eliminada con éxito (Check-Out realizado).", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    actualizarTabla();
                } else {
                    JOptionPane.showMessageDialog(this, "Error: No se pudo eliminar la reserva.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            new Reservas(new Logica()).setVisible(true);
        });
    }


    // Variables declaration - do not modify
    private javax.swing.JTable Tabla;
    private javax.swing.JPanel exitBtn;
    private javax.swing.JLabel exitTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration
}
//</editor-fold>