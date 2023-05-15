package Windows;

import DB_management.Conexion;
import Modelos.Empleado;
import Modelos.Piloto;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class InicioPiloto extends JFrame {
    public static void paginatr(Piloto piloto){
        JFrame paginapi = new JFrame("");
        paginapi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        paginapi.setSize(525, 600);
        paginapi.setLayout(new BorderLayout());
        Conexion c2 = new Conexion();

        //Logo arriba
        Image logoo=Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("JUan_avion_Logo.png"));
        paginapi.setIconImage(logoo);


        //Color del frame
        Container c = paginapi.getContentPane();
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
        paginapi.add(ParteArriba, BorderLayout.NORTH);


        //Pagina principal parte de abajo
        JPanel parte_abajo = new JPanel(new GridLayout(1,5));

        parte_abajo.setBackground(new Color(140, 136, 136));

        //Espacio en blanco del grid
        parte_abajo.add(Box.createVerticalGlue());

        //Imagen Ver perfil
        Image iconIniciarsesion = new ImageIcon("Iniciar sesion.png").getImage();
        JButton botonVerperfil = new JButton();
        botonVerperfil.setBackground(new Color(140, 136, 136));
        iconIniciarsesion = iconIniciarsesion.getScaledInstance(50,50,Image.SCALE_SMOOTH);
        ImageIcon sesion = new ImageIcon(iconIniciarsesion);
        botonVerperfil.setIcon(sesion);
        parte_abajo.add(botonVerperfil);
        parte_abajo.add(Box.createVerticalGlue());

        //Imagen de ver vuelos propios
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

        paginapi.add(parte_abajo, BorderLayout.SOUTH);


        //vervuelos
        Conexion c1 = new Conexion();
        JPanel Vervuelos = new JPanel();
        JPanel button = new JPanel();
        button.setLayout(new BoxLayout(button, BoxLayout.X_AXIS));
        String[] Columnas = {"Avion","Id_Vuelo", "Origen", "Destino", "Salida", "Llegada", "Precio"};
        JLabel titulo = new JLabel("Vuelos disponibles       ");
        Font tipo1 = new Font("Serif", Font.ITALIC, 30);
        titulo.setFont(tipo1);
        Vervuelos.setBackground(new Color(148, 223, 234));
        button.setBackground(new Color(148, 223, 234));
        JButton vuelos_propios = new JButton("Mis Vuelos");
        JButton editar_vuelos= new JButton("Editar");



        //Configuracion Jtable
        JTable datos = new JTable(Inicio_de_sesion.Mostrarvuelos(c1,Columnas), Columnas);
        JPanel panelconscroll = new JPanel();
        panelconscroll.setBackground(new Color(148, 223, 234));
        panelconscroll.setBorder(new EmptyBorder(5, 5, 5, 5));
        panelconscroll.add(datos);
        ScrollPane s1 = new ScrollPane();
        s1.setPreferredSize(new Dimension(500, 500));
        s1.add(panelconscroll);
        datos.setBackground(new Color(148, 223, 234));

        button.add(titulo);
        button.add(Box.createVerticalGlue());
        button.add(vuelos_propios);
        button.add(editar_vuelos);
        Vervuelos.add(button);
        Vervuelos.add(s1);
        paginapi.add(Vervuelos);


        //vuelos propios
        JPanel vuelos_piloto = new JPanel();
        JPanel button2 = new JPanel();
        button.setLayout(new BoxLayout(button, BoxLayout.X_AXIS));
        String[] Columnas2 = {"Avion", "Id_vuelo", "Origen", "Destino", "Salida", "Llegada"};
        JLabel titulo_vuelos_propios = new JLabel("Mis Vuelos       ");
        Font tipo_letra_vuelosPropios = new Font("Serif", Font.ITALIC, 30);
        titulo_vuelos_propios.setFont(tipo_letra_vuelosPropios);
        vuelos_piloto.setBackground(new Color(148, 223, 234));
        button2.setBackground(new Color(148, 223, 234));
        JButton Todos_los_vuelos = new JButton("Todos los vuelos");
        JButton editar_vuelos_propios= new JButton("Editar");


        JTable Vuelos_propios = new JTable(Mostrar_mis_vuelos(c1,Columnas2, piloto), Columnas2);
        JPanel panelconscroll_Vuelos_propios = new JPanel();
        panelconscroll_Vuelos_propios.setBackground(new Color(148, 223, 234));
        panelconscroll_Vuelos_propios.setBorder(new EmptyBorder(5, 5, 5, 5));
        panelconscroll_Vuelos_propios.add(Vuelos_propios);
        ScrollPane s2 = new ScrollPane();
        s2.setPreferredSize(new Dimension(500, 400));
        s2.add(panelconscroll_Vuelos_propios);
        Vuelos_propios.setBackground(new Color(148, 223, 234));

        button2.add(titulo_vuelos_propios);
        button2.add(Box.createVerticalGlue());
        button2.add(Todos_los_vuelos);
        button2.add(editar_vuelos_propios);
        vuelos_piloto.add(button2);
        vuelos_piloto.add(s2);



        //ver perfil
        JPanel verperfil = new JPanel();
        verperfil.setBackground(new Color(148, 223, 234));
        verperfil.setLayout(new GridLayout(7,3));
        JLabel Perfil = new JLabel("      Perfil");
        Font tipoLetra_perfil = new Font("Serif", Font.ITALIC, 30);
        Perfil.setFont(tipoLetra_perfil);
        JButton cerrar_Sesion = new JButton("Cerrar Sesion");
        cerrar_Sesion.setPreferredSize(new Dimension(50,50));

        verperfil.add(Box.createVerticalGlue());
        verperfil.add(Perfil);
        verperfil.add(Box.createVerticalGlue());
        verperfil.add(new JLabel("           Numero empleado: "+ piloto.getNumemp()));
        verperfil.add(Box.createVerticalGlue());
        verperfil.add(new JLabel("Nombre: "+ piloto.getNombre()));
        verperfil.add(new JLabel("           Apellidos: "+ piloto.getApellido()));
        verperfil.add(Box.createVerticalGlue());
        verperfil.add(new JLabel("Trabajo: "+ piloto.getTrabajo()));
        verperfil.add(new JLabel("           Sueldo: "+ piloto.getSueldo()));
        verperfil.add(Box.createVerticalGlue());
        verperfil.add(new JLabel("Id Aerolinea: "+ piloto.getId_aerolinia()));
        verperfil.add(new JLabel("           Hora Entrada: "+ piloto.getHora_Entrada()));
        verperfil.add(Box.createVerticalGlue());
        verperfil.add(new JLabel("Hora Salida: "+ piloto.getHora_salida()));
        verperfil.add(Box.createVerticalGlue());
        verperfil.add(cerrar_Sesion);
        verperfil.add(Box.createVerticalGlue());
        verperfil.add(Box.createVerticalGlue());
        verperfil.add(Box.createVerticalGlue());
        verperfil.add(Box.createVerticalGlue());



        botonVerperfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paginapi.add(verperfil);
                Vervuelos.setVisible(false);
                vuelos_piloto.setVisible(false);
                verperfil.setVisible(true);


            }
        });
        bontonVerVuelos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paginapi.add(Vervuelos);
                verperfil.setVisible(false);
                vuelos_piloto.setVisible(false);
                Vervuelos.setVisible(true);


            }
        });

        Todos_los_vuelos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paginapi.add(Vervuelos);
                verperfil.setVisible(false);
                vuelos_piloto.setVisible(false);
                Vervuelos.setVisible(true);


            }
        });

        vuelos_propios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               paginapi.add(vuelos_piloto);
                verperfil.setVisible(false);
                Vervuelos.setVisible(false);
                vuelos_piloto.setVisible(true);
            }
        });

        editar_vuelos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int idvuelo;
                idvuelo = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el ID del vuelo"));
                JTextField llegada = new JTextField(5);
                JTextField salida = new JTextField(5);

                JPanel panel = new JPanel();
                panel.add(new JLabel("salida:"));
                panel.add(salida);
                panel.add(Box.createHorizontalStrut(15)); // a spacer
                panel.add(new JLabel("llegada:"));
                panel.add(llegada);
                String newsalida = null;
                String newllegada = null;
                int result = JOptionPane.showConfirmDialog(null, panel,
                        "Ingresa nueva hora de salida y llegada", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                     newsalida = salida.getText();
                     newllegada = llegada.getText();
                }
                try {
                    Statement st=c2.getConn().createStatement();
                    ResultSet rs = st.executeQuery("UPDATE vuelos SET hora_partida = timestamp '1970-01-01 "+ newsalida + ":00.000' WHERE id_vuelo = '" + idvuelo + "'");
                    ResultSet rs1 = st.executeQuery("UPDATE vuelos SET hora_destino = timestamp '1970-01-01 "+ newllegada + ":00.000' WHERE id_vuelo = '" + idvuelo + "'");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                JOptionPane.showMessageDialog(null,"Se ha cambiado la hora correctamente");

            }
        });

        editar_vuelos_propios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int idvuelo;
                idvuelo = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el ID del vuelo"));
                JTextField llegada = new JTextField(5);
                JTextField salida = new JTextField(5);

                JPanel panel = new JPanel();
                panel.add(new JLabel("salida:"));
                panel.add(salida);
                panel.add(Box.createHorizontalStrut(15)); // a spacer
                panel.add(new JLabel("llegada:"));
                panel.add(llegada);
                String newsalida = null;
                String newllegada = null;
                int result = JOptionPane.showConfirmDialog(null, panel,
                        "Ingresa nueva hora de salida y llegada", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    newsalida = salida.getText();
                    newllegada = llegada.getText();
                }
                try {
                    Statement st=c2.getConn().createStatement();
                    ResultSet rs = st.executeQuery("UPDATE vuelos SET hora_partida = timestamp '1970-01-01 "+ newsalida + ":00.000' WHERE id_vuelo = '" + idvuelo + "'");
                    ResultSet rs1 = st.executeQuery("UPDATE vuelos SET hora_destino = timestamp '1970-01-01 "+ newllegada + ":00.000' WHERE id_vuelo = '" + idvuelo + "'");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                JOptionPane.showMessageDialog(null,"Se ha cambiado la hora correctamente");

            }
        });

        cerrar_Sesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                paginapi.setVisible(false);
                CerrarSesion(piloto);

            }
        });



        paginapi.setVisible(true);

    }
    public static String[][] Mostrar_mis_vuelos(Conexion c1, String[] Columnas, Piloto piloto) {
        String[][] Filas = new String[Contfilas_vuelos_propios(c1, piloto)][6];
        try {

            Statement buscar1 = c1.getConn().createStatement();
            ResultSet rs = buscar1.executeQuery("select v.ID_AVION,v.ID_VUELO, SALIDA, LLEGADA, HORA_PARTIDA, HORA_DESTINO from VUELOS v inner join AVIONES a on v.ID_AVION = a.ID_AVION where a.NUMEMP = '"+piloto.getNumemp()+"'");

            for (int i = 0; i < 6; i++) {
                Filas[0][i] = Columnas[i];

            }

            int contador = 1;

            while (rs.next()) {
                Filas[contador][0] = rs.getString("ID_AVION");
                Filas[contador][1] = rs.getString("ID_VUELO");
                Filas[contador][2] = rs.getString("SALIDA");
                Filas[contador][3] = rs.getString("LLEGADA");
                Filas[contador][4] = rs.getString("HORA_PARTIDA").replaceAll("1970-01-01","");
                Filas[contador][5] = rs.getString("HORA_DESTINO").replaceAll("1970-01-01","");
                contador++;

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Filas;
    }
    public static int Contfilas_vuelos_propios(Conexion c1, Piloto piloto) {
        int confilas=1;

        try {
            Statement buscar1 = c1.getConn().createStatement();
            ResultSet rs = buscar1.executeQuery("select v.ID_AVION,v.ID_VUELO, SALIDA, LLEGADA, HORA_PARTIDA, HORA_DESTINO from VUELOS v inner join AVIONES a on v.ID_AVION = a.ID_AVION where a.NUMEMP = '"+piloto.getNumemp()+"'");
            while (rs.next()) {
                confilas++;

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return confilas;

    }


    public static Piloto CerrarSesion(Piloto piloto){
        piloto = null;
        Inicio_de_sesion cerrarSesion = new Inicio_de_sesion();
        cerrarSesion.setVisible(true);
        return piloto;

    }
}
