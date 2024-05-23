import java.util.Scanner;
import java.util.InputMismatchException;

public class Principal {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        Scanner entrada = new Scanner(System.in);

        int opc;
        do {
            System.out.println("1. Registrar participante");
            System.out.println("2. Tomar asistencia");
            System.out.println("3. Listar asistentes");
            System.out.println("4. Listar no asistentes");
            System.out.println("5. Guardar en archivo y salir");
            opc = entrada.nextInt();

            switch (opc) {
                case 1:
                int folio;
                do {
                    System.out.println("Ingresa el folio (3 dígitos):");
                    folio = validarEnteros(entrada);
        
                    } while (folio <100 || folio > 999);
                    entrada.nextLine();  //limpia buffer
                    System.out.println("Ingresa el nombre:");
                    String nombre = entrada.nextLine();
                    arbol.insertarParticipante(new Participante(folio, nombre));
                    break;
                case 2:
                    System.out.println("Ingresa el folio del participante:");
                    folio = entrada.nextInt();
                    Participante participante = arbol.buscarParticipante(folio);
                    if (participante != null) {
                        participante.setAsistencia(true);
                        System.out.println("Asistencia registrada.");
                    } else {
                        System.out.println("Participante no encontrado.");
                    }
                    break;
                case 3:
                    System.out.println("Participantes que asistieron:");
                    arbol.listarAsistentes();
                    break;
                case 4:
                    System.out.println("Participantes que no asistieron:");
                    arbol.listarNoAsistentes();
                    break;
                case 5:
                    arbol.guardarEnArchivo();
                    System.out.println("Información guardada. Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opc != 5);
        entrada.close();
    }

    

    private static int validarEnteros(Scanner scanner) { 
        int input;  
        while (true) {
            try {
                input = scanner.nextInt();
                break;}
            catch (InputMismatchException e)  {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                scanner.next(); 
            }
        }
        return input; 
    }
}
