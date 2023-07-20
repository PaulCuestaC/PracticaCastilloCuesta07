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

    public ControladorCantante() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void crear(Cantante cantante){
        this.cantante = cantante;
        cantanteDAO.create(cantante);
        
    }
    public void update(Object obj) {

        cantanteDAO.update((Cantante) obj);

    }
    public Cantante  buscar(String cod){
        this.cantante=cantanteDAO.read(cod);;
        return this.cantante;
        
    }
    public void eliminarCantante(String cod){
        cantanteDAO.delete(cod);
    }
    
    public void agregarDisco(Disco disco, String cod){
        this.cantante = cantanteDAO.read(cod);
        cantante.AgregarDisco(disco);
        
    }
    public List<Cantante> list() {
        return cantanteDAO.list();
    }
}
