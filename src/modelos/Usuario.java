// Usuario.java actualizado
package modelos;

import java.util.Date;

public class Usuario {
    private int id;
    private String nombre;
    private String email;
    private String contrasena;
    private String tipo;
    private Date ultimo_acceso;
    private String membresia;  // Añadido para reflejar membresía del usuario
    private Date fechaRegistro;  // Añadido para reflejar la fecha de registro

    // Constructor vacío
    public Usuario() {}

    // Constructor completo
    public Usuario(int id, String nombre, String email, String membresia, Date fechaRegistro, Date ultimoAcceso, String contrasena, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.membresia = membresia;
        this.fechaRegistro = fechaRegistro;
        this.ultimo_acceso = ultimoAcceso;
        this.contrasena = contrasena;
        this.tipo = tipo;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getUltimoAcceso() {
        return ultimo_acceso;
    }

    public void setUltimoAcceso(Date ultimo_acceso) {
        this.ultimo_acceso = ultimo_acceso;
    }

    public String getMembresia() {
        return membresia;
    }

    public void setMembresia(String membresia) {
        this.membresia = membresia;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
} 