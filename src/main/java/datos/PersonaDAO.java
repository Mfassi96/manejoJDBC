package datos;

import static datos.Conexion.*;
import domain.Persona;
import java.sql.*;
import java.sql.ResultSet;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonaDAO {

    private static String SQL_SELECT = "SELECT * FROM persona";
    private static String SQL_INSRT = "INSERT INTO persona(id_persona,nombre, apellido, email, telefono) VALUES (NULL,?,?,?,?)";
    
    public List<Persona> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery(); //devueve todo el set de resultado de la consulta

            while (rs.next()) {

                int idPersona = rs.getInt("id_persona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String telefono = rs.getString("telefono");

                //se crea el objeto persona
                persona = new Persona(idPersona, nombre, apellido, nombre, telefono);

                // y se agrega a la lista
                personas.add(persona);

            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
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

    public int insertar(Persona persona) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros=0;
        
        try {
            conn=getConnection();
            stmt=conn.prepareStatement("SQL_INSERT");
            
            //pasar valores a la consukta
            stmt.setString(2, persona.getNombre());
            stmt.setString(3, persona.getApellido());
            stmt.setString(4, persona.getEmail());
            stmt.setString(5, persona.getTelefono());
            registros=stmt.executeUpdate(); //este metodo puede ejecutar sentencias tipo insert, update o delete
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            
        
    }
        return registros;

    }

}
