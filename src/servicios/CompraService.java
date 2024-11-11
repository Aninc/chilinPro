// CompraService.java actualizado
package servicios;

import dataBase.DatabaseConnection;
import modelos.Compra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompraService {
    public boolean agregarCompra(Compra compra) {
        String query = "INSERT INTO compras (id_usuario, id_contenido, fecha_compra, estado, direccion_envio) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, compra.getIdUsuario());
            statement.setInt(2, compra.getIdContenido());
            statement.setDate(3, new java.sql.Date(compra.getFechaCompra().getTime()));
            statement.setString(4, compra.getEstado());
            statement.setString(5, compra.getDireccionEnvio());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Compra> obtenerComprasPorUsuario(int userId) {
        List<Compra> compras = new ArrayList<>();
        String query = "SELECT * FROM compras WHERE id_usuario = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Compra compra = new Compra();
                compra.setId(resultSet.getInt("id_compra"));
                compra.setIdUsuario(resultSet.getInt("id_usuario"));
                compra.setIdContenido(resultSet.getInt("id_contenido"));
                compra.setFechaCompra(resultSet.getDate("fecha_compra"));
                compra.setEstado(resultSet.getString("estado"));
                compra.setDireccionEnvio(resultSet.getString("direccion_envio"));
                compras.add(compra);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return compras;
    }
}