/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import metodos.Conexionbd;

/**
 *
 * @author Leonardo
 */
public class Ingresos extends javax.swing.JFrame {

    DefaultTableModel modelo;

    public Ingresos() {
        initComponents();
        llenartabla();
        id.setVisible(false);

        this.setLocationRelativeTo(null);
        jTable_activo.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                try {

                    int fila = jTable_activo.getSelectedRow();

                    if (jTable_activo.getSelectedRow() != -1) {
                        //int fila = jTable_registro.getSelectedRow();

                        id.setText(jTable_activo.getValueAt(fila, 1).toString());
                        cantidad.setText(jTable_activo.getValueAt(fila, 2).toString());
                        nombre_activo.setText(jTable_activo.getValueAt(fila, 3).toString());
                        tipo_activo.setSelectedItem(jTable_activo.getValueAt(fila, 4).toString());
                        aplicacion.setSelectedItem(jTable_activo.getValueAt(fila, 5).toString());

                    }

                } catch (Exception ex) {
                    Logger.getLogger(RegistroUser.class.getName()).log(Level.SEVERE, null, ex);

                }

            }

            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            //}
        });
    }

    void Generarnumeracion() {
        String SQL = "select  max(idactivo) from activo";

        int c = 0;

        try {
            Statement st = cxn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                c = rs.getInt(1);
            }

            if (c == 0) {
                id.setText("1");

            } else {

                id.setText("" + (c + 1));

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroUser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void llenartabla() {
        String[] titulos = {"Id", "Identificador", "Cantidad", "Activo", "Tipo Activo", "Aplicacion"};

        modelo = new DefaultTableModel(null, titulos);
        String datos[] = new String[6];
        String sql = "SELECT idactivo, identificador, Cantidad, nombre_activo, tipo_activo, aplicacion FROM activo";
        try {
            Statement st = cxn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("idactivo");
                datos[1] = rs.getString("identificador");
                datos[2] = rs.getString("Cantidad");
                datos[3] = rs.getString("nombre_activo");
                datos[4] = rs.getString("tipo_activo");
                datos[5] = rs.getString("aplicacion");

                modelo.addRow(datos);
            }
            jTable_activo.setModel(modelo);
        } catch (Exception ex) {
            System.out.println("" + ex);
            Logger.getLogger(RegistroUser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void Deshabilitar() {
        id.setEditable(false);
        cantidad.setEditable(false);
        nombre_activo.setEditable(false);
        tipo_activo.setEnabled(false);
        aplicacion.setEnabled(false);
    }

    void Limpiar() {
        //jTextField_id.setText("");
        id.setText("");
        cantidad.setText("");
        nombre_activo.setText("");
        tipo_activo.setSelectedIndex(0);
        aplicacion.setSelectedIndex(0);

    }

    void Habilitar() {
        id.setEditable(true);
        cantidad.setEditable(true);
        nombre_activo.setEditable(true);
        tipo_activo.setEnabled(true);
        aplicacion.setEnabled(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_activo = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nombre_activo = new javax.swing.JTextField();
        cantidad = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        tipo_activo = new javax.swing.JComboBox<>();
        jButton_guardar = new javax.swing.JButton();
        jButton_modificar = new javax.swing.JButton();
        jButton_eliminar = new javax.swing.JButton();
        jButton_nuevo = new javax.swing.JButton();
        jButton_eliminar1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        aplicacion = new javax.swing.JComboBox<>();
        identificador = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel_activos = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel_amenazas = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_activo.setBackground(new java.awt.Color(204, 204, 204));
        jTable_activo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Indentificador", "Cantidad", "Activo", "Tipo Activo", "Aplicacion"
            }
        ));
        jScrollPane1.setViewportView(jTable_activo);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 255, 663, 140));

        jLabel1.setText("Aplicacion:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, -1, -1));

        jLabel4.setText("Nombre Activo:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, -1));

        jLabel5.setText("Cantidad:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        nombre_activo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        nombre_activo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre_activoActionPerformed(evt);
            }
        });
        jPanel1.add(nombre_activo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 140, -1));

        cantidad.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadActionPerformed(evt);
            }
        });
        jPanel1.add(cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 140, -1));

        id.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });
        jPanel1.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 30, -1));

        tipo_activo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona...", "DI", "SW", "SW", "HW", "COM", "Media", "AUX", "INST", "PSL" }));
        tipo_activo.setToolTipText("");
        jPanel1.add(tipo_activo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, -1, -1));

        jButton_guardar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton_guardar.setText("Guardar");
        jButton_guardar.setBorder(null);
        jButton_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_guardarActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(328, 406, 80, 30));

        jButton_modificar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton_modificar.setText("Modificar");
        jButton_modificar.setBorder(null);
        jButton_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_modificarActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(428, 406, 80, 30));

        jButton_eliminar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton_eliminar.setText("Buscar");
        jButton_eliminar.setBorder(null);
        jButton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(628, 406, 80, 30));

        jButton_nuevo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton_nuevo.setText("Nuevo");
        jButton_nuevo.setBorder(null);
        jButton_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_nuevoActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 406, 80, 30));

        jButton_eliminar1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton_eliminar1.setText("Eliminar");
        jButton_eliminar1.setBorder(null);
        jButton_eliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminar1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_eliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(528, 406, 80, 30));

        jLabel6.setText("Tipo Activo:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));

        aplicacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona...", "SI", "NO" }));
        jPanel1.add(aplicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, -1, -1));

        identificador.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        identificador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                identificadorActionPerformed(evt);
            }
        });
        jPanel1.add(identificador, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 140, -1));

        jLabel7.setText("Identificador:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 900, 520));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_activos.setBackground(new java.awt.Color(27, 29, 37));
        jPanel_activos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel_activosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel_activosMouseExited(evt);
            }
        });

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Activos");

        javax.swing.GroupLayout jPanel_activosLayout = new javax.swing.GroupLayout(jPanel_activos);
        jPanel_activos.setLayout(jPanel_activosLayout);
        jPanel_activosLayout.setHorizontalGroup(
            jPanel_activosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_activosLayout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(jLabel21)
                .addContainerGap(260, Short.MAX_VALUE))
        );
        jPanel_activosLayout.setVerticalGroup(
            jPanel_activosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_activosLayout.createSequentialGroup()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel_activos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 50));

        jPanel_amenazas.setBackground(new java.awt.Color(27, 29, 37));
        jPanel_amenazas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_amenazasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel_amenazasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel_amenazasMouseExited(evt);
            }
        });

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Amenazas");

        javax.swing.GroupLayout jPanel_amenazasLayout = new javax.swing.GroupLayout(jPanel_amenazas);
        jPanel_amenazas.setLayout(jPanel_amenazasLayout);
        jPanel_amenazasLayout.setHorizontalGroup(
            jPanel_amenazasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_amenazasLayout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(jLabel20)
                .addContainerGap(199, Short.MAX_VALUE))
        );
        jPanel_amenazasLayout.setVerticalGroup(
            jPanel_amenazasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_amenazasLayout.createSequentialGroup()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel_amenazas, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 430, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombre_activoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre_activoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombre_activoActionPerformed

    private void cantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidadActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void jButton_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_modificarActionPerformed


    }//GEN-LAST:event_jButton_modificarActionPerformed

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed


    }//GEN-LAST:event_jButton_eliminarActionPerformed

    private void jButton_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_guardarActionPerformed
        Login lo = new Login();

        // int idusuario_activo=Integer.parseInt(lo.insert_activo_id_user);
        int id_user_ac = (lo.insert_activo_id_user);
        String sql = "";
        

        sql = "INSERT INTO activo(identificador, Cantidad,nombre_activo, tipo_activo, aplicacion, usuario_idusuario)"
                + " VALUES (?,?,?,?,'" + id_user_ac + "')";
        System.out.println("este es el dato" + id_user_ac);
        try {

            int cant = Integer.parseInt(cantidad.getText().toString());
            // int idd = Integer.parseInt(id.getText().toString());
            //     int cedula = Integer.parseInt(jTextField_cedula.getText().toString());

            PreparedStatement dato = cxn.prepareStatement(sql);
            //dato.setInt(1, idd);

            dato.setString(1, identificador.getText().toString());
            dato.setInt(2, cant);
            dato.setString(3, nombre_activo.getText().toString());
            dato.setString(4, tipo_activo.getModel().getSelectedItem().toString());
            dato.setString(5, aplicacion.getModel().getSelectedItem().toString());

            dato.executeUpdate();

            //btn_nuevo.setEnabled(true);
            JOptionPane.showMessageDialog(null, " Registro Ingresado Correctamente");
            //Generarnumeracion();
            Limpiar();
            llenartabla();
        } catch (SQLException e) {
            System.out.println("Error => Problema al Insertar Registro " + e);
        }
    }//GEN-LAST:event_jButton_guardarActionPerformed

    private void jButton_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_nuevoActionPerformed

        // TODO add your handling code here:

    }//GEN-LAST:event_jButton_nuevoActionPerformed

    private void jButton_eliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminar1ActionPerformed
        try {
            int fila = jTable_activo.getSelectedRow();
            String sql = "delete from activo where idactivo=" + jTable_activo.getValueAt(fila, 0);

            Statement sent = cxn.createStatement();
            int n = sent.executeUpdate(sql);
            if (n > 0) {

                JOptionPane.showMessageDialog(null, "datos eliminados");
                llenartabla();
                Limpiar();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error" + e.getMessage());
        }
    }//GEN-LAST:event_jButton_eliminar1ActionPerformed

    private void jPanel_activosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_activosMouseEntered
        setColor(jPanel_activos);
    }//GEN-LAST:event_jPanel_activosMouseEntered

    private void jPanel_activosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_activosMouseExited
        resetColor(jPanel_activos);
    }//GEN-LAST:event_jPanel_activosMouseExited

    private void jPanel_amenazasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_amenazasMouseEntered
        setColor(jPanel_amenazas);
    }//GEN-LAST:event_jPanel_amenazasMouseEntered

    private void jPanel_amenazasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_amenazasMouseExited
        resetColor(jPanel_amenazas);
    }//GEN-LAST:event_jPanel_amenazasMouseExited

    private void jPanel_amenazasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_amenazasMouseClicked
        //Amenazas amenazas = new Amenazas();
        // amenazas.setVisible(true);
        // Amenazas amenazas= new Amenazas();
        // jPanel_amenazas.add(amenazas);
        //amenazas.show();
        //jPanel_amenazas
        // dispose();
    }//GEN-LAST:event_jPanel_amenazasMouseClicked

    private void identificadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_identificadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_identificadorActionPerformed
    public void setColor(JPanel jpanel) {

        jpanel.setBackground(new java.awt.Color(60, 64, 77));

    }

    public void resetColor(JPanel jpanel) {

        jpanel.setBackground(new java.awt.Color(27, 29, 37));

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
            java.util.logging.Logger.getLogger(Ingresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ingresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ingresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ingresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ingresos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> aplicacion;
    public static javax.swing.JTextField cantidad;
    public static javax.swing.JTextField id;
    public static javax.swing.JTextField identificador;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JButton jButton_eliminar1;
    private javax.swing.JButton jButton_guardar;
    private javax.swing.JButton jButton_modificar;
    private javax.swing.JButton jButton_nuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JPanel jPanel_activos;
    public static javax.swing.JPanel jPanel_amenazas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_activo;
    public static javax.swing.JTextField nombre_activo;
    public static javax.swing.JComboBox<String> tipo_activo;
    // End of variables declaration//GEN-END:variables
        Conexionbd conxlogin = new Conexionbd();
    Connection cxn = conxlogin.getConnection();
    String idfila = "";
}
