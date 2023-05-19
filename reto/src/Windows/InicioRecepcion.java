package Windows;

import DB_management.Conexion;
import Modelos.Clase;
import Modelos.Piloto;
import Modelos.Recepcionista;
import jdk.jshell.Snippet;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InicioRecepcion extends JFrame {
    public static void paginatr(Recepcionista recepcion, Conexion c1){
        JFrame paginare = new JFrame("");
        paginare.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        paginare.setSize(550, 625);
        paginare.setLayout(new BorderLayout());


        //Logo arriba
        Image logoo=Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("JUan_avion_Logo.png"));
        paginare.setIconImage(logoo);


        //Color del frame
        Container c = paginare.getContentPane();
        c.setBackground(new Color(148, 223, 234));


        //Pagina principal parte de arriba
        JPanel ParteArriba = new JPanel();
        ParteArriba.setBackground(new Color(140, 136, 136));
        ParteArriba.setPreferredSize(new Dimension(500,80));
        Image img = new ImageIcon("JUan.png").getImage();
        img = img.getScaledInstance(165,80,Image.SCALE_SMOOTH);
        ImageIcon logo = new ImageIcon(img);
        JLabel logocont = new JLabel(logo);
        logocont.setSize(100,100);
        ParteArriba.add(logocont);
        ParteArriba.add(Box.createVerticalGlue());
        ParteArriba.add(Box.createVerticalGlue());
        paginare.add(ParteArriba, BorderLayout.NORTH);

        //Pagina principal parte de abajo
        JPanel parte_abajo = new JPanel(new GridLayout(1,5));

        parte_abajo.setBackground(new Color(140, 136, 136));

        //Espacio en blanco del grid
        parte_abajo.add(Box.createVerticalGlue());

        //Imagen Ver perfil
        Image iconVerperfil = new ImageIcon("Iniciar sesion.png").getImage();
        JButton BotonVerperfil = new JButton();
        BotonVerperfil.setBackground(new Color(140, 136, 136));
        iconVerperfil = iconVerperfil.getScaledInstance(50,50,Image.SCALE_SMOOTH);
        ImageIcon perfil = new ImageIcon(iconVerperfil);
        BotonVerperfil.setIcon(perfil);
        parte_abajo.add(BotonVerperfil);
        parte_abajo.add(Box.createVerticalGlue());

        //Espacio en blanco del grid
        parte_abajo.add(Box.createVerticalGlue());

        //Imagen de ver vuelos
        Image iconVervuelos = new ImageIcon("Vervuelos1.png").getImage();
        JButton bontonVerVuelos= new JButton();
        bontonVerVuelos.setBackground(new Color(140, 136, 136));
        iconVervuelos = iconVervuelos.getScaledInstance(75,55, Image.SCALE_SMOOTH);
        ImageIcon vuelos = new ImageIcon(iconVervuelos);
        bontonVerVuelos.setIcon(vuelos);
        parte_abajo.add(bontonVerVuelos);

        //Espacio en blanco del grid
        parte_abajo.add(Box.createVerticalGlue());

        paginare.add(parte_abajo, BorderLayout.SOUTH);

        //ver vuelos
        JPanel Vervuelos = new JPanel();
        JPanel button = new JPanel();
        button.setBackground(new Color(148, 223, 234));
        button.setLayout(new BoxLayout(button, BoxLayout.X_AXIS));
        String[] Columnas = {"Avion", "Id_vuelo", "Origen", "Destino", "Salida", "Llegada", "Precio"};
        JLabel titulo = new JLabel("Vuelos disponibles     ");
        JButton Comprar_vuelo = new JButton("Comprar");
        JButton Ver_pasajes= new JButton("Pasajes");
        Font tipo1 = new Font("Serif", Font.ITALIC, 30);
        titulo.setFont(tipo1);
        Vervuelos.setBackground(new Color(148, 223, 234));


        //Configuracion Jtable
        JTable datos = new JTable(Inicio_de_sesion.Mostrarvuelos(c1, Columnas), Columnas);
        JPanel panelconscroll = new JPanel();
        panelconscroll.setBackground(new Color(148, 223, 234));
        panelconscroll.setBorder(new EmptyBorder(5, 5, 5, 5));
        panelconscroll.add(datos);
        ScrollPane s1 = new ScrollPane();
        s1.setPreferredSize(new Dimension(500, 400));
        s1.add(panelconscroll);
        datos.setBackground(new Color(148, 223, 234));


        button.add(titulo);
        button.add(Box.createVerticalGlue());
        button.add(Comprar_vuelo);
        button.add(Ver_pasajes);
        Vervuelos.add(button);
        Vervuelos.add(s1);
        Vervuelos.add(Box.createVerticalGlue());
        paginare.add(Vervuelos);

        //Ver perfil
        JPanel verperfil = new JPanel();
        verperfil.setBackground(new Color(148, 223, 234));
        verperfil.setLayout(new GridLayout(7,3));
        JLabel Perfil = new JLabel("      Perfil");
        Font tipoLetra_perfil = new Font("Serif", Font.ITALIC, 30);
        Perfil.setFont(tipoLetra_perfil);
        JButton cerrarSesion = new JButton("Cerrar sesion");

        verperfil.add(Box.createVerticalGlue());
        verperfil.add(Perfil);
        verperfil.add(Box.createVerticalGlue());
        verperfil.add(new JLabel("           Numero empleado: "+ recepcion.getNumemp()));
        verperfil.add(Box.createVerticalGlue());
        verperfil.add(new JLabel("Nombre: "+ recepcion.getNombre()));
        verperfil.add(new JLabel("           Apellidos: "+ recepcion.getApellido()));
        verperfil.add(Box.createVerticalGlue());
        verperfil.add(new JLabel("Trabajo: "+ recepcion.getTrabajo()));
        verperfil.add(new JLabel("           Sueldo: "+ recepcion.getSueldo()));
        verperfil.add(Box.createVerticalGlue());
        verperfil.add(new JLabel("Id Aeropuerto: "+ recepcion.getId_aeropuerto()));
        verperfil.add(new JLabel("           Hora Entrada: "+ recepcion.getHora_Entrada()));
        verperfil.add(Box.createVerticalGlue());
        verperfil.add(new JLabel("Hora Salida: "+ recepcion.getHora_salida()));
        verperfil.add(Box.createVerticalGlue());
        verperfil.add(cerrarSesion);
        verperfil.add(Box.createVerticalGlue());

        //Jbutton de la ventana de pasajes
        JButton editar_pasaje = new JButton("Editar pasaje");

        //editar pasajje
        JPanel Editar_pasaje = new JPanel();
        Editar_pasaje.setLayout(new BoxLayout(Editar_pasaje,BoxLayout.X_AXIS));
        String[]Clases = new String[4];
        for (int i = 0; i < Clases.length; i++){
            if (i==0){
                Clases[i]= String.valueOf(Clase.Turista);
            }else if (i==1){
                Clases[i]= String.valueOf(Clase.Premium);
            }else if (i==2){
                Clases[i]= String.valueOf(Clase.Ejecutiva);
            }else{
                Clases[i]= String.valueOf(Clase.Primera);
            }
        }

        JComboBox Clases_almacen = new JComboBox<>(Clases);
        JTextField nuevo_precio= new JTextField();
        Editar_pasaje.add(Clases_almacen);
        Editar_pasaje.add(nuevo_precio);


        //Panel de comprar pasaje
        JPanel comprar_pasaje = new JPanel();
        comprar_pasaje.setLayout(new GridLayout(12,1));
        JTextField DNI_compra = new JTextField();
        JTextField Nombre_compra = new JTextField();
        JTextField Apellido_compra = new JTextField();
        JTextField Telefono_compra = new JTextField();
        JTextField Correo_compra = new JTextField();
        JTextField Contraseña_compra = new JTextField();
        JComboBox Clase_compra = new JComboBox(Clases);
        JTextField Asiento_compra = new JTextField();
        JTextField Precio_compra = new JTextField();
        JTextField Id_vuelo_compra = new JTextField();
        JTextField Peso = new JTextField();


        comprar_pasaje.add(new JLabel("Clase: "));
        comprar_pasaje.add(Clase_compra);
        comprar_pasaje.add(new JLabel("Asiento: "));
        comprar_pasaje.add(Asiento_compra);
        comprar_pasaje.add(new JLabel("Precio: "));
        comprar_pasaje.add(Precio_compra);
        comprar_pasaje.add(new JLabel("ID_vuelo: "));
        comprar_pasaje.add(Id_vuelo_compra);
        comprar_pasaje.add(new JLabel("DNI: "));
        comprar_pasaje.add(DNI_compra);
        comprar_pasaje.add(new JLabel("Peso del equipaje: "));
        comprar_pasaje.add(Peso);



        JPanel Registro_cliente =new JPanel();
        Registro_cliente.setLayout(new GridLayout(10,1));
        Registro_cliente.add(new JLabel("Nombre: "));
        Registro_cliente.add(Nombre_compra);
        Registro_cliente.add(new JLabel("Apellido: "));
        Registro_cliente.add(Apellido_compra);
        Registro_cliente.add(new JLabel("Telefono: "));
        Registro_cliente.add(Telefono_compra);
        Registro_cliente.add(new JLabel("Correo: "));
        Registro_cliente.add(Correo_compra);
        Registro_cliente.add(new JLabel("Contraseña: "));
        Registro_cliente.add(Contraseña_compra);



        BotonVerperfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paginare.add(verperfil);
                Vervuelos.setVisible(false);
                verperfil.setVisible(true);


            }
        });
        bontonVerVuelos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paginare.add(Vervuelos);
                verperfil.setVisible(false);
                Vervuelos.setVisible(true);


            }
        });

        Ver_pasajes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //filtrar pasaje
                JPanel pasajes_Filtrados = new JPanel();
                pasajes_Filtrados.setPreferredSize(new Dimension(500,300));
                JLabel titulo_pasajes = new JLabel("Pasajes");
                Font tipo1_pasajes = new Font("Serif", Font.ITALIC, 30);
                titulo_pasajes.setFont(tipo1_pasajes);
                pasajes_Filtrados.add(titulo_pasajes);
                int id_vuelo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Id_vuelo"));
                String[] Columnas_pasajes = {"Id pasaje", "Id vuelo", "Clase", "Asiento", "Precio", "DNI"};
                JTable datos = new JTable(MostrarPasajes(c1, id_vuelo, Columnas_pasajes), Columnas_pasajes);
                JPanel panelconscroll = new JPanel();
                panelconscroll.setBorder(new EmptyBorder(5, 5, 5, 5));
                panelconscroll.add(datos);
                ScrollPane s2 = new ScrollPane();
                s2.setPreferredSize(new Dimension(500, 200));
                s2.add(panelconscroll);
                pasajes_Filtrados.add(s2);
                pasajes_Filtrados.add(editar_pasaje);
                int ok = JOptionPane.showConfirmDialog(null, pasajes_Filtrados,"Pasajes filtrados", JOptionPane.OK_CANCEL_OPTION);
                if (ok == JOptionPane.YES_OPTION){
                    pasajes_Filtrados.remove(s2);
                }

            }
        });

        editar_pasaje.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int Id_pasaje = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el pasaje que quiera editar"));
                int Ok=JOptionPane.showConfirmDialog(null, Editar_pasaje, "Editar pasaje", JOptionPane.OK_CANCEL_OPTION);
                String claseElegida = (String) Clases_almacen.getSelectedItem();
                String precio = nuevo_precio.getText();
                if (Ok==JOptionPane.OK_OPTION) {
                    try {
                        Statement st = c1.getConn().createStatement();
                        ResultSet rs = st.executeQuery("update PASAJE set CLASE = '" + claseElegida + "', PRECIO = " + precio + " where ID_PASAJE = " + Id_pasaje);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    JOptionPane.showMessageDialog(null,"La información se ha actualizado con éxito");
                }

            }
        });

        Comprar_vuelo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int decision0=JOptionPane.showConfirmDialog(null, comprar_pasaje, "Datos del pasaje", JOptionPane.OK_CANCEL_OPTION);
                if (decision0==JOptionPane.YES_OPTION) {
                    int añadirId_Pasaje = 0;
                    int MAX_ID_Equipaje=0;
                    int decision = 0;
                    int decision2 = 0;
                    boolean existe = true;
                    String añadirclase = "";
                    String añadirAsiento = "";
                    String añadirPrecio = "";
                    String añadirID_Vuelo = "";
                    String añadirDNI = "";
                    String añadir_Peso ="";

                    try {
                        Statement st = c1.getConn().createStatement();
                        Statement st2 = c1.getConn().createStatement();
                        ResultSet rs = st.executeQuery("select MAX(ID_PASAJE) as MAX from PASAJE");
                        ResultSet rs2 = st2.executeQuery("select MAX(ID_EQUIPAJE) as MAX2 from EQUIPAJE");
                        while (rs.next()) {
                            añadirId_Pasaje = rs.getInt("MAX");
                        }
                        while (rs2.next()){
                            MAX_ID_Equipaje=rs2.getInt("MAX2");
                        }
                        añadirId_Pasaje++;
                        MAX_ID_Equipaje++;
                        añadirclase = (String) Clase_compra.getSelectedItem();
                        añadirAsiento = Asiento_compra.getText();
                        añadirPrecio = Precio_compra.getText();
                        añadirID_Vuelo = Id_vuelo_compra.getText();
                        añadirDNI = DNI_compra.getText();
                        añadir_Peso=Peso.getText();
                        ResultSet rs3 = st.executeQuery("INSERT into PASAJE (ID_PASAJE, ID_VUELO, CLASE, ASIENTO, PRECIO, DNI) VALUES (" + añadirId_Pasaje + ", " + añadirID_Vuelo + ", '" + añadirclase + "', " + añadirAsiento + ", " + añadirPrecio + ", '" + añadirDNI + "')");
                        rs3 = st.executeQuery("INSERT into EQUIPAJE (ID_EQUIPAJE, DNI, PESO) VALUES (" + MAX_ID_Equipaje + ", '" + añadirDNI + "', " + añadir_Peso +")");
                        JOptionPane.showMessageDialog(null,"El pasaje se a comprado");
                    } catch (SQLException e) {
                        decision=JOptionPane.showConfirmDialog(null, "Este cliente no existe. Quieres registrarlo?");
                        if (decision == JOptionPane.YES_OPTION) {
                            decision2 = JOptionPane.showConfirmDialog(null, Registro_cliente, "Registrase", JOptionPane.OK_CANCEL_OPTION);
                            if (decision2 == JOptionPane.YES_OPTION) {
                                Statement st = null;
                                try {
                                    String nombre = Nombre_compra.getText();
                                    String Apellido = Apellido_compra.getText();
                                    String Correo = Correo_compra.getText();
                                    String Password = Contraseña_compra.getText();
                                    String Telefono = Telefono_compra.getText();
                                    st = c1.getConn().createStatement();
                                    ResultSet rs4 = st.executeQuery("INSERT into CLIENTES (DNI, NOMBRE, APELLIDO, CORREO, PASSWORD, TELEFONO_CLIE) VALUES ('" + añadirDNI + "', '" + nombre + "', '" + Apellido + "', '" + Correo + "', '" + Inicio_de_sesion.getHashedPassword(Password) + "', " + Telefono + ")");
                                    rs4 = st.executeQuery("INSERT into PASAJE (ID_PASAJE, ID_VUELO, CLASE, ASIENTO, PRECIO, DNI) VALUES (" + añadirId_Pasaje + ", " + añadirID_Vuelo + ", '" + añadirclase + "', " + añadirAsiento + ", " + añadirPrecio + ", '" + añadirDNI + "')");
                                    rs4= st.executeQuery("INSERT into EQUIPAJE (ID_EQUIPAJE, DNI, PESO) VALUES (" + MAX_ID_Equipaje + ", '" + añadirDNI + "', " + añadir_Peso +")");
                                    JOptionPane.showMessageDialog(null, "El cliente se ha registrado Y el pasaje a sido comprado");


                                } catch (SQLException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                        }
                    }

                }
            }
        });

        cerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                paginare.setVisible(false);
                CerrarSesion(recepcion);

            }
        });

        paginare.setLocationRelativeTo(null);
        paginare.setResizable(false);
        paginare.setVisible(true);



    }

    public static int Contfilas_Pasaje(Conexion c1, int id_vuelo) {
        int confilas=1;

        try {
            Statement buscar1 = c1.getConn().createStatement();
            ResultSet rs = buscar1.executeQuery("select * from PASAJE where ID_VUELO = "+id_vuelo);
            while (rs.next()) {
                confilas++;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return confilas;

    }

    public static String[][] MostrarPasajes(Conexion c1, int id_vuelo, String [] Columnas) {
        String[][] Filas = new String[Contfilas_Pasaje(c1, id_vuelo)][6];
        try {

            Statement buscar1 = c1.getConn().createStatement();
            ResultSet rs = buscar1.executeQuery("select * from PASAJE where ID_VUELO = "+id_vuelo);

            for (int i = 0; i < 6; i++) {
                Filas[0][i] = Columnas[i];
            }

            int contador = 1;

            while (rs.next()) {
                Filas[contador][0] = rs.getString("ID_PASAJE");
                Filas[contador][1] = rs.getString("ID_VUELO");
                Filas[contador][2] = rs.getString("CLASE");
                Filas[contador][3] = rs.getString("ASIENTO");
                Filas[contador][4] = rs.getString("PRECIO");
                Filas[contador][5] = rs.getString("DNI");
                contador++;

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Filas;
    }
    public static Recepcionista CerrarSesion(Recepcionista recepcionista){
        recepcionista = null;
        Inicio_de_sesion cerrarSesion = new Inicio_de_sesion();
        cerrarSesion.setVisible(true);
        return recepcionista;

    }
}
