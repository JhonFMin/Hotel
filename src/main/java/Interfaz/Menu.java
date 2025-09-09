package Interfaz;

import Interfaz.Habitaciones;
import Interfaz.Reportes;
import Interfaz.Reservas;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.GridLayout;
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

    private final Logica logicaHotel;
    private JPanel panelGraficos;

    public Menu() {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        this.logicaHotel = new Logica();
        actualizarTarjetas();
        crearYMostrarGraficos();
        // Trae los gráficos al frente
        getContentPane().setComponentZOrder(panelGraficos, 0);
    }

    public Menu(Logica logicaHotel) {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        this.logicaHotel = logicaHotel;
        actualizarTarjetas();
        crearYMostrarGraficos();
        // Trae los gráficos al frente
        getContentPane().setComponentZOrder(panelGraficos, 0);
    }

    /**
     * Actualiza los valores de las tarjetas superiores con datos de la lógica.
     */
     private void actualizarTarjetas() {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("es", "CO"));
        currencyFormatter.setMaximumFractionDigits(0);

        totalHab.setText(String.valueOf(logicaHotel.getTotalHabitaciones()));
        habRe.setText(String.valueOf(logicaHotel.getHabitacionesOcupadas()));
        habDis1.setText(String.valueOf(logicaHotel.getHabitacionesDisponibles()));

        String ventasFormateadas = currencyFormatter.format(logicaHotel.getFacturacionAcumulada());
        totalVen.setText(ventasFormateadas);
    }

    private void crearYMostrarGraficos() {
        JFreeChart pieChart = crearGraficoPastel();
        ChartPanel pieChartPanel = new ChartPanel(pieChart);
        pieChartPanel.setOpaque(false);

        JFreeChart barChart = crearGraficoBarras();
        ChartPanel barChartPanel = new ChartPanel(barChart);
        barChartPanel.setOpaque(false);

        panelGraficos = new JPanel(new GridLayout(1, 2, 20, 0));
        panelGraficos.setOpaque(false);
        panelGraficos.add(pieChartPanel);
        panelGraficos.add(barChartPanel);

        getContentPane().add(panelGraficos, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, 1000, 300));
    }

    /**
     * Genera el gráfico de pastel de ocupación.
     */
    private JFreeChart crearGraficoPastel() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Ocupadas", logicaHotel.getHabitacionesOcupadas());
        dataset.setValue("Disponibles", logicaHotel.getHabitacionesDisponibles());

        JFreeChart chart = ChartFactory.createPieChart("Ocupación de Habitaciones", dataset, true, true, false);

        chart.setBackgroundPaint(null);
        chart.getTitle().setPaint(Color.WHITE);
        chart.getLegend().setBackgroundPaint(new Color(30, 30, 30));
        chart.getLegend().setItemPaint(Color.WHITE);

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setBackgroundPaint(null);
        plot.setLabelGenerator(null);
        plot.setSectionPaint("Ocupadas", new Color(3, 138, 255));
        plot.setSectionPaint("Disponibles", new Color(0, 184, 148));
        plot.setOutlineVisible(false);
        plot.setShadowPaint(null);

        return chart;
    }

    /**
     * Genera el gráfico de barras de ingresos.
     */
    private JFreeChart crearGraficoBarras() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(logicaHotel.getFacturacionAcumulada(), "Ingresos", "Facturación Total");

        JFreeChart chart = ChartFactory.createBarChart("Ingresos del Hotel", "Concepto", "Monto (COP)", dataset, PlotOrientation.VERTICAL, false, true, false);

        chart.setBackgroundPaint(null);
        chart.getTitle().setPaint(Color.WHITE);

        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(null);
        plot.setRangeGridlinePaint(Color.GRAY);
        plot.setOutlineVisible(false);

        plot.getDomainAxis().setTickLabelPaint(Color.WHITE);
        plot.getDomainAxis().setLabelPaint(Color.WHITE);
        plot.getRangeAxis().setTickLabelPaint(Color.WHITE);
        plot.getRangeAxis().setLabelPaint(Color.WHITE);

        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(255, 118, 117));

        return chart;
    }

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
        getContentPane().add(habDis1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 130, 30, 40));

        habRe.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        habRe.setText("0");
        getContentPane().add(habRe, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 30, 40));

        totalVen.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        totalVen.setText("0");
        getContentPane().add(totalVen, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 130, 30, 40));

        totalHab.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        totalHab.setText("0");
        getContentPane().add(totalHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 30, 40));

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

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\USUARIO\\Documents\\NetBeansProjects\\Hotel\\src\\main\\java\\Interfaz\\Sources\\Menú Principal.png")); // NOI18N
        jLabel2.setToolTipText("");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitTxtMouseExited(java.awt.event.MouseEvent evt) {
        exitBtn.setBackground(Color.white);
        exitTxt.setForeground(Color.black);
    }

    private void exitTxtMouseEntered(java.awt.event.MouseEvent evt) {
        exitBtn.setBackground(Color.red);
        exitTxt.setForeground(Color.white);
    }

    private void exitTxtMouseClicked(java.awt.event.MouseEvent evt) {
        this.dispose();
        // Le pasa la "memoria" actual a la siguiente ventana
        Login login = new Login(this.logicaHotel);
        login.setVisible(true);
        login.setLocationRelativeTo(null);
    }

    private void reservas1ActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        // Le pasa la "memoria" actual a la siguiente ventana
        Reservas ventanaReservas = new Reservas(this.logicaHotel);
        ventanaReservas.setVisible(true);
        ventanaReservas.setLocationRelativeTo(null);
    }

    private void habitaciones1ActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        Habitaciones habitaciones = new Habitaciones(this.logicaHotel);
        habitaciones.setVisible(true);
        habitaciones.setLocationRelativeTo(null);
    }

    private void reportes1ActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        Reportes reportes = new Reportes(this.logicaHotel);
        reportes.setVisible(true);
        reportes.setLocationRelativeTo(null);
    }

    private void reportesActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        Reportes reportes = new Reportes(this.logicaHotel);
        reportes.setVisible(true);
        reportes.setLocationRelativeTo(null);
    }

    private void habitacionesActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        Habitaciones habitaciones = new Habitaciones(this.logicaHotel);
        habitaciones.setVisible(true);
        habitaciones.setLocationRelativeTo(null);
    }

    private void reservaActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        // Le pasa la "memoria" actual a la siguiente ventana
        Reservas ventanaReservas = new Reservas(this.logicaHotel);
        ventanaReservas.setVisible(true);
        ventanaReservas.setLocationRelativeTo(null);
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new Menu().setVisible(true);
        });
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
