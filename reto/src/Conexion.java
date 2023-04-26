import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Conexion {
        static final String SERVER_IP = "172.16.7.81";
        static final String DB_NAME = "orcl";
        static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
        static final String DB_URL ="jdbc:oracle:thin:@"+SERVER_IP+":1521/"+ DB_NAME;


        static final String USER = "DW31_GRUPO5";
        static final String PASS = "Zubiri123";

        private Connection conn;

        private Statement st;
        private ResultSet rs;


        public Conexion() {
            try {
                Class.forName(JDBC_DRIVER);
                System.out.println("Connection to database...");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                System.out.println("Connected.");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    public Connection getConn() {
        return conn;
    }

    public Statement getSt() {
        return st;
    }

    public ResultSet getRs() {
        return rs;
    }
}
