/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import login.SqlUsuarios;
import login.Hash;
import login.Registro;

/**
 *
 * @author PC
 */
public class Login extends javax.swing.JFrame {

    public static RegistroVista frmReg;
    public static Home frmHome;

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelBestRoute = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JPasswordField();
        btnIngresar = new javax.swing.JButton();
        lblRegistrarme = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Iniciar Sesión");
        setMinimumSize(new java.awt.Dimension(416, 300));
        setResizable(false);
        getContentPane().setLayout(null);

        labelBestRoute.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        labelBestRoute.setForeground(new java.awt.Color(102, 51, 0));
        labelBestRoute.setText("Best Route");
        getContentPane().add(labelBestRoute);
        labelBestRoute.setBounds(120, -10, 210, 120);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 51, 0));
        jLabel1.setText("Usuario");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(73, 102, 60, 17);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 51, 0));
        jLabel2.setText("Contraseña");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(63, 153, 80, 17);

        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txtUsuario);
        txtUsuario.setBounds(161, 99, 150, 23);

        txtContraseña.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txtContraseña);
        txtContraseña.setBounds(161, 150, 150, 23);

        btnIngresar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(102, 51, 0));
        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIngresar);
        btnIngresar.setBounds(190, 210, 83, 25);

        lblRegistrarme.setForeground(new java.awt.Color(51, 51, 0));
        lblRegistrarme.setText("Quiero registrarme");
        lblRegistrarme.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRegistrarme.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegistrarmeMouseClicked(evt);
            }
        });
        getContentPane().add(lblRegistrarme);
        lblRegistrarme.setBounds(180, 240, 110, 20);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ColorFondo.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(1, -4, 480, 310);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // TODO add your handling code here:

        SqlUsuarios modSqul = new SqlUsuarios();
        Registro mod = new Registro();

        String contra = new String(txtContraseña.getPassword());

        if (!txtUsuario.getText().equals("") && !contra.equals("")) {

            String nuevaContra = Hash.sha2(contra);

            mod.setUsuario(txtUsuario.getText());
            mod.setContraseña(nuevaContra);

            try {
                if (modSqul.login(mod)) {

                    this.dispose();
                    frmHome = new Home(mod);
                    frmHome.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "Datos incorrectos");

                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
        }

    }//GEN-LAST:event_btnIngresarActionPerformed

    private void lblRegistrarmeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegistrarmeMouseClicked
        // TODO add your handling code here:
        this.dispose();
        frmReg = new RegistroVista();
        frmReg.setVisible(true);

    }//GEN-LAST:event_lblRegistrarmeMouseClicked

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
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelBestRoute;
    private javax.swing.JLabel lblRegistrarme;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
