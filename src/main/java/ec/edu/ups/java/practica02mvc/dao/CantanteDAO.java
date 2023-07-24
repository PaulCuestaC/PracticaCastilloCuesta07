/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//Cantante dao 2
package ec.edu.ups.java.practica02mvc.dao;

import ec.edu.ups.java.practica02mvc.idao.ICantanteDAO;
import ec.edu.ups.java.practica02mvc.modelo.Cantante;
import ec.edu.ups.java.practica02mvc.modelo.Disco;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ESTUDIANTE
 */
public class CantanteDAO implements ICantanteDAO {

    private String ruta;

    private Set<Cantante> lista;
    private String rutaProyecto = System.getProperty("user.dir");
    private String nombreArchivo = "\\src\\main\\java\\ec\\edu\\ups\\java\\practica02mvc\\archivos\\cantates.dat";
    private String rutaCompleta = rutaProyecto + File.separator + nombreArchivo;

    public CantanteDAO() {

        ruta = rutaCompleta;
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
            if (numeroMusical.length() < 25) {
                for (int i = nombre.length(); i < 25; i++) {
                    nombre = nombre + " ";
                }
            }
            if (nacionalidad.length() < 25) {
                for (int i = nombre.length(); i < 25; i++) {
                    nombre = nombre + " ";
                }
            }
            if (nombreArtistico.length() < 25) {
                for (int i = nombre.length(); i < 25; i++) {
                    nombre = nombre + " ";
                }
            }
//guarda información sobre el cantante en un archivo de codigo, edad,etc.
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
            if (discografia.size() < 10) {
                //si hay menos de 10 elementos en la lista), el código realiza un bucle "for"                
                for (int i = discografia.size() + 1; i < 10; i++) {
                    //Agregar discos adicionales a la lista hasta que alcance 
                    //un total de 10 elementos.
                    Disco e = new Disco();
                    discografia.add(e);
                }
            }

            for (int i = 0; i < 10; i++) {
//asegurar que el nombre de cada disco en la lista "discografia" tenga 
//una longitud de exactamente 25 caracteres y si es mas corto se llena de espacios
                Disco disco = discografia.get(i);
                String discoN = disco.getNombre();
                if (discoN.length() < 25) {
                    for (int j = discoN.length(); j < 25; j++) {
                        discoN = discoN + "";
                    }
                }
                archivo.writeInt(disco.getCodigo());
                archivo.writeUTF(discoN);
                archivo.writeInt(disco.getAnioDeLanzamiento());

            }

            archivo.close();

        } catch (FileNotFoundException ex) {
            //el archivo no se encontro
            Logger.getLogger(CantanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex);
        }
    }

    @Override
    public Cantante read(String cod) throws Exception {
        int cod2 = Integer.parseInt(cod);
        cod2 = cod2 - 1;
        cod2 = cod2 * 517;
        Cantante p = new Cantante();
        try {
//abrir un archivo en modo de lectura y escritura y luego se posiciona en una ubicación 
//específica en ese archivo
            RandomAccessFile archivo = new RandomAccessFile(ruta, "rw");
          

            //Leer archivo binario
            archivo.seek(cod2);
            if (archivo.readUTF() != null) {
//abrir un archivo en modo de lectura y escritura y luego se posiciona en una ubicación 
//específica en ese archivo
                archivo.seek(cod2);
                p.setNombre(archivo.readUTF().trim());
                
                p.setApellido(archivo.readUTF().trim());
                

                p.setEdad(archivo.readInt());
                
                p.setGeneroMusical(archivo.readUTF());
                
                p.setNacionalidad(archivo.readUTF());
               
                p.setNombreArtistico(archivo.readUTF());
                
                p.setNumeroDeConciertos(archivo.readInt());
               
                p.setNumeroDeGiras(archivo.readInt());
                
                p.setNumeroDeSencillos(archivo.readInt());
                
                p.setSalario(archivo.readDouble());
             
       

                for (int j = 0; j < 10; j++) {
//leemos datos de un archivo binario, y calculamos la posicion dentro del archivo
//para cada discoo
                    
                    Disco disco = new Disco();
                    disco.setCodigo(archivo.readInt());
                  
                    disco.setNombre(archivo.readUTF());
                   
                    disco.setAnioDeLanzamiento(archivo.readInt());
                    p.AgregarDisco(disco);
                }

                archivo.close();
                return p;
            } else {
                JOptionPane.showMessageDialog(null, "El Cantante No existe");

            }
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        } catch (IOException ex) {
            System.out.println("Error de escritura");;
        }
        return p;

    }

    @Override
    public void update(Cantante cantante, int pos) {

        try {
            RandomAccessFile archivo = new RandomAccessFile(ruta, "rw");
            //Escribe desde el final del archivo
            pos = pos - 1;
            pos = pos * 517;
            archivo.seek(pos);
            //Escribir en archivo binario
            if (archivo.readUTF() != null) {
                archivo.seek(pos);
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
                if (numeroMusical.length() < 25) {
                    for (int i = nombre.length(); i < 25; i++) {
                        nombre = nombre + " ";
                    }
                }
                if (nacionalidad.length() < 25) {
                    for (int i = nombre.length(); i < 25; i++) {
                        nombre = nombre + " ";
                    }
                }
                if (nombreArtistico.length() < 25) {
                    for (int i = nombre.length(); i < 25; i++) {
                        nombre = nombre + " ";
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
                if (discografia.size() < 10) {
                    for (int i = discografia.size() + 1; i < 10; i++) {
                        Disco e = new Disco();

                        discografia.add(e);
                    }
                }
                for (int i = 0; i < 10; i++) {
                    Disco disco = discografia.get(i);
                    String discoN = disco.getNombre();
                    if (discoN.length() < 25) {
                        for (int j = discoN.length(); j < 25; j++) {
                            discoN = discoN + "";
                        }
                    }
                    archivo.writeInt(disco.getCodigo());
                    archivo.writeUTF((disco.getNombre()));
                    archivo.writeInt(disco.getAnioDeLanzamiento());

                }

                archivo.close();
            } else {
                JOptionPane.showMessageDialog(null, "La persona No existe");
            }
        } catch (FileNotFoundException ex9) {
            System.out.println("Archivo no encontrado");
        } catch (IOException ex10) {
            System.out.println("Error de escritura");;
        }

    }

    @Override
    public void delete(String cod) {
//eliminar un registro de información en un archivo binario utilizando un 
//enfoque de "marcaje" del registro
        try {
            int pos = Integer.parseInt(cod);
            RandomAccessFile archivo = new RandomAccessFile(ruta, "rw");
            pos = pos - 1;
            pos = pos * 517;
            archivo.seek(pos);
            String vacio = " ";
            for (int i = 1; i < 517; i++) {
                vacio = vacio + " ";
            }
            String v = archivo.readUTF();
            if (v.equals(vacio)) {
                JOptionPane.showMessageDialog(null, "La persona Ya No Existe");

            } else {
                archivo.seek(pos);
                archivo.writeUTF(vacio);

                archivo.close();

            }

        } catch (FileNotFoundException ex9) {
            System.out.println("Archivo no encontrado");
        } catch (IOException ex10) {
            System.out.println("Error de escritura");;
        }

    }

    public Set<Cantante> getLista() throws Exception {
//leemos datos de varios registros de cantantes almacenados en un archivo binario
        lista = new HashSet<Cantante>();
        try {
            RandomAccessFile archivo = new RandomAccessFile(ruta, "rw");
            long registros = archivo.length() / 517;
            System.out.println("numero de registros: " + registros);
            int pos = 0;
            String vacio = " ";
            for (int i = 1; i < 517; i++) {
                vacio = vacio + " ";
            }
            for (int i = 0; i < registros; i++) {
                pos = i;
                pos = pos * 517;
                archivo.seek(pos);
                Cantante p = new Cantante();
                String v = archivo.readUTF();
                if (v.equals(vacio)) {

                } else {
                    archivo.seek(pos);
                    p.setNombre(archivo.readUTF().trim());
                    archivo.seek(pos + 31);
                    p.setApellido(archivo.readUTF().trim());
                    archivo.seek(pos + 58);

                    p.setEdad(archivo.readInt());
                    archivo.seek(pos + 62);
                    p.setGeneroMusical(archivo.readUTF());
                    archivo.seek(pos + 89);
                    p.setNacionalidad(archivo.readUTF());
                    archivo.seek(pos + 116);
                    p.setNombreArtistico(archivo.readUTF());
                    archivo.seek(pos + 143);
                    p.setNumeroDeConciertos(archivo.readInt());
                    archivo.seek(pos + 147);
                    p.setNumeroDeGiras(archivo.readInt());
                    archivo.seek(pos + 151);
                    p.setNumeroDeSencillos(archivo.readInt());
                    archivo.seek(pos + 155);
                    p.setSalario(archivo.readDouble());
                    archivo.seek(pos + 163);
                    List<Disco> discografiando;

                    for (int j = 0; j < 10; j++) {
                        archivo.seek(pos + (35 * j) + 163);
                        Disco disco = new Disco();
                        disco.setCodigo(archivo.readInt());
                        archivo.seek(pos + (35 * j) + 167);
                        disco.setNombre(archivo.readUTF());
                        archivo.seek(pos + (35 * j) + 194);
                        disco.setAnioDeLanzamiento(archivo.readInt());
                        lista.add(p);
                    }

                }
            }
            archivo.close();
            return lista;
        } catch (FileNotFoundException ex9) {
            System.out.println("Archivo no encontrado");
        } catch (IOException ex10) {
            System.out.println("Error de escritura");;
        }
        return null;
    }

}
