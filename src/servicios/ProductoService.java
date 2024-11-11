package servicios;

import dataBase.DatabaseConnection;
import modelos.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoService {

    // Método para comprar un producto
    public boolean comprarProducto(Producto producto) {
        String query = "INSERT INTO compras (producto_id, usuario_id, cantidad, total) VALUES (?, ?, ?, ?)";
        boolean isPurchased = false;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Simulando valores, ya que el id del usuario no está definido
            int usuarioId = 1; // En un caso real, sería el id del usuario logueado
            int cantidad = 1; // Simulando que se compra solo una unidad
            double total = producto.getPrecio() * cantidad;

            statement.setInt(1, producto.getId());
            statement.setInt(2, usuarioId);
            statement.setInt(3, cantidad);
            statement.setDouble(4, total);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                isPurchased = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isPurchased;
    }

    // Método para obtener un producto por su ID
    public Producto obtenerProductoPorId(int id) {
        Producto producto = null;
        String query = "SELECT * FROM productos WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                producto = new Producto();
                producto.setId(resultSet.getInt("id"));
                producto.setTitulo(resultSet.getString("titulo"));
                producto.setDescripcion(resultSet.getString("descripcion"));
                producto.setPrecio(resultSet.getDouble("precio"));
                producto.setStock(resultSet.getInt("stock"));
                producto.setCategoria(resultSet.getString("categoria"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return producto;
    }

    // Método para obtener todos los productos
    public List<Producto> obtenerTodosLosProductos() {
        List<Producto> productos = new ArrayList<>();
        String query = "SELECT * FROM productos";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Producto producto = new Producto();
                producto.setId(resultSet.getInt("id"));
                producto.setTitulo(resultSet.getString("titulo"));
                producto.setDescripcion(resultSet.getString("descripcion"));
                producto.setPrecio(resultSet.getDouble("precio"));
                producto.setStock(resultSet.getInt("stock"));
                producto.setCategoria(resultSet.getString("categoria"));
                productos.add(producto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return productos;
    }
}
