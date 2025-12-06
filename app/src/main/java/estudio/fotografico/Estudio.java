package estudio.fotografico;

public class Estudio {

    private String id_estudio;
    private String nombre;
    private String direccion;
    private String terminos;
    private String encargado;
    private String id_usuario_responsable;

    public Estudio() {}

    public Estudio(String id_estudio, String nombre, String direccion,
                   String terminos, String encargado, String id_usuario_responsable) {

        this.id_estudio = id_estudio;
        this.nombre = nombre;
        this.direccion = direccion;
        this.terminos = terminos;
        this.encargado = encargado;
        this.id_usuario_responsable = id_usuario_responsable;
    }

    public String getId_estudio() { return id_estudio; }
    public String getNombre() { return nombre; }
    public String getDireccion() { return direccion; }
    public String getTerminos() { return terminos; }
    public String getEncargado() { return encargado; }
    public String getId_usuario_responsable() { return id_usuario_responsable; }

    public void setId_estudio(String id_estudio) { this.id_estudio = id_estudio; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public void setTerminos(String terminos) { this.terminos = terminos; }
    public void setEncargado(String encargado) { this.encargado = encargado; }
    public void setId_usuario_responsable(String id_usuario_responsable) { this.id_usuario_responsable = id_usuario_responsable; }
}
