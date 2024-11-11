package servicios;

import dataBase.DatabaseConnection;
import modelos.MetodoPago;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MetodoPagoService {

    // Método para agregar un método de pago
    public boolean agregarMetodoPago(MetodoPago metodoPago) {
        String query = "INSERT INTO metodos_pago (numero_tarjeta, nombre_titular, fecha_vencimiento) VALUES (?, ?, ?)";
        boolean isInserted = false;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, metodoPago.getNumeroTarjeta());
            statement.setString(2, metodoPago.getNombreTitular());
            statement.setString(3, metodoPago.getFechaVencimiento());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                isInserted = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isInserted; // Asegúrate de devolver un valor booleano apropiado
    }
}