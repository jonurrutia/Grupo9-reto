import jdk.javadoc.doclet.Taglet;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn.*;
import java.security.*;

public class Inicio_de_sesion extends JFrame{
    public Inicio_de_sesion(){
        //frame
        JFrame pagina_principal = new JFrame("Aeropuertos juan");
        pagina_principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pagina_principal.setSize(525,525);
        pagina_principal.setLayout(new BorderLayout());

        //Logo arriba
        Image logoo=Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("JUan_avion_Logo.png"));
        pagina_principal.setIconImage(logoo);


        //Color del frame
        Container c = pagina_principal.getContentPane();
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
        pagina_principal.add(ParteArriba, BorderLayout.NORTH);


        //Pagina principal parte de abajo
        JPanel parte_abajo = new JPanel(new GridLayout(1,5));

        parte_abajo.setBackground(new Color(140, 136, 136));

        //Espacio en blanco del grid
        parte_abajo.add(Box.createVerticalGlue());

        //Imagen Iniciar sesion
        Image iconIniciarsesion = new ImageIcon("Iniciar sesion.png").getImage();
        JButton botonIniciarSesion = new JButton();
        botonIniciarSesion.setBackground(new Color(140, 136, 136));
        iconIniciarsesion = iconIniciarsesion.getScaledInstance(50,50,Image.SCALE_SMOOTH);
        ImageIcon sesion = new ImageIcon(iconIniciarsesion);
        botonIniciarSesion.setIcon(sesion);
        parte_abajo.add(botonIniciarSesion);
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

        pagina_principal.add(parte_abajo, BorderLayout.SOUTH);


        //Panel de Ver vuelos
        Conexion c1 = new Conexion();
        JPanel Vervuelos = new JPanel();
        Vervuelos.setLayout(new BoxLayout(Vervuelos, BoxLayout.Y_AXIS));
        JLabel titulo = new JLabel("Vuelos disponibles                                                 ");
        Font tipo1 = new Font("Serif", Font.ITALIC, 30);
        titulo.setFont(tipo1);
        Vervuelos.setBackground(new Color(148, 223, 234));
        int contfilas = 2;

        try {
            Statement buscar1 = c1.getConn().createStatement();
            ResultSet rs = buscar1.executeQuery("select v.ID_AVION, SALIDA, LLEGADA, HORA_PARTIDA, HORA_DESTINO, PRECIO from VUELOS v inner join PASAJE p on v.ID_VUELO=p.ID_VUELO");
            while (rs.next()){
                contfilas++;

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String [] Columnas = {"Avion", "Origen", "Destino", "Salida", "Llegada", "Precio"};
        String [][] Filas = new  String[contfilas][6];




        try{

            Statement buscar1 = c1.getConn().createStatement();
            ResultSet rs = buscar1.executeQuery("select v.ID_AVION, SALIDA, LLEGADA, HORA_PARTIDA, HORA_DESTINO, PRECIO from VUELOS v inner join PASAJE p on v.ID_VUELO=p.ID_VUELO");

            for (int i = 0; i <6; i++){
                Filas[1][i] = Columnas[i];

            }

            int contador=2;

            while (rs.next()){
                    Filas[contador][0]=rs.getString("ID_AVION");
                    Filas[contador][1]=rs.getString("SALIDA");
                    Filas[contador][2]=rs.getString("LLEGADA");
                    Filas[contador][3]=rs.getString("HORA_PARTIDA");
                    Filas[contador][4]=rs.getString("HORA_DESTINO");
                    Filas[contador][5]=rs.getString("PRECIO");
                contador++;

            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        //Configuracion Jtable
        JTable datos = new JTable(Filas,Columnas);
        JPanel panelconscroll = new JPanel();
        panelconscroll.setBackground(new Color(148, 223, 234));
        panelconscroll.setBorder(new EmptyBorder(5,5,5,5));
        panelconscroll.add(datos);
        ScrollPane s1 = new ScrollPane();
        s1.setPreferredSize(new Dimension(250,250));
        s1.add(panelconscroll);
        datos.setBackground(new Color(148, 223, 234));


        Vervuelos.add(titulo);
        Vervuelos.add(Box.createVerticalGlue());
        Vervuelos.add(s1);
        Vervuelos.add(Box.createVerticalGlue());
        pagina_principal.add(Vervuelos);




        //Pagina Iniciar sesion
        JPanel iniciar_sesion = new JPanel();
        iniciar_sesion.setLayout(new GridLayout(12,3));
        iniciar_sesion.setBackground(new Color(148, 223, 234));
        JTextField usuario = new JTextField();
        usuario.setPreferredSize(new Dimension(20,20));
        JPasswordField contraseña = new JPasswordField();
        JButton Iniciar = new JButton("Iniciar sesion");
        JLabel registrarse = new JLabel("¿No tienes cuenta? registrate");
        registrarse.setForeground(new Color(47, 123, 225 ));
        JPanel radios = new JPanel();
        JRadioButton [] array1 = {new JRadioButton("Trabajador"),  new JRadioButton("Clientes")};
        ButtonGroup b1 = new ButtonGroup();
        radios.add(Box.createVerticalGlue());
        for (JRadioButton j : array1){
            j.setActionCommand(String.valueOf(j));
            b1.add(j);
            radios.add(j);
        }


        iniciar_sesion.add(Box.createVerticalGlue());
        iniciar_sesion.add(Box.createVerticalGlue());
        iniciar_sesion.add(Box.createVerticalGlue());
        iniciar_sesion.add(Box.createVerticalGlue());
        iniciar_sesion.add(new JLabel("Usuario:"));
        iniciar_sesion.add(Box.createVerticalGlue());
        iniciar_sesion.add(Box.createVerticalGlue());
        iniciar_sesion.add(usuario);
        iniciar_sesion.add(Box.createVerticalGlue());
        iniciar_sesion.add(Box.createVerticalGlue());
        iniciar_sesion.add(new JLabel("Contraseña:"));
        iniciar_sesion.add(Box.createVerticalGlue());
        iniciar_sesion.add(Box.createVerticalGlue());
        iniciar_sesion.add(contraseña);
        iniciar_sesion.add(Box.createVerticalGlue());
        iniciar_sesion.add(Box.createVerticalGlue());
        iniciar_sesion.add(Box.createVerticalGlue());
        iniciar_sesion.add(Box.createVerticalGlue());
        iniciar_sesion.add(Box.createVerticalGlue());
        iniciar_sesion.add(radios);
        iniciar_sesion.add(Box.createVerticalGlue());
        iniciar_sesion.add(Box.createVerticalGlue());
        iniciar_sesion.add(Box.createVerticalGlue());
        iniciar_sesion.add(Box.createVerticalGlue());
        iniciar_sesion.add(Box.createVerticalGlue());
        iniciar_sesion.add(Iniciar);
        iniciar_sesion.add(Box.createVerticalGlue());
        iniciar_sesion.add(Box.createVerticalGlue());
        iniciar_sesion.add(registrarse);
        iniciar_sesion.add(Box.createVerticalGlue());
        iniciar_sesion.add(Box.createVerticalGlue());
        iniciar_sesion.add(Box.createVerticalGlue());
        iniciar_sesion.add(Box.createVerticalGlue());
        iniciar_sesion.add(Box.createVerticalGlue());
        iniciar_sesion.add(Box.createVerticalGlue());
        iniciar_sesion.add(Box.createVerticalGlue());



        //Registrarse
        JPanel Registrar = new JPanel();
        Registrar.setLayout(new GridLayout(17,3));
        Registrar.setBackground(new Color(148, 223, 234));
        JTextField nombreegister = new JTextField();
        usuario.setPreferredSize(new Dimension(20,20));
        JTextField DNIegister = new JTextField();
        usuario.setPreferredSize(new Dimension(20,20));
        JTextField Apellidoegister = new JTextField();
        usuario.setPreferredSize(new Dimension(20,20));
        JTextField Corrreoregister = new JTextField();
        usuario.setPreferredSize(new Dimension(20,20));
        JTextField Telefonoregister = new JTextField();
        usuario.setPreferredSize(new Dimension(20,20));
        JTextField useregister = new JTextField();
        usuario.setPreferredSize(new Dimension(20,20));
        JPasswordField Paswordregister = new JPasswordField();
        JButton Registrarse = new JButton("Registrarse");
        JLabel iniciar_sesionenregistrar = new JLabel("Iniciar sesion");
        registrarse.setForeground(new Color(47, 123, 225 ));
        radios.setBackground(new Color(148, 223, 234));


        Registrar.add(Box.createVerticalGlue());
        Registrar.add(Box.createVerticalGlue());
        Registrar.add(Box.createVerticalGlue());
        Registrar.add(Box.createVerticalGlue());
        Registrar.add(new JLabel("DNI:"));
        Registrar.add(Box.createVerticalGlue());
        Registrar.add(Box.createVerticalGlue());
        Registrar.add(DNIegister);
        Registrar.add(Box.createVerticalGlue());
        Registrar.add(Box.createVerticalGlue());
        Registrar.add(new JLabel("Nombre:"));
        Registrar.add(Box.createVerticalGlue());
        Registrar.add(Box.createVerticalGlue());
        Registrar.add(nombreegister);
        Registrar.add(Box.createVerticalGlue());
        Registrar.add(Box.createVerticalGlue());
        Registrar.add(new JLabel("Apellido:"));
        Registrar.add(Box.createVerticalGlue());
        Registrar.add(Box.createVerticalGlue());
        Registrar.add(Apellidoegister);
        Registrar.add(Box.createVerticalGlue());
        Registrar.add(Box.createVerticalGlue());
        Registrar.add(new JLabel("Correo:"));
        Registrar.add(Box.createVerticalGlue());
        Registrar.add(Box.createVerticalGlue());
        Registrar.add(Corrreoregister);
        Registrar.add(Box.createVerticalGlue());
        Registrar.add(Box.createVerticalGlue());
        Registrar.add(new JLabel("Telefono:"));
        Registrar.add(Box.createVerticalGlue());
        Registrar.add(Box.createVerticalGlue());
        Registrar.add(Telefonoregister);
        Registrar.add(Box.createVerticalGlue());
        Registrar.add(Box.createVerticalGlue());
        Registrar.add(new JLabel("Contraseña:"));
        Registrar.add(Box.createVerticalGlue());
        Registrar.add(Box.createVerticalGlue());
        Registrar.add(Paswordregister);
        Registrar.add(Box.createVerticalGlue());
        Registrar.add(Box.createVerticalGlue());
        Registrar.add(Box.createVerticalGlue());
        Registrar.add(Box.createVerticalGlue());
        Registrar.add(Box.createVerticalGlue());
        Registrar.add(Registrarse);
        Registrar.add(Box.createVerticalGlue());


        //Accciones
        botonIniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagina_principal.add(iniciar_sesion);
                Vervuelos.setVisible(false);
                Registrar.setVisible(false);
                iniciar_sesion.setVisible(true);


            }
        });
        bontonVerVuelos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagina_principal.add(Vervuelos);
                iniciar_sesion.setVisible(false);
                Registrar.setVisible(false);
                Vervuelos.setVisible(true);

            }
        });

        Iniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String user = usuario.getText();
                String user2="";
                String password = contraseña.getText();
                String hash = getHashedPassword(password);
                String tipo = "";
                for (JRadioButton j : array1) {
                    if (j.isSelected()) {
                        tipo = j.getText();
                    }
                }
                Statement verificar= null;
                try {
                    verificar = c1.getConn().createStatement();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                if (tipo.equals("Trabajador")) {
                        ResultSet rs = null;
                        try {
                            rs = verificar.executeQuery("select nombre, password from empleados where NOMBRE = '" + user + "'");
                            while (rs.next()) {
                                 user2 = rs.getString("nombre");
                                password = rs.getString("password");
                            }


                            if (password.equals(hash)&&user.equals(user2)) {
                                InicioTrabajadores paginatr = new InicioTrabajadores();
                                paginatr.paginatr();
                                paginatr.setVisible(true);
                                pagina_principal.setVisible(false);
                            }
                            if (!user.equals(user2)){
                                JOptionPane error = new JOptionPane();
                                JOptionPane.showMessageDialog(error,"Usuario incorrecto");
                            }
                            else if (!password.equals(hash)) {
                                JOptionPane error = new JOptionPane();
                                JOptionPane.showMessageDialog(error,"Contraseña incorrecta");
                            }

                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    if (tipo.equals("Clientes")) {
                        ResultSet rs = null;
                        try {
                            rs = verificar.executeQuery("select nombre, password from clientes where NOMBRE = '" + user + "'");
                            while (rs.next()) {
                                user2 = rs.getString("nombre");
                                password = rs.getString("password");
                            }
                            if (password.equals(hash)&&user.equals(user2)) {
                                InicioClientes cl1 = new InicioClientes();
                                cl1.paginacl();
                                cl1.setVisible(true);
                                pagina_principal.setVisible(false);
                            }
                            else if (!user.equals(user2)){
                                JOptionPane error = new JOptionPane();
                                JOptionPane.showMessageDialog(error,"Usuario incorrecto");
                            }
                            else if (!password.equals(hash)) {
                                JOptionPane error = new JOptionPane();
                                JOptionPane.showMessageDialog(error,"Contraseña incorrecta");
                            }

                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }

                    }
            }
        });

        //frame.pack();
        pagina_principal.setVisible(true);

        registrarse.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                pagina_principal.add(Registrar);
                iniciar_sesion.setVisible(false);
                Registrar.setVisible(true);

            }
        });

        Registrarse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

               String DNI = DNIegister.getText();
               String nombre = nombreegister.getText();
               String Apellido = Apellidoegister.getText();
               String Correo  = Corrreoregister.getText();
               String contraseñaregister = getHashedPassword(Paswordregister.getText());
               String Telefono = Telefonoregister.getText();

               Statement insertar = null;

               try{
                   insertar = c1.getConn().createStatement();
                   ResultSet rs = insertar.executeQuery("insert into CLIENTES (DNI, NOMBRE, APELLIDO, CORREO, PASSWORD, TELEFONO_CLIE) values ('"+DNI+"', '"+nombre+"', '"+Apellido+"', '"+Correo+"', '"+contraseñaregister+"', '"+Telefono+"')");
                   System.out.println(rs);
               } catch (SQLException e) {
                   throw new RuntimeException(e);
               }
            }
        });

    }
    public static String getHashedPassword(String password) {
        String hashedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            hashedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
        return hashedPassword;
    }
}
