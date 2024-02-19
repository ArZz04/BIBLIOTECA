public class Autor {
    //Atributo de instancia
    private int id;
    private String nombre;
    private String aPaterno;
    private String aMaterno;
    private String ciudad;

    public Autor() {
    }

    public Autor(int id, String nombre, String aPaterno, String aMaterno, String ciudad){
        this.id = id;
        this.nombre = nombre;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.ciudad = ciudad;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id){
        this.id=id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getaPaterno() {
        return this.aPaterno;
    }

    public void setaPaterno(String aPaterno){
        this.aPaterno = aPaterno;
    }

    public String getaMaterno() {
        return this.aMaterno;
    }

    public void setaMaterno(String aMaterno){
        this.aMaterno = aMaterno;
    }

    public String getCiudad() {
        return this.ciudad;
    }

    public void setCiudad(String ciudad){
        this.ciudad = ciudad;
    }

}