/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicaion_auxiliar;

import aplicacion.*;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.TableView.TableRow;
import metodos.Conexionbd;
import metodos.JtableComboBox;

/**
 *
 * @author Leonardo
 */
public class cruces_activos_amenazas_aux extends javax.swing.JFrame {

    /**
     * Creates new form cruces_activos_amenazas
     */
    Conexionbd conxlogin = new Conexionbd();
    Connection cxn = conxlogin.getConnection();

    public cruces_activos_amenazas_aux() {
        initComponents();
        this.setLocationRelativeTo(null);
        llenartabla_amenaza();
        guardar_cruces();
        Bguardar.setVisible(false);
//       llenar_amenaza(); 
    }

    public int columna = 0;
    public int fila = 0;

    void llenartabla_amenaza() {

        Object[] amenaza = {"Amenaza/Activo"};
        DefaultTableModel modelo = new DefaultTableModel(null, amenaza);
        String datos[] = new String[1];
        Object dat;
        String sqld = "SELECT nombre_amenaza from amenaza";
        String sql = "SELECT identificador from activo where aplicacion = 'SI'";
        try {
            Statement st = cxn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Statement sts = cxn.createStatement();
            ResultSet rss = sts.executeQuery(sqld);
            while (rss.next()) {
                datos[0] = rss.getString("nombre_amenaza");
                modelo.addRow(datos);
//                fila = modelo.getRowCount();
            }
//            int tamaño = 0;
            while (rs.next()) {
                dat = rs.getString("identificador");
                modelo.addColumn(dat);
            }
//                tamaño = modelo.getColumnCount();
//                columna = modelo.getColumnCount();

//            String[] positions = {"SI", "NO"};
//            JComboBox combo = null;
//                    combo = new JComboBox<String>(positions);
//            combo.addActionListener(new ActionListener() {
//                public void actionPerformed(ActionEvent ae) {
//                    
////                    JOptionPane.showMessageDialog(null, "" + );
//                }
//            });
//JComboBox comboBox = new JComboBox();
//comboBox.addItem("SI");
//comboBox.addItem("NO");
//// String [] dato = modelo.getValueAt(fila, fila);
//            
////for (int i = 0; i < 5; i++) {
//              TableColumn column = jTable_cruces.getColumnModel().getColumn(1);
//             column.setCellEditor(new DefaultCellEditor(comboBox)); 
////}
//    for (int j =0; j < fila; j++){
//                    jTable_cruces.getColumn(1);
//                    //modelo.addRow(amenaza);
//                    TableColumn col1 = jTable_cruces.getColumnModel().getColumn(j);
////                col1.setCellRenderer(new DefaultTableCellRenderer());
//                    
//                }
//                
//                TableColumn col1 = jTable_cruces.getColumnModel().getColumn(i);
//                col1.setCellRenderer(new DefaultTableCellRenderer());
//                col1.setCellEditor(new DefaultCellEditor(combo));
            jTable_cruces.setModel(modelo);

//            
//            TableColumn col2 = jTable_cruces.getColumnModel().getColumn(2);
//            TableColumn col3 = jTable_cruces.getColumnModel().getColumn(3);
//            TableColumn col4 = jTable_cruces.getColumnModel().getColumn(4);
//
//            col2.setCellEditor(new DefaultCellEditor(combo));
//            col3.setCellEditor(new DefaultCellEditor(combo));
//            col4.setCellEditor(new DefaultCellEditor(combo));
            ancho_columnas();
        } catch (SQLException ex) {
            Logger.getLogger(RegistroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void guardar_cruces() {

        int colum = jTable_cruces.getColumnCount();

        String[] positions = {"SI", "NO"};
        JComboBox combo = null;
        combo = new JComboBox<String>(positions);
        combo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

//                    JOptionPane.showMessageDialog(null, "" + );
            }
        });
        int e=1;
        int i;
        for (i = e; i < colum; i++) {

            TableColumn column = jTable_cruces.getColumnModel().getColumn(i);
            column.setCellEditor(new DefaultCellEditor(combo));

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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_cruces = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        Breporte = new javax.swing.JButton();
        Bexportar = new javax.swing.JButton();
        Bguardar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        Bnuevo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(900, 560));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 4), "Cruce entre Amenaza y Activo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N

        jTable_cruces.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTable_cruces.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Amenaza/Activo", "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9"
            }
        ));
        jScrollPane1.setViewportView(jTable_cruces);
        if (jTable_cruces.getColumnModel().getColumnCount() > 0) {
            jTable_cruces.getColumnModel().getColumn(0).setHeaderValue("Amenaza/Activo");
            jTable_cruces.getColumnModel().getColumn(1).setHeaderValue("A1");
            jTable_cruces.getColumnModel().getColumn(2).setHeaderValue("A2");
            jTable_cruces.getColumnModel().getColumn(3).setHeaderValue("A3");
            jTable_cruces.getColumnModel().getColumn(4).setHeaderValue("A4");
            jTable_cruces.getColumnModel().getColumn(5).setHeaderValue("A5");
            jTable_cruces.getColumnModel().getColumn(6).setHeaderValue("A6");
            jTable_cruces.getColumnModel().getColumn(7).setHeaderValue("A7");
            jTable_cruces.getColumnModel().getColumn(8).setHeaderValue("A8");
            jTable_cruces.getColumnModel().getColumn(9).setHeaderValue("A9");
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 786, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 840, 460));

        jPanel3.setBackground(new java.awt.Color(113, 128, 147));

        Breporte.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Breporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Set_As_Resume_30px.png"))); // NOI18N
        Breporte.setText("Reporte");
        Breporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BreporteActionPerformed(evt);
            }
        });

        Bexportar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Bexportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Microsoft_Excel_30px.png"))); // NOI18N
        Bexportar.setText("Exportar");
        Bexportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BexportarActionPerformed(evt);
            }
        });

        Bguardar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Bguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Save_30px.png"))); // NOI18N
        Bguardar.setText("Guardar");
        Bguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BguardarActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Go_Back_40px.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        Bnuevo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Bnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Available_Updates_30px_2.png"))); // NOI18N
        Bnuevo.setText("Nuevo");
        Bnuevo.setBorder(null);
        Bnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BnuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel9)
                .addGap(24, 24, 24)
                .addComponent(Bnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Bexportar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Breporte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Bguardar)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Bexportar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Breporte)
                            .addComponent(Bguardar)
                            .addComponent(Bnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1))))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BreporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BreporteActionPerformed
        int fila = jTable_cruces.getRowCount();
        int colum = jTable_cruces.getColumnCount();
        int i;
        int j;
        String valores = "";
        for (i = 0; i < fila; i++) {
            for (j = 1; j < colum; j++) {
                String valor = (String) jTable_cruces.getValueAt(i, j);
                // Con esta condición solo ponemos comas hasta el penúltimo valor :)
                if ((String) jTable_cruces.getValueAt(i, j) == null) {

                } else {
                    valores += valor;
                    valores += ",";
                }

            }
        }

        System.out.println("" + valores);
        JOptionPane.showMessageDialog(null, "valores de la columna1: " + valores);
// TODO add your handling code here:
//          jTable_cruces.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//            @Override
//            public void valueChanged(ListSelectionEvent e) {
//       int fila = jTable_cruces.getSelectedRow();
//      int columna = jTable_cruces.getSelectedColumn();
//                  
//                    
//                        //int fila = jTable_registro.getSelectedRow();
//                     String ff =jTable_cruces.getValueAt(fila, columna).toString();
//
//                       jTextField1.setText(ff);
//                        System.out.println(""+apli);
//        DefaultTableModel modelo = new DefaultTableModel();
//
//     for(int i=0;i<modelo.getRowCount();i++){
//                            for(int j=0;j<modelo.getColumnCount();j++){
//
//                        String a=modelo.getValueAt(i, j).toString();
//                                System.out.println(""+ a);
//     }}
//    
//    }
//            
//           });
    }//GEN-LAST:event_BreporteActionPerformed
    public void setColor(JButton jbutton) {

        jbutton.setBackground(new java.awt.Color(52, 73, 94));

    }

    public void resetColor(JButton jbutton) {

        jbutton.setBackground(new java.awt.Color(47, 54, 64));

    }
    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        this.setVisible(false);
        Modulos modu = new Modulos();
        modu.setVisible(true);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void BexportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BexportarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BexportarActionPerformed

    private void BnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BnuevoActionPerformed
        
    }//GEN-LAST:event_BnuevoActionPerformed

    private void BguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BguardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BguardarActionPerformed

    /**
     * @param args the command line arguments
     */
    public void ancho_columnas() {
        jTable_cruces.getColumnModel().getColumn(0).setPreferredWidth(650);

    }

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
            java.util.logging.Logger.getLogger(cruces_activos_amenazas_aux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cruces_activos_amenazas_aux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cruces_activos_amenazas_aux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cruces_activos_amenazas_aux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cruces_activos_amenazas_aux().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bexportar;
    private javax.swing.JButton Bguardar;
    public static javax.swing.JButton Bnuevo;
    private javax.swing.JButton Breporte;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_cruces;
    // End of variables declaration//GEN-END:variables
}
