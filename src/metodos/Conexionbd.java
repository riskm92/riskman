/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexionbd {
    
    public Connection getConnection(){
        Connection cxn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cxn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/riskman?useSSL=false", "root", "12345");
           //Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/INTtech?useSSL=false","root","root");
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } catch(Exception e1){
            System.out.println("Error: " +e1.getMessage());
        } finally {
          // JOptionPane.showMessageDialog(null, "Conexión Exitosa");
            return cxn;
        }
       
       
        }
    }