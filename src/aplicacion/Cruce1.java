/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import metodos.Conexionbd;

/**
 *
 * @author Leonardo
 */
public class Cruce1 extends javax.swing.JFrame {
    DefaultTableModel modelo;

    /**
     * Creates new form Ingresos
     */
    public Cruce1() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
   void llenartabla(){
   String [] amenazas= {"Id","Amenaza","Aplicación"};
   modelo=new  DefaultTableModel(null,amenazas);   
   String datos []= new String[5];
   String sql="SELECT idamenaza,nombre_amenaza FROM amenaza"; 
   String apli="SI";
        try {
            Statement st = cxn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            { 
                datos[0]=rs.getString("idamenaza");
                datos[1]=rs.getString("nombre_amenaza");
                datos[2]= apli;
                
                modelo.addRow(datos);
            }
            jTableAmenazas.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(RegistroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   Conexionbd conxlogin = new Conexionbd();
   Connection cxn = conxlogin.getConnection();
   String idfila="";
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAmenazas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField_id = new javax.swing.JTextField();
        jTextField_activo = new javax.swing.JTextField();
        jTextField_cantidad = new javax.swing.JTextField();
        jTextField_identificador = new javax.swing.JTextField();
        jComboBox_aplicacion = new javax.swing.JComboBox<String>();
        jButton_guardar = new javax.swing.JButton();
        jButton_modificar = new javax.swing.JButton();
        jButton_eliminar = new javax.swing.JButton();
        jButton_nuevo = new javax.swing.JButton();
        jButton_eliminar1 = new javax.swing.JButton();
        jButton_nuevo1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel_activos = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel_amenazas = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableAmenazas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Amenaza", "Aplicacion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableAmenazas);

        jLabel1.setText("Aplicacion:");

        jLabel2.setText("id:");

        jLabel3.setText("Identificador:");

        jLabel4.setText("Nombre Activo:");

        jLabel5.setText("Cantidad:");

        jTextField_id.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextField_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_idActionPerformed(evt);
            }
        });

        jTextField_activo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextField_activo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_activoActionPerformed(evt);
            }
        });

        jTextField_cantidad.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextField_cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_cantidadActionPerformed(evt);
            }
        });

        jTextField_identificador.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextField_identificador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_identificadorActionPerformed(evt);
            }
        });

        jComboBox_aplicacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona...", "SI", "NO" }));

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
        jButton_eliminar.setText("Buscar");
        jButton_eliminar.setBorder(null);
        jButton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarActionPerformed(evt);
            }
        });

        jButton_nuevo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton_nuevo.setText("Amenazas");
        jButton_nuevo.setBorder(null);
        jButton_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_nuevoActionPerformed(evt);
            }
        });

        jButton_eliminar1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton_eliminar1.setText("Eliminar");
        jButton_eliminar1.setBorder(null);
        jButton_eliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminar1ActionPerformed(evt);
            }
        });

        jButton_nuevo1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton_nuevo1.setText("Nuevo");
        jButton_nuevo1.setBorder(null);
        jButton_nuevo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_nuevo1ActionPerformed(evt);
            }
        });

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Volver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel2)
                        .addGap(8, 8, 8)
                        .addComponent(jTextField_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(25, 25, 25)
                                .addComponent(jTextField_identificador, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(16, 16, 16)
                                .addComponent(jTextField_activo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(160, 160, 160)
                                .addComponent(jButton_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(43, 43, 43)
                                .addComponent(jTextField_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(39, 39, 39)
                                .addComponent(jComboBox_aplicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton_nuevo1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(jButton_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jButton_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(595, 595, 595)
                        .addComponent(jButton2)
                        .addGap(51, 51, 51)
                        .addComponent(jButton1)
                        .addGap(130, 130, 130)
                        .addComponent(jButton_eliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jButton_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextField_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextField_identificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextField_activo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jButton_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextField_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBox_aplicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_nuevo1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_eliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)))))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 820, 530));

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
                .addContainerGap(210, Short.MAX_VALUE))
        );
        jPanel_activosLayout.setVerticalGroup(
            jPanel_activosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_activosLayout.createSequentialGroup()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel_activos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 50));

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
                .addContainerGap(169, Short.MAX_VALUE))
        );
        jPanel_amenazasLayout.setVerticalGroup(
            jPanel_amenazasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_amenazasLayout.createSequentialGroup()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel_amenazas, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 400, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_idActionPerformed

    private void jTextField_activoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_activoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_activoActionPerformed

    private void jTextField_cantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_cantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_cantidadActionPerformed

    private void jTextField_identificadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_identificadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_identificadorActionPerformed

    private void jButton_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_modificarActionPerformed

      

    }//GEN-LAST:event_jButton_modificarActionPerformed

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed

       

    }//GEN-LAST:event_jButton_eliminarActionPerformed

    private void jButton_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_guardarActionPerformed
        
    }//GEN-LAST:event_jButton_guardarActionPerformed

    private void jButton_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_nuevoActionPerformed

      llenartabla();
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton_nuevoActionPerformed

    private void jButton_eliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminar1ActionPerformed
        // TODO add your handling code here:
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

    private void jButton_nuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_nuevo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_nuevo1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Modulos visi=new Modulos();
        visi.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed
 public void setColor(JPanel jpanel){
        
        jpanel.setBackground(new java.awt.Color(60,64,77));
        
    }
    public void resetColor(JPanel jpanel){
        
        jpanel.setBackground(new java.awt.Color(27,29,37));
        
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
            java.util.logging.Logger.getLogger(Cruce1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cruce1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cruce1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cruce1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cruce1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JButton jButton_eliminar1;
    private javax.swing.JButton jButton_guardar;
    private javax.swing.JButton jButton_modificar;
    private javax.swing.JButton jButton_nuevo;
    private javax.swing.JButton jButton_nuevo1;
    public static javax.swing.JComboBox<String> jComboBox_aplicacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JPanel jPanel_activos;
    public static javax.swing.JPanel jPanel_amenazas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAmenazas;
    public static javax.swing.JTextField jTextField_activo;
    public static javax.swing.JTextField jTextField_cantidad;
    public static javax.swing.JTextField jTextField_id;
    public static javax.swing.JTextField jTextField_identificador;
    // End of variables declaration//GEN-END:variables


}
