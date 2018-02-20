/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import metodos.Conexionbd;

/**
 *
 * @author Leonardo
 */
public final class cruces_activos_amenazas extends javax.swing.JFrame {

    /**
     * Creates new form cruces_activos_amenazas
     */
    Conexionbd conxlogin = new Conexionbd();
    Connection cxn = conxlogin.getConnection();
    public String iden = "";
    public String nom_ame = "";
    public int id_Activo = 0;
    public int id_Amenaza = 0;

    public cruces_activos_amenazas() {
//        int ID_activo=id_Activo;
//        int ID_amenaza=id_Amenaza;

        initComponents();
        this.setLocationRelativeTo(null);
        llenartabla_amenaza();
        guardar_cruces();
//       llenar_amenaza(); 
    }

    public int columna = 0;
    public int fila = 0;

    void llenartabla_amenaza() {

        Object[] amenaza = {"Amenaza/Activo"};
        DefaultTableModel modelo = new DefaultTableModel(null, amenaza);
        String datos[] = new String[1];

        Object dat;
        int fila = jTable_cruces.getRowCount();
        int colum = jTable_cruces.getColumnCount();
        int i;
        int j;
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

            }
            while (rs.next()) {
                dat = rs.getString("identificador");
                String da=(String) dat;
                iden = da;
                modelo.addColumn(dat);
                
                
            }

            jTable_cruces.setModel(modelo);

            ancho_columnas();
        } catch (SQLException ex) {
            Logger.getLogger(RegistroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    void actualizar() {
////       llenartabla_amenaza();
//        DefaultTableModel modelo = new DefaultTableModel();
//        String datos[] = new String[100];
//          int colum= jTable_cruces.getColumnCount();
//          for (int i = 0; colum < 100; i++) {
//                datos[i] = "";
//                   
//        }
//        
//          
//
//                modelo.addColumn(datos);
//               jTable_cruces.setModel(modelo);        
//    }
//            
//        
//            int fila = jTable_cruces.getRowCount();
//        int colum = jTable_cruces.getColumnCount();
//        int i;
//        int j;
//Object ff=""; 
//        String valores = "";
//        for (i = 0; i < fila; i++) {
//            for (j = 1; j < colum; j++) {
//                TableModel dataModel = null;
//                jTable_cruces.setModel(dataModel);
//                                   jTextField_nombres.setText("");
//                jTable_cruces.remove(j);
//             String valor = (String) jTable_cruces.getValueAt(i, j).toString();
//                // Con esta condición solo ponemos comas hasta el penúltimo valor :)
//                if ((String) jTable_cruces.getValueAt(i, j) == null) {
//                    valores += valor;
//                    valores += ",";
//            }
//        }
//        System.out.println("" + valores);
//        JOptionPane.showMessageDialog(null, "valores de la columna1: " + valores);
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
        int e = 1;
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
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jButton_nuevo = new javax.swing.JButton();

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

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Set_As_Resume_30px.png"))); // NOI18N
        jButton1.setText("Reporte");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Microsoft_Excel_30px.png"))); // NOI18N
        jButton3.setText("Exportar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Save_30px.png"))); // NOI18N
        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Go_Back_40px.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        jButton_nuevo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButton_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Available_Updates_30px_2.png"))); // NOI18N
        jButton_nuevo.setText("Nuevo");
        jButton_nuevo.setBorder(null);
        jButton_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_nuevoActionPerformed(evt);
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
                .addComponent(jButton_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(377, 377, 377))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
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
void insertar_cruces() {
//     String sql ="insert into activo_amenaza( amenazas_idamenaza='"+ +"', activos_idactivos='"+ +"', aplicacion='"+ +"')values()";

    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int colum = jTable_cruces.getColumnCount();

        int fila = jTable_cruces.getRowCount();
        int i = 0;
        int j;
        String valores = "";
//        String datos[] = new String[100];

        for (j = 1; j < colum; j++) {
            for (i = 0; i < fila; i++) {

                String valor = (String) jTable_cruces.getValueAt(i, j);
                // Con esta condición solo ponemos comas hasta el penúltimo valor :)

                if ((String) jTable_cruces.getValueAt(i, j) == null) {

                } else {

                    valores += valor;
//                    Object col = jTable_cruces.getColumnModel().getColumn(0);
                   
                  
//                    String sql="insert into activo_amenaza(aplicacion='"+valores+"')values()";
           
                    
                }

            }
                
        }
     
        
//                System.out.println(Arrays.toString(datos));
        JOptionPane.showMessageDialog(null, "valores de la columna1: " + valores);

    }//GEN-LAST:event_jButton1ActionPerformed
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        obtener_id_activo(); 
    }//GEN-LAST:event_jButton2ActionPerformed
     void obtener_id_activo() {
              JTableHeader colum = jTable_cruces.getTableHeader();
             int co =colum.getColumnModel().getColumnCount();
//       int fila = jTable_cruces.getRowCount();
        int i;
        int j;
            for (i = 0; i < co; i++) {
              String valo = (String) jTable_cruces.getValueAt(0, i);
                    System.out.println(""+valo);
        }
    }
    void obtener_id_amenaza() {
//              int colum = jTable_cruces.getColumnCount();

       int fila = jTable_cruces.getRowCount();
        int i = 0;
        int j;
            for (i = 0; i < fila; i++) {
              String valo = (String) jTable_cruces.getValueAt(i, 0);
                    System.out.println(""+valo);
        }
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
                      obtener_id_amenaza();
//
//        System.out.println(iden + "" + nom_ame);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_nuevoActionPerformed
        System.out.println(""+iden);
    }//GEN-LAST:event_jButton_nuevoActionPerformed

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
            java.util.logging.Logger.getLogger(cruces_activos_amenazas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cruces_activos_amenazas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cruces_activos_amenazas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cruces_activos_amenazas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cruces_activos_amenazas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    public static javax.swing.JButton jButton_nuevo;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_cruces;
    // End of variables declaration//GEN-END:variables

    private void removeAll(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
