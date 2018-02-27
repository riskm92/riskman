/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author barcelona
 */
public class combox extends JApplet {
    
        JTable tabla;
        JComboBox sexo;
        DefaultTableModel modelo;

        public void iniit() {

            String nomcols[] = {"Nombre", "Apellido", "Sexo"};
            String datos[][] = new String[4][3];
            datos[0][0] = "Java";
            datos[0][1] = "Zone";
            datos[0][2] = "Masculino";

            modelo = new DefaultTableModel(datos, nomcols);
            tabla = new JTable(modelo);

            TableColumn col = tabla.getColumnModel().getColumn(2);

            String op[] = {"Masculino", "Femenino"};

            sexo = new JComboBox(op);

            col.setCellEditor(new DefaultCellEditor(sexo));

            JScrollPane scroll = new JScrollPane(tabla);

            add(scroll);

            JPanel pbotones = new JPanel();
            JButton agregar = new JButton("Agregar");
            agregar.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent arg0) {
                    String s[] = {"", "", "Masculino"};
                    modelo.addRow(s);
                }

            });

            pbotones.add(agregar);
            add(pbotones, BorderLayout.SOUTH);

        }
    }

