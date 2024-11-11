package servicios;

import dataBase.DatabaseConnection;
import modelos.Pregunta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PreguntaService {

    // Método para agregar una nueva pregunta
    public boolean agregarPregunta(Pregunta nuevaPregunta) {
        String query = "INSERT INTO preguntas (user_id, mensaje) VALUES (?, ?)";
        boolean isInserted = false;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, nuevaPregunta.getUserId());
            statement.setString(2, nuevaPregunta.getMensaje());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                isInserted = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isInserted;
    }

    // Método para obtener todas las preguntas de un usuario específico
    public List<Pregunta> obtenerPreguntasPorUsuario(int userId) {
        List<Pregunta> preguntas = new ArrayList<>();
        String query = "SELECT * FROM preguntas WHERE user_id = ? ORDER BY fecha DESC";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Pregunta pregunta = new Pregunta();
                pregunta.setId(resultSet.getInt("id"));
                pregunta.setUserId(resultSet.getInt("user_id"));
                pregunta.setMensaje(resultSet.getString("mensaje"));
                pregunta.setFecha(resultSet.getTimestamp("fecha"));
                preguntas.add(pregunta);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return preguntas;
    }
}
