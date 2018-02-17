/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import aplicaion_auxiliar.Modulos_aux;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import metodos.Conectarbd;
import metodos.Conexionbd;

/**
 *
 * @author barcelona
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        //    Textid.setVisible(false);
        initComponents();
        this.setLocationRelativeTo(null);
        //   this.setUndecorated(false);
        //edite esta parte

    }
    public static String insert_activo_id_user = "";

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        BIngresar = new javax.swing.JButton();
        TextContraseña = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        TextUsuario = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 456, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(152, 189, 219));
        setLocation(new java.awt.Point(0, 0));
        setLocationByPlatform(true);

        jPanel4.setBackground(new java.awt.Color(233, 235, 238));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel4.setFocusTraversalPolicyProvider(true);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(39, 60, 117));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(233, 235, 238));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(233, 235, 238));
        jLabel1.setText("RiskManagement 1.0");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/img_login_1.png"))); // NOI18N
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 196, 200));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(233, 235, 238));
        jLabel6.setText("Bienvenidos");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, -1));
        jPanel5.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 320, 160, 10));
        jPanel5.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 110, 10));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 477));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 19)); // NOI18N
        jLabel3.setText("Loguearse");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 19)); // NOI18N
        jLabel4.setText("Usuario:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 19)); // NOI18N
        jLabel5.setText("Contraseña:");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, -1, 21));

        BIngresar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BIngresar.setText("Ingresar");
        BIngresar.setBorder(null);
        BIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BIngresarActionPerformed(evt);
            }
        });
        jPanel4.add(BIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, 79, 33));

        TextContraseña.setBackground(new java.awt.Color(233, 235, 238));
        TextContraseña.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TextContraseña.setForeground(new java.awt.Color(51, 51, 51));
        TextContraseña.setBorder(null);
        TextContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextContraseñaActionPerformed(evt);
            }
        });
        jPanel4.add(TextContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 140, 30));

        jSeparator2.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel4.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 180, 10));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/user.png"))); // NOI18N
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 30, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pass.png"))); // NOI18N
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, -1, -1));

        jSeparator5.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel4.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 180, 10));

        TextUsuario.setBackground(new java.awt.Color(233, 235, 238));
        TextUsuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TextUsuario.setToolTipText("");
        TextUsuario.setBorder(null);
        TextUsuario.setName(""); // NOI18N
        TextUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextUsuarioActionPerformed(evt);
            }
        });
        jPanel4.add(TextUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 140, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextContraseñaActionPerformed

    private void BIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BIngresarActionPerformed

        String usu = TextUsuario.getText();
        String pas = new String(TextContraseña.getPassword());
        Ingresar(usu, pas);

        /* String user = TextUsuario.getText();
        String pass = TextContraseña.getText();
        if (user.equals("")) {
            JOptionPane.showMessageDialog(null, "debe ingresar el usuario");
        }
        if (pass.equals("")) {
            JOptionPane.showMessageDialog(null, "debe ingresar la contraseña");
        }else{
          
            try {
                login(user, pass);
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            }
        }*/
    }//GEN-LAST:event_BIngresarActionPerformed

    public void Ingresar(String user, String pass) {

        String capt = "";
        String id_usuario = "";
        String sql = "SELECT * FROM usuario WHERE usuario='" + user + "' && password='" + pass + "'";
        try {
            Statement st = cxn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //   insert_activo_id_user=rs.getString("idusuario");

//            while(rs.next()){
//                     //Textid.setText(rs.getString("idusuario"));
//            }
            while (rs.next()) {
                capt = rs.getString("tipo_usuario");
                //insert_activo_id_user=rs.getString("idusuario");

                // insert_activo_id_user=rs.getString("idusuario");
                //Modulos.Text_id.setText(rs.getString("idusuario"));
                //ing.id.setText(rs.getString("idusuario"));
                //insert_activo_id_user=rs.getString("idusuario");
                // Textid.setText(rs.getString("idusuario"));
                insert_activo_id_user = rs.getString("idusuario");

                //   Modulos.Text_id.setText(Textid.getText());
                //Modulos.Text_id
                //JOptionPane.showMessageDialog(null, insert_activo_id_user);
            }
            if (capt.equals("Administrador")) {
                //  Administrador admin = new Administrador();
                //Textid.setText= rs
                //   rs.getString(1, Textid.setText());
//                    insert_activo_id_user=rs.getString("idusuario");
                //                  JOptionPane.showMessageDialog(null, insert_activo_id_user);
                //       Textid.setText(rs.getString("idusuario"));
                //       dato.setString(2, jTextField_nombres.getText().toString());
                Modulos modulos = new Modulos();
                //   Login login = new Login();
                //  insert_activo_id_user = "select idusuario from usuario";
                //    Statement st1 = cxn.createStatement();
                //  st1.executeQuery(insert_activo_id_user);

                JOptionPane.showMessageDialog(null, "Bienvenido\n Has ingresado "
                        + "satisfactoriamente al sistema", "Mensaje de bienvenida",
                        JOptionPane.INFORMATION_MESSAGE);
                modulos.setVisible(true);
                dispose();
                modulos.pack();

                //  Administrador.labelconectado.setText(user);
            }

            if (capt.equals("Auxiliar")) {
                Modulos_aux auxiliar = new Modulos_aux();
                //  insert_activo_id_user = "select idusuario from usuario";
                // Statement st2 = cxn.createStatement();
                //  st2.executeQuery(insert_activo_id_user);
                // id_usuario=rs.getString("idusuario");
                JOptionPane.showMessageDialog(null, "Bienvenido\n Has ingresado "
                        + "satisfactoriamente al sistema", "Mensaje de bienvenida",
                        JOptionPane.INFORMATION_MESSAGE);
                auxiliar.setVisible(true);

            }

            if (user.equals("")) {
                JOptionPane.showMessageDialog(null, "debe ingresar el usuario");
            } else {
                if (pass.equals("")) {
                    JOptionPane.showMessageDialog(null, "debe ingresar la contraseña");
                } else {
                    if ((!capt.equals("Administrador")) && (!capt.equals("Auxiliar"))) {
                        //JOptionPane.showMessageDialog(null, "no existe datos");
                        JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
                                + "Por favor ingrese un usuario y/o contraseña correctos", "Acceso denegado",
                                JOptionPane.ERROR_MESSAGE);
                    }

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        //insert_activo_id_user = Integer.parseInt(id_usuario);

    }

    private void TextUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextUsuarioActionPerformed

    private void setColor(JLabel jLabel_exit) {
        jLabel_exit.setBackground(new java.awt.Color(204, 203, 203));
    }

    private void resetColor(JLabel jLabel_exit) {
        jLabel_exit.setBackground(new java.awt.Color(204, 203, 203));
    }

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
    public static javax.swing.JButton BIngresar;
    public static javax.swing.JPasswordField TextContraseña;
    public static javax.swing.JTextField TextUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    // End of variables declaration//GEN-END:variables
Conexionbd conxlogin = new Conexionbd();
    Connection cxn = conxlogin.getConnection();

    //Modulos.AccessibleAWTComponent
//    Modulos md=new Modulos();
}
