package servicios;

import com.mysql.cj.jdbc.Driver;
import dataBase.DatabaseConnection;
import modelos.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class AdminService {

    // Método para validar a un administrador
    public boolean validarAdmin(String usuario, String contrasena) {
        boolean isValid = false;
        String query = "SELECT * FROM admins WHERE usuario = ? AND contrasena = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, usuario);
            statement.setString(2, contrasena);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                isValid = true;  // Si se encontró una coincidencia, las credenciales son válidas
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isValid;
    }
}
