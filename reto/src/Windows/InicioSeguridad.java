package Windows;

import DB_management.Conexion;
import Modelos.Piloto;
import Modelos.Seguridad;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InicioSeguridad extends JFrame {
    public static void paginatr(Seguridad seguridad, Conexion c1){
        JFrame paginase = new JFrame("");
        paginase.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        paginase.setSize(550, 625);
        paginase.setLayout(new BorderLayout());

        JPanel p1 = new JPanel();

        //Logo arriba
        Image logoo=Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("JUan_avion_Logo.png"));
        paginase.setIconImage(logoo);


        //Color del frame
        Container c = paginase.getContentPane();
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
        paginase.add(ParteArriba, BorderLayout.NORTH);


        //Pagina principal parte de abajo
        JPanel parte_abajo = new JPanel(new GridLayout(1,5));

        parte_abajo.setBackground(new Color(140, 136, 136));

        //Espacio en blanco del grid
        parte_abajo.add(Box.createVerticalGlue());

        //Imagen Iniciar sesion
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

        paginase.add(parte_abajo, BorderLayout.SOUTH);

        //vervuelos
        JPanel Vervuelos = new JPanel();
        JPanel button = new JPanel();
        button.setLayout(new BoxLayout(button, BoxLayout.X_AXIS));
        String[] Columnas = {"Avion","Id_Vuelo", "Origen", "Destino", "Salida", "Llegada", "Precio"};
        JLabel titulo = new JLabel("Vuelos disponibles       ");
        Font tipo1 = new Font("Serif", Font.ITALIC, 30);
        titulo.setFont(tipo1);
        Vervuelos.setBackground(new Color(148, 223, 234));
        button.setBackground(new Color(148, 223, 234));
        JButton editar_peso= new JButton("Editar Peso del equipaje");



        //Configuracion Jtable
        JTable datos = new JTable(Inicio_de_sesion.Mostrarvuelos(c1,Columnas), Columnas);
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
        button.add(editar_peso);
        Vervuelos.add(button);
        Vervuelos.add(s1);
        paginase.add(Vervuelos);


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
        verperfil.add(new JLabel("           Numero empleado: "+ seguridad.getNumemp()));
        verperfil.add(Box.createVerticalGlue());
        verperfil.add(new JLabel("Nombre: "+ seguridad.getNombre()));
        verperfil.add(new JLabel("           Apellidos: "+ seguridad.getApellido()));
        verperfil.add(Box.createVerticalGlue());
        verperfil.add(new JLabel("Trabajo: "+ seguridad.getTrabajo()));
        verperfil.add(new JLabel("           Sueldo: "+ seguridad.getSueldo()));
        verperfil.add(Box.createVerticalGlue());
        verperfil.add(new JLabel("Id Aerolinea: "+ seguridad.getId_aeropuerto()));
        verperfil.add(new JLabel("           Hora Entrada: "+ seguridad.getHora_Entrada()));
        verperfil.add(Box.createVerticalGlue());
        verperfil.add(new JLabel("Hora Salida: "+ seguridad.getHora_salida()));
        verperfil.add(Box.createVerticalGlue());
        verperfil.add(cerrar_Sesion);
        verperfil.add(Box.createVerticalGlue());
        verperfil.add(Box.createVerticalGlue());
        verperfil.add(Box.createVerticalGlue());
        verperfil.add(Box.createVerticalGlue());


        //Editar peso
        JPanel editarPeso = new JPanel();
        editarPeso.setLayout(new BoxLayout(editarPeso,BoxLayout.X_AXIS));
        JTextField DNI = new JTextField();
        JTextField Peso = new JTextField();
        editarPeso.add(new JLabel("DNI: "));
        editarPeso.add(DNI);
        editarPeso.add(new JLabel("Peso: "));
        editarPeso.add(Peso);



        //Acciones
        BotonVerperfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paginase.add(verperfil);
                Vervuelos.setVisible(false);
                verperfil.setVisible(true);

            }
        });
        bontonVerVuelos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paginase.add(Vervuelos);
                verperfil.setVisible(false);
                Vervuelos.setVisible(true);


            }
        });


        editar_peso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int respuesta = JOptionPane.showConfirmDialog(null, editarPeso, "Equipaje a editar", JOptionPane.OK_CANCEL_OPTION);
                if (respuesta==JOptionPane.YES_OPTION){
                    int pesoCogido = Integer.parseInt(Peso.getText());
                    String DNICogido = DNI.getText();
                    try {
                        Statement st = c1.getConn().createStatement();
                        int rs = st.executeUpdate("UPDATE EQUIPAJE set peso = "+pesoCogido+" where DNI = '"+DNICogido+"'");
                        if (rs < 1){
                            throw new SQLException("");
                        }
                        JOptionPane.showMessageDialog(null,"Equipaje editado");
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null,"El DNI no existe");
                    }
                }
            }
        });

        cerrar_Sesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                paginase.setVisible(false);
                CerrarSesion(seguridad);

            }
        });

        paginase.setLocationRelativeTo(null);
        paginase.setResizable(false);
        paginase.setVisible(true);

    }

    public static Seguridad CerrarSesion(Seguridad seguridad){
        seguridad = null;
        Inicio_de_sesion cerrarSesion = new Inicio_de_sesion();
        cerrarSesion.setVisible(true);
        return seguridad;

    }
}
