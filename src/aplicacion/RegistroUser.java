/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import static aplicacion.Login.TextUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import metodos.Conexionbd;

/**
 *
 * @author Leonardo
 */
public class RegistroUser extends javax.swing.JPanel {

    DefaultTableModel modelo;
    DefaultTableModel model;

    /**
     * Creates new form RegistroUser
     */
    public RegistroUser() {
        initComponents();

        llenartabla();
        Generarnumeracion();
        //this.setLocationRelativeTo(null);
        jTable_registro.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                try {
                    String sql = "";
                    int fila = jTable_registro.getSelectedRow();
                    //   sql="select idusuario, nombres, apellidos, correo, celular, institucion, cedula, usuario, password,tipo_usuario from usuario";
                    // Statement st = cxn.createStatement();
                    //ResultSet rs = st.executeQuery(sql);

                    //    Statement sent=cxn.createStatement();
                    // int n=sent.executeQuery(sql);
                    if (jTable_registro.getSelectedRow() != -1) {
                        //int fila = jTable_registro.getSelectedRow();
                        jTextField_id.setText(jTable_registro.getValueAt(fila, 0).toString());
                        jTextField_nombres.setText(jTable_registro.getValueAt(fila, 1).toString());
                        jTextField_apellidos.setText(jTable_registro.getValueAt(fila, 2).toString());
                        jTextField_correo.setText(jTable_registro.getValueAt(fila, 3).toString());
                        jTextField_celular.setText(jTable_registro.getValueAt(fila, 4).toString());
                        jTextField_institucion.setText(jTable_registro.getValueAt(fila, 5).toString());
                        jTextField_cedula.setText(jTable_registro.getValueAt(fila, 6).toString());
                        jTextField_usuario.setText(jTable_registro.getValueAt(fila, 7).toString());
                        jPassword.setText(jTable_registro.getValueAt(fila, 8).toString());
                        jComboBox_tipo.setSelectedItem(jTable_registro.getValueAt(fila, 9).toString());
                        // jTextField_nombres.setText(jTable_registro.getValueAt(fila, 2).toString());   

                    }

                } catch (Exception ex) {
                    Logger.getLogger(RegistroUser.class.getName()).log(Level.SEVERE, null, ex);

                }

            }

            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            //}
        });
    }

    void Deshabilitar() {
        jTextField_id.setEditable(false);
        jTextField_nombres.setEditable(false);
        jTextField_apellidos.setEditable(false);
        jTextField_correo.setEditable(false);
        jTextField_celular.setEditable(false);
        jTextField_institucion.setEditable(false);
        jTextField_cedula.setEditable(false);
        jTextField_usuario.setEditable(false);
        jPassword.setEditable(false);
        jComboBox_tipo.setEnabled(false);
    }

    void Limpiar() {
        //jTextField_id.setText("");
        jTextField_nombres.setText("");
        jTextField_apellidos.setText("");
        jTextField_correo.setText("");
        jTextField_celular.setText("");
        jTextField_institucion.setText("");
        jTextField_cedula.setText("");
        jTextField_usuario.setText("");
        jPassword.setText("");
        // jComboBox_tipo.setSelectedItem(0);
        jComboBox_tipo.setSelectedIndex(0);
        // listadesplegable1.setSelectedIndex(0);//opción1
        //  listadesplegable2.setSelectedItem("Seleccione");//opción2
    }

    void Habilitar() {
        jTextField_id.setEditable(true);
        jTextField_nombres.setEditable(true);
        jTextField_apellidos.setEditable(true);
        jTextField_correo.setEditable(true);
        jTextField_celular.setEditable(true);
        jTextField_institucion.setEditable(true);
        jTextField_cedula.setEditable(true);
        jTextField_usuario.setEditable(true);
        jPassword.setEditable(true);
        jComboBox_tipo.setEnabled(true);
    }

    void Generarnumeracion() {
        String SQL = "select  max(idusuario) from usuario";

        int c = 0;

        try {
            Statement st = cxn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                c = rs.getInt(1);
            }

            if (c == 0) {
                jTextField_id.setText("1");
            } else {

                jTextField_id.setText("" + (c + 1));

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroUser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void llenartabla() {
        String[] titulos = {"Id", "Nombres", "Apellidos", "Correo", "Celular", "Institucion", "Cedula", "Usuario", "Password", "Tipo Usuario"};
        modelo = new DefaultTableModel(null, titulos);
        String datos[] = new String[10];
        String sql = "SELECT idusuario,nombres,apellidos,correo,celular,institucion,cedula,usuario,password,tipo_usuario FROM usuario";
        try {
            Statement st = cxn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("idusuario");
                datos[1] = rs.getString("nombres");
                datos[2] = rs.getString("apellidos");
                datos[3] = rs.getString("correo");
                datos[4] = rs.getString("celular");
                datos[5] = rs.getString("institucion");
                datos[6] = rs.getString("cedula");
                datos[7] = rs.getString("usuario");
                datos[8] = rs.getString("password");
                datos[9] = rs.getString("tipo_usuario");

                modelo.addRow(datos);
            }
            jTable_registro.setModel(modelo);
        } catch (Exception ex) {
            System.out.println("" + ex);
            Logger.getLogger(RegistroUser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField_id = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField_nombres = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField_apellidos = new javax.swing.JTextField();
        jTextField_celular = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField_institucion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField_correo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField_cedula = new javax.swing.JTextField();
        jPassword = new javax.swing.JPasswordField();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField_usuario = new javax.swing.JTextField();
        jComboBox_tipo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_registro = new javax.swing.JTable();
        jButton_nuevo = new javax.swing.JButton();
        jButton_guardar = new javax.swing.JButton();
        jButton_modificar = new javax.swing.JButton();
        jButton_eliminar = new javax.swing.JButton();

        jTextField_id.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextField_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_idActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setText("id:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setText("Nombres:");

        jTextField_nombres.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextField_nombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_nombresActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setText("Apellidos:");

        jTextField_apellidos.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextField_apellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_apellidosActionPerformed(evt);
            }
        });

        jTextField_celular.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextField_celular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_celularActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel10.setText("Celular:");

        jTextField_institucion.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextField_institucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_institucionActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel6.setText("Institución:");

        jTextField_correo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextField_correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_correoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel8.setText("Correo:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel7.setText("Cédula:");

        jTextField_cedula.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextField_cedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_cedulaActionPerformed(evt);
            }
        });

        jPassword.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel13.setText("Contraseña:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel12.setText("Usuario:");

        jTextField_usuario.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextField_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_usuarioActionPerformed(evt);
            }
        });

        jComboBox_tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar...", "Administrador", "Auxiliar" }));
        jComboBox_tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_tipoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setText("Tipo:");

        jTable_registro.setBackground(new java.awt.Color(204, 204, 204));
        jTable_registro.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTable_registro.setForeground(new java.awt.Color(51, 51, 51));
        jTable_registro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nombres", "Apellidos", "Correo", "Celular", "Institucion", "Cedula", "Usuario", "Password", "Tipo Usuario"
            }
        ));
        jTable_registro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_registroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_registro);

        jButton_nuevo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton_nuevo.setText("Nuevo");
        jButton_nuevo.setBorder(null);
        jButton_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_nuevoActionPerformed(evt);
            }
        });

        jButton_guardar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton_guardar.setText("Guardar");
        jButton_guardar.setBorder(null);
        jButton_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_guardarActionPerformed(evt);
            }
        });

        jButton_modificar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton_modificar.setText("Modificar");
        jButton_modificar.setBorder(null);
        jButton_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_modificarActionPerformed(evt);
            }
        });

        jButton_eliminar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton_eliminar.setText("Eliminar");
        jButton_eliminar.setBorder(null);
        jButton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(jButton_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButton_guardar, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addGap(38, 38, 38)
                .addComponent(jButton_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(228, 228, 228))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(jLabel3)
                        .addGap(6, 6, 6)
                        .addComponent(jTextField_id, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(jLabel4)
                        .addGap(12, 12, 12)
                        .addComponent(jTextField_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel5)
                        .addGap(23, 23, 23)
                        .addComponent(jTextField_apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(jLabel7)
                        .addGap(27, 27, 27)
                        .addComponent(jTextField_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel10)
                        .addGap(37, 37, 37)
                        .addComponent(jTextField_celular, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(jLabel8)
                        .addGap(26, 26, 26)
                        .addComponent(jTextField_correo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel6)
                        .addGap(19, 19, 19)
                        .addComponent(jTextField_institucion, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(jLabel12)
                        .addGap(22, 22, 22)
                        .addComponent(jTextField_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel13)
                        .addGap(11, 11, 11)
                        .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(jLabel2)
                        .addGap(21, 21, 21)
                        .addComponent(jComboBox_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel3))
                    .addComponent(jTextField_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_celular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10))))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_institucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6))))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_idActionPerformed

    private void jTextField_nombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_nombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_nombresActionPerformed

    private void jTextField_apellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_apellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_apellidosActionPerformed

    private void jTextField_celularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_celularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_celularActionPerformed

    private void jTextField_institucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_institucionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_institucionActionPerformed

    private void jTextField_correoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_correoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_correoActionPerformed

    private void jTextField_cedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_cedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_cedulaActionPerformed

    private void jPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordActionPerformed

    private void jTextField_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_usuarioActionPerformed

    private void jComboBox_tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_tipoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBox_tipoActionPerformed

    private void jButton_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_modificarActionPerformed

        int id = Integer.parseInt(jTextField_id.getText().toString());
        String nombres = jTextField_nombres.getText();
        String apellidos = jTextField_apellidos.getText();
        String correo = jTextField_correo.getText();
        String celular = jTextField_celular.getText();
        String institucion = jTextField_institucion.getText();
        String cedula = jTextField_cedula.getText();
        String usuario = jTextField_usuario.getText();
        String password = new String(jPassword.getPassword());
        String tipo_usuario = jComboBox_tipo.getModel().getSelectedItem().toString();

        try {
            String sql = "Update usuario set nombres='" + nombres + "', apellidos='" + apellidos + "', "
                    + "correo='" + correo + "', celular='" + celular + "', institucion='" + institucion + "', "
                    + "cedula='" + cedula + "', usuario='" + usuario + "', password='" + password + "', "
                    + "tipo_usuario='" + tipo_usuario + "' where  idusuario='" + id + "'";

//            int fila=jTable_registro.getSelectedRow();
//            String dato=(String)jTable_registro.getValueAt(fila,0);
            PreparedStatement ps = cxn.prepareCall(sql);
//            ps.setString(1,jTextField_nombres.getText());
////            ps.setString(2,jTextField_apellidos.getText());
////            ps.setString(3,correo.getText());
////            ps.setString(4,jTextField_celular.getText());//valor de campos de texto a pasar a
////            ps.setString(5,jTextField_institucion.getText());
////            ps.setString(6,cedula.getText());
////            ps.setString(7,usuario.getText());
////            ps.setString(8, new String (jPassword.getPassword()));
////            ps.setString(9,jComboBox_tipo.getModel().getSelectedItem().toString());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "datos modificados");
            Limpiar();
            llenartabla();
            Generarnumeracion();
            //BasedeDatos

//           ps.setString(9,dato);//la llamada sql se muestra en la tabla
//            if(ps.executeQuery()){
//                
//            }
//            int n=ps.executeUpdate();
//            if(n>0){
//                Limpiar();
//                llenartabla();
//                JOptionPane.showMessageDialog(null, "datos modificados");
//
//            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error" + e.getMessage());
        }


    }//GEN-LAST:event_jButton_modificarActionPerformed

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed

        try {
            int fila = jTable_registro.getSelectedRow();
            String sql = "delete from usuario where idusuario=" + jTable_registro.getValueAt(fila, 0);

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

    }//GEN-LAST:event_jButton_eliminarActionPerformed

    private void jButton_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_guardarActionPerformed
        String sql = "";
        sql = "INSERT INTO usuario(idusuario,nombres,apellidos,correo,celular,institucion,cedula,usuario,password,tipo_usuario) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {

            int id = Integer.parseInt(jTextField_id.getText().toString());
            int celular = Integer.parseInt(jTextField_celular.getText().toString());
            int cedula = Integer.parseInt(jTextField_cedula.getText().toString());

            PreparedStatement dato = cxn.prepareStatement(sql);
            //dato.setInt(1, id);
            dato.setInt(1, id);
            dato.setString(2, jTextField_nombres.getText().toString());
            dato.setString(3, jTextField_apellidos.getText().toString());
            dato.setString(4, jTextField_correo.getText().toString());
            dato.setInt(5, celular);
            dato.setString(6, jTextField_institucion.getText().toString());
            dato.setInt(7, cedula);
            dato.setString(8, jTextField_usuario.getText().toString());
            dato.setString(9, new String(jPassword.getPassword()));
            dato.setString(10, jComboBox_tipo.getModel().getSelectedItem().toString());
            dato.executeUpdate();

            //btn_nuevo.setEnabled(true);
            JOptionPane.showMessageDialog(null, " Registro Ingresado Correctamente");
            Generarnumeracion();
            Limpiar();
            llenartabla();
        } catch (SQLException e) {
            System.out.println("Error => Problema al Insertar Registro " + e);
        }
    }//GEN-LAST:event_jButton_guardarActionPerformed

    private void jButton_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_nuevoActionPerformed
        Generarnumeracion();
        Limpiar();
        Habilitar();
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton_nuevoActionPerformed

    private void jTable_registroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_registroMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable_registroMouseClicked
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
                new RegistroUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JButton jButton_guardar;
    private javax.swing.JButton jButton_modificar;
    private javax.swing.JButton jButton_nuevo;
    private javax.swing.JComboBox<String> jComboBox_tipo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_registro;
    private javax.swing.JTextField jTextField_apellidos;
    private javax.swing.JTextField jTextField_cedula;
    private javax.swing.JTextField jTextField_celular;
    private javax.swing.JTextField jTextField_correo;
    private javax.swing.JTextField jTextField_id;
    private javax.swing.JTextField jTextField_institucion;
    private javax.swing.JTextField jTextField_nombres;
    private javax.swing.JTextField jTextField_usuario;
    // End of variables declaration//GEN-END:variables
Conexionbd conxlogin = new Conexionbd();
    Connection cxn = conxlogin.getConnection();
    String idfila = "";
}
