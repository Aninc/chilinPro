package servicios;

import com.mysql.cj.jdbc.Driver;
import dataBase.DatabaseConnection;
import modelos.Pelicula;
import modelos.Compra;
import modelos.MetodoPago;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PeliculaService {

    // Método para obtener las películas recomendadas
    public List<Pelicula> obtenerPeliculasRecomendadas() {
        List<Pelicula> peliculasRecomendadas = new ArrayList<>();
        String query = "SELECT * FROM peliculas WHERE recomendada = 1";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Pelicula pelicula = new Pelicula();

                pelicula.setTitulo(resultSet.getString("titulo"));
                pelicula.setSinopsis(resultSet.getString("sinopsis"));
                pelicula.setClasificacion(resultSet.getString("clasificacion"));
                peliculasRecomendadas.add(pelicula);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return peliculasRecomendadas;
    }

    // Método para buscar películas por título o descripción
    public List<Pelicula> buscarPeliculas(String queryParam) {
        List<Pelicula> peliculasEncontradas = new ArrayList<>();
        String query = "SELECT * FROM peliculas WHERE titulo LIKE ? OR sinopsis LIKE ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, "%" + queryParam + "%");
            statement.setString(2, "%" + queryParam + "%");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Pelicula pelicula = new Pelicula();
                pelicula.setId(resultSet.getInt("id"));
                pelicula.setTitulo(resultSet.getString("titulo"));
                pelicula.setSinopsis(resultSet.getString("sinopsis"));
                pelicula.setClasificacion(resultSet.getString("clasificacion"));
                peliculasEncontradas.add(pelicula);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return peliculasEncontradas;
    }

    // Método para agregar una nueva película
    public boolean agregarPelicula(Pelicula nuevaPelicula) {
        String query = "INSERT INTO peliculas (titulo, sinopsis, clasificacion, anio_estreno, duracion, recomendada) VALUES (?, ?, ?, ?, ?, ?)";
        boolean isInserted = false;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, nuevaPelicula.getTitulo());
            statement.setString(2, nuevaPelicula.getSinopsis());
            statement.setString(3, nuevaPelicula.getClasificacion());
            statement.setString(4, nuevaPelicula.getAnio_estreno());
            statement.setInt(5, nuevaPelicula.getDuracion());
            statement.setBoolean(6, nuevaPelicula.getRecomendada()); // True o false para recomendada

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
