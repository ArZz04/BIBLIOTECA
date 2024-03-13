import java.util.ArrayList;

public class Libro {
    private long isbn;
    private String titulo;
    private String edicion;
    private String genero;
    private Editorial editorial;
    private ArrayList<Autor> autores;

    public Libro (long isbn, String titulo, String edicion, String genero, Editorial editorial, ArrayList<Autor> autores){
        this.isbn = isbn;
        this.titulo = titulo;
        this.edicion = edicion;
        this.genero = genero;
        this.editorial = editorial;
        this.autores = autores;
    }

    public long getIsbn(){
        return isbn;
    }

    public void setIsbn(long isbn){
        this.isbn = isbn;
    }

    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getEdicion(){
        return edicion;
    }

    public void setEdicion(String edicion){
        this.edicion = edicion;
    }

    public String getGenero(){
        return genero;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    public Editorial getEditorial(){
        return editorial;
    }

    public void setEditorial(Editorial editorial){
        this.editorial = editorial;
    }

    public ArrayList<Autor> getAutores(){
        return autores;
    }

    public void setAutores(ArrayList<Autor> autores){
        this.autores = autores;
    }
}
