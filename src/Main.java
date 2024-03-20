import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner rc = new Scanner(System.in);
    static PrintStream trm = System.out;

    static ArrayList<Autor> autores = new ArrayList<>();
    static ArrayList<Editorial> editoriales = new ArrayList<>();
    static ArrayList<Libro> libros = new ArrayList<>();

    public static void main(String[] args) {

        int op = 0;
        int id;
        Autor a;
        do {
            trm.println("---- BIBLIOTECA -----");
            trm.println("1.- Agregar Autor");
            trm.println("2.- Agregar Editorial");
            trm.println("3.- Agregar Libro");
            trm.println("4.- Buscar Autor");
            trm.println("5.- Buscar Editorial");
            trm.println("6.- Buscar Libro");
            trm.println("7.- Modificar Autor");
            trm.println("8.- Modificar Editorial");
            trm.println("9.- Modificar Libro");
            trm.println("10.- Eliminar Autor");
            trm.println("11.- Eliminar Editorial");
            trm.println("12.- Eliminar Libro");
            trm.println("0.- Salir");
            trm.print("- Selecciona una opcion ->  ");
            op = rc.nextInt();
            switch (op) {
                case 0:
                    trm.println("----------------------------------");
                    trm.println("Programa finalizado con éxito!!...");
                    break;
                case 1:
                    Autor autor = registerAutor();
                    if (autor != null) {
                        autores.add(autor);
                    } else {
                        trm.println("Límite de autores alcanzados");
                    }
                    break;
                case 2:
                    Editorial editorial = registerEditorial();
                    if (editorial != null) {
                        editoriales.add(editorial);
                    } else {
                        trm.println("Límite de editoriales alcanzados");
                    }
                    break;
                case 3:
                    Libro libro = registerLibro();
                    if (libro != null) {
                        libros.add(libro);
                    } else {
                        trm.println("No se pudo registrar el libro");
                    }
                    break;
                case 4:
                    findAutor();
                    break;
                case 5:
                    findEditorial();
                    break;
                case 6:
                    findLibro();
                    break;
                case 7:
                    modifyAutor();
                    break;
                case 8:
                    modifyEditorial();
                    break;
                case 9:
                    modifyLibro();
                    break;
                case 10:
                    deleteAutor();
                    break;
                case 11:
                    deleteEditorial();
                    break;
                case 12:
                    deleteLibro();
                    break;
                default:
                    trm.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }

        } while (op != 0);
    }

    public static Autor registerAutor() {
        int id;
        String nombre, aPaterno, aMaterno, ciudad;

        trm.println("----- Registra un Autor -------");

        trm.print("Ingresa el id del autor: ");
        id = rc.nextInt();
        rc.nextLine();

        trm.print("Ingresa el nombre del autor: ");
        nombre = rc.nextLine();
        trm.print("Ingresa el apellido paterno del autor: ");
        aPaterno = rc.nextLine();
        trm.print("Ingresa el apellido materno del autor: ");
        aMaterno = rc.nextLine();
        trm.print("Ingresa la ciudad del autor: ");
        ciudad = rc.nextLine();
        trm.println(" --------------------------------------");

        return new Autor(id, nombre, aPaterno, aMaterno, ciudad);
    }

    public static Autor findAutor() {
        trm.println("----- Busca un Autor -------");
        trm.println("Ingrese el id del usuario que desea buscar -> ");
        int idToFind = rc.nextInt();

        for (Autor a : autores) {
            if (a.getId() == idToFind) {
                trm.println("--------------------------------------");
                trm.println("Nombre: " + a.getNombre());
                trm.println("Apellido Paterno: " + a.getaPaterno());
                trm.println("Apellido Materno: " + a.getaMaterno());
                trm.println("Ciudad: " + a.getCiudad());
                trm.println("--------------------------------------");
                return a;
            }
        }
        trm.println("No se encontró ningún autor con ese ID.");
        return null;
    }

    public static Autor findAutor(int idToFind) {
        for (Autor a : autores) {
            if (a.getId() == idToFind) {
                return a;
            }
        }
        return null;
    }

    public static String showAutors() {
        StringBuilder output = new StringBuilder();
        output.append("----- Listar Autores -----\n");

        if (autores.isEmpty()) {
            output.append("No hay autores registrados.\n");
        } else {
            output.append("ID\tNombre\tApellido Paterno\tApellido Materno\tCiudad\n");
            for (Autor autor : autores) {
                output.append(autor.getId())
                        .append("\t").append(autor.getNombre())
                        .append("\t").append(autor.getaPaterno())
                        .append("\t").append(autor.getaMaterno())
                        .append("\t").append(autor.getCiudad())
                        .append("\n");
            }
        }

        return output.toString();
    }

    public static void modifyAutor() {
        trm.println("----- Editar Autor -----");
        trm.print("Ingrese el ID del autor que desea editar: ");
        int idToEdit = rc.nextInt();
        rc.nextLine();

        boolean found = false;
        for (Autor autor : autores) {
            if (autor.getId() == idToEdit) {
                trm.println("---------- Autor Encontrado -------------------");

                trm.print("Ingresa el nombre del autor: ");
                String nombre = rc.nextLine();
                trm.print("Ingresa el apellido paterno del autor: ");
                String aPaterno = rc.nextLine();
                trm.print("Ingresa el apellido materno del autor: ");
                String aMaterno = rc.nextLine();
                trm.print("Ingresa la ciudad del autor: ");
                String ciudad = rc.nextLine();

                autor.setNombre(nombre);
                autor.setaPaterno(aPaterno);
                autor.setaMaterno(aMaterno);
                autor.setCiudad(ciudad);

                trm.println("Autor actualizado con éxito.");
                trm.println("--------------------------------------");
                found = true;
                break;
            }
        }

        if (!found) {
            trm.println("No se encontró ningún autor con ese ID.");
        }
    }

    public static void deleteAutor() {
        trm.println("----- Eliminar Autor -----");
        trm.print("Ingrese el ID del autor que desea eliminar: ");
        int idToDelete = rc.nextInt();
        rc.nextLine();

        boolean found = false;
        for (int i = 0; i < autores.size(); i++) {
            Autor autor = autores.get(i);
            if (autor.getId() == idToDelete) {
                autores.remove(i);
                trm.println("Autor encontrado y eliminado.");
                found = true;
                trm.println("--------------------------------------");
                break;
            }
        }

        if (!found) {
            trm.println("No se encontró ningún autor con ese ID.");
        }
    }

    /* EDITORIAL */

    public static Editorial registerEditorial() {
        int id;
        String nombre, direccion, ciudad;
        long telefono;

        trm.println("----- Registra una Editorial -------");

        trm.print("Ingresa el id de la editorial: ");
        id = rc.nextInt();
        rc.nextLine();

        trm.print("Ingresa el nombre de la editorial: ");
        nombre = rc.nextLine();
        trm.print("Ingresa la dirección de la editorial: ");
        direccion = rc.nextLine();
        trm.print("Ingresa el teléfono de la editorial: ");
        telefono = rc.nextLong();
        rc.nextLine();
        trm.print("Ingresa la ciudad de la editorial: ");
        ciudad = rc.nextLine();
        trm.println(" --------------------------------------");

        return new Editorial(id, nombre, direccion, telefono, ciudad);
    }

    public static Editorial findEditorial() {
        trm.println("----- Busca una Editorial -------");
        trm.println("Ingrese el id de la editorial que desea buscar -> ");
        int idToFind = rc.nextInt();

        for (Editorial editorial : editoriales) {
            if (editorial.getId() == idToFind) {
                trm.println("--------------------------------------");
                trm.println("Nombre: " + editorial.getNombre());
                trm.println("Direccion: " + editorial.getDireccion());
                trm.println("Telefono: " + editorial.getTelefono());
                trm.println("Ciudad: " + editorial.getCiudad());
                trm.println("--------------------------------------");
                return editorial;
            }
        }
        trm.println("No se encontró ninguna editorial con ese ID.");
        return null;
    }

    public static Editorial findEditorial(int id) {

        for (Editorial editorial : editoriales) {
            if (editorial.getId() == id) {
                return editorial;
            }
        }
        return null;
    }

    public static String showEditoriales() {
        StringBuilder output = new StringBuilder();
        output.append("----- Listar Editoriales -----\n");
        if (editoriales.isEmpty()) {
            output.append("No hay editoriales registradas.\n");
        } else {
            output.append("ID\tNombre\tDireccion\tTelefono\tCiudad\n");
            for (Editorial editorial : editoriales) {
                output.append(editorial.getId())
                        .append("\t").append(editorial.getNombre())
                        .append("\t").append(editorial.getDireccion())
                        .append("\t").append(editorial.getTelefono())
                        .append("\t").append(editorial.getCiudad())
                        .append("\n");
            }
        }
        return output.toString();
    }

    public static void modifyEditorial() {
        trm.println("----- Editar Editorial -----");
        trm.print("Ingrese el ID de la editorial que desea editar: ");
        int idToEdit = rc.nextInt();
        rc.nextLine();

        boolean found = false;
        for (Editorial editorial : editoriales) {
            if (editorial.getId() == idToEdit) {
                trm.println("---------- Editorial Encontrada -------------------");

                trm.print("Ingresa el nombre de la editorial: ");
                String nombre = rc.nextLine();
                trm.print("Ingresa la dirección de la editorial: ");
                String direccion = rc.nextLine();
                trm.print("Ingresa el teléfono de la editorial: ");
                long telefono = rc.nextLong();
                rc.nextLine(); // Consumir el salto de línea pendiente después de nextLong()
                trm.print("Ingresa la ciudad de la editorial: ");
                String ciudad = rc.nextLine();

                // Actualizar los datos de la editorial encontrada
                editorial.setNombre(nombre);
                editorial.setDireccion(direccion);
                editorial.setTelefono(telefono);
                editorial.setCiudad(ciudad);

                trm.println("Editorial actualizada con éxito.");
                trm.println("--------------------------------------");
                found = true;
                break;
            }
        }

        if (!found) {
            trm.println("No se encontró ninguna editorial con ese ID.");
        }
    }

    public static void deleteEditorial() {
        trm.println("----- Eliminar Editorial -----");
        trm.print("Ingrese el ID de la editorial que desea eliminar: ");
        int idToDelete = rc.nextInt();
        rc.nextLine();

        boolean found = false;
        for (int i = 0; i < editoriales.size(); i++) {
            Editorial editorial = editoriales.get(i);
            if (editorial.getId() == idToDelete) {
                editoriales.remove(i);
                trm.println("Editorial encontrada y eliminada.");
                found = true;
                trm.println("--------------------------------------");
                break;
            }
        }

        if (!found) {
            trm.println("No se encontró ninguna editorial con ese ID.");
        }
    }

    /* LIBRO */

    public static Libro registerLibro() {
        long isbn;
        String titulo, edicion, genero;
        Editorial editorial;
        ArrayList<Autor> autores = new ArrayList<>(); // Inicializamos la lista de autores

        trm.println("----- Registra un Libro -------");

        trm.print("Ingresa el isbn del libro: ");
        isbn = rc.nextLong();
        rc.nextLine();

        trm.print("Ingresa el título del libro: ");
        titulo = rc.nextLine();
        trm.print("Ingresa la edición del libro: ");
        edicion = rc.nextLine();
        trm.print("Ingresa el género del libro: ");
        genero = rc.nextLine();
        trm.print("Ingresa el id del editorial: ");
        int idEditorial = rc.nextInt();
        editorial = findEditorial(idEditorial);

        if (editorial != null) {
            int op;
            do {
                trm.println("---- Autores -----");
                trm.println("1.- Agregar Autor");
                trm.println("2.- Finalizar");
                op = rc.nextInt();
                if (op == 1) {
                    trm.print("Ingrese el ID del autor: ");
                    int idAutor = rc.nextInt();
                    Autor autor = findAutor(idAutor); // Obtener el autor por su ID
                    if (autor != null) {
                        autores.add(autor);
                        trm.println("Autor agregado al libro.");
                    } else {
                        trm.println("No se encontró ningún autor con ese ID.");
                    }
                }
            } while (op != 2);
        } else {
            trm.println("--------------------------");
            trm.println(" El editorial no existe!! ");
            trm.println("--------------------------");
            return null;
        }

        return new Libro(isbn, titulo, edicion, genero, editorial, autores);
    }



    public static Libro findLibro() {
        trm.println("----- Busca un Libro -------");
        trm.println("Ingrese el ISBN del libro que desea buscar -> ");
        long isbnToFind = rc.nextLong();

        for (Libro libro : libros) {
            if (libro.getIsbn() == isbnToFind) {
                trm.println("--------------------------------------");
                trm.println("Libro: " + libro.getTitulo());
                trm.println("Editorial: " + libro.getEditorial().getNombre());
                trm.println("Género: " + libro.getGenero());
                trm.print("Autores: ");
                for (Autor autor : libro.getAutores()) {
                    trm.print(autor.getNombreCompleto() + ", ");
                }
                trm.println("\n--------------------------------------");
                return libro;
            }
        }
        trm.println("No se encontró ningún libro con ese ISBN.");
        return null;
    }

    public static String showLibros(ArrayList<Libro> libros) {
        StringBuilder output = new StringBuilder();
        output.append("----- Listar Libros -----\n");

        if (libros == null || libros.isEmpty()) {
            output.append("No hay libros registrados.\n");
        } else {
            output.append(String.format("%-15s%-50s%-15s%-20s%-30s\n", "ISBN", "Titulo", "Edición", "Género", "Editorial"));
            for (Libro libro : libros) {
                output.append(String.format("%-15d%-50s%-15s%-20s%-30s\n",
                        libro.getIsbn(),
                        libro.getTitulo(),
                        libro.getEdicion(),
                        libro.getGenero(),
                        libro.getEditorial().getNombre()));
            }
        }
        return output.toString();
    }

    public static void modifyLibro() {
        trm.println("----- Editar Libro -----");
        trm.print("Ingrese el ISBN del libro que desea editar: ");
        long isbnToEdit = rc.nextLong();
        rc.nextLine();

        boolean found = false;
        for (Libro libro : libros) {
            if (libro.getIsbn() == isbnToEdit) {
                trm.println("---------- Libro Encontrado -------------------");

                trm.print("Ingrese el nuevo título del libro: ");
                String nuevoTitulo = rc.nextLine();
                trm.print("Ingrese la nueva edición del libro: ");
                String nuevaEdicion = rc.nextLine();
                trm.print("Ingrese el nuevo género del libro: ");
                String nuevoGenero = rc.nextLine();

                libro.setTitulo(nuevoTitulo);
                libro.setEdicion(nuevaEdicion);
                libro.setGenero(nuevoGenero);

                trm.println("Libro actualizado con éxito.");
                trm.println("--------------------------------------");
                found = true;
                break;
            }
        }

        if (!found) {
            trm.println("No se encontró ningún libro con ese ISBN.");
        }
    }


    public static void deleteLibro() {
        trm.println("----- Eliminar Libro -----");
        trm.print("Ingrese el ISBN del libro que desea eliminar: ");
        long isbnToDelete = rc.nextLong();

        boolean found = false;
        for (int i = 0; i < libros.size(); i++) {
            Libro libro = libros.get(i);
            if (libro.getIsbn() == isbnToDelete) {
                libros.remove(i);
                trm.println("Libro encontrado y eliminado.");
                found = true;
                trm.println("--------------------------------------");
                break;
            }
        }

        if (!found) {
            trm.println("No se encontró ningún libro con ese ISBN.");
        }
    }

}