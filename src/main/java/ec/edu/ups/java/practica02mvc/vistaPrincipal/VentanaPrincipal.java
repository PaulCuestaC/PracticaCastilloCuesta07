/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ec.edu.ups.java.practica02mvc.vistaPrincipal;

import ec.edu.ups.java.practica02mvc.controlador.ControladorCantante;
import ec.edu.ups.java.practica02mvc.controlador.ControladorCompositor;
import ec.edu.ups.java.practica02mvc.dao.CantanteDAO;
import ec.edu.ups.java.practica02mvc.dao.CompositorDAO;
import ec.edu.ups.java.practica02mvc.idao.ICantanteDAO;
import ec.edu.ups.java.practica02mvc.idao.ICompositorDAO;
import ec.edu.ups.java.practica02mvc.vista.Compositor.VentanaActualizarCompositor;
import ec.edu.ups.java.practica02mvc.vista.Compositor.VentanaBuscarCompositor;
import ec.edu.ups.java.practica02mvc.vista.Compositor.VentanaCrearCompositor;
import ec.edu.ups.java.practica02mvc.vista.Compositor.VentanaEliminarCompositor;
import ec.edu.ups.java.practica02mvc.vista.Compositor.VentanaListarCompositor;
import ec.edu.ups.java.practica02mvc.vista.cancion.VentanaActualizarCancion;
import ec.edu.ups.java.practica02mvc.vista.cancion.VentanaBuscarCancion;
import ec.edu.ups.java.practica02mvc.vista.cancion.VentanaCrearCancion;
import ec.edu.ups.java.practica02mvc.vista.cancion.VentanaEliminarCancion;
import ec.edu.ups.java.practica02mvc.vista.cancion.VentanaListarCancion;
import ec.edu.ups.java.practica02mvc.vista.disco.VentanaActualizarDisco;
import ec.edu.ups.java.practica02mvc.vista.disco.VentanaBuscarDisco;
import ec.edu.ups.java.practica02mvc.vista.disco.VentanaCrearDisco;
import ec.edu.ups.java.practica02mvc.vista.disco.VentanaEliminarDisco;
import ec.edu.ups.java.practica02mvc.vista.disco.VentanaListarDisco;
import ec.edu.ups.java.practica02mvc.vistaCantante.VentanaActualizarCantante;
import ec.edu.ups.java.practica02mvc.vistaCantante.VentanaBuscarCantante;
import ec.edu.ups.java.practica02mvc.vistaCantante.VentanaCrearCantante;
import ec.edu.ups.java.practica02mvc.vistaCantante.VentanaEliminarCantante;
import ec.edu.ups.java.practica02mvc.vistaCantante.VentanaListarCantante;
import java.awt.Graphics;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;

/**
 *
 * @author ESTUDIANTE
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    private VentanaCrearCompositor ventanaCrearCompositor;
    private VentanaCrearCantante ventanaCrearCantante;
    private VentanaCrearDisco ventanaCrearDisco;
    private VentanaCrearCancion ventanaCrearCancion;
    private VentanaActualizarCompositor ventanaActualizarCompositor;
    private VentanaActualizarCantante ventanaActualizarCantante;
    private VentanaActualizarCancion ventanaActualizarCancion;
    private VentanaActualizarDisco ventanaActualizarDisco;
    private VentanaEliminarCompositor ventanaEliminarCompositor;
    private VentanaEliminarCantante ventanaEliminarCantante;
    private VentanaEliminarCancion ventanaEliminarCancion;
    private VentanaEliminarDisco ventanaEliminarDisco;
    private VentanaBuscarCompositor ventanaBuscarCompositor;
    private VentanaBuscarCantante ventanaBuscarCantante;
    private VentanaBuscarCancion ventanaBuscarCancion;
    private VentanaBuscarDisco ventanaBuscarDisco;
    private VentanaListarCompositor ventanaListarCompositor;
    private VentanaListarCantante ventanaListarCantante;
    private VentanaListarCancion ventanaListarCancion;
    private VentanaListarDisco ventanaListarDisco;

    private ControladorCompositor controladorCompositor;
    private ControladorCantante controladorCantante;

    private ICompositorDAO compositorDAO;
    private ICantanteDAO cantanteDAO;
    //Internacionalización
    private Locale localizacion;
    private ResourceBundle mensajes;
    
    
    
    
    
    
    
    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        compositorDAO = new CompositorDAO();
        cantanteDAO = new CantanteDAO();
        controladorCompositor = new ControladorCompositor((CompositorDAO) compositorDAO);
        controladorCantante = new ControladorCantante(cantanteDAO);
        localizacion = Locale.getDefault();
        cambiarIdioma();
        agregarFondo();
        
    }
    private void agregarFondo() {
        // Obtenemos la ruta de la imagen de fondo desde la carpeta "imagenes".
        String imagePath = "‪C:\\Users\\Personal\\Documents\\NetBeansProjects\\PracticaCastilloCuesta07\\src\\main\\Imagenes\\FondoPrincipal.jpg";

        // Creamos un JLabel para contener la imagen de fondo.
        JLabel fondoPrincipalLabel = new JLabel(new ImageIcon(imagePath));

        // Establecemos el tamaño y la posición del JLabel para que cubra toda la ventana.
        fondoPrincipalLabel.setBounds(0, 0, desktopPane.getWidth(), desktopPane.getHeight());

        // Agregamos el JLabel al JDesktopPane.       
        desktopPane.add(fondoPrincipalLabel);

        // Aseguramos que el JLabel esté detrás de todos los demás componentes del JDesktopPane.
        desktopPane.setComponentZOrder(fondoPrincipalLabel, 0);
    }
    
    
    private void cambiarIdioma() {
        mensajes = ResourceBundle.getBundle("mensajes.mensaje", localizacion);

        menuCompositor.setText(mensajes.getString("menu.compositor"));

        jMenuItemCrearCompositor.setText(mensajes.getString("jMenuItem.crearCompositor"));
        jMenuItemBuscarCompositor.setText(mensajes.getString("jMenuItem.buscarCompositor"));
        jMenuItemActualizarCompositor.setText(mensajes.getString("jMenuItem.actualizarCompositor"));
        jMenuItemEliminarCompositor.setText(mensajes.getString("jMenuItem.eliminarCompositor"));
        jMenuItemListarCompositor.setText(mensajes.getString("jMenuItem.listarCompositor"));

        menuCantante.setText(mensajes.getString("menu.cantante"));

        jMenuItemCrearCantante.setText(mensajes.getString("jMenuItem.crearCantante"));
        jMenuItemBuscareCantante.setText(mensajes.getString("jMenuItem.buscarCantante"));
        jMenuItemActualizarCantante.setText(mensajes.getString("jMenuItem.actualizarCantante"));
        jMenuItemEliminarCantante.setText(mensajes.getString("jMenuItem.eliminarCantante"));
        jMenuItemListarCantante.setText(mensajes.getString("jMenuItem.listarCantante"));

        menuCancion.setText(mensajes.getString("menu.cancion"));

        jMenuItemCrearCancion.setText(mensajes.getString("jMenuItem.crearCancion"));
        jMenuItemBuscarCancion.setText(mensajes.getString("jMenuItem.buscarCancion"));
        jMenuItemActualizarCancion.setText(mensajes.getString("jMenuItem.actualizarCancion"));
        jMenuItemEliminarCancion.setText(mensajes.getString("jMenuItem.eliminarCancion"));
        jMenuItemListarCancion.setText(mensajes.getString("jMenuItem.listarCancion"));

        menuDisco.setText(mensajes.getString("menu.disco"));

        jMenuItemCrearDisco.setText(mensajes.getString("jMenuItem.crearDisco"));
        jMenuItemBuscarDisco.setText(mensajes.getString("jMenuItem.buscarDisco"));
        jMenuItemActualizarDisco.setText(mensajes.getString("jMenuItem.actualizarDisco"));
        jMenuItemEliminarDisco.setText(mensajes.getString("jMenuItem.eliminarDisco"));
        jMenuItemListarDisco.setText(mensajes.getString("jMenuItem.listarDisco"));

        menuIdiomas.setText(mensajes.getString("menu.idiomas"));

        jMenuItemEspañol.setText(mensajes.getString("jMenuItem.español"));
        jMenuItemIngles.setText(mensajes.getString("jMenuItem.ingles"));
        jMenuItemFrances.setText(mensajes.getString("jMenuItem.frances"));
        
        menuMenu.setText(mensajes.getString("menu.menu"));

        jMenuItemSalir.setText(mensajes.getString("jMenuItem.salir"));
                
        
        //Compositor
        if (ventanaCrearCompositor != null) {
            ventanaCrearCompositor.cambiarIdioma(localizacion);
        }
        if (ventanaBuscarCompositor != null) {
            ventanaBuscarCompositor.cambiarIdioma(localizacion);
        }
        if (ventanaActualizarCompositor != null) {
            ventanaActualizarCompositor.cambiarIdioma(localizacion);
        }
        if (ventanaEliminarCompositor != null) {
            ventanaEliminarCompositor.cambiarIdioma(localizacion);
        }

        //Cantante
        if (ventanaCrearCantante != null) {
            ventanaCrearCantante.cambiarIdioma(localizacion);
        }
        if (ventanaBuscarCantante != null) {
            ventanaBuscarCantante.cambiarIdioma(localizacion);
        }
        if (ventanaActualizarCantante != null) {
            ventanaActualizarCantante.cambiarIdioma(localizacion);
        }
        if (ventanaEliminarCantante != null) {
            ventanaEliminarCantante.cambiarIdioma(localizacion);
        }

        //Disco
        if (ventanaCrearDisco != null) {
            ventanaCrearDisco.cambiarIdioma(localizacion);
        }
        if (ventanaBuscarDisco != null) {
            ventanaBuscarDisco.cambiarIdioma(localizacion);
        }
        if (ventanaActualizarDisco != null) {
            ventanaActualizarDisco.cambiarIdioma(localizacion);
        }
        if (ventanaEliminarDisco != null) {
            ventanaEliminarDisco.cambiarIdioma(localizacion);
        }

        //Cancion
        if (ventanaCrearCancion != null) {
            ventanaCrearCancion.cambiarIdioma(localizacion);
        }
        if (ventanaBuscarCancion != null) {
            ventanaBuscarCancion.cambiarIdioma(localizacion);
        }
        if (ventanaActualizarCancion != null) {
            ventanaActualizarCancion.cambiarIdioma(localizacion);
        }
        if (ventanaEliminarCancion != null) {
            ventanaEliminarCancion.cambiarIdioma(localizacion);
        }

        
        
        
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCompositor = new javax.swing.JMenu();
        jMenuItemCrearCompositor = new javax.swing.JMenuItem();
        jMenuItemBuscarCompositor = new javax.swing.JMenuItem();
        jMenuItemActualizarCompositor = new javax.swing.JMenuItem();
        jMenuItemEliminarCompositor = new javax.swing.JMenuItem();
        jMenuItemListarCompositor = new javax.swing.JMenuItem();
        menuCancion = new javax.swing.JMenu();
        jMenuItemCrearCancion = new javax.swing.JMenuItem();
        jMenuItemBuscarCancion = new javax.swing.JMenuItem();
        jMenuItemActualizarCancion = new javax.swing.JMenuItem();
        jMenuItemEliminarCancion = new javax.swing.JMenuItem();
        jMenuItemListarCancion = new javax.swing.JMenuItem();
        menuCantante = new javax.swing.JMenu();
        jMenuItemCrearCantante = new javax.swing.JMenuItem();
        jMenuItemBuscareCantante = new javax.swing.JMenuItem();
        jMenuItemActualizarCantante = new javax.swing.JMenuItem();
        jMenuItemEliminarCantante = new javax.swing.JMenuItem();
        jMenuItemListarCantante = new javax.swing.JMenuItem();
        menuDisco = new javax.swing.JMenu();
        jMenuItemCrearDisco = new javax.swing.JMenuItem();
        jMenuItemBuscarDisco = new javax.swing.JMenuItem();
        jMenuItemActualizarDisco = new javax.swing.JMenuItem();
        jMenuItemEliminarDisco = new javax.swing.JMenuItem();
        jMenuItemListarDisco = new javax.swing.JMenuItem();
        menuMenu = new javax.swing.JMenu();
        jMenuItemSalir = new javax.swing.JMenuItem();
        menuIdiomas = new javax.swing.JMenu();
        jMenuItemEspañol = new javax.swing.JMenuItem();
        jMenuItemIngles = new javax.swing.JMenuItem();
        jMenuItemFrances = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoPrincipal.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        desktopPane.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, Short.MAX_VALUE)
        );

        menuCompositor.setText("Compositor");

        jMenuItemCrearCompositor.setText("Crear");
        jMenuItemCrearCompositor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCrearCompositorActionPerformed(evt);
            }
        });
        menuCompositor.add(jMenuItemCrearCompositor);

        jMenuItemBuscarCompositor.setText("Buscar");
        jMenuItemBuscarCompositor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemBuscarCompositorActionPerformed(evt);
            }
        });
        menuCompositor.add(jMenuItemBuscarCompositor);

        jMenuItemActualizarCompositor.setText("Actualizar");
        jMenuItemActualizarCompositor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemActualizarCompositorActionPerformed(evt);
            }
        });
        menuCompositor.add(jMenuItemActualizarCompositor);

        jMenuItemEliminarCompositor.setText("Eliminar");
        jMenuItemEliminarCompositor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEliminarCompositorActionPerformed(evt);
            }
        });
        menuCompositor.add(jMenuItemEliminarCompositor);

        jMenuItemListarCompositor.setText(" Listar");
        jMenuItemListarCompositor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListarCompositorActionPerformed(evt);
            }
        });
        menuCompositor.add(jMenuItemListarCompositor);

        menuCancion.setText("Cancion");

        jMenuItemCrearCancion.setText("Crear cancion");
        jMenuItemCrearCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCrearCancionActionPerformed(evt);
            }
        });
        menuCancion.add(jMenuItemCrearCancion);

        jMenuItemBuscarCancion.setText(" Buscar cancion");
        jMenuItemBuscarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemBuscarCancionActionPerformed(evt);
            }
        });
        menuCancion.add(jMenuItemBuscarCancion);

        jMenuItemActualizarCancion.setText("Actualizar Cancion");
        jMenuItemActualizarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemActualizarCancionActionPerformed(evt);
            }
        });
        menuCancion.add(jMenuItemActualizarCancion);

        jMenuItemEliminarCancion.setText(" Eliminar cancion");
        jMenuItemEliminarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEliminarCancionActionPerformed(evt);
            }
        });
        menuCancion.add(jMenuItemEliminarCancion);

        jMenuItemListarCancion.setText(" Listar cancion");
        jMenuItemListarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListarCancionActionPerformed(evt);
            }
        });
        menuCancion.add(jMenuItemListarCancion);

        menuCompositor.add(menuCancion);

        jMenuBar1.add(menuCompositor);

        menuCantante.setText("Cantante");

        jMenuItemCrearCantante.setText("Crear");
        jMenuItemCrearCantante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCrearCantanteActionPerformed(evt);
            }
        });
        menuCantante.add(jMenuItemCrearCantante);

        jMenuItemBuscareCantante.setText("Buscar");
        jMenuItemBuscareCantante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemBuscareCantanteActionPerformed(evt);
            }
        });
        menuCantante.add(jMenuItemBuscareCantante);

        jMenuItemActualizarCantante.setText("Actualizar");
        jMenuItemActualizarCantante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemActualizarCantanteActionPerformed(evt);
            }
        });
        menuCantante.add(jMenuItemActualizarCantante);

        jMenuItemEliminarCantante.setText("Eliminar");
        jMenuItemEliminarCantante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEliminarCantanteActionPerformed(evt);
            }
        });
        menuCantante.add(jMenuItemEliminarCantante);

        jMenuItemListarCantante.setText(" Listar");
        jMenuItemListarCantante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListarCantanteActionPerformed(evt);
            }
        });
        menuCantante.add(jMenuItemListarCantante);

        menuDisco.setText(" Disco");

        jMenuItemCrearDisco.setText("Crear disco");
        jMenuItemCrearDisco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCrearDiscoActionPerformed(evt);
            }
        });
        menuDisco.add(jMenuItemCrearDisco);

        jMenuItemBuscarDisco.setText("Buscar disco");
        jMenuItemBuscarDisco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemBuscarDiscoActionPerformed(evt);
            }
        });
        menuDisco.add(jMenuItemBuscarDisco);

        jMenuItemActualizarDisco.setText(" Actualizar disco");
        jMenuItemActualizarDisco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemActualizarDiscoActionPerformed(evt);
            }
        });
        menuDisco.add(jMenuItemActualizarDisco);

        jMenuItemEliminarDisco.setText("Eliminar disco");
        jMenuItemEliminarDisco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEliminarDiscoActionPerformed(evt);
            }
        });
        menuDisco.add(jMenuItemEliminarDisco);

        jMenuItemListarDisco.setText(" Listar disco");
        jMenuItemListarDisco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListarDiscoActionPerformed(evt);
            }
        });
        menuDisco.add(jMenuItemListarDisco);

        menuCantante.add(menuDisco);

        jMenuBar1.add(menuCantante);

        menuMenu.setText(" Menu");

        jMenuItemSalir.setText("Salir");
        menuMenu.add(jMenuItemSalir);

        jMenuBar1.add(menuMenu);

        menuIdiomas.setText("Idioma");

        jMenuItemEspañol.setText("Español");
        jMenuItemEspañol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEspañolActionPerformed(evt);
            }
        });
        menuIdiomas.add(jMenuItemEspañol);

        jMenuItemIngles.setText("Ingles");
        jMenuItemIngles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemInglesActionPerformed(evt);
            }
        });
        menuIdiomas.add(jMenuItemIngles);

        jMenuItemFrances.setText("Frances");
        jMenuItemFrances.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFrancesActionPerformed(evt);
            }
        });
        menuIdiomas.add(jMenuItemFrances);

        jMenuBar1.add(menuIdiomas);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemCrearCompositorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCrearCompositorActionPerformed
        if (ventanaCrearCompositor == null) {
            ventanaCrearCompositor = new VentanaCrearCompositor(controladorCompositor);
            desktopPane.add(ventanaCrearCompositor);
        }
        ventanaCrearCompositor.setVisible(true);   
        ventanaCrearCompositor.cambiarIdioma(localizacion);
               // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemCrearCompositorActionPerformed

    private void jMenuItemBuscarCompositorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBuscarCompositorActionPerformed
        if (ventanaBuscarCompositor == null) {
            ventanaBuscarCompositor = new VentanaBuscarCompositor(controladorCompositor);
            desktopPane.add(ventanaBuscarCompositor);
        }

        ventanaBuscarCompositor.setVisible(true);
        ventanaBuscarCompositor.cambiarIdioma(localizacion);

    }//GEN-LAST:event_jMenuItemBuscarCompositorActionPerformed

    private void jMenuItemActualizarCompositorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemActualizarCompositorActionPerformed
        if (ventanaActualizarCompositor == null) {
            ventanaActualizarCompositor = new VentanaActualizarCompositor(controladorCompositor);
            desktopPane.add(ventanaActualizarCompositor);
        }

        ventanaActualizarCompositor.setVisible(true);
        ventanaActualizarCompositor.cambiarIdioma(localizacion);

    }//GEN-LAST:event_jMenuItemActualizarCompositorActionPerformed

    private void jMenuItemEliminarCompositorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEliminarCompositorActionPerformed
        if (ventanaEliminarCompositor == null) {
            ventanaEliminarCompositor = new VentanaEliminarCompositor(controladorCompositor);
            desktopPane.add(ventanaEliminarCompositor);
        }

        ventanaEliminarCompositor.setVisible(true);
        ventanaEliminarCompositor.cambiarIdioma(localizacion);

    }//GEN-LAST:event_jMenuItemEliminarCompositorActionPerformed

    private void jMenuItemListarCompositorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListarCompositorActionPerformed
        if (ventanaListarCompositor == null) {
            ventanaListarCompositor = new VentanaListarCompositor(controladorCompositor);
            desktopPane.add(ventanaListarCompositor);
        }

        ventanaListarCompositor.setVisible(true);
    }//GEN-LAST:event_jMenuItemListarCompositorActionPerformed

    private void jMenuItemCrearCantanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCrearCantanteActionPerformed
        if (ventanaCrearCantante == null) {
            ventanaCrearCantante = new VentanaCrearCantante(controladorCantante);
            desktopPane.add(ventanaCrearCantante);
        }

        ventanaCrearCantante.setVisible(true);
        ventanaCrearCantante.cambiarIdioma(localizacion);
    }//GEN-LAST:event_jMenuItemCrearCantanteActionPerformed

    private void jMenuItemBuscareCantanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBuscareCantanteActionPerformed
        if (ventanaBuscarCantante == null) {
            ventanaBuscarCantante = new VentanaBuscarCantante(controladorCantante);
            desktopPane.add(ventanaBuscarCantante);
        }

        ventanaBuscarCantante.setVisible(true);
        ventanaBuscarCantante.cambiarIdioma(localizacion);

    }//GEN-LAST:event_jMenuItemBuscareCantanteActionPerformed

    private void jMenuItemActualizarCantanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemActualizarCantanteActionPerformed
        if (ventanaActualizarCantante == null) {
            ventanaActualizarCantante = new VentanaActualizarCantante(controladorCantante);
            desktopPane.add(ventanaActualizarCantante);
        }

        ventanaActualizarCantante.setVisible(true);
        ventanaActualizarCantante.cambiarIdioma(localizacion);

    }//GEN-LAST:event_jMenuItemActualizarCantanteActionPerformed

    private void jMenuItemEliminarCantanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEliminarCantanteActionPerformed
        if (ventanaEliminarCantante == null) {
            ventanaEliminarCantante = new VentanaEliminarCantante(controladorCantante);
            desktopPane.add(ventanaEliminarCantante);
        }

        ventanaEliminarCantante.setVisible(true);
        ventanaEliminarCantante.cambiarIdioma(localizacion);

    }//GEN-LAST:event_jMenuItemEliminarCantanteActionPerformed

    private void jMenuItemListarCantanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListarCantanteActionPerformed
        if (ventanaListarCantante == null) {
            ventanaListarCantante = new VentanaListarCantante(controladorCantante);
            desktopPane.add(ventanaListarCantante);
        }

        ventanaListarCantante.setVisible(true);
        ventanaListarCantante.setVisible(true);
    }//GEN-LAST:event_jMenuItemListarCantanteActionPerformed

    private void jMenuItemActualizarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemActualizarCancionActionPerformed
        if (ventanaActualizarCancion == null) {
            ventanaActualizarCancion = new VentanaActualizarCancion(controladorCompositor);
            desktopPane.add(ventanaActualizarCancion);
        }

        ventanaActualizarCancion.setVisible(true);
        ventanaActualizarCancion.cambiarIdioma(localizacion);

    }//GEN-LAST:event_jMenuItemActualizarCancionActionPerformed

    private void jMenuItemCrearDiscoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCrearDiscoActionPerformed
        if (ventanaCrearDisco == null) {
            ventanaCrearDisco = new VentanaCrearDisco(controladorCantante);
            desktopPane.add(ventanaCrearDisco);
        }

        ventanaCrearDisco.setVisible(true);
        ventanaCrearDisco.cambiarIdioma(localizacion);
    }//GEN-LAST:event_jMenuItemCrearDiscoActionPerformed

    private void jMenuItemCrearCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCrearCancionActionPerformed
        if (ventanaCrearCancion == null) {
            ventanaCrearCancion = new VentanaCrearCancion(controladorCompositor);
            desktopPane.add(ventanaCrearCancion);
        }

        ventanaCrearCancion.setVisible(true);
        ventanaCrearCancion.cambiarIdioma(localizacion);
    }//GEN-LAST:event_jMenuItemCrearCancionActionPerformed

    private void jMenuItemEspañolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEspañolActionPerformed
        localizacion = new Locale("es", "EC");
        cambiarIdioma();

    }//GEN-LAST:event_jMenuItemEspañolActionPerformed

    private void jMenuItemInglesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemInglesActionPerformed
        localizacion = new Locale("en", "US");
        cambiarIdioma();
    }//GEN-LAST:event_jMenuItemInglesActionPerformed

    private void jMenuItemFrancesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFrancesActionPerformed
        localizacion = new Locale("fr", "FR");
        cambiarIdioma();
    }//GEN-LAST:event_jMenuItemFrancesActionPerformed

    private void jMenuItemBuscarDiscoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBuscarDiscoActionPerformed
        if (ventanaBuscarDisco == null) {
            ventanaBuscarDisco = new VentanaBuscarDisco(controladorCantante);
            desktopPane.add(ventanaBuscarDisco);
        }

        ventanaBuscarDisco.setVisible(true);
        ventanaBuscarDisco.cambiarIdioma(localizacion);

    }//GEN-LAST:event_jMenuItemBuscarDiscoActionPerformed

    private void jMenuItemActualizarDiscoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemActualizarDiscoActionPerformed
        if (ventanaActualizarDisco == null) {
            ventanaActualizarDisco = new VentanaActualizarDisco(controladorCantante);
            desktopPane.add(ventanaActualizarDisco);
        }

        ventanaActualizarDisco.setVisible(true);
        ventanaActualizarDisco.cambiarIdioma(localizacion);

    }//GEN-LAST:event_jMenuItemActualizarDiscoActionPerformed

    private void jMenuItemEliminarDiscoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEliminarDiscoActionPerformed
        if (ventanaEliminarDisco == null) {
            ventanaEliminarDisco = new VentanaEliminarDisco(controladorCantante);
            desktopPane.add(ventanaEliminarDisco);
        }

        ventanaEliminarDisco.setVisible(true);
        ventanaEliminarDisco.cambiarIdioma(localizacion);

    }//GEN-LAST:event_jMenuItemEliminarDiscoActionPerformed

    private void jMenuItemBuscarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBuscarCancionActionPerformed
        if (ventanaBuscarCancion == null) {
            ventanaBuscarCancion = new VentanaBuscarCancion(controladorCompositor);
            desktopPane.add(ventanaBuscarCancion);
        }

        ventanaBuscarCancion.setVisible(true);
        ventanaBuscarCancion.cambiarIdioma(localizacion);

    }//GEN-LAST:event_jMenuItemBuscarCancionActionPerformed

    private void jMenuItemEliminarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEliminarCancionActionPerformed
       if (ventanaEliminarCancion == null) {
            ventanaEliminarCancion = new VentanaEliminarCancion(controladorCompositor);
            desktopPane.add(ventanaEliminarCancion);
        }

        ventanaEliminarCancion.setVisible(true);
        ventanaEliminarCancion.cambiarIdioma(localizacion);

    }//GEN-LAST:event_jMenuItemEliminarCancionActionPerformed

    private void jMenuItemListarDiscoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListarDiscoActionPerformed
        if (ventanaListarDisco == null) {
            ventanaListarDisco = new VentanaListarDisco(controladorCantante);
            desktopPane.add(ventanaListarDisco);
        }

        ventanaListarDisco.setVisible(true);

    }//GEN-LAST:event_jMenuItemListarDiscoActionPerformed

    private void jMenuItemListarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListarCancionActionPerformed
 if (ventanaListarCancion == null) {
            ventanaListarCancion = new VentanaListarCancion(controladorCompositor);
            desktopPane.add(ventanaListarCancion);
        }

        ventanaListarCancion.setVisible(true);
        ventanaEliminarCancion.cambiarIdioma(localizacion);

    }//GEN-LAST:event_jMenuItemListarCancionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemActualizarCancion;
    private javax.swing.JMenuItem jMenuItemActualizarCantante;
    private javax.swing.JMenuItem jMenuItemActualizarCompositor;
    private javax.swing.JMenuItem jMenuItemActualizarDisco;
    private javax.swing.JMenuItem jMenuItemBuscarCancion;
    private javax.swing.JMenuItem jMenuItemBuscarCompositor;
    private javax.swing.JMenuItem jMenuItemBuscarDisco;
    private javax.swing.JMenuItem jMenuItemBuscareCantante;
    private javax.swing.JMenuItem jMenuItemCrearCancion;
    private javax.swing.JMenuItem jMenuItemCrearCantante;
    private javax.swing.JMenuItem jMenuItemCrearCompositor;
    private javax.swing.JMenuItem jMenuItemCrearDisco;
    private javax.swing.JMenuItem jMenuItemEliminarCancion;
    private javax.swing.JMenuItem jMenuItemEliminarCantante;
    private javax.swing.JMenuItem jMenuItemEliminarCompositor;
    private javax.swing.JMenuItem jMenuItemEliminarDisco;
    private javax.swing.JMenuItem jMenuItemEspañol;
    private javax.swing.JMenuItem jMenuItemFrances;
    private javax.swing.JMenuItem jMenuItemIngles;
    private javax.swing.JMenuItem jMenuItemListarCancion;
    private javax.swing.JMenuItem jMenuItemListarCantante;
    private javax.swing.JMenuItem jMenuItemListarCompositor;
    private javax.swing.JMenuItem jMenuItemListarDisco;
    private javax.swing.JMenuItem jMenuItemSalir;
    private javax.swing.JMenu menuCancion;
    private javax.swing.JMenu menuCantante;
    private javax.swing.JMenu menuCompositor;
    private javax.swing.JMenu menuDisco;
    private javax.swing.JMenu menuIdiomas;
    private javax.swing.JMenu menuMenu;
    // End of variables declaration//GEN-END:variables
}
