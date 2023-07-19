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
        this.cantante = cantante;
        cantanteDAO.create(cantante);
        
    }
    public void update(Object obj,int pos) {

        cantanteDAO.update((Cantante) obj, pos);

    }
    public Cantante  buscar(String cod) throws Exception{
        this.cantante=cantanteDAO.read(cod);
        return this.cantante;
        
    }
    public void eliminarCantante(String cod){
        cantanteDAO.delete(cod);
    }
    
    public void agregarDisco(Disco disco, String cod) throws Exception{
        this.cantante = cantanteDAO.read(cod);
        cantante.AgregarDisco(disco);
        
    }
    public Set<Cantante> list() throws Exception {
        return cantanteDAO.getLista();
    }
}
