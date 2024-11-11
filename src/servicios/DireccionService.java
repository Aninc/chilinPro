package servicios;

import dataBase.DatabaseConnection;
import modelos.Direccion;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DireccionService {

    // Método para agregar una nueva dirección a la base de datos
    public boolean agregarDireccion(Direccion nuevaDireccion) {
        String query = "INSERT INTO direcciones (estado, ciudad, calle, codigo_postal, referencias, telefono, user_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        boolean isInserted = false;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, nuevaDireccion.getEstado());
            statement.setString(2, nuevaDireccion.getCiudad());
            statement.setString(3, nuevaDireccion.getCalle());
            statement.setString(4, nuevaDireccion.getCodigoPostal());
            statement.setString(5, nuevaDireccion.getReferencias());
            statement.setString(6, nuevaDireccion.getTelefono());
            statement.setInt(7, nuevaDireccion.getUserId());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                isInserted = true; // La dirección se insertó correctamente
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isInserted;
    }
}
