/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicaion_auxiliar;

import aplicacion.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import metodos.Conexionbd;

/**
 *
 * @author Leonardo
 */
public class Ingresos_aux extends javax.swing.JFrame {

    DefaultTableModel modelo;
    public static String insert_dato = "";

    public Ingresos_aux() {
        Login lg = new Login();
        insert_dato = lg.insert_activo_id_user;
        initComponents();
        llenartabla();
        //  id.setVisible(true);
      
        // id.setText(dd);
        this.setLocationRelativeTo(null);
        jTable_activo.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                try {

                    int fila = jTable_activo.getSelectedRow();

                    if (jTable_activo.getSelectedRow() != -1) {
                        //int fila = jTable_registro.getSelectedRow();
                        area.setText(jTable_activo.getValueAt(fila, 0).toString());
                        identificador.setText(jTable_activo.getValueAt(fila, 1).toString());
                        cantidad.setText(jTable_activo.getValueAt(fila, 2).toString());
                        nombre_activo.setText(jTable_activo.getValueAt(fila, 3).toString());
                        tipo_activo.setSelectedItem(jTable_activo.getValueAt(fila, 4).toString());
                        buscar_activo.setSelectedItem(jTable_activo.getValueAt(fila, 5).toString());

                    }

                } catch (Exception ex) {
                    Logger.getLogger(RegistroUsuario.class.getName()).log(Level.SEVERE, null, ex);

                }

            }

            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            //}
        });
    }

    /*void Generarnumeracion() {
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

    }*/
    void llenartabla() {
        String[] titulos = {"Area", "Identificador", "Cantidad", "Activo", "Tipo Activo", "Aplicacion"};

        modelo = new DefaultTableModel(null, titulos);
        String datos[] = new String[6];
        String sql = "SELECT area, identificador, Cantidad, nombre_activo, tipo_activo, aplicacion FROM activo";
        try {
            Statement st = cxn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("area");
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
            Logger.getLogger(RegistroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void Deshabilitar() {
        //  id.setEditable(false);
        area.setEditable(false);
        identificador.setEditable(false);
        cantidad.setEditable(false);
        nombre_activo.setEditable(false);
        Textactivo_buscar.setEditable(false);
        tipo_activo.setEnabled(false);
        aplicacion.setEnabled(false);
        buscar_activo.setEnabled(false);
    }

    void Limpiar() {
        area.setText("");
        identificador.setText("");
        cantidad.setText("");
        nombre_activo.setText("");
        aplicacion.setSelectedItem(0);
        Textactivo_buscar.setText("");
        tipo_activo.setSelectedIndex(0);
        buscar_activo.setSelectedIndex(0);

    }

    void Habilitar() {
        area.setEditable(true);
        identificador.setEditable(true);
        cantidad.setEditable(true);
        nombre_activo.setEditable(true);
        Textactivo_buscar.setEditable(true);
        tipo_activo.setEnabled(true);
        aplicacion.setEnabled(true);
        buscar_activo.setEnabled(true);

    }

    /**
     *
     */
    private void filtro() {
        int columnaABuscar = 0;
        if (buscar_activo.getSelectedItem() == "Area") {
            columnaABuscar = 0;
        }
        if (buscar_activo.getSelectedItem().toString() == "Identificador") {
            columnaABuscar = 1;
        }
        if (buscar_activo.getSelectedItem().toString() == "Cantidad") {
            columnaABuscar = 2;
        }
        if (buscar_activo.getSelectedItem().toString() == "Activo") {
            columnaABuscar = 3;
        }
        if (buscar_activo.getSelectedItem().toString() == "Tipo Activo") {
            columnaABuscar = 4;
        }
        if (buscar_activo.getSelectedItem().toString() == "Aplicacion") {
            columnaABuscar = 5;
        }
        trsFiltro.setRowFilter(RowFilter.regexFilter(Textactivo_buscar.getText(), columnaABuscar));
        // return columnaABuscar;
        llenartabla();
    }

    /*public int BuscarActivo() {

        String[] activos = {"Id", "Identificador", "Cantidad", "Activo", "Tipo Activo", "Aplicacion"};
        modelo = new DefaultTableModel(null, activos);
        String datos[] = new String[7];
        int seleccion = filtro();
        String cadena = (Textactivo_buscar.getText());
        String activoCruce = "";
        int activoCruceInt = -1;
        if (seleccion == 0) {
            //String cadena = (txtFiltro.getText());
            //txtFiltro.setText(cadena);
            String sql = "SELECT idactivo, identificador, Cantidad, nombre_activo, tipo_activo, aplicacion FROM "
                    + "activo where idactivo= '" + cadena + "' ";

            try {
                Statement st = cxn.createStatement();
                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {
                    activoCruce = rs.getString("idactivo");
                    if (activoCruce == null || activoCruce.equals("")) {
                        activoCruceInt = 0;
                        System.out.println("No existe activo");
                    } else {
                        activoCruceInt = Integer.parseInt(activoCruce);
                        System.out.println("SI existe activo");
                    }
                    datos[0] = rs.getString("idactivo");
                    datos[1] = rs.getString("identificador");
                    datos[2] = rs.getString("Cantidad");
                    datos[3] = rs.getString("nombre_activo");
                    datos[4] = rs.getString("tipo_activo");
                    datos[5] = rs.getString("aplicacion");
                    modelo.addRow(datos);
                }
                jTable_activo.setModel(modelo);
            } catch (SQLException ex) {
                Logger.getLogger(RegistroUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (seleccion == 1) {
                //String cadena = (txtFiltro.getText());
                //txtFiltro.setText(cadena);
                String sql = "SELECT idactivo,identificador,Cantidad,nombre_activo, tipo_activo, aplicacion FROM activo where identificador= '" + cadena + "' ";

                try {
                    Statement st = cxn.createStatement();
                    ResultSet rs = st.executeQuery(sql);
                    while (rs.next()) {
                        activoCruce = rs.getString("idactivo");
                        if (activoCruce == null || activoCruce.equals("")) {
                            activoCruceInt = 0;
                            System.out.println("No existe activo");
                        } else {
                            activoCruceInt = Integer.parseInt(activoCruce);
                            System.out.println("SI existe activo");
                        }
                        activoCruce = rs.getString("idactivo");
                        datos[0] = rs.getString("idactivo");
                        datos[1] = rs.getString("identificador");
                        datos[2] = rs.getString("Cantidad");
                        datos[3] = rs.getString("nombre_activo");
                        datos[4] = rs.getString("tipo_activo");
                        datos[5] = rs.getString("aplicacion");
                        modelo.addRow(datos);
                    }
                    jTable_activo.setModel(modelo);
                } catch (SQLException ex) {
                    Logger.getLogger(RegistroUser.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                if (seleccion == 2) {
                    // String cadena = (txtFiltro.getText());
                    //txtFiltro.setText(cadena);
                    String sql = "SELECT idactivo, identificador, Cantidad, nombre_activo, tipo_activo, aplicacion "
                            + "FROM activo where nombre_activo= '" + cadena + "' ";

                    try {
                        Statement st = cxn.createStatement();
                        ResultSet rs = st.executeQuery(sql);
                        while (rs.next()) {
                            activoCruce = rs.getString("idactivo");
                            if (activoCruce == null || activoCruce.equals("")) {
                                activoCruceInt = 0;
                                System.out.println("No existe activo");
                            } else {
                                activoCruceInt = Integer.parseInt(activoCruce);
                                System.out.println("SI existe activo");
                            }
                            activoCruce = rs.getString("idactivo");
                            datos[0] = rs.getString("idactivo");
                            datos[1] = rs.getString("identificador");
                            datos[2] = rs.getString("Cantidad");
                            datos[3] = rs.getString("nombre_activo");
                            datos[4] = rs.getString("tipo_activo");
                            datos[5] = rs.getString("aplicacion");
                            modelo.addRow(datos);
                        }
                        jTable_activo.setModel(modelo);
                    } catch (SQLException ex) {
                        Logger.getLogger(RegistroUser.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    if (seleccion == 3) {
                        // String cadena = (txtFiltro.getText());
                        String sql = "SELECT idactivo,identificador,Cantidad,nombre_activo, tipo_activo, aplicacion "
                                + "FROM activo where tipo_activo= '" + cadena + "' ";

                        try {
                            Statement st = cxn.createStatement();
                            ResultSet rs = st.executeQuery(sql);
                            while (rs.next()) {
                                activoCruce = rs.getString("idactivo");
                                if (activoCruce == null || activoCruce.equals("")) {
                                    activoCruceInt = 0;
                                    System.out.println("No existe activo");
                                } else {
                                    activoCruceInt = Integer.parseInt(activoCruce);
                                    System.out.println("SI existe activo");
                                }
                                activoCruce = rs.getString("idactivo");
                                datos[0] = rs.getString("idactivo");
                                datos[1] = rs.getString("identificador");
                                datos[2] = rs.getString("Cantidad");
                                datos[3] = rs.getString("nombre_activo");
                                datos[4] = rs.getString("tipo_activo");
                                datos[5] = rs.getString("aplicacion");
                                modelo.addRow(datos);
                            }
                            jTable_activo.setModel(modelo);
                        } catch (SQLException ex) {
                            Logger.getLogger(RegistroUser.class.getName()).log(Level.SEVERE, null, ex);

                        }
                    }
                }
            }
        }
        //activoCruceInt= Integer.parseInt(activoCruce);
        //activoCruceInt= Integer.parseInt(activoCruce);
        if (activoCruceInt == -1) {
            System.out.println("No existe activo con el parametro seleccionado");
            JOptionPane.showMessageDialog(null, "¡No existe activo con el parametro seleccionado!");
        }
        System.out.println(activoCruceInt);
        return activoCruceInt;
    }*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        area = new javax.swing.JTextField();
        identificador = new javax.swing.JTextField();
        cantidad = new javax.swing.JTextField();
        nombre_activo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tipo_activo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        aplicacion = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_activo = new javax.swing.JTable();
        jButton_guardar = new javax.swing.JButton();
        jButton_nuevo = new javax.swing.JButton();
        jButton_modificar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        buscar_activo = new javax.swing.JComboBox<>();
        Textactivo_buscar = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        Bactivo = new javax.swing.JButton();
        Bamenaza = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(233, 235, 238));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Go_Back_40px.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 3), "Registro Activo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N

        area.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areaActionPerformed(evt);
            }
        });

        identificador.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        identificador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                identificadorActionPerformed(evt);
            }
        });

        cantidad.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadActionPerformed(evt);
            }
        });

        nombre_activo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        nombre_activo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre_activoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel8.setText("Area:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel7.setText("Identificador:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setText("Cantidad:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setText("Nombre Activo:");

        tipo_activo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tipo_activo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DI", "SW", "HW", "COM", "Media", "AUX", "INST", "PSL" }));
        tipo_activo.setToolTipText("");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel6.setText("Tipo Activo:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setText("Aplicacion:");

        aplicacion.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        aplicacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tipo_activo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(aplicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(18, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(area, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(identificador, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombre_activo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(identificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre_activo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2)
                    .addComponent(aplicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipo_activo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 310, 240));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 3), "Tabla de Activos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_activo.setBackground(new java.awt.Color(204, 204, 204));
        jTable_activo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
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
                "Area", "Indentificador", "Cantidad", "Activo", "Tipo Activo", "Aplicacion"
            }
        ));
        jScrollPane1.setViewportView(jTable_activo);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 663, 140));

        jButton_guardar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButton_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Save_30px.png"))); // NOI18N
        jButton_guardar.setText("Guardar");
        jButton_guardar.setBorder(null);
        jButton_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_guardarActionPerformed(evt);
            }
        });
        jPanel4.add(jButton_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, 100, 40));

        jButton_nuevo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButton_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Available_Updates_30px_2.png"))); // NOI18N
        jButton_nuevo.setText("Nuevo");
        jButton_nuevo.setBorder(null);
        jButton_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_nuevoActionPerformed(evt);
            }
        });
        jPanel4.add(jButton_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 100, 40));

        jButton_modificar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButton_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Edit_Property_30px.png"))); // NOI18N
        jButton_modificar.setText("Modificar");
        jButton_modificar.setBorder(null);
        jButton_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_modificarActionPerformed(evt);
            }
        });
        jPanel4.add(jButton_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, 100, 40));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 760, 230));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 3), "Buscar Activos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel1.setText("Buscar por:");

        buscar_activo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        buscar_activo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id", "Identificador", "Aplicacion" }));

        Textactivo_buscar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Textactivo_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Textactivo_buscarActionPerformed(evt);
            }
        });
        Textactivo_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Textactivo_buscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Textactivo_buscarKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscar_activo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Textactivo_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(buscar_activo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Textactivo_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 310, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 900, 520));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Bactivo.setBackground(new java.awt.Color(47, 54, 64));
        Bactivo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Bactivo.setForeground(new java.awt.Color(255, 255, 255));
        Bactivo.setText("Activo");
        Bactivo.setBorder(null);
        Bactivo.setContentAreaFilled(false);
        Bactivo.setOpaque(true);
        Bactivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BactivoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BactivoMouseExited(evt);
            }
        });
        Bactivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BactivoActionPerformed(evt);
            }
        });
        jPanel2.add(Bactivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 50));

        Bamenaza.setBackground(new java.awt.Color(47, 54, 64));
        Bamenaza.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Bamenaza.setForeground(new java.awt.Color(255, 255, 255));
        Bamenaza.setText("Amenaza");
        Bamenaza.setBorder(null);
        Bamenaza.setContentAreaFilled(false);
        Bamenaza.setOpaque(true);
        Bamenaza.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BamenazaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BamenazaMouseExited(evt);
            }
        });
        Bamenaza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BamenazaActionPerformed(evt);
            }
        });
        jPanel2.add(Bamenaza, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 440, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombre_activoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre_activoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombre_activoActionPerformed

    private void cantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidadActionPerformed

    int id_activo() {
//       if (jTable_activo.getSelectedRow() != -1) {
        //int fila = jTable_registro.getSelectedRow();
        int id_act = 0;
        try {
            int fila = jTable_activo.getSelectedRow();
            String dato = (jTable_activo.getValueAt(fila, 1).toString());

            String sql1 = "select idactivo  from activo where identificador='" + dato + "'";

            Statement st = cxn.createStatement();
            ResultSet rs = st.executeQuery(sql1);
            while (rs.next()) {
                id_act = rs.getInt("idactivo");

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return id_act;
    }
    private void jButton_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_modificarActionPerformed

        //int id = Integer.parseInt(jTextField_id.getText().toString());
//        int fila = jTable_activo.getSelectedRow();
//        String id_act = jTable_activo.getValueAt(fila, 0).toString();
//        int id_activo = Integer.parseInt(id_act);
        String are = area.getText();
        String iden = identificador.getText();
        int cant = Integer.parseInt(cantidad.getText());
        String nombre_ac = nombre_activo.getText();
        String tipo_ac = tipo_activo.getModel().getSelectedItem().toString();
        String apli = aplicacion.getModel().getSelectedItem().toString();

        try {

            String sql = "Update activo set area='" + are + "', identificador='" + iden + "', Cantidad='" + cant + "', "
                    + "nombre_activo='" + nombre_ac + "', tipo_activo='" + tipo_ac + "', aplicacion='" + apli + "'where  idactivo='" + id_activo() + "'";

            PreparedStatement ps = cxn.prepareCall(sql);
            int n = ps.executeUpdate(sql);
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "datos modificados");
                llenartabla();
                Limpiar();

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error" + e.getMessage());
        }


    }//GEN-LAST:event_jButton_modificarActionPerformed
//
//    public int obtener_id(String user) {
//        int numero = 0;
//        String sql = "select idusuario from usuario where usuario='" + user + "'";
//        try {
//            Statement st = cxn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//
//            while (rs.next()) {
//                numero = rs.getInt("idusuario");
//            }
//
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//
//        return numero;
//
//    }
    private void jButton_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_guardarActionPerformed
       
        String sql = "";

        sql = "INSERT INTO activo(area, identificador, Cantidad, nombre_activo, tipo_activo, aplicacion, usuario_idusuario)"
                + " VALUES (?,?,?,?,?,?,?)";
//        System.out.println("este es el dato" + id_user_ac);

        String idd = insert_dato;
        int id = Integer.parseInt(idd);
        int cant = Integer.parseInt(cantidad.getText().toString());
        //  int in_us_ac =  Integer.parseInt(Login.Textid.getText());
        // int idd = Integer.parseInt(id.getText().toString());
        //     int cedula = Integer.parseInt(jTextField_cedula.getText().toString());
        try {
            PreparedStatement dato = cxn.prepareStatement(sql);
          
            dato.setString(1, area.getText().toString());
            dato.setString(2, identificador.getText().toString());
            dato.setInt(3, cant);
            dato.setString(4, nombre_activo.getText().toString());
            dato.setString(5, tipo_activo.getModel().getSelectedItem().toString());
            dato.setString(6, aplicacion.getModel().getSelectedItem().toString());
            dato.setInt(7, id);
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
        Limpiar();
        llenartabla();

    }//GEN-LAST:event_jButton_nuevoActionPerformed

    private void identificadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_identificadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_identificadorActionPerformed

    private void Textactivo_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Textactivo_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Textactivo_buscarActionPerformed

    private void Textactivo_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Textactivo_buscarKeyReleased
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
    }//GEN-LAST:event_Textactivo_buscarKeyReleased
    private TableRowSorter trsFiltro;
    private void Textactivo_buscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Textactivo_buscarKeyTyped

        Textactivo_buscar.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (Textactivo_buscar.getText());
                Textactivo_buscar.setText(cadena);
                repaint();
                filtro();

                llenartabla();
            }
        });

        trsFiltro = new TableRowSorter(jTable_activo.getModel());
        jTable_activo.setRowSorter(trsFiltro);


    }//GEN-LAST:event_Textactivo_buscarKeyTyped

    private void areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_areaActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        this.setVisible(false);
        Modulos_aux modu=new Modulos_aux();
        modu.setVisible(true);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void BactivoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BactivoMouseEntered
        setColor(Bactivo);
    }//GEN-LAST:event_BactivoMouseEntered

    private void BactivoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BactivoMouseExited
        resetColor(Bactivo);
    }//GEN-LAST:event_BactivoMouseExited

    private void BactivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BactivoActionPerformed
//        Administrador admin = new Administrador();
//        jPanel_principal.add(inf);
//        inf.show();
//        admin.setVisible(true);
//        this.setVisible(false);
    }//GEN-LAST:event_BactivoActionPerformed

    private void BamenazaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BamenazaMouseEntered
        setColor(Bamenaza);
    }//GEN-LAST:event_BamenazaMouseEntered

    private void BamenazaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BamenazaMouseExited
        resetColor(Bamenaza);
    }//GEN-LAST:event_BamenazaMouseExited

    private void BamenazaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BamenazaActionPerformed
        
        try {
            Amenazas_aux amenaza = new Amenazas_aux();
            amenaza.setVisible(true);
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(Ingresos_aux.class.getName()).log(Level.SEVERE, null, ex);
        }
       
                 

    }//GEN-LAST:event_BamenazaActionPerformed
    public void setColor(JButton jpanel) {

        jpanel.setBackground(new java.awt.Color(52, 73, 94));

    }
    
    

    public void resetColor(JButton jpanel) {

        jpanel.setBackground(new java.awt.Color(47,54,64));

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
            java.util.logging.Logger.getLogger(Ingresos_aux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ingresos_aux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ingresos_aux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ingresos_aux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Ingresos_aux().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bactivo;
    private javax.swing.JButton Bamenaza;
    private javax.swing.JTextField Textactivo_buscar;
    public static javax.swing.JComboBox<String> aplicacion;
    public static javax.swing.JTextField area;
    public static javax.swing.JComboBox<String> buscar_activo;
    public static javax.swing.JTextField cantidad;
    public static javax.swing.JTextField identificador;
    private javax.swing.JButton jButton_guardar;
    private javax.swing.JButton jButton_modificar;
    private javax.swing.JButton jButton_nuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_activo;
    public static javax.swing.JTextField nombre_activo;
    public static javax.swing.JComboBox<String> tipo_activo;
    // End of variables declaration//GEN-END:variables
    Conexionbd conxlogin = new Conexionbd();
    Connection cxn = conxlogin.getConnection();
    String idfila = "";
    Login lg = new Login();

}
