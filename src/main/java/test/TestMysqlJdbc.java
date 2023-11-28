package test;

import java.sql.*;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class TestMysqlJdbc {
    
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=True&serverTimezone=UTC&allowPublicKeyRetrieval=True ";
        try {
            //     Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion= DriverManager.getConnection(url,"root","");
            
            Statement instruccion =conexion.createStatement();
            var sql="SELECT * FROM persona";
            ResultSet resultado= instruccion.executeQuery(sql);
            while(resultado.next()){
                //System.out.println("Persona: " + resultado.getInt("id_persona"));
                JOptionPane.showMessageDialog(null, "ID Persona: " + resultado.getInt("id_persona") + '\n' + "Nombre; " + resultado.getString("nombre") + '\n' + "Apellido; " + resultado.getString("apellido"));
            }
            resultado.close();
            instruccion.close();
            conexion.close();
        }
        catch (SQLException ex) {
           ex.printStackTrace(System.out);
                
        }
        
        
    }
}
