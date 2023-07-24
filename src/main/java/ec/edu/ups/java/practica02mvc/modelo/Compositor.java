/*
 * Clase Compositor que abstrae los atributos
 */
package ec.edu.ups.java.practica02mvc.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Compositor extends Persona {

    private int numeroDeComposiciones;//atributo entero que guarda el numero de Composiciones de la clase compositor
    private List<Cancion> cancionesTop100Billboard;//atributo lista que guarda las canciones de la clase compositor
    private List<Cantante> clientes; //atributo lista que guarda los clientes cantantes de la clase compositor


    /*
 * Constructor con parámetros de la clase Compositor.
 * 
 * @param numeroDeComposiciones: int, número de composiciones del compositor
 * @param codigo: int, código del compositor
 * @param nombre: String, nombre del compositor
 * @param apellido: String, apellido del compositor
 * @param edad: int, edad del compositor
 * @param nacionalidad: String, nacionalidad del compositor
 * @param salario: double, salario del compositor
     */

    public Compositor(int numeroDeComposiciones, List<Cancion> cancionesTop100Billboard, List<Cantante> clientes, Persona persona, String codigo, String nombre, String apellido, int edad, String nacionalidad, double salario) {
        super(codigo, nombre, apellido, edad, nacionalidad, salario);
        this.numeroDeComposiciones = numeroDeComposiciones;
        this.cancionesTop100Billboard = cancionesTop100Billboard;
        this.clientes = clientes;
       
    }


    /*
     * Constructor vacío de la clase Cancion
     */
    public Compositor() {
    }
    //getters y setters  
    public int getNumeroDeComposiciones() {
        return numeroDeComposiciones;
    }

    public void setNumeroDeComposiciones(int numeroDeComposiciones) {
        this.numeroDeComposiciones = numeroDeComposiciones;
    }

    public List<Cancion> getCancionesTop100Billboard() {
        return cancionesTop100Billboard;
    }

    public void setCancionesTop100Billboard(List<Cancion> cancionesTop100Billboard) {
        this.cancionesTop100Billboard = cancionesTop100Billboard;
    }

    public List<Cantante> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cantante> clientes) {
        this.clientes = clientes;
    }

    
//Agregamos una nueva cancion a la lista 
    public void AgregarCancion(Cancion cancion) {
        cancionesTop100Billboard.add(cancion);//Agregamos una nueva cancion al final de la lista 
                                                //mediante el metodo add
    }

    public Cancion readCancion(int cod) {
    //metodo que representa el codigo de la cancion que se desa buscar en la lista
    //cancionesTop100Billboard
        for (Cancion cancion : cancionesTop100Billboard) {
        //recorre la lista cancionesTop100Billboard y se asignara a la variable cancion
            if (cancion.getCodigo() == (cod)) {
            //si el codigo de la cancion actual coincide 
            //con el codigo buscado de ejecutara el if 
                return cancion;
                //devolvera la cancion encunetrada 
                
            }
        }
        return null;
    }

    public void updateCancion(Cancion cancion) {
    //metodo para actualizar la cancion de la lista cancionesTop100Billboard
        for (int i = 0; i < cancionesTop100Billboard.size(); i++) {
        //for para recorrer la lista cancionesTop100Billboard 
        //comienza en 0 y continuara mientras  i sea menor que el tamano de la lista 
            Cancion cancionGuar = cancionesTop100Billboard.get(i);
            if (cancionGuar.getCodigo() == (cancion.getCodigo())) {
            //si la cancion actual es igual a la cancion proporcionada 
            //se encontrara la cancion que vamos a actualizar
            //reemplazaremos esa cancion en la lista por la version actualizada 
          
                cancionesTop100Billboard.set(i, cancion);
                break;
            }
        }
    }

    public void deleteCancion(int cod) {
    //metodo para eliminar la cancion de la lista cancionesTop100Billboard
        for (int i = 0; i < cancionesTop100Billboard.size(); i++) {
        //recorre la lista cancionesTop100Billboard con el indice i     
        //obtiene la canción actual de la lista en la posición i 
        //y se almacena en la variable cancionSad
            Cancion cancionSad = cancionesTop100Billboard.get(i);
            if (cancionSad.getCodigo() == (cod)) {
            //Comparamos la cancion actual con la  cancion proporcionada como parametro
            //Si es igual, la cancion se eliminara de la lista en la posicion i
                cancionesTop100Billboard.remove(i);
                break;
            }
        }
    }
    public List<Cancion> listarCancion(){
        return cancionesTop100Billboard;
    }

    /*
     * Retorna el valor del hashcode de la instancia actual de la clase Compositor
     * @return el valor del hashcode de la instancia actual de la clase Compositor
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.numeroDeComposiciones;
        hash = 71 * hash + Objects.hashCode(this.cancionesTop100Billboard);
        hash = 71 * hash + Objects.hashCode(this.clientes);
        return hash;
    }

    /*
    Compara si la instancia actual de la clase Compositor es igual a otro objeto.
    @param obj objeto a comparar con la instancia actual de la clase Compositor
    @return true si la instancia actual de la clase Compositor es igual al objeto pasado como parametro,
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Compositor other = (Compositor) obj;
        if (this.numeroDeComposiciones != other.numeroDeComposiciones) {
            return false;
        }
        if (!Objects.equals(this.cancionesTop100Billboard, other.cancionesTop100Billboard)) {
            return false;
        }
        return Objects.equals(this.clientes, other.clientes);
    }

    /* Calcula el salario del cantante teniendo en cuenta diferentes factores. 
    @return double, salario calculado del cantante 
     */
    @Override
    public double calcularSalario() {
        double salarioNuveo = super.getSalario();
        // Incrementa el salario en 300 si el cantante tiene más de 5 numero de composiciones
        if (this.numeroDeComposiciones > 5) {
            salarioNuveo += 300.0;
        }
        // Incrementa el salario en 0.10% si el cantante tiene más de 1 y menos de 3 canciones
        if (this.cancionesTop100Billboard.size() >= 1 && this.cancionesTop100Billboard.size() <= 3) {
            salarioNuveo *= 1.10;
            // Incrementa el salario en 0.20% si el cantante tiene más de 4 y menos de 6 canciones    
        } else if (this.cancionesTop100Billboard.size() >= 4 && this.cancionesTop100Billboard.size() <= 6) {
            salarioNuveo *= 1.20;
            // Incrementa el salario en 0.20% si el cantante tiene más de 6
        } else if (this.cancionesTop100Billboard.size() > 6) {
            salarioNuveo *= 1.20;
        }
        //Retorna el salario
        return salarioNuveo;
    }

    /*
    Metodo agregarCancion con los atributos de la clase Disco
     */
    public void agregarCancion(int codigo, String titulo, String letra, double tiempoEnMinutos) {
        Cancion cancion = new Cancion(codigo, titulo, letra, tiempoEnMinutos);
        //Agrega el cancion a la lista canciones
        this.cancionesTop100Billboard.add(cancion);
    }

    /*
    Metodo agregarCliente con los atributos de la clase Disco
     */
    public void agregarCliente(Cantante cliente) {
        //Agrega un cliente a la lista clientes
        this.clientes.add(cliente);
    }
    /*
    Metodo toString que devuelve de forma de string los atributos
     */
    @Override
    public String toString() {
        return "Compositor{" + "numeroDeComposiciones=" + numeroDeComposiciones + ", cancionesTop100Billboard=" + cancionesTop100Billboard + ", clientes=" + clientes  + '}';
    }
}
