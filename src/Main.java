import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    static Scanner rc = new Scanner(System.in);
    static PrintStream trm = System.out;
    static boolean trmController = true;

    public static void main(String[] args){

        int arraySize = 10;
        Autor[] autors = new Autor[arraySize];
        int op = 0;
        int pos = 0;
        do {
            clearTrm();
            trm.println("---- REGISTRADOR DE AUTORES -----");
            trm.println("1.- Agregar");
            trm.println("2.- Buscar");
            trm.println("3.- Listar");
            trm.println("0.- Salir");
            trm.print("- Selecciona una opcion ->  ");
            op = rc.nextInt();
            switch (op){
                case 0:
                    trm.println("----------------------------------");
                    trm.println("Programa finalizado con exito!!...");
                    break;
                case 1:
                    if (pos < arraySize) {
                        autors[pos] = registerAutor();
                        pos++;
                    }else {
                        trm.println("Limite de autores alcanzados");
                        break;
                    }
                case 2:
                    findUser();

                case 3:
                    continue;
            }

        }while (op != 0);
    }

    public static Autor registerAutor(){

        int id;
        String nombre, aPaterno, aMaterno, ciudad;

        trmController = false;
        clearTrm();
        trm.println(" ----- Registra un Autor -------");

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

        return new Autor(id, nombre, aPaterno, aMaterno, ciudad);
    }

    public static Autor findUser(){
        trmController = false;
        clearTrm();

        int idToFind;
        boolean idValid = false;
        int nRetry = 0;

        do {
            nRetry ++;
            trmController = true;
            clearTrm();

            String error = "-----| El ID ingresado es invalido. |-----";

            trm.print("Ingrese el id del usuario que desea buscar -> ");
            // Verificar si el próximo token es un entero
            if (rc.hasNextInt()) {
                idToFind = rc.nextInt();

                // Verificar si el entero ingresado es positivo
                if (idToFind <= 0) {
                    trm.println(error);
                } else {
                    idValid = true;
                    trmController = true;
                    trm.println("Entraste.");
                }
            } else {
                trm.println(error);
                // Limpiar el buffer del Scanner en caso de que la entrada no sea un entero
                rc.next();
            }
            if (nRetry >= 3) {
                trm.println("------------------------------------------------------");
                trm.println("Demasiados intentos.. Volviendo al Menu Principal ...");
                trmController = false;
                break;
            }
        }while (!idValid);


        return new Autor(0, "prueba", "prueba", "prueba", "prueba");
    }

    public static void clearTrm() {
        int iteration = trmController ? 0 : 20;
        for (int i = 0; i < iteration; i++) {
            trm.println();
        }
    }
}