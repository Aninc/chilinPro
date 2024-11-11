package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver; // IMPORTACIÓN CORREGIDA A ESTA POSICIÓN

public class DatabaseConnection {
    // Método para obtener la conexión a la base de datos
        static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al registrar el driver: " + e.getMessage());
        }
    }
    
    public static Connection getConnection() {
        Connection connection = null;
        try {
            String url = "jdbc:mysql://localhost:3306/vhs"; // Cambia 'localhost' si tu servidor está en otro lado
            String user = "root"; // Tu usuario de MySQL
            String password = "Chimbombin4."; // Tu contraseña de MySQL

            // Obtener la conexión
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexion a la base de datos establecida con exito.");

        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos.");
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        // Prueba la conexión
        getConnection();
    }
}
