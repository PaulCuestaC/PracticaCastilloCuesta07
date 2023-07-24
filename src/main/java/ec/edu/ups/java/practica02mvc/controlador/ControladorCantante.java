/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.java.practica02mvc.controlador;

import ec.edu.ups.java.practica02mvc.dao.CantanteDAO;
import ec.edu.ups.java.practica02mvc.idao.ICantanteDAO;
import ec.edu.ups.java.practica02mvc.modelo.Cantante;
import ec.edu.ups.java.practica02mvc.modelo.Disco;
import java.util.List;
import java.util.Set;

/**
 *
 * @author ESTUDIANTE
 */
public class ControladorCantante {
    private Cantante cantante;
    private ICantanteDAO cantanteDAO;
    
      public ControladorCantante(ICantanteDAO cantanteDAO){
        this.cantanteDAO = cantanteDAO;
    }


    
    public void crear(Cantante cantante){
    //Metodo para crear el cantante y almacenarlo en la fuente de datos 
    //Llamamos al metodo del ICantanteDAO de la interfaz para almacenar 
    //el objeto cantante 
        
        this.cantante = cantante;
        cantanteDAO.create(cantante);
        
    }
    public void update(Object obj,int pos) {
    //metodo para actualizar el objeto en la posicion pos de la 
    //interfaz ICantanteDAO
    //implementamos y realizamos un casting a cantante para   
    //que el objeto sea tratado como un objeto de tipo Cantante
    
        cantanteDAO.update((Cantante) obj, pos);

    }
    public Cantante  buscar(String cod) throws Exception{
    //metodo para buscar el codigo del cantante 
    //si encuentra una coincidencia o lanzará una excepción 
    //si ocurre algún error durante la búsqueda
    //implementamos lo de la interfaz para buscar el objeto Cantante 
    //el read se encarga de la operación de lectura en la fuente de datos
    
        this.cantante=cantanteDAO.read(cod);
        return this.cantante;
        
    }
    public void eliminarCantante(String cod){
    //metodo para eliminar un cantante de la fuente de datos
    //El método delete(cod) de la interfaz ICantanteDAO se encarga de 
    //realizar la operación de eliminación en la fuente de dato    
        cantanteDAO.delete(cod);
    }
    
    public void agregarDisco(Disco disco, String cod) throws Exception{
    //Este método recibe dos parámetros: Disco discoy String cod 
    //el metodo declara que puede lanzar una excepcion 
    //implementación de la interfaz ICantanteDAO para buscar el cantante
    //que tenga el código cod    
    // mediante el read(cod) obtenemos el cantante correspondiente al código proporcionado 
        this.cantante = cantanteDAO.read(cod);
        cantante.AgregarDisco(disco);
        
    }
    public void eliminarDisco(Disco disco, String cod) throws Exception{
        this.cantante = cantanteDAO.read(cod);
        cantante.deleteDisco(Integer.parseInt(cod));
    }
    public Set<Cantante> list() throws Exception {
        return cantanteDAO.getLista();
    }
}
