package Interfaz;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends javax.swing.JFrame {

    int xMouse, yMouse;

    public Login() {

        initComponents();
        setLocationRelativeTo(null);
    }

    private void mostrarCamposIncompletos() {
        JDialog dialog = new JDialog(this, "Campos Incompletos", true);
        dialog.setUndecorated(true);
        dialog.setSize(350, 260);
        dialog.setLocationRelativeTo(this);

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBackground(new Color(25, 25, 25));
        content.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(193, 170, 97), 2),
                BorderFactory.createEmptyBorder(25, 35, 25, 35)
        ));

        // Icono de advertencia
        JLabel iconLabel = new JLabel("⚠");
        iconLabel.setFont(new Font("Segoe UI", Font.BOLD, 42));
        iconLabel.setForeground(new Color(255, 193, 7));
        iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Título
        JLabel titleLabel = new JLabel("Atención");
        titleLabel.setFont(new Font("Modern No. 20", Font.BOLD, 22));
        titleLabel.setForeground(new Color(193, 170, 97));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Mensaje
        JLabel messageLabel = new JLabel("<html><center>Por favor complete todos los campos<br/>para acceder al sistema</center></html>");
        messageLabel.setFont(new Font("Roboto", Font.PLAIN, 13));
        messageLabel.setForeground(Color.WHITE);
        messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Botón
        JLabel button = new JLabel("Entendido");
        button.setFont(new Font("Roboto Condensed", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(255, 193, 7));
        button.setOpaque(true);
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(255, 193, 7).darker(), 1),
                BorderFactory.createEmptyBorder(8, 20, 8, 20)
        ));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dialog.dispose();
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(255, 193, 7).brighter());
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(255, 193, 7));
            }
        });

        content.add(iconLabel);
        content.add(Box.createRigidArea(new Dimension(0, 12)));
        content.add(titleLabel);
        content.add(Box.createRigidArea(new Dimension(0, 12)));
        content.add(messageLabel);
        content.add(Box.createRigidArea(new Dimension(0, 20)));
        content.add(button);

        dialog.add(content);
        dialog.setVisible(true);
    }

// Método para mostrar diálogo de login exitoso
    private void mostrarLoginExitoso() {
        JDialog dialog = new JDialog(this, "Acceso Concedido", true);
        dialog.setUndecorated(true);
        dialog.setSize(350, 280);
        dialog.setLocationRelativeTo(this);

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBackground(new Color(25, 25, 25));
        content.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(193, 170, 97), 2),
                BorderFactory.createEmptyBorder(25, 35, 25, 35)
        ));

        // Icono de éxito
        JLabel iconLabel = new JLabel("<3");
        iconLabel.setFont(new Font("Segoe UI", Font.BOLD, 42));
        iconLabel.setForeground(new Color(40, 167, 69));
        iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Título
        JLabel titleLabel = new JLabel("¡Bienvenido!");
        titleLabel.setFont(new Font("Modern No. 20", Font.BOLD, 22));
        titleLabel.setForeground(new Color(193, 170, 97));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Mensaje
        JLabel messageLabel = new JLabel("<html><center>Acceso concedido al Sistema<br/><b>Hotel Continental</b><br/><br/>Sesión iniciada como Administrador</center></html>");
        messageLabel.setFont(new Font("Roboto", Font.PLAIN, 13));
        messageLabel.setForeground(Color.WHITE);
        messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Botón
        JLabel button = new JLabel("Continuar");
        button.setFont(new Font("Roboto Condensed", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(40, 167, 69));
        button.setOpaque(true);
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(40, 167, 69).darker(), 1),
                BorderFactory.createEmptyBorder(8, 20, 8, 20)
        ));
        this.dispose();

        // Crear y mostrar la ventana Menu
        Menu menuVentana = new Menu();
        menuVentana.setVisible(true);
        menuVentana.setLocationRelativeTo(null);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dialog.dispose();
                // Aquí puedes agregar código para abrir la ventana principal
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(40, 167, 69).brighter());
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(40, 167, 69));
            }
        });

        content.add(iconLabel);
        content.add(Box.createRigidArea(new Dimension(0, 12)));
        content.add(titleLabel);
        content.add(Box.createRigidArea(new Dimension(0, 12)));
        content.add(messageLabel);
        content.add(Box.createRigidArea(new Dimension(0, 20)));
        content.add(button);

        dialog.add(content);
        dialog.setVisible(true);
    }

// Método para mostrar diálogo de error de autenticación
    private void mostrarErrorAutenticacion() {
        JDialog dialog = new JDialog(this, "Error de Autenticación", true);
        dialog.setUndecorated(true);
        dialog.setSize(350, 280);
        dialog.setLocationRelativeTo(this);

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBackground(new Color(25, 25, 25));
        content.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(193, 170, 97), 2),
                BorderFactory.createEmptyBorder(25, 35, 25, 35)
        ));

        // Icono de error
        JLabel iconLabel = new JLabel("✕");
        iconLabel.setFont(new Font("Segoe UI", Font.BOLD, 42));
        iconLabel.setForeground(new Color(220, 53, 69));
        iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Título
        JLabel titleLabel = new JLabel("Acceso Denegado");
        titleLabel.setFont(new Font("Modern No. 20", Font.BOLD, 22));
        titleLabel.setForeground(new Color(193, 170, 97));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Mensaje
        JLabel messageLabel = new JLabel("<html><center>Usuario o contraseña incorrectos<br/><br/>Verifique sus credenciales<br/>e intente nuevamente</center></html>");
        messageLabel.setFont(new Font("Roboto", Font.PLAIN, 13));
        messageLabel.setForeground(Color.WHITE);
        messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Botón
        JLabel button = new JLabel("Reintentar");
        button.setFont(new Font("Roboto Condensed", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(220, 53, 69));
        button.setOpaque(true);
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 53, 69).darker(), 1),
                BorderFactory.createEmptyBorder(8, 20, 8, 20)
        ));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dialog.dispose();
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(220, 53, 69).brighter());
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(220, 53, 69));
            }
        });

        content.add(iconLabel);
        content.add(Box.createRigidArea(new Dimension(0, 12)));
        content.add(titleLabel);
        content.add(Box.createRigidArea(new Dimension(0, 12)));
        content.add(messageLabel);
        content.add(Box.createRigidArea(new Dimension(0, 20)));
        content.add(button);

        dialog.add(content);
        dialog.setVisible(true);
    }

// Método de validación actualizado
    private boolean validarCampos() {
        String usuario = userTxt.getText();
        String contraseña = String.valueOf(passTxt.getPassword());

        if (usuario.isEmpty() || usuario.equals("Ingrese su nombre de usuario")
                || contraseña.isEmpty() || contraseña.equals("********")) {

            mostrarCamposIncompletos(); // Usar diálogo personalizado
            return false;
        }
        return true;
    }

    private void limpiarCampos() {
        userTxt.setText("Ingrese su nombre de usuario");
        userTxt.setForeground(Color.gray);
        passTxt.setText("********");
        passTxt.setForeground(Color.gray);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logo = new javax.swing.JLabel();
        bg = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        exitBtn = new javax.swing.JPanel();
        exitTxt = new javax.swing.JLabel();
        favicon = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        userTxt = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        passLabel = new javax.swing.JLabel();
        passTxt = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        logoname1 = new javax.swing.JLabel();
        loginBtn = new javax.swing.JPanel();
        loginBtnTxt = new javax.swing.JLabel();
        logoname = new javax.swing.JLabel();
        citybg = new javax.swing.JLabel();

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon("C:\\Users\\USUARIO\\Documents\\NetBeansProjects\\Hotel\\src\\main\\java\\Interfaz\\Sources\\2e.png")); // NOI18N
        logo.setAutoscrolls(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        bg.setBackground(new java.awt.Color(15, 23, 36));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(255, 255, 255));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });

        exitBtn.setBackground(new java.awt.Color(255, 255, 255));

        exitTxt.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        exitTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitTxt.setText("X");
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
            .addComponent(exitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        exitBtnLayout.setVerticalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bg.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 40));

        favicon.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        favicon.setIcon(new javax.swing.ImageIcon("C:\\Users\\USUARIO\\Documents\\NetBeansProjects\\Hotel\\src\\main\\java\\Interfaz\\Sources\\2e.png")); // NOI18N
        favicon.setToolTipText("");
        favicon.setAutoscrolls(true);
        bg.add(favicon, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, 60, 220, 120));

        title.setBackground(new java.awt.Color(255, 255, 255));
        title.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("INICIAR SESIÓN");
        bg.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        userLabel.setBackground(new java.awt.Color(255, 255, 255));
        userLabel.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel.setForeground(new java.awt.Color(255, 255, 255));
        userLabel.setText("USUARIO");
        bg.add(userLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        userTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        userTxt.setForeground(new java.awt.Color(60, 63, 65));
        userTxt.setText("Ingrese su nombre de usuario");
        userTxt.setActionCommand("<Not Set>");
        userTxt.setBorder(new javax.swing.border.MatteBorder(null));
        userTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                userTxtMousePressed(evt);
            }
        });
        userTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userTxtActionPerformed(evt);
            }
        });
        bg.add(userTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 410, 30));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 410, 20));

        passLabel.setBackground(new java.awt.Color(255, 255, 255));
        passLabel.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        passLabel.setForeground(new java.awt.Color(255, 255, 255));
        passLabel.setText("CONTRASEÑA");
        bg.add(passLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        passTxt.setForeground(new java.awt.Color(60, 63, 65));
        passTxt.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        passTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                passTxtMousePressed(evt);
            }
        });
        passTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passTxtActionPerformed(evt);
            }
        });
        bg.add(passTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 410, 30));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 410, 20));

        logoname1.setBackground(new java.awt.Color(81, 81, 49));
        logoname1.setFont(new java.awt.Font("Modern No. 20", 0, 36)); // NOI18N
        logoname1.setForeground(new java.awt.Color(193, 170, 97));
        logoname1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoname1.setText("Hotel");
        bg.add(logoname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 270, 110, 20));

        loginBtn.setBackground(new java.awt.Color(255, 255, 255));
        loginBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        loginBtn.setForeground(new java.awt.Color(255, 255, 255));
        loginBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginBtn.setFocusable(false);
        loginBtn.setOpaque(false);
        loginBtn.setRequestFocusEnabled(false);
        loginBtn.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout loginBtnLayout = new javax.swing.GroupLayout(loginBtn);
        loginBtn.setLayout(loginBtnLayout);
        loginBtnLayout.setHorizontalGroup(
            loginBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );
        loginBtnLayout.setVerticalGroup(
            loginBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        bg.add(loginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 130, 40));

        loginBtnTxt.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        loginBtnTxt.setForeground(new java.awt.Color(60, 63, 65));
        loginBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginBtnTxt.setText("ENTRAR");
        loginBtnTxt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        loginBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginBtnTxtMouseExited(evt);
            }
        });
        bg.add(loginBtnTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 130, 40));

        logoname.setBackground(new java.awt.Color(81, 81, 49));
        logoname.setFont(new java.awt.Font("Modern No. 20", 0, 43)); // NOI18N
        logoname.setForeground(new java.awt.Color(193, 170, 97));
        logoname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoname.setText("CONTINENTAL");
        bg.add(logoname, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 370, 90));

        citybg.setBackground(new java.awt.Color(0, 134, 190));
        citybg.setForeground(new java.awt.Color(0, 0, 0));
        citybg.setIcon(new javax.swing.ImageIcon("C:\\Users\\USUARIO\\Documents\\NetBeansProjects\\Hotel\\src\\main\\java\\Interfaz\\Sources\\luxa.org-opacity-changed-._b916900c657dc3f54a23a313b11b255a.jpg")); // NOI18N
        citybg.setToolTipText("");
        citybg.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        citybg.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        citybg.setDebugGraphicsOptions(javax.swing.DebugGraphics.FLASH_OPTION);
        citybg.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        citybg.setIconTextGap(2);
        citybg.setVerifyInputWhenFocusTarget(false);
        citybg.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        bg.add(citybg, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 370, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnTxtMouseExited

    }//GEN-LAST:event_loginBtnTxtMouseExited

    private void loginBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnTxtMouseEntered

    }//GEN-LAST:event_loginBtnTxtMouseEntered

    private void loginBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnTxtMouseClicked
        if (!validarCampos()) {
            return;
        }

        String usuario = userTxt.getText().trim();
        String contraseña = String.valueOf(passTxt.getPassword());

        if (usuario.equals("Admin") && contraseña.equals("250484")) {
            mostrarLoginExitoso(); // Usar diálogo personalizado
        } else {
            mostrarErrorAutenticacion(); // Usar diálogo personalizado
            limpiarCampos();
        }
    }//GEN-LAST:event_loginBtnTxtMouseClicked

    private void passTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passTxtMousePressed
        if (String.valueOf(passTxt.getPassword()).equals("********")) {
            passTxt.setText("");
            passTxt.setForeground(Color.black);
        }
        if (userTxt.getText().isEmpty()) {
            userTxt.setText("Ingrese su nombre de usuario");
            userTxt.setForeground(Color.gray);
        }
    }//GEN-LAST:event_passTxtMousePressed

    private void userTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userTxtActionPerformed

    private void userTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTxtMousePressed

        if (userTxt.getText().equals("Ingrese su nombre de usuario")) {
            userTxt.setText("");
            userTxt.setForeground(Color.black);
        }
        if (String.valueOf(passTxt.getPassword()).isEmpty()) {
            passTxt.setText("********");
            passTxt.setForeground(Color.gray);
        }
    }//GEN-LAST:event_userTxtMousePressed

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

    private void exitTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseExited
        exitBtn.setBackground(Color.white);
        exitTxt.setForeground(Color.black);
    }//GEN-LAST:event_exitTxtMouseExited

    private void exitTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseEntered
        exitBtn.setBackground(Color.red);
        exitTxt.setForeground(Color.white);
    }//GEN-LAST:event_exitTxtMouseEntered

    private void exitTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitTxtMouseClicked

    private void passTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passTxtActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JLabel citybg;
    private javax.swing.JPanel exitBtn;
    private javax.swing.JLabel exitTxt;
    private javax.swing.JLabel favicon;
    private javax.swing.JPanel header;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel loginBtn;
    private javax.swing.JLabel loginBtnTxt;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel logoname;
    private javax.swing.JLabel logoname1;
    private javax.swing.JLabel passLabel;
    private javax.swing.JPasswordField passTxt;
    private javax.swing.JLabel title;
    private javax.swing.JLabel userLabel;
    private javax.swing.JTextField userTxt;
    // End of variables declaration//GEN-END:variables
}
