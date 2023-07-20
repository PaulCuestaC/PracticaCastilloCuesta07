/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ups.java.practica02mvc.idao;

import ec.edu.ups.java.practica02mvc.modelo.Compositor;
import java.util.List;
import java.util.Set;

/**
 *
 * @author ESTUDIANTE
 */
public interface ICompositorDAO {
      public abstract void create(Compositor compositor); //C

    public abstract Compositor read(String cod)throws Exception; //R

    public abstract void update(Compositor compositor, int cod2); //U

    public abstract void delete(String cod); //D

    public abstract Set<Compositor> getLista() throws Exception;
}
