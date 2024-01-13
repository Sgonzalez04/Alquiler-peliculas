class Cliente {
    private int id;
    private String nombre;
    private String correo;
    private String celular;

    public Cliente(int id, String nombre, String correo, String celular) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.celular = celular;
    }

    // Getters and setters for id, nombre, correo, and celular

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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}
