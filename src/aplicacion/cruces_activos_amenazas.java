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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
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
public class cruces_activos_amenazas extends javax.swing.JFrame {

    /**
     * Creates new form cruces_activos_amenazas
     */
    Conexionbd conxlogin = new Conexionbd();
    Connection cxn = conxlogin.getConnection();

    public cruces_activos_amenazas() {
        initComponents();
   
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
        int i;
        for (i = 0; i < colum; i++) {

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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_cruces = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 786, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int fila = jTable_cruces.getRowCount();
        int colum = jTable_cruces.getColumnCount();
        int i;
        int j;
        String valores = "";
        for (i = 0; i < fila; i++) {
            for (j = 1; j < colum; j++) {
            String valor = (String) jTable_cruces.getValueAt(i, j);
            // Con esta condición solo ponemos comas hasta el penúltimo valor :)
        if((String) jTable_cruces.getValueAt(i, j)==null){
       
        }else{
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
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_cruces;
    // End of variables declaration//GEN-END:variables
}
