package datos;

import static datos.Conexion.*;
import domain.Persona;
import java.sql.*;
import java.sql.ResultSet;
import java.util.*;


public class PersonaDAO {
    
    private static String SQL_SELECT="SELECT * FROM persona";
    
    public List <Persona> seleccionar(){
        Connection conn=null;
        PreparedStatement stmt= null;
        ResultSet rs=null;
        Persona persona=null;
        List<Persona>personas=new ArrayList<>();
        
        
        try {
            conn=getConnection();
            stmt=conn.prepareStatement(SQL_SELECT);
            rs=stmt.executeQuery(); //devueve todo el set de resultado de la consulta
            
            while(rs.next()){
                
                int idPersona=rs.getInt("id_persona");
                String nombre=rs.getString("nombre");
                String apellido=rs.getString("apellido");
                String telefono=rs.getString("telefono");
                
                //se crea el objeto persona
                persona=new Persona(idPersona, nombre, apellido, nombre, telefono);
                
                // y se agrega a la lista
                personas.add(persona);
                
                
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            
            
           
        }
        return personas;
    }
    
}
