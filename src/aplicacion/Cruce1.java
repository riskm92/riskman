/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import metodos.Conexionbd;

/**
 *
 * @author Leonardo
 */
public class Cruce1 extends javax.swing.JFrame {

    DefaultTableModel modelo;
    private TableRowSorter trsFiltro;
    JTable tabla;

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
    void llenartabla() {
        String[] amenazas = {"Id", "Amenaza", "Aplicación"};
        modelo = new DefaultTableModel(null, amenazas);
        String datos[] = new String[5];
        String sql = "SELECT idamenaza,nombre_amenaza FROM amenaza";
        String apli = "SI";
        try {
            Statement st = cxn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("idamenaza");
                datos[1] = rs.getString("nombre_amenaza");
                //datos[2]= 
                modelo.addRow(datos);
            }
            String[] positions = {"Seleccionar", "SI", "NO"};
            JComboBox combo = new JComboBox<String>(positions);
            combo.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    //JOptionPane.showMessageDialog(null, combo.getSelectedItem());
                }
            });
            jTableAmenazas.setModel(modelo);
            TableColumn col = jTableAmenazas.getColumnModel().getColumn(2);
            col.setCellEditor(new DefaultCellEditor(combo));

        } catch (SQLException ex) {
            Logger.getLogger(RegistroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int filtro() {
        int columnaABuscar = 0;
        if (comboFiltro.getSelectedItem() == "Id") {
            columnaABuscar = 0;
        }
        if (comboFiltro.getSelectedItem().toString() == "Localizacion") {
            columnaABuscar = 1;
        }
        if (comboFiltro.getSelectedItem().toString() == "Nombre Activo") {
            columnaABuscar = 2;
        }
        if (comboFiltro.getSelectedItem().toString() == "Tipo Activo") {
            columnaABuscar = 3;
        }
        return columnaABuscar;
    }

        public int BuscarActivo(){
   
            String [] activos= {"Id","Localizacion","Nombre Activo", "Tipo Activo"};
            modelo=new  DefaultTableModel(null,activos);
            String datos []= new String[5];
            int seleccion=filtro();
            String cadena = (txtFiltro.getText());
            String activoCruce="";
            int activoCruceInt=-1;
            if (seleccion==0){
                //String cadena = (txtFiltro.getText());
                //txtFiltro.setText(cadena);
                String sql="SELECT idactivo,identificador,Cantidad,nombre_activo, tipo_activo FROM activo where idactivo= '"+cadena+"' ";       
                
                     try {
                     Statement st = cxn.createStatement();
                     ResultSet rs = st.executeQuery(sql);

                     while(rs.next())
                     { 
                         activoCruce=rs.getString("idactivo");
                         if (activoCruce == null || activoCruce.equals("")){
                             activoCruceInt=0;
                             System.out.println("No existe activo");
                         }else{
                             activoCruceInt= Integer.parseInt(activoCruce);
                             System.out.println("SI existe activo");
                         }
                         datos[0]=rs.getString("idactivo");
                         datos[1]=rs.getString("identificador");
                         datos[2]= rs.getString("nombre_activo");
                         datos[3]= rs.getString("tipo_activo");
                         modelo.addRow(datos);
                     }
                     jTableActivo.setModel(modelo);
                 } catch (SQLException ex) {
                     Logger.getLogger(RegistroUsuario.class.getName()).log(Level.SEVERE, null, ex);
                 }
           }else{ 
                    if (seleccion==1){
                        //String cadena = (txtFiltro.getText());
                        //txtFiltro.setText(cadena);
                        String sql="SELECT idactivo,identificador,Cantidad,nombre_activo, tipo_activo FROM activo where identificador= '"+cadena+"' ";       
                       
                        try {
                             Statement st = cxn.createStatement();
                             ResultSet rs = st.executeQuery(sql);
                             while(rs.next())
                             { 
                                activoCruce=rs.getString("idactivo");
                                if (activoCruce == null || activoCruce.equals("")){
                                        activoCruceInt=0;
                                    System.out.println("No existe activo");
                                }else{
                                     activoCruceInt= Integer.parseInt(activoCruce);
                                     System.out.println("SI existe activo");
                                }
                                 activoCruce=rs.getString("idactivo");
                                 datos[0]=rs.getString("idactivo");
                                 datos[1]=rs.getString("identificador");
                                 datos[2]= rs.getString("nombre_activo");
                                 datos[3]= rs.getString("tipo_activo");
                                 modelo.addRow(datos);
                             }
                             jTableActivo.setModel(modelo);
                         } catch (SQLException ex) {
                             Logger.getLogger(RegistroUsuario.class.getName()).log(Level.SEVERE, null, ex);
                         }     
                    }
                    else{
                        if (seleccion==2){
                       // String cadena = (txtFiltro.getText());
                        //txtFiltro.setText(cadena);
                        String sql="SELECT idactivo,identificador,Cantidad,nombre_activo, tipo_activo FROM activo where nombre_activo= '"+cadena+"' ";       
                        
                        try {
                             Statement st = cxn.createStatement();
                             ResultSet rs = st.executeQuery(sql);
                             while(rs.next())
                             { 
                                activoCruce=rs.getString("idactivo");
                                if (activoCruce == null || activoCruce.equals("")){
                                    activoCruceInt=0;
                                    System.out.println("No existe activo");
                                }else{
                                     activoCruceInt= Integer.parseInt(activoCruce);
                                     System.out.println("SI existe activo");
                                }
                                 activoCruce=rs.getString("idactivo");
                                 datos[0]=rs.getString("idactivo");
                                 datos[1]=rs.getString("identificador");
                                 datos[2]= rs.getString("nombre_activo");
                                 datos[3]= rs.getString("tipo_activo");
                                 modelo.addRow(datos);
                             }
                             jTableActivo.setModel(modelo);
                            } catch (SQLException ex) {
                                Logger.getLogger(RegistroUsuario.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }else{
                            if (seleccion==3){
                               // String cadena = (txtFiltro.getText());
                                String sql="SELECT idactivo,identificador,Cantidad,nombre_activo, tipo_activo FROM activo where tipo_activo= '"+cadena+"' ";       
                                
                                try {
                                    Statement st = cxn.createStatement();
                                    ResultSet rs = st.executeQuery(sql);
                                    while(rs.next())
                                    { 
                                        activoCruce=rs.getString("idactivo");
                                        if (activoCruce == null || activoCruce.equals("")){
                                           activoCruceInt=0;
                                           System.out.println("No existe activo");
                                        }else{
                                             activoCruceInt= Integer.parseInt(activoCruce);
                                             System.out.println("SI existe activo");
                                        }
                                        datos[0]=rs.getString("idactivo");
                                        datos[1]=rs.getString("identificador");
                                        datos[2]= rs.getString("nombre_activo");
                                        datos[3]= rs.getString("tipo_activo");
                                        modelo.addRow(datos);
                                    }
                                    jTableActivo.setModel(modelo);
                                   } catch (SQLException ex) {
                                       Logger.getLogger(RegistroUsuario.class.getName()).log(Level.SEVERE, null, ex);
                                      
                                    }
                            }
                        }   
                     } 
                 }
            //activoCruceInt= Integer.parseInt(activoCruce);
            //activoCruceInt= Integer.parseInt(activoCruce);
            if(activoCruceInt==-1){
                System.out.println("No existe activo con el parametro seleccionado");  
                JOptionPane.showMessageDialog(null, "¡No existe activo con el parametro seleccionado!");
            }
            System.out.println(activoCruceInt); 
            return activoCruceInt;
        }

    Conexionbd conxlogin = new Conexionbd();
    Connection cxn = conxlogin.getConnection();
    String idfila = "";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAmenazas = new javax.swing.JTable();
        jButton_guardar = new javax.swing.JButton();
        jButton_eliminar = new javax.swing.JButton();
        jButton_nuevo = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        comboFiltro = new javax.swing.JComboBox();
        txtFiltro = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableActivo = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel_activos = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel_amenazas = new javax.swing.JPanel();

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

        jButton_guardar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton_guardar.setText("Guardar");
        jButton_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_guardarActionPerformed(evt);
            }
        });

        jButton_eliminar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton_eliminar.setText("Buscar");
        jButton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarActionPerformed(evt);
            }
        });

        jButton_nuevo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton_nuevo.setText("Mostrar Amenazas");
        jButton_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_nuevoActionPerformed(evt);
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

        jLabel5.setText("Buscar Activo por:");

        comboFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Id", "Localizacion", "Nombre Activo", "Tipo Activo" }));
        comboFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboFiltroActionPerformed(evt);
            }
        });

        txtFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFiltroActionPerformed(evt);
            }
        });
        txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFiltroKeyTyped(evt);
            }
        });

        jTableActivo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Id", "Localizacion", "Nombre Activo", "Tipo Activo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableActivo);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(483, 483, 483)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jButton_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jButton_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(295, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 980, 530));

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
        jLabel21.setText("Cruce Activo - Amenazas");

        javax.swing.GroupLayout jPanel_activosLayout = new javax.swing.GroupLayout(jPanel_activos);
        jPanel_activos.setLayout(jPanel_activosLayout);
        jPanel_activosLayout.setHorizontalGroup(
            jPanel_activosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_activosLayout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(jLabel21)
                .addContainerGap(92, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanel_amenazasLayout = new javax.swing.GroupLayout(jPanel_amenazas);
        jPanel_amenazas.setLayout(jPanel_amenazasLayout);
        jPanel_amenazasLayout.setHorizontalGroup(
            jPanel_amenazasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        jPanel_amenazasLayout.setVerticalGroup(
            jPanel_amenazasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel_amenazas, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 500, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed
        BuscarActivo();


    }//GEN-LAST:event_jButton_eliminarActionPerformed

    private void jButton_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_guardarActionPerformed

    }//GEN-LAST:event_jButton_guardarActionPerformed

    private void jButton_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_nuevoActionPerformed

        llenartabla();
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton_nuevoActionPerformed

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Modulos visi = new Modulos();
        visi.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltroActionPerformed

    private void txtFiltroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyTyped
        // TODO add your handling code here:
        

    }//GEN-LAST:event_txtFiltroKeyTyped

    public void obtener(String dato) {

    }
    private void comboFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFiltroActionPerformed
        // TODO add your handling code here:
//        String [] activos= {"Id","Localizacion","Nombre Activo", "Tipo Activo"};
     /*   modelo=new  DefaultTableModel();
         String datos []= new String[4];
         String dato = "";
         if(comboFiltro.getSelectedItem().toString().equals("Localizacion")){
         dato = txtFiltro.getText().toString();
         String sql="SELECT idactivo,identificador,Cantidad,nombre_activo, tipo_activo FROM activo  "; 
         //where Localizacion ='"+comboFiltro.getSelectedItem().toString()+"'   
         try {
         Statement st = cxn.createStatement();
         ResultSet rs = st.executeQuery(sql);
         while(rs.next())
         { 
         datos[0]=rs.getString("idactivo");
         datos[1]=rs.getString("identificador");
         datos[2]= rs.getString("nombre_activo");
         datos[3]= rs.getString("tipo_activo");

         modelo.addRow(datos);
         }
         jTableActivo.setModel(modelo);
         } catch (SQLException ex) {
         System.out.println("error " + ex);
         Logger.getLogger(RegistroUsuario.class.getName()).log(Level.SEVERE, null, ex);
         }
            
            
         }else{
         if(comboFiltro.getSelectedItem().toString().equals("Localizacion")){

         }else{
         if(comboFiltro.getSelectedItem().toString().equals("Nombre Activo")){

         }else{
         if(comboFiltro.getSelectedItem().toString().equals("Tipo Activo")){

         }
         }
         }
         }*/

    }//GEN-LAST:event_comboFiltroActionPerformed

    private void txtFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyReleased
        // TODO add your handling code here:
        /*String [] activos= {"Id","Localizacion","Nombre Activo", "Tipo Activo"};
         modelo=new  DefaultTableModel(null,activos);
         String datos []= new String[5];
         //int seleccion=filtro();
         //if (seleccion==1){
         String cadena = (txtFiltro.getText());
         //  System.out.println(cadena );
         // txtFiltro.setText(cadena);
         String sql="SELECT idactivo,identificador,Cantidad,nombre_activo, tipo_activo FROM activo where nombre_activo ='"+cadena+"' ";                 
         try {
         Statement st = cxn.createStatement();
         ResultSet rs = st.executeQuery(sql);
         while(rs.next())
         { 
         datos[0]=rs.getString("idactivo");
         datos[1]=rs.getString("identificador");
         datos[2]= rs.getString("nombre_activo");
         datos[3]= rs.getString("tipo_activo");

         modelo.addRow(datos);
         }
         jTableActivo.setModel(modelo);
         } catch (SQLException ex) {
         System.out.println("error " + ex);
         Logger.getLogger(RegistroUsuario.class.getName()).log(Level.SEVERE, null, ex);
         }*/

    }//GEN-LAST:event_txtFiltroKeyReleased
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
    private javax.swing.JComboBox comboFiltro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JButton jButton_guardar;
    private javax.swing.JButton jButton_nuevo;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel5;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JPanel jPanel_activos;
    public static javax.swing.JPanel jPanel_amenazas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableActivo;
    private javax.swing.JTable jTableAmenazas;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables

}
