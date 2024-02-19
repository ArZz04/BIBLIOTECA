import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    static Scanner rc = new Scanner(System.in);
    static PrintStream trm = System.out;
    static boolean trmController = true;

    public static void main(String[] args) {

        int arraySize = 10;
        Autor[] autors = new Autor[arraySize];
        int op = 0;
        int pos = 0;
        do {
            trm.println("---- REGISTRADOR DE AUTORES -----");
            trm.println("1.- Agregar");
            trm.println("2.- Buscar");
            trm.println("3.- Listar");
            trm.println("4.- Modificar");
            trm.println("5.- Eliminar");
            trm.println("0.- Salir");
            trm.print("- Selecciona una opcion ->  ");
            op = rc.nextInt();
            switch (op) {
                case 0:
                    trm.println("----------------------------------");
                    trm.println("Programa finalizado con exito!!...");
                    break;
                case 1:
                    if (pos < arraySize) {
                        autors[pos] = registerAutor();
                        pos++;
                    } else {
                        trm.println("Limite de autores alcanzados");
                    }
                    break;
                case 2:
                    Autor foundAutor = findUser(autors);
                    if (foundAutor != null) {
                        trm.println("--------------------------------------");
                        trm.println("Nombre: " + foundAutor.getNombre());
                        trm.println("Apellido Paterno: " + foundAutor.getaPaterno());
                        trm.println("Apellido Materno: " + foundAutor.getaMaterno());
                        trm.println("Ciudad: " + foundAutor.getCiudad());
                        trm.println("--------------------------------------");
                    }
                    break;
                case 3:
                    String autoresInfo = showAutors(autors);
                    System.out.println(autoresInfo);
                    trm.println("--------------------------------------");
                    break;
                case 4:
                    modifyAutor(autors);
                    break;
                case 5:
                    deleteAutor(autors);
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

    public static Autor findUser(Autor[] autors) {
        trm.println("----- Busca un Autor -------");
        trm.println("Ingrese el id del usuario que desea buscar -> ");
        int idToFind = rc.nextInt();

        for (Autor autor : autors) {
            if (autor != null && autor.getId() == idToFind) {
                return autor;
            }
        }

        trm.println("No se encontró ningún autor con ese ID.");
        return null;
    }

    public static String showAutors(Autor[] autors) {
        StringBuilder output = new StringBuilder();
        output.append("----- Listar Autores -----\n");
        if (autors == null || autors.length == 0) {
            output.append("No hay autores registrados.\n");
        } else {
            output.append("ID\tNombre\tApellido Paterno\tApellido Materno\tCiudad\n");
            for (Autor autor : autors) {
                if (autor != null) {
                    output.append(autor.getId())
                            .append("\t").append(autor.getNombre())
                            .append("\t").append(autor.getaPaterno())
                            .append("\t").append(autor.getaMaterno())
                            .append("\t").append(autor.getCiudad())
                            .append("\n");
                }
            }
        }
        return output.toString();
    }

    public static void modifyAutor(Autor[] autors) {
        trm.println("----- Editar Autor -----");
        trm.print("Ingrese el ID del autor que desea editar: ");
        int idToEdit = rc.nextInt();
        rc.nextLine();

        boolean found = false;
        for (int i = 0; i < autors.length; i++) {
            if (autors[i] != null && autors[i].getId() == idToEdit) {
                trm.println("---------- Usuario Encontrado -------------------");

                trm.print("Ingresa el nombre del autor: ");
                String nombre = rc.nextLine();
                trm.print("Ingresa el apellido paterno del autor: ");
                String aPaterno = rc.nextLine();
                trm.print("Ingresa el apellido materno del autor: ");
                String aMaterno = rc.nextLine();
                trm.print("Ingresa la ciudad del autor: ");
                String ciudad = rc.nextLine();

                autors[i].setNombre(nombre);
                autors[i].setaPaterno(aPaterno);
                autors[i].setaMaterno(aMaterno);
                autors[i].setCiudad(ciudad);

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

    public static void deleteAutor(Autor[] autors) {
        trm.println("----- Eliminar Autor -----");
        trm.print("Ingrese el ID del autor que desea eliminar: ");
        int idToDelete = rc.nextInt();

        boolean found = false;
        for (int i = 0; i < autors.length; i++) {
            if (autors[i] != null && autors[i].getId() == idToDelete) {
                trm.println("Autor encontrado y eliminado.");
                autors[i] = null;
                found = true;
                trm.println("--------------------------------------");
                break;
            }
        }

        if (!found) {
            trm.println("No se encontró ningún autor con ese ID.");
        }
    }
}