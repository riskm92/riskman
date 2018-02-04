package aplicacion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import metodos.Conexionbd;

/**
 *
 * @author barcelona
 */
public final class RegistroUsuario extends javax.swing.JFrame {
DefaultTableModel modelo;
DefaultTableModel model;
    /**
     * Creates new form Administrador
     */
    public RegistroUsuario() {
        initComponents();
        
        llenartabla();
      //  Generarnumeracion();
        this.setLocationRelativeTo(null);
        jTable_registro.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
           @Override
          public void valueChanged(ListSelectionEvent e) {
          
               try {
                   String sql ="";
                   int fila = jTable_registro.getSelectedRow();
                   sql="select idusuario, nombres, apellidos, correo, celular, institucion, cedula, usuario, password from usuario";
                  Statement st = cxn.createStatement();
                  ResultSet rs = st.executeQuery(sql);
                  
         //    Statement sent=cxn.createStatement();
           // int n=sent.executeQuery(sql);
           if (jTable_registro.getSelectedRow() !=-1) {
                     //int fila = jTable_registro.getSelectedRow();
                      jTextField_id.setText(jTable_registro.getValueAt(fila, 1).toString());
                      jTextField_nombres.setText(jTable_registro.getValueAt(fila, 2).toString()); 
                      jTextField_apellidos.setText(jTable_registro.getValueAt(fila, 3).toString());   
                      jTextField_correo.setText(jTable_registro.getValueAt(fila, 4).toString());   
                      jTextField_celular.setText(jTable_registro.getValueAt(fila, 5).toString());   
                      jTextField_institucion.setText(jTable_registro.getValueAt(fila, 6).toString());   
                      jTextField_cedula.setText(jTable_registro.getValueAt(fila, 7).toString());   
                      jTextField_usuario.setText(jTable_registro.getValueAt(fila, 8).toString());   
                      jPassword.setText(jTable_registro.getValueAt(fila, 9).toString());   
                     // jTextField_nombres.setText(jTable_registro.getValueAt(fila, 2).toString());   
           
           
           
           
           }
         /*  if(fila>0){
             
             jTextField_id.setText(rs.getString("idusuario"));
             jTextField_nombres.setText(rs.getString("nombres"));
             jTextField_apellidos.setText(rs.getString("apellidos"));
             jTextField_correo.setText(rs.getString("correo"));
             jTextField_celular.setText(rs.getString("celular"));
             jTextField_institucion.setText(rs.getString("institucion"));
             jTextField_cedula.setText(rs.getString("cedula"));
             jTextField_usuario.setText(rs.getString("usuario"));
             jPassword.setText(rs.getString("contraseña"));

            }*/
               
            
          
           // jComboBox_tipo.setsetText(rs.getString("contraseña"));
            //dato.setString(10,jComboBox_tipo.getModel().getSelectedItem().toString());
               // new String(jPassword.getPassword())
            
                   // Connection cxn = conxlogin.getConnection();
                   //   Statement sent=cxn.createStatement();
                   //   int n=sent.executeUpdate(sql);
                   
                 //   PreparedStatement dato = cxn.prepareStatement(sql);
                   
                   //if (jTable_registro.getSelectedRow() !=-1) {
                   //  int fila = jTable_registro.getSelectedRow();
                   //   jTextField_id.setText(jTable_registro.getValueAt(fila, 1).toString());
                   //   jTextField_cedula.setText(jTable_registro.getValueAt(fila, 2).toString());            
               } catch (SQLException ex) {
                   Logger.getLogger(RegistroUsuario.class.getName()).log(Level.SEVERE, null, ex);
               }
                    
                }
                
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           //}
       });
    }
    void Deshabilitar(){
        jTextField_id.setEditable(false);
        jTextField_nombres.setEditable(false);
        jTextField_apellidos.setEditable(false);
        jTextField_correo.setEditable(false);
        jTextField_celular.setEditable(false);
        jTextField_institucion.setEditable(false);
        jTextField_cedula.setEditable(false);
        jTextField_usuario.setEditable(false);
        jPassword.setEditable(false);
        jComboBox_tipo.setEditable(false);
    }
    void Limpiar(){
        jTextField_id.setText("");
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
    void Habilitar(){
        jTextField_id.setEditable(true);
        jTextField_nombres.setEditable(true);
        jTextField_apellidos.setEditable(true);
        jTextField_correo.setEditable(true);
        jTextField_celular.setEditable(true);
        jTextField_institucion.setEditable(true);
        jTextField_cedula.setEditable(true);
        jTextField_usuario.setEditable(true);
        jPassword.setEditable(true);
    //    jComboBox_tipo.setEditable(true);
    }
     void Generarnumeracion()
    {
     String SQL="select  max(id_usuario) from usuarios";
        
          int c=0;
          
        try {
           Statement st = cxn.createStatement();
           ResultSet rs=st.executeQuery(SQL);
            while(rs.next())
            {              
                 c=rs.getInt(1);
            }
      
            if(c==0){
                jTextField_id.setText("1");
            }
            else
            {
                
              jTextField_id.setText(""+(c+1));
         
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    void llenartabla(){
   String [] titulos= {"Id","Cedula","Usuario","Tipo Usuario"};
   modelo=new  DefaultTableModel(null,titulos);   
   String datos []= new String[5];
   String sql="SELECT idusuario,cedula,usuario,tipo_usuario FROM usuario"; 
        try {
            Statement st = cxn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            { 
                datos[0]=rs.getString("idusuario");
                datos[1]=rs.getString("cedula");
                datos[2]= rs.getString("usuario");
                datos[3]= rs.getString("tipo_usuario");
                modelo.addRow(datos);
            }
            jTable_registro.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(RegistroUsuario.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel_contacto = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel_informacion = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel_registrouser = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        labelconectado = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_registro = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jTextField_id = new javax.swing.JTextField();
        jTextField_nombres = new javax.swing.JTextField();
        jTextField_apellidos = new javax.swing.JTextField();
        jTextField_correo = new javax.swing.JTextField();
        jTextField_celular = new javax.swing.JTextField();
        jTextField_institucion = new javax.swing.JTextField();
        jTextField_cedula = new javax.swing.JTextField();
        jTextField_usuario = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jComboBox_tipo = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jButton_modificar = new javax.swing.JButton();
        jButton_eliminar = new javax.swing.JButton();
        jButton_guardar = new javax.swing.JButton();
        jButton_nuevo = new javax.swing.JButton();
        jPassword = new javax.swing.JPasswordField();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(27, 29, 37));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_contacto.setBackground(new java.awt.Color(27, 29, 37));
        jPanel_contacto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_contactoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel_contactoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel_contactoMouseExited(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Contacto");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Phone_20px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel_contactoLayout = new javax.swing.GroupLayout(jPanel_contacto);
        jPanel_contacto.setLayout(jPanel_contactoLayout);
        jPanel_contactoLayout.setHorizontalGroup(
            jPanel_contactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_contactoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel11)
                .addGap(20, 20, 20)
                .addComponent(jLabel9))
        );
        jPanel_contactoLayout.setVerticalGroup(
            jPanel_contactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel2.add(jPanel_contacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 210, 50));

        jPanel_informacion.setBackground(new java.awt.Color(27, 29, 37));
        jPanel_informacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_informacionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel_informacionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel_informacionMouseExited(evt);
            }
        });

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Informacion");

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_More_Info_20px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel_informacionLayout = new javax.swing.GroupLayout(jPanel_informacion);
        jPanel_informacion.setLayout(jPanel_informacionLayout);
        jPanel_informacionLayout.setHorizontalGroup(
            jPanel_informacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_informacionLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel19)
                .addGap(20, 20, 20)
                .addComponent(jLabel18))
        );
        jPanel_informacionLayout.setVerticalGroup(
            jPanel_informacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel2.add(jPanel_informacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 210, 50));

        jPanel_registrouser.setBackground(new java.awt.Color(27, 29, 37));
        jPanel_registrouser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_registrouserMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel_registrouserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel_registrouserMouseExited(evt);
            }
        });

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Registro Usuario");

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Add_User_Male_20px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel_registrouserLayout = new javax.swing.GroupLayout(jPanel_registrouser);
        jPanel_registrouser.setLayout(jPanel_registrouserLayout);
        jPanel_registrouserLayout.setHorizontalGroup(
            jPanel_registrouserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_registrouserLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel21)
                .addGap(20, 20, 20)
                .addComponent(jLabel20))
        );
        jPanel_registrouserLayout.setVerticalGroup(
            jPanel_registrouserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel2.add(jPanel_registrouser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 210, 50));

        jPanel3.setBackground(new java.awt.Color(117, 117, 123));

        labelconectado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelconectado.setText("bienvenido");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Administrador");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelconectado)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(368, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelconectado)
                    .addComponent(jLabel1))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(55, 58, 70));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Informacion");
        jPanel13.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, 50));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_More_Info_20px.png"))); // NOI18N
        jPanel13.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setText("Tipo:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setText("id:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setText("Nombres:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setText("Apellidos:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel6.setText("Institución:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel7.setText("Cédula:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel8.setText("Correo:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel10.setText("Celular:");

        jTable_registro.setBackground(new java.awt.Color(204, 204, 204));
        jTable_registro.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTable_registro.setForeground(new java.awt.Color(51, 51, 51));
        jTable_registro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Cedula", "Usuario", "Tipo Usuario"
            }
        ));
        jTable_registro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_registroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_registro);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel12.setText("Usuario:");

        jTextField_id.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextField_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_idActionPerformed(evt);
            }
        });

        jTextField_nombres.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextField_nombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_nombresActionPerformed(evt);
            }
        });

        jTextField_apellidos.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextField_apellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_apellidosActionPerformed(evt);
            }
        });

        jTextField_correo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextField_correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_correoActionPerformed(evt);
            }
        });

        jTextField_celular.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextField_celular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_celularActionPerformed(evt);
            }
        });

        jTextField_institucion.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextField_institucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_institucionActionPerformed(evt);
            }
        });

        jTextField_cedula.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextField_cedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_cedulaActionPerformed(evt);
            }
        });

        jTextField_usuario.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextField_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_usuarioActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel13.setText("Contraseña:");

        jComboBox_tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar...", "Administrador", "Auxiliar" }));
        jComboBox_tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_tipoActionPerformed(evt);
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

        jButton_guardar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton_guardar.setText("Guardar");
        jButton_guardar.setBorder(null);
        jButton_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_guardarActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        jPassword.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(6, 6, 6)
                                .addComponent(jTextField_id, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(12, 12, 12)
                                .addComponent(jTextField_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jLabel5)
                                .addGap(23, 23, 23)
                                .addComponent(jTextField_apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(27, 27, 27)
                                .addComponent(jTextField_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jLabel10)
                                .addGap(37, 37, 37)
                                .addComponent(jTextField_celular, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(26, 26, 26)
                                .addComponent(jTextField_correo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jLabel6)
                                .addGap(19, 19, 19)
                                .addComponent(jTextField_institucion, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(22, 22, 22)
                                .addComponent(jTextField_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jLabel13)
                                .addGap(11, 11, 11)
                                .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel2)
                                .addGap(21, 21, 21)
                                .addComponent(jComboBox_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextField_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextField_apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextField_celular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextField_institucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField_correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jTextField_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel_informacionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_informacionMouseEntered
        // TODO add your handling code here:
         setColor(jPanel_informacion);
    }//GEN-LAST:event_jPanel_informacionMouseEntered

    private void jPanel_informacionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_informacionMouseExited
        // TODO add your handling code here:
        resetColor(jPanel_informacion);
    }//GEN-LAST:event_jPanel_informacionMouseExited

    private void jPanel_registrouserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_registrouserMouseEntered
        // TODO add your handling code here:
        setColor(jPanel_registrouser);
    }//GEN-LAST:event_jPanel_registrouserMouseEntered

    private void jPanel_registrouserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_registrouserMouseExited
        // TODO add your handling code here:
         resetColor(jPanel_registrouser);
    }//GEN-LAST:event_jPanel_registrouserMouseExited

    private void jPanel_contactoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_contactoMouseEntered
        // TODO add your handling code here:
        setColor(jPanel_contacto);
    }//GEN-LAST:event_jPanel_contactoMouseEntered

    private void jPanel_contactoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_contactoMouseExited
        // TODO add your handling code here:
        resetColor(jPanel_contacto);
    }//GEN-LAST:event_jPanel_contactoMouseExited

    private void jPanel_informacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_informacionMouseClicked
        // TODO add your handling code here:
            Administrador administrador=new Administrador();
            administrador.setVisible(true);
            dispose();
    }//GEN-LAST:event_jPanel_informacionMouseClicked

    private void jPanel_registrouserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_registrouserMouseClicked
        // TODO add your handling code here:
        RegistroUsuario registro= new RegistroUsuario();
        registro.setVisible(true);
        dispose();
    }//GEN-LAST:event_jPanel_registrouserMouseClicked

    private void jPanel_contactoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_contactoMouseClicked
        // TODO add your handling code here:
         Contacto contacto = new Contacto();
         contacto.setVisible(true);
         dispose();
    }//GEN-LAST:event_jPanel_contactoMouseClicked

    private void jTextField_nombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_nombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_nombresActionPerformed

    private void jTextField_apellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_apellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_apellidosActionPerformed

    private void jTextField_correoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_correoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_correoActionPerformed

    private void jTextField_celularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_celularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_celularActionPerformed

    private void jTextField_cedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_cedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_cedulaActionPerformed

    private void jTextField_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_usuarioActionPerformed

    private void jComboBox_tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_tipoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jComboBox_tipoActionPerformed

    private void jButton_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_nuevoActionPerformed
          
                  Limpiar();
                  Habilitar();
        // TODO add your handling code here:
    

    }//GEN-LAST:event_jButton_nuevoActionPerformed
   
    private void jTextField_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_idActionPerformed

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed
      
          try{
            int fila=jTable_registro.getSelectedRow();
            String sql="delete from usuarios where id_usuario="+jTable_registro.getValueAt(fila,0);

            Statement sent=cxn.createStatement();
            int n=sent.executeUpdate(sql);
            if(n>0){

                JOptionPane.showMessageDialog(null, "datos eliminados");
                llenartabla();

            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "error"+e.getMessage());
        }
  
         
    }//GEN-LAST:event_jButton_eliminarActionPerformed

    private void jButton_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_modificarActionPerformed
                                                   
        try{
            String sql="Update usuarios set nombres=?, apellidos=?, correo=?, celular=?, institucion=?, cedula=?,"
                    + "usuario=?, contraseña=?, tipo_usuario=?"+
                    "where id_usuario=?";
            
             //  int fila=jTable_registro.getSelectedRow();
              // String table=(String)jTable_registro.getValueAt(fila,0);
              PreparedStatement dato=cxn.prepareCall(sql);
         
               //int id = Integer.parseInt(jTextField_id.getText().toString());
              //  int celular = Integer.parseInt(jTextField_celular.getText().toString());
        
                //int cedula = Integer.parseInt(jTextField_cedula.getText().toString());

                dato.setString(1, jTextField_id.getText().toString());
                dato.setString(2, jTextField_nombres.getText());
                dato.setString(3, jTextField_apellidos.getText().toString());
                dato.setString(4, jTextField_correo.getText().toString());
               dato.setString(5, jTextField_celular.getText().toString());
                dato.setString(6, jTextField_institucion.getText().toString());
                dato.setString(7, jTextField_cedula.getText().toString());
                dato.setString(8, jTextField_usuario.getText().toString());
               dato.setString(9, new String(jPassword.getPassword()));
                dato.setString(10,jComboBox_tipo.getModel().getSelectedItem().toString());
                dato.executeUpdate();
         
           //dato.setString(4,table);//la llamada sql se muestra en la tabla

            int n=dato.executeUpdate();
            if(n>0){
              //  Limpiar();
                llenartabla();
                JOptionPane.showMessageDialog(null, "datos modificados");
                

            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "error"+ e.getMessage());
           
        }
                // TODO add your handling code here:
                        
    }//GEN-LAST:event_jButton_modificarActionPerformed

    private void jButton_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_guardarActionPerformed
      String sql="";
                    sql="INSERT INTO usuarios(id_usuario,nombres,apellidos,correo,celular,institucion,cedula,usuario,contraseña,tipo_usuario) VALUES (?,?,?,?,?,?,?,?,?,?)";
          try{
                int id = Integer.parseInt(jTextField_id.getText().toString());

                Generarnumeracion();
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
                dato.setString(10,jComboBox_tipo.getModel().getSelectedItem().toString());
                dato.executeUpdate();
               


                //btn_nuevo.setEnabled(true);
                JOptionPane.showMessageDialog(null," Registro Ingresado Correctamente");
                 Limpiar();
                 llenartabla();
            }catch(SQLException e){
                System.out.println("Error => Problema al Insertar Registro " + e );
            } 
    }//GEN-LAST:event_jButton_guardarActionPerformed

    private void jTextField_institucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_institucionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_institucionActionPerformed

    private void jPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordActionPerformed

    private void jTable_registroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_registroMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable_registroMouseClicked
 public void setColor(JPanel jpanel){
        
        jpanel.setBackground(new java.awt.Color(60,64,77));
        
    }
    public void resetColor(JPanel jpanel){
        
        jpanel.setBackground(new java.awt.Color(27,29,37));
        
    }
    public void Insertar(){
 
    
    }
    public void modificar(){
    
    }
    public void eliminar(){
     
    
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
            java.util.logging.Logger.getLogger(RegistroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JButton jButton_guardar;
    private javax.swing.JButton jButton_modificar;
    private javax.swing.JButton jButton_nuevo;
    private javax.swing.JComboBox<String> jComboBox_tipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel_contacto;
    private javax.swing.JPanel jPanel_informacion;
    private javax.swing.JPanel jPanel_registrouser;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_registro;
    private javax.swing.JTextField jTextField_apellidos;
    private javax.swing.JTextField jTextField_cedula;
    private javax.swing.JTextField jTextField_celular;
    private javax.swing.JTextField jTextField_correo;
    private javax.swing.JTextField jTextField_id;
    private javax.swing.JTextField jTextField_institucion;
    private javax.swing.JTextField jTextField_nombres;
    private javax.swing.JTextField jTextField_usuario;
    public static javax.swing.JLabel labelconectado;
    // End of variables declaration//GEN-END:variables
Conexionbd conxlogin = new Conexionbd();
Connection cxn = conxlogin.getConnection();
String idfila="";

   
}
