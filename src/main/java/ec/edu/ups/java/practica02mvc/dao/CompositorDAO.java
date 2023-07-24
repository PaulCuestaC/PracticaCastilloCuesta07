/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.java.practica02mvc.dao;

import ec.edu.ups.java.practica02mvc.idao.ICompositorDAO;
import ec.edu.ups.java.practica02mvc.modelo.Cancion;
import ec.edu.ups.java.practica02mvc.modelo.Cantante;
import ec.edu.ups.java.practica02mvc.modelo.Compositor;
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
public class CompositorDAO implements ICompositorDAO {

    private String ruta;
private Set<Compositor> lista;
private String rutaProyecto = System.getProperty("user.dir");
    private String nombreArchivo = "\\src\\main\\java\\ec\\edu\\ups\\java\\practica02mvc\\archivos\\compositores.dat";
    private String rutaCompleta = rutaProyecto + File.separator + nombreArchivo;
public CompositorDAO() {

ruta = rutaCompleta;
        
        }     
//       
  public void create(Compositor compositor) {
        try {
            RandomAccessFile archivo = new RandomAccessFile(ruta, "rw");
            
            //Escribe desde el final del archivo
            if (archivo.length() > 0) {
                archivo.seek(archivo.length());
                //Se crea un nuevo registro de un objeto "Compositor" y se escribe en un archivo binario
                String nombre = compositor.getNombre();
                String apellido = compositor.getApellido();
                int codigo = Integer.parseInt(compositor.getCodigo());
                int numeroComposiciones = compositor.getNumeroDeComposiciones();
                String nacionalidad = compositor.getNacionalidad();

                int edad = compositor.getEdad();
                double salario = compositor.getSalario();

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

                if (nacionalidad.length() < 25) {
                    for (int i = nombre.length(); i < 25; i++) {
                        nombre = nombre + " ";
                    }
                }
////guarda información sobre el compositor en un archivo de codigo, nombre, etc
                archivo.writeInt(codigo);
                archivo.writeUTF(nombre);
                archivo.writeUTF(apellido);
                archivo.writeInt(edad);
                archivo.writeInt(numeroComposiciones);
                archivo.writeUTF(nacionalidad);

                archivo.writeDouble(salario);
//agregamos nuevas canciones hasta que alcance 10 y si lo hace procede a 
////ejecutar otro codigo
                for (int i = 0; i < 10; i++) {
                    Cancion cancion = new Cancion();
                    String cancionN = "";

                    for (int j = 0; j < 25; j++) {
                        cancionN = cancionN + " ";
                    }

                    String letra = null;

                    for (int j = 0; j < 25; j++) {
                        letra = letra + " ";
                    }
                    int codigoD = 0;
                    double tiempo = 0;
                    archivo.writeInt(codigoD);
                    archivo.writeUTF(cancionN);
                    archivo.writeDouble(tiempo);
                    archivo.writeUTF(letra);

                }

                for (int i = 0; i < 10; i++) {
                    Cantante cantante = new Cantante();
                    String clienteN = "";

                    for (int j = 0; j < 25; j++) {
                        clienteN = clienteN + " ";
                    }

                    archivo.writeUTF(clienteN);
                }

                archivo.close();

            } else {
                archivo.seek(0);
                //Escribir en archivo binario
                String nombre = compositor.getNombre();
                String apellido = compositor.getApellido();
                int codigo = Integer.parseInt(compositor.getCodigo());
                int numeroComposiciones = compositor.getNumeroDeComposiciones();
                String nacionalidad = compositor.getNacionalidad();

                int edad = compositor.getEdad();
                double salario = compositor.getSalario();

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

                if (nacionalidad.length() < 25) {
                    for (int i = nombre.length(); i < 25; i++) {
                        nombre = nombre + " ";
                    }
                }

                archivo.writeInt(codigo);
                archivo.writeUTF(nombre);
                archivo.writeUTF(apellido);
                archivo.writeInt(edad);
                archivo.writeInt(numeroComposiciones);
                archivo.writeUTF(nacionalidad);

                archivo.writeDouble(salario);
//si la lista tiene menos  de 10 elementos se agregan nuevas instancias de Cantante 
                for (int i = 0; i < 10; i++) {
                    Cancion cancion = new Cancion();
                    String cancionN = "";

                    for (int j = 0; j < 25; j++) {
                        cancionN = cancionN + " ";
                    }

                    String letra = "";

                    for (int j = 0; j < 25; j++) {
                        letra = letra + " ";
                    }
                    int codigoD = 0;
                    double tiempo = 0;
                    archivo.writeInt(codigoD);
                    archivo.writeUTF(cancionN);
                    archivo.writeDouble(tiempo);
                    archivo.writeUTF(letra);

                }

                for (int i = 0; i < 10; i++) {
                    Cantante cantante = new Cantante();
                    String clienteN = "";

                    for (int j = 0; j < 25; j++) {
                        clienteN = clienteN + " ";
                    }

                    archivo.writeUTF(clienteN);
                }

                archivo.close();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CantanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    @Override
    public Compositor read(String cod) throws Exception {
        
////Se lee los datos de un "Compositor" almacenado en un archivo binario, 
////utilizando un código específico para ubicar el registro en el archivo
        int cod2 = Integer.parseInt(cod);
        cod2 = cod2 - 1;
        cod2 = cod2 * 1004;
        Compositor p = new Compositor();
        try {
            RandomAccessFile archivo = new RandomAccessFile(ruta, "r");
            archivo.seek(cod2);

            //Leer archivo binario
            archivo.seek(cod2);
            if (archivo.readUTF() != null) {
                archivo.seek(cod2);
                p.setNombre(archivo.readUTF().trim());
                archivo.seek(cod2 + 31);
                p.setApellido(archivo.readUTF().trim());
                archivo.seek(cod2 + 58);

                p.setEdad(archivo.readInt());
                archivo.seek(cod2 + 62);
                p.setNumeroDeComposiciones(archivo.readInt());
                archivo.seek(cod2 + 66);
                p.setNacionalidad(archivo.readUTF());
                archivo.seek(cod2 + 93);
                p.setSalario(archivo.readDouble());
                archivo.seek(cod2 + 101);

                for (int j = 0; j < 10; j++) {
                    archivo.seek(cod2 + (66 * j) + 101);
                    Cancion cancion = new Cancion();
                    cancion.setCodigo(archivo.readInt());
                    archivo.seek(cod2 + (66 * j) + 105);
                    cancion.setTitulo(archivo.readUTF());
                    archivo.seek(cod2 + (66 * j) + 132);
                    cancion.setTiempoEnMinutos(archivo.readDouble());
                    archivo.seek(cod2 + (66 * j) + 140);
                    cancion.setLetra(archivo.readUTF());
                    p.AgregarCancion(cancion);

                }
                for (int j = 0; j < 10; j++) {
                    archivo.seek(cod2 + (27 * j) + 734);
                    Cantante cantante = new Cantante();
                    cantante.setNombreArtistico(archivo.readUTF());
                    p.agregarCliente(cantante);
                }
                archivo.close();
                return p;
            } else {
                JOptionPane.showMessageDialog(null, "El Cantante No existe");
                return null;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        } catch (IOException ex) {
            System.out.println("Error de escritura");;
        }
        return p;

    }

    @Override
    public void update(Compositor compositor, int cod2) {
////Actualiza los datos de un "Compositor" en un archivo binario
////calcula la posición en el archivo basada en el valor "cod2"
////lee el contenido del registro en esa posición para verificar si existe algún dato en él
////Si encuentra datos válidos, obtiene la información actualizada del objeto "Compositor"
//
        try {
            RandomAccessFile archivo = new RandomAccessFile(ruta, "rw");
            //Escribe desde el final del archivo
            cod2 = cod2 - 1;
            cod2 = cod2 * 1004;
            archivo.seek(cod2);
            //Escribir en archivo binario
            if (archivo.readUTF() != null) {
                String nombre = compositor.getNombre();
                String apellido = compositor.getApellido();
                int codigo = Integer.parseInt(compositor.getCodigo());
                int numeroComposiciones = compositor.getNumeroDeComposiciones();
                String nacionalidad = compositor.getNacionalidad();

                int edad = compositor.getEdad();
                double salario = compositor.getSalario();

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

                if (nacionalidad.length() < 25) {
                    for (int i = nombre.length(); i < 25; i++) {
                        nombre = nombre + " ";
                    }
                }

                archivo.writeInt(codigo);
                archivo.writeUTF(nombre);
                archivo.writeUTF(apellido);
                archivo.writeInt(edad);
                archivo.writeInt(numeroComposiciones);
                archivo.writeUTF(nacionalidad);

                archivo.writeDouble(salario);

                for (int i = 0; i < 10; i++) {
                    Cancion cancion = new Cancion();
                    String cancionN = "";

                    for (int j = 0; j < 25; j++) {
                        cancionN = cancionN + " ";
                    }

                    String letra = null;

                    for (int j = 0; j < 25; j++) {
                        letra = letra + " ";
                    }
                    int codigoD = 0;
                    double tiempo = 0;
                    archivo.writeInt(codigoD);
                    archivo.writeUTF(cancionN);
                    archivo.writeDouble(tiempo);
                    archivo.writeUTF(letra);

                }

                for (int i = 0; i < 10; i++) {
                    Cantante cantante = new Cantante();
                    String clienteN = "";

                    for (int j = 0; j < 25; j++) {
                        clienteN = clienteN + " ";
                    }

                    archivo.writeUTF(clienteN);
                }

                archivo.close();

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CantanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    @Override
    public void delete(String cod) {
//el código proporcionado ("cod") es para calcular la posición en el archivo
//donde se encuentra el registro a eliminar. Se verifica si el registro 
//contiene datos válidos.Si el registro ya está vacío  se muestra que la 
//persona ya no existe.De lo contrario, escribe espacios en blanco en el 
//registro para eliminar los datos y cierra el archivo.
        try {
            int pos = Integer.parseInt(cod);
            RandomAccessFile archivo = new RandomAccessFile(ruta, "rw");
            pos = pos - 1;
            pos = pos * 1004;
            archivo.seek(pos);
            String vacio = " ";
            for (int i = 1; i < 1004; i++) {
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

    @Override
    public Set<Compositor> getLista() throws Exception {
        lista = new HashSet<Compositor>();
        try {
            RandomAccessFile archivo = new RandomAccessFile(ruta, "rw");
            long registros = archivo.length() / 1027;
            System.out.println("numero de registros: " + registros);
            int pos = 0;
            String vacio = " ";
            for (int i = 1; i < 1027; i++) {
                vacio = vacio + " ";
            }
            for (int i = 0; i < registros; i++) {
                pos = i;
                pos = pos * 1027;
                archivo.seek(pos);
                Compositor p = new Compositor();
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
                    p.setNacionalidad(archivo.readUTF());
                    archivo.seek(pos + 89);
                    p.setNacionalidad(archivo.readUTF());
                    archivo.seek(pos + 116);
                    p.setSalario(archivo.readDouble());
                    archivo.seek(pos + 124);

                    for (int j = 0; j < 10; j++) {
                        archivo.seek(pos + (66 * j) + 124);
                        Cancion cancion = new Cancion();
                        cancion.setCodigo(archivo.readInt());
                        archivo.seek(pos + (66 * j) + 128);
                        cancion.setTitulo(archivo.readUTF());
                        archivo.seek(pos + (66 * j) + 155);
                        cancion.setTiempoEnMinutos(archivo.readDouble());
                        archivo.seek(pos + (66 * j) + 163);
                        cancion.setLetra(archivo.readUTF());
                        p.AgregarCancion(cancion);

                    }
                    for (int j = 0; j < 10; j++) {
                        archivo.seek(pos + (27 * j) + 784);
                        Cantante cantante = new Cantante();
                        cantante.setNombreArtistico(archivo.readUTF());
                        p.agregarCliente(cantante);
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

     public void agregarCancion(Compositor compositor, int codigo) {
        List<Cancion> canciones = compositor.getCancionesTop100Billboard();
        try {

            RandomAccessFile archivo = new RandomAccessFile(ruta, "rw");
            int cod2 = Integer.parseInt(compositor.getCodigo());
           

            archivo.seek(cod2 + (66 *codigo) + 101);
            Cancion cancion = canciones.get(codigo);
            int codigo2 = cancion.getCodigo();
            archivo.writeInt(codigo2);
            archivo.seek(cod2 + (66 * codigo) + 105);
            String titulo = cancion.getTitulo();
            archivo.writeUTF(titulo);
            archivo.seek(cod2 + (66 * codigo) + 132);
            double tiempo = cancion.getTiempoEnMinutos();
            archivo.writeDouble(tiempo);
            archivo.seek(cod2 + (66 * codigo) + 140);
            String letra = cancion.getLetra();
            archivo.writeUTF(letra);

    }
    catch (FileNotFoundException ex

        ) {
            Logger.getLogger(CompositorDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    catch (IOException ex

    
        ) {
            Logger.getLogger(CompositorDAO.class.getName()).log(Level.SEVERE, null, ex);
    }

}

}
