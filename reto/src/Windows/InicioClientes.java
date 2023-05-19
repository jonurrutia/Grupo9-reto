package Windows;

import DB_management.Conexion;
import Modelos.Clase;
import Modelos.Cliente;
import Modelos.Piloto;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class InicioClientes extends JFrame {
    public static void paginacl(Cliente cliente){
        JFrame paginacl = new JFrame("");
        paginacl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        paginacl.setSize(550, 625);
        paginacl.setLayout(new BorderLayout());

        //Logo arriba
        Image logoo=Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("JUan_avion_Logo.png"));
        paginacl.setIconImage(logoo);


        //Color del frame
        Container c = paginacl.getContentPane();
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
        paginacl.add(ParteArriba, BorderLayout.NORTH);


        //Pagina principal parte de abajo
        JPanel parte_abajo = new JPanel(new GridLayout(1,5));

        parte_abajo.setBackground(new Color(140, 136, 136));

        //Espacio en blanco del grid
        parte_abajo.add(Box.createVerticalGlue());

        //Imagen Iniciar sesion
        Image iconIniciarsesion = new ImageIcon("Iniciar sesion.png").getImage();
        JButton botonVerPerfil = new JButton();
        botonVerPerfil.setBackground(new Color(140, 136, 136));
        iconIniciarsesion = iconIniciarsesion.getScaledInstance(50,50,Image.SCALE_SMOOTH);
        ImageIcon sesion = new ImageIcon(iconIniciarsesion);
        botonVerPerfil.setIcon(sesion);
        parte_abajo.add(botonVerPerfil);
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

        paginacl.add(parte_abajo, BorderLayout.SOUTH);

        //vervuelos
        Conexion c2 = new Conexion();
        JPanel Vervuelos = new JPanel();
        JPanel button = new JPanel();
        button.setLayout(new BoxLayout(button, BoxLayout.X_AXIS));
        String[] Columnas = {"Avion","Id_Vuelo", "Origen", "Destino", "Salida", "Llegada", "Precio"};
        JLabel titulo = new JLabel("Vuelos disponibles       ");
        Font tipo1 = new Font("Serif", Font.ITALIC, 30);
        titulo.setFont(tipo1);
        JLabel titulo2 = new JLabel("Vuelos disponibles         ");
        Font tipo2 = new Font("Serif", Font.ITALIC, 30);
        titulo2.setFont(tipo2);
        Vervuelos.setBackground(new Color(148, 223, 234));
        button.setBackground(new Color(148, 223, 234));
        JButton Comprar = new JButton("Comprar vuelo");


        Image iconFiltrar = new ImageIcon("luupaa.png").getImage();
        JButton botonFiltrar = new JButton();
        botonFiltrar.setBackground(new Color(148, 223, 234));
        iconFiltrar = iconFiltrar.getScaledInstance(25, 18, Image.SCALE_SMOOTH);
        ImageIcon filtrarIMG = new ImageIcon(iconFiltrar);
        botonFiltrar.setIcon(filtrarIMG);

        //Panel para comprar
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
        JPanel comprarPasaje = new JPanel();
        comprarPasaje.setLayout(new BoxLayout(comprarPasaje,BoxLayout.Y_AXIS));
        JTextField ID_vuelo = new JTextField();
        JComboBox Clase = new JComboBox<>(Clases);
        comprarPasaje.add(new JLabel("ID Vuelo: "));
        comprarPasaje.add(ID_vuelo);
        comprarPasaje.add(new JLabel("CLase: "));
        comprarPasaje.add(Clase);

        //Panel para filtrar
        JPanel vuelosFiltrados = new JPanel();
        vuelosFiltrados.setBackground(new Color(148, 223, 234));
        JTextField preciominimo = new JTextField(5);
        JTextField preciomaximo = new JTextField(5);
        JPanel panel = new JPanel();
        panel.add(new JLabel("Precio minimo:"));
        panel.add(preciominimo);
        panel.add(Box.createHorizontalStrut(15)); // a spacer
        panel.add(new JLabel("Precio maximo:"));
        panel.add(preciomaximo);




        //Configuracion Jtable
        JTable datos = new JTable(Inicio_de_sesion.Mostrarvuelos(c2,Columnas), Columnas);
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
        button.add(Comprar);
        button.add(Box.createVerticalGlue());
        button.add(botonFiltrar);
        Vervuelos.add(button);
        Vervuelos.add(s1);
        paginacl.add(Vervuelos);

        //ver perfil
        JPanel verperfil = new JPanel();
        JPanel box = new JPanel();
        JPanel box2 = new JPanel();
        box.setBackground(new Color(148, 223, 234));
        box2.setBackground(new Color(148, 223, 234));
        box.setLayout(new GridLayout(5,3));
        box2.setLayout(new GridLayout(3,5));
        verperfil.setLayout(new BoxLayout(verperfil, BoxLayout.Y_AXIS));
        JLabel Perfil = new JLabel("      Perfil");
        Font tipoLetra_perfil = new Font("Serif", Font.ITALIC, 30);
        Perfil.setFont(tipoLetra_perfil);
        JButton cerrar_Sesion = new JButton("Cerrar Sesion");
        JButton cancelar = new JButton("Calcelar");
        cerrar_Sesion.setPreferredSize(new Dimension(50,50));




        box.add(Box.createVerticalGlue());
        box.add(Perfil);
        box.add(Box.createVerticalGlue());
        box.add(new JLabel("           DNI: "+ cliente.getDNI()));
        box.add(Box.createVerticalGlue());
        box.add(new JLabel("Nombre: "+ cliente.getNombre()));
        box.add(new JLabel("           Apellidos: "+ cliente.getApellido()));
        box.add(Box.createVerticalGlue());
        box.add(new JLabel("Correo: "+ cliente.getCorreo()));
        box.add(new JLabel("           Telefono: "+ cliente.getTelefono()));
        box.add(Box.createVerticalGlue());
        box.add(Box.createVerticalGlue());
        verperfil.add(box);




        //Configuracion Jtable Pasajes
        String[] Columnaspasajes = {"ID_Pasaje","Id_Vuelo", "Clase", "Asiento", "Precio", "DNI"};
        String[][] pasajesdesobra = Mostrarpasajes(c2,Columnaspasajes,cliente);
        String[] pasajes = new String[Contfilas(c2,cliente)];
        for (int i = 1; i<Contfilas(c2,cliente); i++){
            pasajes[i]=pasajesdesobra[i][0];
            System.out.println(pasajesdesobra[i][0]);
            System.out.println(pasajes[i]);
        }
        JTable tablepasajes = new JTable(Mostrarpasajes(c2,Columnaspasajes,cliente),Columnaspasajes);
        JPanel panelconscrollPasajes = new JPanel();
        panelconscrollPasajes.setBackground(new Color(148, 223, 234));
        panelconscrollPasajes.setBorder(new EmptyBorder(5, 5, 5, 5));
        panelconscrollPasajes.add(tablepasajes);
        ScrollPane s2 = new ScrollPane();
        s2.setPreferredSize(new Dimension(500, 150));
        s2.add(panelconscrollPasajes);
        tablepasajes.setBackground(new Color(148, 223, 234));
        verperfil.add(s2);

        //panel para cancelar vuelo
        JPanel cancelar_Vuelo = new JPanel();
        cancelar_Vuelo.setLayout(new BoxLayout(cancelar_Vuelo, BoxLayout.X_AXIS));
        JComboBox ID_PASAJE = new JComboBox(pasajes);
        cancelar_Vuelo.add(new JLabel("Pasajes"));
        cancelar_Vuelo.add(ID_PASAJE);

        box2.add(Box.createVerticalGlue());
        box2.add(Box.createVerticalGlue());
        box2.add(Box.createVerticalGlue());
        box2.add(Box.createVerticalGlue());
        box2.add(Box.createVerticalGlue());
        box2.add(Box.createVerticalGlue());
        box2.add(cerrar_Sesion);
        box2.add(Box.createVerticalGlue());
        box2.add(cancelar);
        box2.add(Box.createVerticalGlue());
        box2.add(Box.createVerticalGlue());
        box2.add(Box.createVerticalGlue());
        box2.add(Box.createVerticalGlue());
        box2.add(Box.createVerticalGlue());
        box2.add(Box.createVerticalGlue());
        verperfil.add(box2);






        botonVerPerfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paginacl.add(verperfil);
                Vervuelos.setVisible(false);
                verperfil.setVisible(true);
                vuelosFiltrados.setVisible(false);

            }
        });
        bontonVerVuelos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paginacl.add(Vervuelos);
                verperfil.setVisible(false);
                Vervuelos.setVisible(true);
                vuelosFiltrados.setVisible(false);

            }
        });

        Comprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int respuesta = JOptionPane.showConfirmDialog(null, comprarPasaje, "Ingrese los datos", JOptionPane.OK_CANCEL_OPTION);
                if (respuesta==JOptionPane.YES_OPTION){
                    Random random = new Random();
                    String ClaseParaComprar = (String) Clase.getSelectedItem();
                    int Vuelo = Integer.parseInt(ID_vuelo.getText());
                    int añadirAsiento =random.nextInt(150);
                    int precio=0;
                    if (ClaseParaComprar.equals("Turista")){
                       precio = random.nextInt(100);
                    }else if (ClaseParaComprar.equals("Premium")){
                        precio= random.nextInt(101)+100;
                    }else if (ClaseParaComprar.equals("Ejecutiva")){
                        precio= random.nextInt(201)+100;
                    }else if (ClaseParaComprar.equals("Primera")){
                        precio= random.nextInt(200)+800;
                    }
                    int añadirId_Pasaje =0;
                    try {
                            Statement st = c2.getConn().createStatement();
                            Statement st2 = c2.getConn().createStatement();
                            ResultSet rs = st.executeQuery("select MAX(ID_PASAJE) as MAX from PASAJE");
                            while (rs.next()) {
                                añadirId_Pasaje = rs.getInt("MAX");
                            }
                            añadirId_Pasaje++;
                            int ultimatum=JOptionPane.showConfirmDialog(null,"El pasaje vale "+precio+"€. Estas de acuerdo??");
                            if (ultimatum==JOptionPane.YES_OPTION) {
                                rs = st.executeQuery("INSERT into PASAJE (ID_PASAJE, ID_VUELO, CLASE, ASIENTO, PRECIO, DNI) VALUES (" + añadirId_Pasaje + ", " + Vuelo + ", '" + ClaseParaComprar + "', " + añadirAsiento + ", " + precio + ", '" + cliente.getDNI() + "')");
                                JOptionPane.showMessageDialog(null, "Pasaje comprado");
                            }
                        }
                        catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, "El vuelo no existe");
                        }
                }
            }
        });




        cerrar_Sesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                paginacl.setVisible(false);
                CerrarSesion(cliente);

            }
        });

        botonFiltrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int decision = 0;
                decision = JOptionPane.showConfirmDialog(null, panel,"Rango de precio", JOptionPane.OK_CANCEL_OPTION);
                if (decision == JOptionPane.YES_OPTION){
                    int precio1 = Integer.parseInt(preciominimo.getText());
                    int precio2 = Integer.parseInt(preciomaximo.getText());
                    JTable datos = new JTable(Inicio_de_sesion.MostrarvuelosFiltrados(c2, Columnas, precio1, precio2), Columnas);
                    JPanel panelconscroll = new JPanel();
                    panelconscroll.setBackground(new Color(148, 223, 234));
                    panelconscroll.setBorder(new EmptyBorder(5, 5, 5, 5));
                    panelconscroll.add(datos);
                    ScrollPane s1 = new ScrollPane();
                    s1.removeAll();
                    s1.setPreferredSize(new Dimension(500, 400));
                    s1.add(panelconscroll);
                    datos.setBackground(new Color(148, 223, 234));
                    vuelosFiltrados.removeAll();
                    vuelosFiltrados.add(titulo2);
                    vuelosFiltrados.add(s1);
                    paginacl.add(vuelosFiltrados);
                    vuelosFiltrados.setVisible(true);
                    Vervuelos.setVisible(false);
                    verperfil.setVisible(false);

                }
            }
        });

        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int decision = JOptionPane.showConfirmDialog(null, cancelar_Vuelo);
                if (decision==JOptionPane.YES_OPTION){
                    String pasajecancelado = ID_PASAJE.getSelectedItem().toString();
                    try {
                        Statement st = c2.getConn().createStatement();
                        ResultSet rs = st.executeQuery("Delete from PASAJE where ID_PASAJE = "+pasajecancelado+" and DNI = '"+cliente.getDNI()+"'");
                        JOptionPane.showMessageDialog(null,"Pasaje reembolsado");
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });


        paginacl.setLocationRelativeTo(null);
        paginacl.setResizable(false);
        paginacl.setVisible(true);

    }
    public static int Contfilas(Conexion c1, Cliente cliente) {
        int confilas=1;

        try {
            Statement buscar1 = c1.getConn().createStatement();
            ResultSet rs = buscar1.executeQuery("select * from Pasaje where DNI = '"+cliente.getDNI()+"'");
            while (rs.next()) {
                confilas++;

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return confilas;

    }

    public static String[][] Mostrarpasajes(Conexion c1, String[] ColumnasPasajes, Cliente cliente) {
        String[][] Filas = new String[Contfilas(c1, cliente)][6];
        try {

            Statement buscar1 = c1.getConn().createStatement();
            ResultSet rs = buscar1.executeQuery("select * from Pasaje where DNI = '"+cliente.getDNI()+"'");
            for (int i = 0; i < 6; i++) {
                Filas[0][i] = ColumnasPasajes[i];

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

    public static Cliente CerrarSesion(Cliente cliente){
        cliente = null;
        Inicio_de_sesion cerrarSesion = new Inicio_de_sesion();
        cerrarSesion.setVisible(true);
        return cliente;

    }
}
