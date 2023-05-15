package Windows;

import Modelos.Seguridad;

import javax.swing.*;
import java.awt.*;

public class InicioSeguridad extends JFrame {
    public static void paginatr(Seguridad seguridad){
        JFrame paginase = new JFrame("");
        paginase.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        paginase.setSize(500, 600);
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

        paginase.setVisible(true);

    }
}
