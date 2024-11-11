package servicios;

import dataBase.DatabaseConnection;
import modelos.Membresia;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MembresiaService {

    // Método para actualizar la membresía de un usuario
    public boolean actualizarMembresia(Membresia membresia) {
        String query = "UPDATE usuarios SET membresia = ? WHERE user_id = ?";
        boolean isUpdated = false;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, membresia.getTipo());
            statement.setInt(2, 1); // Supongamos que estamos usando un usuario específico para la prueba

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                isUpdated = true; // La membresía se actualizó correctamente
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isUpdated;
    }
}
