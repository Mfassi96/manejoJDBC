package test;

import datos.PersonaDAO;
import domain.Persona;
import java.util.List;


public class TestManejoPersonas {
    public static void main(String[] args) {
        PersonaDAO personaDao= new PersonaDAO();
        
        //Insertando un nuevo objeto
        
//        Persona personaNueva=new Persona("prueba2", "prueba2", "Sincere@april.biz", "1-770-736-8031 x56442");
//        personaDao.insertar(personaNueva);
        
           //modificar un objeto persona
           
//           Persona personaModificar=new Persona(6, "Modificado", "Modificado", "mail@mail.com", "1234");
//           personaDao.actualizar(personaModificar);

            //eliminar persona
            Persona personaEliminar=new Persona(6);
            personaDao.eliminar(personaEliminar);
           
        List <Persona> personas=personaDao.seleccionar();
        
        for(Persona persona:personas){
            System.out.println("persona = " + persona);
        }
        
    }
}
