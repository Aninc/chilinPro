package servicios;

import dataBase.DatabaseConnection;
import modelos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioService {//aqui error >p
   public Usuario validarUsuario(String email, String contrasena) {
    String query = "SELECT * FROM usuarios WHERE email = ? AND contrasena = ?";
    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(query)) {
        
        statement.setString(1, email);
        statement.setString(2, contrasena);
        System.out.println("Email ingresado: " + email);
        System.out.println("Contraseña ingresada: " + contrasena);
        
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            System.out.println("Usuario encontrado: " + resultSet.getString("nombre"));
            Usuario usuario = new Usuario();
            usuario.setId(resultSet.getInt("id_usuario"));
            usuario.setNombre(resultSet.getString("nombre"));
            usuario.setEmail(resultSet.getString("email"));
            usuario.setContrasena(resultSet.getString("contrasena"));
            usuario.setTipo(resultSet.getString("tipo"));
            usuario.setUltimoAcceso(resultSet.getTimestamp("ultimo_acceso"));
            return usuario;
        } else {
            System.out.println("Usuario o contraseña incorrectos para el email: " + email);
        }
        if (resultSet.next()) {
    System.out.println("Usuario encontrado: " + resultSet.getString("nombre"));
    System.out.println("Contraseña en la base de datos: " + resultSet.getString("contrasena"));
    // Comparar manualmente el valor almacenado y el ingresado para ver si difieren.
    
}
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}


    public boolean actualizarUsuario(Usuario usuario) {
        String query = "UPDATE usuarios SET nombre = ?, email = ?, contrasena = ?, tipo = ?, ultimoAcceso = ?, membresia = ?, fechaRegistro = ? WHERE id_usuario = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getEmail());
            statement.setString(3, usuario.getContrasena());
            statement.setString(4, usuario.getTipo());
            statement.setTimestamp(5, new java.sql.Timestamp(usuario.getUltimoAcceso().getTime()));
            statement.setString(6, usuario.getMembresia());
            statement.setDate(7, new java.sql.Date(usuario.getFechaRegistro().getTime()));
            statement.setInt(8, usuario.getId());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}