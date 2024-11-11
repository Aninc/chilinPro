package modelos;

import java.sql.Timestamp;

public class Pregunta {
    private int id;
    private int userId;
    private String mensaje;
    private Timestamp fecha;

    // Constructor vacío
    public Pregunta() {}

    // Constructor con parámetros
    public Pregunta(int id, int userId, String mensaje, Timestamp fecha) {
        this.id = id;
        this.userId = userId;
        this.mensaje = mensaje;
        this.fecha = fecha;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
}
