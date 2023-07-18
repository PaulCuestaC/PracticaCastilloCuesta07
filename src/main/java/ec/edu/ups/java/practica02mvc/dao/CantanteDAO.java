/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.java.practica02mvc.dao;

import ec.edu.ups.java.practica02mvc.idao.ICantanteDAO;
import ec.edu.ups.java.practica02mvc.modelo.Cancion;
import ec.edu.ups.java.practica02mvc.modelo.Cantante;
import ec.edu.ups.java.practica02mvc.modelo.Disco;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ESTUDIANTE
 */
public class CantanteDAO implements ICantanteDAO {

    private String ruta;
    private List<Cantante> listaCantantes;

    public CantanteDAO() {
        listaCantantes = new ArrayList<>();
        ruta = "C:\\Users\\paulc\\OneDrive\\Desktop\\Practica07-main\\src\\main\\java\\ec\\edu\\ups\\java\\practica02mvc\\compositores.dat";
    }

    @Override
    public void create(Cantante cantante) {
        try {
            RandomAccessFile archivo = new RandomAccessFile(ruta, "rw");
            //Escribe desde el final del archivo
            archivo.seek(archivo.length());
            //Escribir en archivo binario
            String nombre = cantante.getNombre();
            String apellido = cantante.getApellido();
            String codigo = cantante.getCodigo();
            String numeroMusical = cantante.getGeneroMusical();
            String nacionalidad = cantante.getNacionalidad();
            String nombreArtistico = cantante.getNombreArtistico();
            int edad = cantante.getEdad();
            int numeroConciertos = cantante.getNumeroDeConciertos();
            int numeroGiras = cantante.getNumeroDeGiras();
            int numeroSencillos = cantante.getNumeroDeSencillos();
            double salario = cantante.getSalario();
            List<Disco> discografia = cantante.getDiscografia();
            if (nombre.length() < 25) {
                for (int i = nombre.length(); i < 25; i++) {
                    nombre = nombre + " ";
                }
            }
            //Rellena espacios hasta 25 caracteres en el apellido
            if (apellido.length() < 25) {
                for (int i = apellido.length(); i < 25; i++) {
                    apellido = apellido + " ";
                }
            }
            for (int i = 0; i < 10; i++) {
                discografia.get(i);

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CantanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    @Override
    public Cantante read(String cod) {

        for (Cantante cantante : listaCantantes) {
            if (cantante.getCodigo().equals(cod)) {
                return cantante;
            }
        }
        return null;
    }

    @Override
    public void update(Cantante cantante) {
        for (int i = 0; i < listaCantantes.size(); i++) {
            Cantante cantanteGuardada = listaCantantes.get(i);
            if (cantanteGuardada.getCodigo().equals(cantante.getCodigo())) {
                listaCantantes.set(i, cantante);
                break;
            }
        }
    }

    @Override
    public void delete(String cod) {
        for (int i = 0; i < listaCantantes.size(); i++) {
            Cantante personaGuardada = listaCantantes.get(i);
            if (personaGuardada.getCodigo().equals(cod)) {
                listaCantantes.remove(i);
                break;
            }
        }
    }

    public void agregarCancion(Disco disco) {

        Cantante cantante = new Cantante();

        cantante.AgregarDisco(disco);
    }

    @Override
    public List<Cantante> list() {
        return listaCantantes;
    }

}
