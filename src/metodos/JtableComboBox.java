/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package metodos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
/**
 *
 * @author fatte
 */
public class JtableComboBox extends JFrame {
    
    public JtableComboBox(){
        //super ("JCOBO IN TABLE");
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        DefaultTableModel dm=new DefaultTableModel();
        
        dm.setDataVector(new Object[][]
        {
        {"1","SI","NO","Seleccionar"},
        {"1","SI","NO","Seleccionar"},
        },
        new Object[]{"Id","Amenaza","Aplicacion"});
    
         JTable table=new JTable(dm); 
         String[] positions={ "SI", "NO"};
         JComboBox combo= new JComboBox<String>(positions);
         combo.addActionListener(new ActionListener(){      
             
             public void actionPerformed(ActionEvent ae){
                 //JOptionPane.showMessageDialog(null, combo.getSelectedItem());
             }
             
        });
         TableColumn col= table.getColumnModel().getColumn(2);
         col.setCellEditor(new DefaultCellEditor(combo));
         
         JScrollPane pane=new JScrollPane(table);
         getContentPane().add(pane);
         setSize(350,200);
    }
    
    public static void main (String[] args)
    {
        JtableComboBox j=new JtableComboBox();
        j.setVisible(true);
    }
    
    
    
}
