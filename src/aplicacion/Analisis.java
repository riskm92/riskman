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
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import metodos.Conexionbd;

/**
 *
 * @author fatte
 */
public class Analisis extends javax.swing.JFrame {

    DefaultTableModel modelo;

    /**
     * Creates new form Analisis
     */
    public Analisis() {
        initComponents();
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
    String idfila = "";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_analisis = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        jButton4.setText("jButton4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setMinimumSize(new java.awt.Dimension(900, 560));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(233, 235, 238));
        jPanel3.setMinimumSize(new java.awt.Dimension(900, 560));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 4), "Analisis de Riesgo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N

        jTable_analisis.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTable_analisis.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable_analisis);

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

        jButton8.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Set_As_Resume_30px.png"))); // NOI18N
        jButton8.setText("Reporte");
        jPanel5.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 120, -1));

        jButton7.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Microsoft_Excel_30px.png"))); // NOI18N
        jButton7.setText("Exportar");
        jPanel5.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 120, -1));

        jButton9.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Save_30px.png"))); // NOI18N
        jButton9.setText("Guardar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 120, -1));

        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Analyze_30px.png"))); // NOI18N
        jButton6.setText("Visualizar Análisis");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 170, 41));

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

    void llenartabla_amenaza() {

        Object[] columnas = {"Activo", "Amenaza", "Probabilidad", "Impacto", "Riesgo"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        String datos[] = new String[2];
//        String datos1[] = new String[1];
        String sql_act_ame = " select nombre_activo, nombre_amenaza from activo_amenaza "
                + "inner join activo on activo_amenaza.activos_idactivos=activo.idactivo "
                + "inner join amenaza on activo_amenaza.amenazas_idamenaza=amenaza.idamenaza";
//        String sql_ame_nom = "select ame.nombre_amenaza from amenaza ame join activo_amenaza am on am.amenazas_idamenaza=ame.idamenaza"
//                + " where am.amenazas_idamenaza";
        try {
            Statement st = cxn.createStatement();
            ResultSet rs = st.executeQuery(sql_act_ame);

            while (rs.next()) {
                datos[0] = rs.getString("nombre_activo");
                datos[1] = rs.getString("nombre_amenaza");
                modelo.addRow(datos); 
            }

            jTable_analisis.setModel(modelo);

        } catch (SQLException ex) {
            Logger.getLogger(RegistroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        llenartabla_amenaza();


    }//GEN-LAST:event_jButton6ActionPerformed

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        this.setVisible(false);
        Modulos modu = new Modulos();
        modu.setVisible(true);

    }//GEN-LAST:event_jLabel10MouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

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
            java.util.logging.Logger.getLogger(Analisis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Analisis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Analisis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Analisis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Analisis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_analisis;
    // End of variables declaration//GEN-END:variables
}
