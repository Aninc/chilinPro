package servicios;

import dataBase.DatabaseConnection;
import modelos.Serie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SerieService {

    // Método para obtener las series recomendadas
    public List<Serie> obtenerSeriesRecomendadas() {
        List<Serie> seriesRecomendadas = new ArrayList<>();
        String query = "SELECT * FROM series WHERE recomendada = 1";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Serie serie = new Serie();
                serie.setId(resultSet.getInt("id"));
                serie.setTitulo(resultSet.getString("titulo"));
                serie.setSinopsis(resultSet.getString("sinopsis"));
                serie.setClasificacion(resultSet.getString("clasificacion"));
                serie.setImagen(resultSet.getString("imagen")); // Nueva propiedad para la imagen
                seriesRecomendadas.add(serie);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return seriesRecomendadas;
    }

    // Método para buscar series por título o descripción
    public List<Serie> buscarSeries(String queryParam) {
        List<Serie> seriesEncontradas = new ArrayList<>();
        String query = "SELECT * FROM series WHERE titulo LIKE ? OR sinopsis LIKE ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, "%" + queryParam + "%");
            statement.setString(2, "%" + queryParam + "%");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Serie serie = new Serie();
                serie.setId(resultSet.getInt("id"));
                serie.setTitulo(resultSet.getString("titulo"));
                serie.setSinopsis(resultSet.getString("sinopsis"));
                serie.setClasificacion(resultSet.getString("clasificacion"));
                serie.setImagen(resultSet.getString("imagen")); // Nueva propiedad para la imagen
                seriesEncontradas.add(serie);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return seriesEncontradas;
    }

    // Método para agregar una nueva serie
    public boolean agregarSerie(Serie nuevaSerie) {
        String query = "INSERT INTO series (titulo, sinopsis, clasificacion, imagen) VALUES (?, ?, ?, ?)";
        boolean isInserted = false;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, nuevaSerie.getTitulo());
            statement.setString(2, nuevaSerie.getSinopsis());
            statement.setString(3, nuevaSerie.getClasificacion());
            statement.setString(4, nuevaSerie.getImagen()); // Nueva propiedad para la imagen

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                isInserted = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isInserted;
    }
}
