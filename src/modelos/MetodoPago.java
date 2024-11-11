package modelos;

public class MetodoPago {
    private String numeroTarjeta;
    private String nombreTitular;  // Añadido para reflejar el campo en la base de datos
    private String fechaVencimiento;  // Añadido para reflejar el campo en la base de datos

    // Getters y setters
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}