package test;

import datos.PersonaDAO;
import domain.Persona;
import java.util.List;


public class TestManejoPersonas {
    public static void main(String[] args) {
        PersonaDAO personaDao= new PersonaDAO();
        
        //Insertando un nuevo objeto
        
        Persona personaNueva=new Persona("Leanne", "Graham", "Sincere@april.biz", "1-770-736-8031 x56442");
        personaDao.insertar(personaNueva);
        
        List <Persona> personas=personaDao.seleccionar();
        
        for(Persona persona:personas){
            System.out.println("persona = " + persona);
        }
        
    }
}
