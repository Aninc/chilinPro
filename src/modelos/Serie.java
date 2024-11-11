package modelos;

public class Serie {
    private int id;
    private String titulo;
    private String sinopsis;
    private int temporadas;
    private String genero;
    private String clasificacion; // Añadido
    private String imagen; // Añadido

    // Constructor vacío
    public Serie() {}

    // Constructor con parámetros
    public Serie(int id, String titulo, String sinopsis, int temporadas, String genero, String clasificacion, String imagen) {
        this.id = id;
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.temporadas = temporadas;
        this.genero = genero;
        this.clasificacion = clasificacion;
        this.imagen = imagen;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
