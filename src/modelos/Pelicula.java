package modelos;

public class Pelicula {
    private int id;
    private String titulo;
    private String clasificacion;
    private String sinopsis; // Añadimos este atributo para la sinopsis
    private String anio_estreno;
    private int duracion;
    private boolean recomendada;
    // Getters y setters

    public String getAnio_estreno(){
        return anio_estreno;
    }
    
    public void setAnio_estreno(String anio_estreno){
        this.anio_estreno=anio_estreno;
    }
    
    public int getDuracion(){
        return duracion;
    }
    
    public void setDuracion(int duracion){
        this.duracion=duracion;
    }
    
    public boolean getRecomendada(){
        return recomendada;
    }
    
    public void setRecomendada(boolean recomendada) { // Corregido 'recomendad' a 'recomendada'
        this.recomendada = recomendada;
    }
    
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

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    // Getter y setter para sinopsis
    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
}
