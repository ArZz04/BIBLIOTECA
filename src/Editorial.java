public class Editorial {
    private int id;
    private String nombre;
    private String direccion;
    private long telefono;
    private String ciudad;

    public Editorial (int id, String nombre, String direccion, long telefono, String ciudad){
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ciudad = ciudad;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getDireccion(){
        return direccion;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }


    public long getTelefono(){
        return telefono;
    }

    public void setTelefono(long telefono){
        this.telefono = telefono;
    }

    public String getCiudad(){
        return ciudad;
    }

    public void setCiudad(String ciudad){
        this.ciudad = ciudad;
    }
}
