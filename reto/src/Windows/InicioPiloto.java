package Windows;

import DB_management.Conexion;
import Modelos.Piloto;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InicioPiloto extends JFrame {
    public static void paginatr(Piloto piloto){
        JFrame paginapi = new JFrame("");
        paginapi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        paginapi.setSize(525, 525);
        paginapi.setLayout(new BorderLayout());

        JPanel p1 = new JPanel();

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

        paginapi.add(parte_abajo, BorderLayout.SOUTH);


        //vervuelos
        Conexion c1 = new Conexion();
        JPanel Vervuelos = new JPanel();
        String[] Columnas = {"Avion", "Origen", "Destino", "Salida", "Llegada", "Precio"};
        Vervuelos.setLayout(new BoxLayout(Vervuelos, BoxLayout.Y_AXIS));
        JLabel titulo = new JLabel("Vuelos disponibles                                                 ");
        Font tipo1 = new Font("Serif", Font.ITALIC, 30);
        titulo.setFont(tipo1);
        Vervuelos.setBackground(new Color(148, 223, 234));


        //Configuracion Jtable
        JTable datos = new JTable(Inicio_de_sesion.Mostrarvuelos(c1,Columnas), Columnas);
        JPanel panelconscroll = new JPanel();
        panelconscroll.setBackground(new Color(148, 223, 234));
        panelconscroll.setBorder(new EmptyBorder(5, 5, 5, 5));
        panelconscroll.add(datos);
        ScrollPane s1 = new ScrollPane();
        s1.setPreferredSize(new Dimension(250, 250));
        s1.add(panelconscroll);
        datos.setBackground(new Color(148, 223, 234));


        Vervuelos.add(titulo);
        Vervuelos.add(Box.createVerticalGlue());
        Vervuelos.add(s1);
        Vervuelos.add(Box.createVerticalGlue());
        paginapi.add(Vervuelos);






        //ver perfil
        JPanel verperfil = new JPanel();


        botonVerperfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paginapi.add(verperfil);
                Vervuelos.setVisible(false);
                verperfil.setVisible(true);


            }
        });
        bontonVerVuelos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paginapi.add(Vervuelos);
                verperfil.setVisible(false);
                Vervuelos.setVisible(true);

            }
        });

        paginapi.setVisible(true);

    }
}
