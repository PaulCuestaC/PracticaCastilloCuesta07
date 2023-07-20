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
    public CompositorDAO() {

        ruta = "C:\\Users\\paulc\\OneDrive\\Desktop\\Practica07-main\\src\\main\\java\\ec\\edu\\ups\\java\\practica02mvc\\compositores.dat";
    }

    @Override
    public void create(Compositor compositor) {
        try {
            RandomAccessFile archivo = new RandomAccessFile(ruta, "rw");
            //Escribe desde el final del archivo
            archivo.seek(archivo.length());
            //Escribir en archivo binario
            String nombre = compositor.getNombre();
            String apellido = compositor.getApellido();
            int codigo = Integer.parseInt(compositor.getCodigo());
            int numeroComposiciones = compositor.getNumeroDeComposiciones();
            String nacionalidad = compositor.getNacionalidad();

            int edad = compositor.getEdad();
            double salario = compositor.getSalario();
            List<Cancion> canciones = compositor.getCancionesTop100Billboard();
            List<Cantante> cliente = compositor.getClientes();
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

            archivo.writeUTF(nacionalidad);

            archivo.writeDouble(salario);
            if (canciones.size() < 10) {
                for (int i = canciones.size() + 1; i < 10; i++) {
                    Cancion e = new Cancion();

                    canciones.add(e);
                }
            }
            for (int i = 0; i < 10; i++) {
                Cancion cancion = canciones.get(i);
                String cancionN = cancion.getTitulo();
                if (cancionN.length() < 25) {
                    for (int j = cancionN.length(); j < 25; j++) {
                        cancionN = cancionN + " ";
                    }
                }
                String letra = cancion.getLetra();
                if (letra.length() < 25) {
                    for (int j = letra.length(); j < 25; j++) {
                        letra = letra + " ";
                    }
                }

                archivo.writeInt(cancion.getCodigo());
                archivo.writeUTF(cancionN);
                archivo.writeDouble(cancion.getTiempoEnMinutos());
                archivo.writeUTF(letra);

            }
            if (cliente.size() < 10) {
                for (int i = cliente.size() + 1; i < 10; i++) {
                    Cantante e = new Cantante();

                    cliente.add(e);
                }
            }
            for (int i = 0; i < 10; i++) {
                Cantante cantante = cliente.get(i);
                String clienteN = cantante.getNombreArtistico();
                if (clienteN.length() < 25) {
                    for (int j = clienteN.length(); j < 25; j++) {
                        clienteN = clienteN + " ";
                    }
                }

                archivo.writeUTF(clienteN);
            }

            archivo.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CantanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    @Override
    public Compositor read(String cod) throws Exception {
        int cod2 = Integer.parseInt(cod);
        cod2 = cod2 - 1;
        cod2 = cod2 * 1027;

        try {
            RandomAccessFile archivo = new RandomAccessFile(ruta, "rw");
            archivo.seek(cod2);
            Compositor p = new Compositor();
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
                p.setNacionalidad(archivo.readUTF());
                archivo.seek(cod2 + 89);
                p.setNacionalidad(archivo.readUTF());
                archivo.seek(cod2 + 116);
                p.setSalario(archivo.readDouble());
                archivo.seek(cod2 + 124);

                for (int j = 0; j < 10; j++) {
                    archivo.seek(cod2 + (66 * j) + 124);
                    Cancion cancion = new Cancion();
                    cancion.setCodigo(archivo.readInt());
                    archivo.seek(cod2 + (66 * j) + 128);
                    cancion.setTitulo(archivo.readUTF());
                    archivo.seek(cod2 + (66 * j) + 155);
                    cancion.setTiempoEnMinutos(archivo.readDouble());
                    archivo.seek(cod2 + (66 * j) + 163);
                    cancion.setLetra(archivo.readUTF());
                    p.AgregarCancion(cancion);

                }
                for (int j = 0; j < 10; j++) {
                    archivo.seek(cod2 + (27 * j) + 784);
                    Cantante cantante = new Cantante();
                    cantante.setNombreArtistico(archivo.readUTF());
                    p.agregarCliente(cantante);
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
        return null;

    }

    @Override
    public void update(Compositor compositor, int cod2) {

        try {
            RandomAccessFile archivo = new RandomAccessFile(ruta, "rw");
            //Escribe desde el final del archivo
            cod2 = cod2 - 1;
            cod2 = cod2 * 1027;
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
                List<Cancion> canciones = compositor.getCancionesTop100Billboard();
                List<Cantante> cliente = compositor.getClientes();
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

                archivo.writeUTF(nacionalidad);

                archivo.writeDouble(salario);
                if (canciones.size() < 10) {
                    for (int i = canciones.size() + 1; i < 10; i++) {
                        Cancion e = new Cancion();

                        canciones.add(e);
                    }
                }
                for (int i = 0; i < 10; i++) {
                    Cancion cancion = canciones.get(i);
                    String cancionN = cancion.getTitulo();
                    if (cancionN.length() < 25) {
                        for (int j = cancionN.length(); j < 25; j++) {
                            cancionN = cancionN + " ";
                        }
                    }
                    String letra = cancion.getLetra();
                    if (letra.length() < 25) {
                        for (int j = letra.length(); j < 25; j++) {
                            letra = letra + " ";
                        }
                    }

                    archivo.writeInt(cancion.getCodigo());
                    archivo.writeUTF(cancionN);
                    archivo.writeDouble(cancion.getTiempoEnMinutos());
                    archivo.writeUTF(letra);

                }
                if (cliente.size() < 10) {
                    for (int i = cliente.size() + 1; i < 10; i++) {
                        Cantante e = new Cantante();

                        cliente.add(e);
                    }
                }
                for (int i = 0; i < 10; i++) {
                    Cantante cantante = cliente.get(i);
                    String clienteN = cantante.getNombreArtistico();
                    if (clienteN.length() < 25) {
                        for (int j = clienteN.length(); j < 25; j++) {
                            clienteN = clienteN + " ";
                        }
                    }

                    archivo.writeUTF(clienteN);
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
        try {
            int pos = Integer.parseInt(cod);
            RandomAccessFile archivo = new RandomAccessFile(ruta, "rw");
            pos = pos - 1;
            pos = pos * 1027;
            archivo.seek(pos);
            String vacio = " ";
            for (int i = 1; i < 1027; i++) {
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

}
