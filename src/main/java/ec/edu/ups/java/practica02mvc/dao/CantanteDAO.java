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
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Date;
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
        ruta = "src\\main\\java\\ec\\edu\\ups\\java\\practica02mvc\\compositores.dat";
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
            int codigo = Integer.parseInt(cantante.getCodigo());
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

            archivo.writeInt(codigo);
            archivo.writeUTF(nombre);
            archivo.writeUTF(apellido);
            archivo.writeInt(edad);
            archivo.writeUTF(numeroMusical);
            archivo.writeUTF(nacionalidad);
            archivo.writeUTF(nombreArtistico);
            archivo.writeInt(numeroConciertos);
            archivo.writeInt(numeroGiras);
            archivo.writeInt(numeroSencillos);
            archivo.writeDouble(salario);
            for (int i = 0; i < 10; i++) {
                Disco disco = discografia.get(i);
                archivo.writeInt(disco.getCodigo());
                archivo.writeUTF((disco.getNombre()));
                archivo.writeInt(disco.getAnioDeLanzamiento());

            }

            archivo.close();
  
           
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CantanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    @Override
    public Cantante read(String cod) {
//        int cod2 = Integer.parseInt(cod);
//        cod2=cod2-1;
//           cod2=cod2*152;
//           
//           try{
//        RandomAccessFile archivo=new RandomAccessFile(ruta,"rw");
//        archivo.seek(cod2);
//        Cantante p=new Cantante();
//        //Leer archivo binario
//        archivo.seek(cod2);
//         if(archivo.readUTF()!=null){
//        archivo.seek(cod2);     
//        p.setNombre(archivo.readUTF().trim());
//        archivo.seek(cod2+31);
//        p.setApellido(archivo.readUTF().trim());
//        archivo.seek(cod2+58);
//
//        p.setEdad(archivo.readInt());
//        archivo.seek(cod2+120);
//        String fecha=archivo.readUTF();
//        Date fecha1=formatter.parse(fecha);
//        p.setFechaNacimiento(fecha1);
//        archivo.seek(pos+132);
//        p.setNumeroTelefono(archivo.readUTF());
//        archivo.seek(pos+144);
//        p.setSalario(archivo.readDouble());
//        archivo.close();
//        return p;
//         }else{
//            JOptionPane.showMessageDialog (null,"La persona No existe");
//                 
//        }
//        }catch(FileNotFoundException ex){
//            System.out.println("Archivo no encontrado");
//        } catch (IOException ex) {
//            System.out.println("Error de escritura");;
//        }
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
