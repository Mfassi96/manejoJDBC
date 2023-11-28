package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    private static final String JDBC_URL="jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=True&serverTimezone=UTC&allowPublicKeyRetrieval=True";
    private static final String JDBC_USER="root";
    private static final String JDBC_PASSWORD="";
    
    //metodo para la conexion
    
    public static Connection getConnection() throws SQLException{
        
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }
    
    //Metodo encargado de cerrar los resultset
    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }
    
       
        public static void close(Statement smtm) throws SQLException{
        smtm.close();
    }
        
                public static void close(PreparedStatement smtm) throws SQLException{
        smtm.close();
    }
        
        
        public static void close(Connection conexion) throws SQLException{
        conexion.close();
    }
    
}
