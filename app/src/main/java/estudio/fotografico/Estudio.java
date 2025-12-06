package estudio.fotografico;

public class Estudio {
    String id;
    String nombre;
    String direccion;
    String terminos;
    String idEncargado;
    String idAdministrador;

    public Estudio(String id, String nombre, String direccion, String terminos, String idEncargado, String idAdministrador) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.terminos = terminos;
        this.idEncargado = idEncargado;
        this.idAdministrador = idAdministrador;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTerminos() {
        return terminos;
    }

    public void setTerminos(String terminos) {
        this.terminos = terminos;
    }

    public String getIdEncargado() {
        return idEncargado;
    }

    public void setIdEncargado(String idEncargado) {
        this.idEncargado = idEncargado;
    }

    public String getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(String idAdministrador) {
        this.idAdministrador = idAdministrador;
    }
}
