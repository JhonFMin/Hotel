/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;

// NUEVO: Importaciones de la lógica del hotel y la librería de gráficos.
import Nodos.Logica;
import java.text.NumberFormat;
import java.util.Locale;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author USUARIO
 */
public class Menu extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Menu.class.getName());

    // NUEVO: Instancia de la clase Logica para acceder a los datos del hotel.
    private Logica logicaHotel;

    /**
     * Creates new form Menu
     */
    public Menu() {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);

        // NUEVO: Inicializamos la lógica del hotel.
        logicaHotel = new Logica();

        // NUEVO: Llamamos a los métodos para poblar la interfaz con datos reales.
        actualizarTarjetas();
        crearYMostrarGraficos();
    }

    // NUEVO: Método para actualizar los valores de las tarjetas superiores.
    private void actualizarTarjetas() {
        // Formateador para los valores monetarios
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("es", "CO"));
        currencyFormatter.setMaximumFractionDigits(0);

        // Actualizamos cada JLabel con la información de la lógica
        totalHab.setText(String.valueOf(logicaHotel.getNumeroHabitaciones()));
        habRe.setText(String.valueOf(logicaHotel.getHabitacionesOcupadas()));
        habDis1.setText(String.valueOf(logicaHotel.getHabitacionesDisponibles()));

        // Formateamos el total de ventas como moneda
        String ventasFormateadas = currencyFormatter.format(logicaHotel.getFacturacionAcumulada());
        totalVen.setText(ventasFormateadas);

        // Ajustamos el tamaño de la fuente si el texto es muy largo
        if (ventasFormateadas.length() > 6) {
            totalVen.setFont(new java.awt.Font("Dialog", 0, 30));
        } else {
            totalVen.setFont(new java.awt.Font("Dialog", 0, 48));
        }
    }

    // NUEVO: Método para crear los dos gráficos y añadirlos a la ventana.
    private void crearYMostrarGraficos() {
        // 1. Creamos el gráfico de pastel
        JFreeChart pieChart = crearGraficoPastel();
        ChartPanel pieChartPanel = new ChartPanel(pieChart);
        pieChartPanel.setOpaque(false); // Hacemos el fondo del panel transparente

        // 2. Creamos el gráfico de barras
        JFreeChart barChart = crearGraficoBarras();
        ChartPanel barChartPanel = new ChartPanel(barChart);
        barChartPanel.setOpaque(false); // Hacemos el fondo del panel transparente

        // 3. Creamos un panel contenedor para los dos gráficos
        JPanel panelGraficos = new JPanel(new GridLayout(1, 2, 20, 0)); // 1 fila, 2 columnas, con 20px de espacio
        panelGraficos.setOpaque(false); // Panel principal transparente
        panelGraficos.add(pieChartPanel);
        panelGraficos.add(barChartPanel);

        // 4. Añadimos el panel de gráficos al contentPane con AbsoluteLayout
        getContentPane().add(panelGraficos, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, 1000, 300));
    }

    // NUEVO: Método que genera el gráfico de pastel de ocupación.
    private JFreeChart crearGraficoPastel() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Ocupadas", logicaHotel.getHabitacionesOcupadas());
        dataset.setValue("Disponibles", logicaHotel.getHabitacionesDisponibles());

        JFreeChart chart = ChartFactory.createPieChart(
                "Ocupación de Habitaciones", // Título
                dataset,
                true, // Incluir leyenda
                true,
                false);

        // Personalización para que coincida con tu tema oscuro
        chart.setBackgroundPaint(null); // Fondo del gráfico transparente
        chart.getTitle().setPaint(Color.WHITE);
        chart.getLegend().setBackgroundPaint(new Color(30, 30, 30));
        chart.getLegend().setItemPaint(Color.WHITE);

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setBackgroundPaint(null); // Fondo del área del gráfico transparente
        plot.setLabelGenerator(null); // Sin etiquetas en las porciones
        plot.setSectionPaint("Ocupadas", new Color(3, 138, 255)); // Azul
        plot.setSectionPaint("Disponibles", new Color(0, 184, 148)); // Verde
        plot.setOutlineVisible(false); // Sin bordes
        plot.setShadowPaint(null);

        return chart;
    }

    // NUEVO: Método que genera el gráfico de barras de ingresos.
    private JFreeChart crearGraficoBarras() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String totalFacturado = "Facturación Total";
        dataset.addValue(logicaHotel.getFacturacionAcumulada(), "Ingresos", totalFacturado);

        JFreeChart chart = ChartFactory.createBarChart(
                "Ingresos del Hotel", // Título
                "Concepto", // Etiqueta eje X
                "Monto (COP)", // Etiqueta eje Y
                dataset,
                PlotOrientation.VERTICAL,
                false, // Sin leyenda
                true,
                false);

        // Personalización para el tema oscuro
        chart.setBackgroundPaint(null); // Fondo transparente
        chart.getTitle().setPaint(Color.WHITE);

        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(null);
        plot.setRangeGridlinePaint(Color.GRAY);
        plot.setOutlineVisible(false);

        // Color de los ejes
        plot.getDomainAxis().setTickLabelPaint(Color.WHITE);
        plot.getDomainAxis().setLabelPaint(Color.WHITE);
        plot.getRangeAxis().setTickLabelPaint(Color.WHITE);
        plot.getRangeAxis().setLabelPaint(Color.WHITE);

        // Color de las barras
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(255, 118, 117)); // Rojo claro
        
        return chart;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        habitaciones = new javax.swing.JButton();
        reserva = new javax.swing.JButton();
        reportes = new javax.swing.JButton();
        habDis1 = new javax.swing.JLabel();
        habRe = new javax.swing.JLabel();
        totalVen = new javax.swing.JLabel();
        totalHab = new javax.swing.JLabel();
        reservas1 = new javax.swing.JButton();
        clientes = new javax.swing.JButton();
        habitaciones1 = new javax.swing.JButton();
        reportes1 = new javax.swing.JButton();
        exitBtn = new javax.swing.JPanel();
        exitTxt = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        habitaciones.setBorderPainted(false);
        habitaciones.setContentAreaFilled(false);
        habitaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                habitacionesActionPerformed(evt);
            }
        });
        getContentPane().add(habitaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 100, 20));

        reserva.setBorderPainted(false);
        reserva.setContentAreaFilled(false);
        reserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservaActionPerformed(evt);
            }
        });
        getContentPane().add(reserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 60, 20));

        reportes.setBorderPainted(false);
        reportes.setContentAreaFilled(false);
        reportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportesActionPerformed(evt);
            }
        });
        getContentPane().add(reportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 70, 20));

        habDis1.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        habDis1.setText("0");
        getContentPane().add(habDis1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 130, 30, 40));

        habRe.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        habRe.setText("0");
        getContentPane().add(habRe, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 130, 30, 40));

        totalVen.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        totalVen.setText("0");
        getContentPane().add(totalVen, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 130, 30, 40));

        totalHab.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        totalHab.setText("0");
        getContentPane().add(totalHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 30, 40));

        reservas1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        reservas1.setBorderPainted(false);
        reservas1.setContentAreaFilled(false);
        reservas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservas1ActionPerformed(evt);
            }
        });
        getContentPane().add(reservas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 610, 130, 130));

        clientes.setBorderPainted(false);
        clientes.setContentAreaFilled(false);
        getContentPane().add(clientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 60, 20));

        habitaciones1.setBorderPainted(false);
        habitaciones1.setContentAreaFilled(false);
        habitaciones1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                habitaciones1ActionPerformed(evt);
            }
        });
        getContentPane().add(habitaciones1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 610, 120, 130));

        reportes1.setBorderPainted(false);
        reportes1.setContentAreaFilled(false);
        reportes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportes1ActionPerformed(evt);
            }
        });
        getContentPane().add(reportes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 610, 130, 140));

        exitBtn.setBackground(new java.awt.Color(255, 255, 255));
        exitBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        exitBtn.setDoubleBuffered(false);
        exitBtn.setEnabled(false);
        exitBtn.setFocusable(false);
        exitBtn.setOpaque(false);

        exitTxt.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        exitTxt.setForeground(new java.awt.Color(255, 0, 0));
        exitTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitTxt.setText("X");
        exitTxt.setBorder(new javax.swing.border.MatteBorder(null));
        exitTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitTxt.setPreferredSize(new java.awt.Dimension(40, 40));
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
            .addComponent(exitTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );
        exitBtnLayout.setVerticalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, Short.MAX_VALUE)
        );

        getContentPane().add(exitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 10, 30, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\USUARIO\\Documents\\NetBeansProjects\\Hotel\\src\\main\\java\\Interfaz\\Sources\\Menú Principal_1.png")); // NOI18N
        jLabel2.setToolTipText("");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseExited
        exitBtn.setBackground(Color.white);
        exitTxt.setForeground(Color.black);
    }//GEN-LAST:event_exitTxtMouseExited

    private void exitTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseEntered
        exitBtn.setBackground(Color.red);
        exitTxt.setForeground(Color.white);
    }//GEN-LAST:event_exitTxtMouseEntered

    private void exitTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseClicked
       System.exit(0); // MODIFICADO: Salir de la aplicación completamente.
    }//GEN-LAST:event_exitTxtMouseClicked

    private void reservas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservas1ActionPerformed
        this.dispose();
        // MODIFICADO: Pasamos la instancia de la lógica a la siguiente ventana.
        Reservas reservas = new Reservas(this.logicaHotel); // Deberás modificar el constructor de Reservas
        reservas.setVisible(true);
        reservas.setLocationRelativeTo(null);
    }//GEN-LAST:event_reservas1ActionPerformed

    private void habitaciones1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_habitaciones1ActionPerformed
        this.dispose();
        Habitaciones habitaciones = new Habitaciones();
        habitaciones.setVisible(true);
        habitaciones.setLocationRelativeTo(null);
    }//GEN-LAST:event_habitaciones1ActionPerformed

    private void reportes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportes1ActionPerformed
      this.dispose();
        Reportes reportes = new Reportes();
        reportes.setVisible(true);
        reportes.setLocationRelativeTo(null);
    }//GEN-LAST:event_reportes1ActionPerformed

    private void reportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportesActionPerformed
        this.dispose();
        Reportes reportes = new Reportes();
        reportes.setVisible(true);
        reportes.setLocationRelativeTo(null);
    }//GEN-LAST:event_reportesActionPerformed

    private void habitacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_habitacionesActionPerformed
        this.dispose();
        Habitaciones habitaciones = new Habitaciones();
        habitaciones.setVisible(true);
        habitaciones.setLocationRelativeTo(null);
    }//GEN-LAST:event_habitacionesActionPerformed

    private void reservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservaActionPerformed
        this.dispose();
        // MODIFICADO: Pasamos la instancia de la lógica a la siguiente ventana.
        Reservas reservas = new Reservas(this.logicaHotel);
        reservas.setVisible(true);
        reservas.setLocationRelativeTo(null);
    }//GEN-LAST:event_reservaActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Menu().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clientes;
    private javax.swing.JPanel exitBtn;
    private javax.swing.JLabel exitTxt;
    private javax.swing.JLabel habDis1;
    private javax.swing.JLabel habRe;
    private javax.swing.JButton habitaciones;
    private javax.swing.JButton habitaciones1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton reportes;
    private javax.swing.JButton reportes1;
    private javax.swing.JButton reserva;
    private javax.swing.JButton reservas1;
    private javax.swing.JLabel totalHab;
    private javax.swing.JLabel totalVen;
    // End of variables declaration//GEN-END:variables
}