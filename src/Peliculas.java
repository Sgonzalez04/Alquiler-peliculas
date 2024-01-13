public class Peliculas {
    private int id;
    private String titulo;
    private String director;
    private String genero;
    private double precioAlquiler;
    private double descuento;

    public Peliculas(int id, String titulo, String director, String genero, double precioAlquiler, double descuento) {
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
        this.precioAlquiler = precioAlquiler;
        this.descuento = descuento;
    }

    // Getters y setters

    public double calcularPrecioTotal() {
        return precioAlquiler - (precioAlquiler * descuento);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setPrecioAlquiler(double precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDirector() {
        return director;
    }

    public String getGenero() {
        return genero;
    }

    public double getPrecioAlquiler() {
        return precioAlquiler;
    }

    public double getDescuento() {
        return descuento;
    }
}