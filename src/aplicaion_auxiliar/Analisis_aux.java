/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicaion_auxiliar;

import aplicacion.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import metodos.Conexionbd;

/**
 *
 * @author fatte
 */
public class Analisis_aux extends javax.swing.JFrame {
    DefaultTableModel modelo;
    

    /**
     * Creates new form Analisis
     */
    public Analisis_aux() {
        initComponents();
        Bguardar.setEnabled(false);
        this.setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
//   void llenartabla(){
//   String [] activos= {"Cantidad","nombre_activo"};
//   modelo=new  DefaultTableModel(null,activos);   
//   String datos []= new String[5];
//   String sql="SELECT Cantidad,nombre_activo FROM activo"; 
//        try {
//            Statement st = cxn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            while(rs.next())
//            { 
//                datos[0]=rs.getString("Cantidad");
//                datos[1]=rs.getString("nombre_activo");
//                //datos[2]= rs.getString("usuario");
//                //datos[3]= rs.getString("tipo_usuario");
//                
//                modelo.addRow(datos);
//            }
//            jTable1.setModel(modelo);
//        } catch (SQLException ex) {
//            Logger.getLogger(RegistroUsuario.class.getName()).log(Level.SEVERE, null, ex);
//        }
//  
//  
//   } 
Conexionbd conxlogin = new Conexionbd();
Connection cxn = conxlogin.getConnection();
String idfila="";
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        Breporte = new javax.swing.JButton();
        Bexportar = new javax.swing.JButton();
        Bguardar = new javax.swing.JButton();
        Banalisis = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        jButton4.setText("jButton4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setMinimumSize(new java.awt.Dimension(900, 560));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(233, 235, 238));
        jPanel3.setMinimumSize(new java.awt.Dimension(900, 560));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 4), "Analisis de Riesgo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N

        jTable2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Activos", "Amenazas", "Probabilidad", "Impacto", "Riesgo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 793, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 850, 470));

        jPanel5.setBackground(new java.awt.Color(113, 128, 147));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Breporte.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Breporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Set_As_Resume_30px.png"))); // NOI18N
        Breporte.setText("Reporte");
        Breporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BreporteActionPerformed(evt);
            }
        });
        jPanel5.add(Breporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 120, -1));

        Bexportar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Bexportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Microsoft_Excel_30px.png"))); // NOI18N
        Bexportar.setText("Exportar");
        jPanel5.add(Bexportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 120, -1));

        Bguardar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Bguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Save_30px.png"))); // NOI18N
        Bguardar.setText("Guardar");
        Bguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BguardarActionPerformed(evt);
            }
        });
        jPanel5.add(Bguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 120, -1));

        Banalisis.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Banalisis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Analyze_30px.png"))); // NOI18N
        Banalisis.setText("Visualizar Análisis");
        Banalisis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BanalisisActionPerformed(evt);
            }
        });
        jPanel5.add(Banalisis, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 170, 41));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Go_Back_40px.png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 60));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  public void setColor(JButton jbutton) {

        jbutton.setBackground(new java.awt.Color(52, 73, 94));

    }

    public void resetColor(JButton jbutton) {

        jbutton.setBackground(new java.awt.Color(47, 54, 64));

    }
    private void BanalisisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BanalisisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BanalisisActionPerformed

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        this.setVisible(false);
        Modulos_aux modu=new Modulos_aux();
        modu.setVisible(true);      
        
    }//GEN-LAST:event_jLabel10MouseClicked

    private void BguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BguardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BguardarActionPerformed

    private void BreporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BreporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BreporteActionPerformed

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
            java.util.logging.Logger.getLogger(Analisis_aux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Analisis_aux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Analisis_aux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Analisis_aux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Analisis_aux().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Banalisis;
    private javax.swing.JButton Bexportar;
    private javax.swing.JButton Bguardar;
    private javax.swing.JButton Breporte;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
