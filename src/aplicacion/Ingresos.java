/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Ingresos extends javax.swing.JFrame {

    DefaultTableModel modelo;
    public static String insert_dato = "";

    public Ingresos() {
        Login lg = new Login();
        insert_dato = lg.insert_activo_id_user;
        initComponents();
        llenartabla();
        //  id.setVisible(true);
        jButton_buscar.setVisible(false);
        // id.setText(dd);
        this.setLocationRelativeTo(null);
        jTable_activo.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                try {

                    int fila = jTable_activo.getSelectedRow();

                    if (jTable_activo.getSelectedRow() != -1) {
                        //int fila = jTable_registro.getSelectedRow();

                        identificador.setText(jTable_activo.getValueAt(fila, 1).toString());
                        cantidad.setText(jTable_activo.getValueAt(fila, 2).toString());
                        nombre_activo.setText(jTable_activo.getValueAt(fila, 3).toString());
                        tipo_activo.setSelectedItem(jTable_activo.getValueAt(fila, 4).toString());
                        buscar_activo.setSelectedItem(jTable_activo.getValueAt(fila, 5).toString());

                    }

                } catch (Exception ex) {
                    Logger.getLogger(RegistroUser.class.getName()).log(Level.SEVERE, null, ex);

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
        //  id.setEditable(false);
        identificador.setEditable(false);
        cantidad.setEditable(false);
        nombre_activo.setEditable(false);
        Textactivo_buscar.setEditable(false);
        tipo_activo.setEnabled(false);
        aplicacion.setEnabled(false);
        buscar_activo.setEnabled(false);
    }

    void Limpiar() {
        //jTextField_id.setText("");
        identificador.setText("");
        cantidad.setText("");
        nombre_activo.setText("");
        aplicacion.setSelectedItem(0);
        Textactivo_buscar.setText("");
        tipo_activo.setSelectedIndex(0);
        buscar_activo.setSelectedIndex(0);

    }

    void Habilitar() {
//        id.setEditable(true);
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
        if (buscar_activo.getSelectedItem() == "Id") {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_activo = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nombre_activo = new javax.swing.JTextField();
        cantidad = new javax.swing.JTextField();
        tipo_activo = new javax.swing.JComboBox<>();
        jButton_guardar = new javax.swing.JButton();
        jButton_modificar = new javax.swing.JButton();
        jButton_buscar = new javax.swing.JButton();
        jButton_nuevo = new javax.swing.JButton();
        jButton_eliminar1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        buscar_activo = new javax.swing.JComboBox<>();
        identificador = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        aplicacion = new javax.swing.JComboBox<>();
        Textactivo_buscar = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel_activos = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel_amenazas = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jLabel1.setText("Buscar por:");

        jLabel4.setText("Nombre Activo:");

        jLabel5.setText("Cantidad:");

        nombre_activo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        nombre_activo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre_activoActionPerformed(evt);
            }
        });

        cantidad.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadActionPerformed(evt);
            }
        });

        tipo_activo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DI", "SW", "HW", "COM", "Media", "AUX", "INST", "PSL" }));
        tipo_activo.setToolTipText("");

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

        jButton_buscar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton_buscar.setText("Buscar");
        jButton_buscar.setBorder(null);
        jButton_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_buscarActionPerformed(evt);
            }
        });

        jButton_nuevo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton_nuevo.setText("Nuevo");
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

        jLabel6.setText("Tipo Activo:");

        buscar_activo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id", "Identificador", "Aplicacion" }));

        identificador.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        identificador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                identificadorActionPerformed(evt);
            }
        });

        jLabel7.setText("Identificador:");

        jLabel2.setText("Aplicacion:");

        aplicacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO" }));

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jButton_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jButton_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jButton_eliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(240, 240, 240))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel6)
                        .addGap(33, 33, 33)
                        .addComponent(tipo_activo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel2)
                        .addGap(39, 39, 39)
                        .addComponent(aplicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jLabel1)
                        .addGap(5, 5, 5)
                        .addComponent(buscar_activo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(Textactivo_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(16, 16, 16)
                                .addComponent(nombre_activo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(25, 25, 25)
                                .addComponent(identificador, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(43, 43, 43)
                                .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(identificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(nombre_activo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(tipo_activo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aplicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(buscar_activo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(Textactivo_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_eliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74))
        );

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

    private void jButton_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_modificarActionPerformed

        //int id = Integer.parseInt(jTextField_id.getText().toString());
        int fila = jTable_activo.getSelectedRow();
        String id_act = jTable_activo.getValueAt(fila, 0).toString();
        int id_activo = Integer.parseInt(id_act);
        String iden = identificador.getText();
        int cant = Integer.parseInt(cantidad.getText());
        String nombre_ac = nombre_activo.getText();
        String tipo_ac = tipo_activo.getModel().getSelectedItem().toString();
        String apli = aplicacion.getModel().getSelectedItem().toString();

        try {
            String sql = "Update activo set identificador='" + iden + "', Cantidad='" + cant + "', "
                    + "nombre_activo='" + nombre_ac + "', tipo_activo='" + tipo_ac + "', aplicacion='" + apli + "' "
                    + "where  idactivo='" + id_activo + "'";

            PreparedStatement ps = cxn.prepareCall(sql);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "datos modificados");
            Limpiar();
            llenartabla();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error" + e.getMessage());
        }


    }//GEN-LAST:event_jButton_modificarActionPerformed

    private void jButton_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_buscarActionPerformed
        //  BuscarActivo();

        //Login lo = new Login();
        // String ll =lo.Textid.getText();
        //id.setText(lo.Textid.getText().toString());
        //int id_ua =Integer.parseInt(lo.insert_activo_id_user);
        //JOptionPane.showMessageDialog(null, id);

    }//GEN-LAST:event_jButton_buscarActionPerformed

    public int obtener_id(String user) {
        int numero = 0;
        String sql = "select idusuario from usuario where usuario='" + user + "'";
        try {
            Statement st = cxn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                numero = rs.getInt("idusuario");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return numero;

    }
    private void jButton_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_guardarActionPerformed
        //Login lo = new Login();
        //int id_ua = Integer.parseInt(lo.insert_activo_id_user);
        // JOptionPane.showMessageDialog(null, id_ua);
        // int idusuario_activo=Integer.parseInt(lo.insert_activo_id_user);
        //  int id_user_ac = (lo.insert_activo_id_user);
        String sql = "";

        sql = "INSERT INTO activo(identificador, Cantidad, nombre_activo, tipo_activo, aplicacion, usuario_idusuario)"
                + " VALUES (?,?,?,?,?,?)";
//        System.out.println("este es el dato" + id_user_ac);
        try {
            int id = obtener_id(insert_dato);
            int cant = Integer.parseInt(cantidad.getText().toString());
            //  int in_us_ac =  Integer.parseInt(Login.Textid.getText());
            // int idd = Integer.parseInt(id.getText().toString());
            //     int cedula = Integer.parseInt(jTextField_cedula.getText().toString());

            PreparedStatement dato = cxn.prepareStatement(sql);
            //dato.setInt(1, idd);
            //String dd = Login.Textid.getText();
            //    int in_us_ac = Integer.parseInt(dd);
            //Text_id.setText(dd);
            // String dd = Login.Textid.getText();
            //int in_us=Integer.parseInt(dd);
            dato.setString(1, identificador.getText().toString());
            dato.setInt(2, cant);
            dato.setString(3, nombre_activo.getText().toString());
            dato.setString(4, tipo_activo.getModel().getSelectedItem().toString());
            dato.setString(5, buscar_activo.getModel().getSelectedItem().toString());

            dato.setInt(6, id);
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

    private void jPanel_amenazasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_amenazasMouseExited
        resetColor(jPanel_amenazas);
    }//GEN-LAST:event_jPanel_amenazasMouseExited

    private void jPanel_amenazasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_amenazasMouseEntered
        setColor(jPanel_amenazas);
    }//GEN-LAST:event_jPanel_amenazasMouseEntered

    private void jPanel_amenazasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_amenazasMouseClicked
        //Amenazas amenazas = new Amenazas();
        // amenazas.setVisible(true);
        // Amenazas amenazas= new Amenazas();
        // jPanel_amenazas.add(amenazas);
        //amenazas.show();
        //jPanel_amenazas
        // dispose();
    }//GEN-LAST:event_jPanel_amenazasMouseClicked

    private void jPanel_activosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_activosMouseExited
        resetColor(jPanel_activos);
    }//GEN-LAST:event_jPanel_activosMouseExited

    private void jPanel_activosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_activosMouseEntered
        setColor(jPanel_activos);
    }//GEN-LAST:event_jPanel_activosMouseEntered
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
    private javax.swing.JTextField Textactivo_buscar;
    public static javax.swing.JComboBox<String> aplicacion;
    public static javax.swing.JComboBox<String> buscar_activo;
    public static javax.swing.JTextField cantidad;
    public static javax.swing.JTextField identificador;
    private javax.swing.JButton jButton_buscar;
    private javax.swing.JButton jButton_eliminar1;
    private javax.swing.JButton jButton_guardar;
    private javax.swing.JButton jButton_modificar;
    private javax.swing.JButton jButton_nuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
    Login lg = new Login();

}
