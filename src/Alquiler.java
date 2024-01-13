import java.time.LocalDateTime;
import java.util.List;

class Alquiler {
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaEntrega;
    private int id;
    private List<Peliculas> peliculas;
    private Cliente cliente;

    public Alquiler(int id, List<Peliculas> peliculas, Cliente cliente) {
        this.id = id;
        this.peliculas = peliculas;
        this.cliente = cliente;
        this.fechaInicio = LocalDateTime.now();
        this.fechaEntrega = this.fechaInicio.plusDays(7);
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDateTime fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Peliculas> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Peliculas> peliculas) {
        this.peliculas = peliculas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}