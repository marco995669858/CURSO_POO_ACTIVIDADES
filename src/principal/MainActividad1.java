package principal;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import controller.ControladorUsuarios;
import entity.Usuario;

public class MainActividad1 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Usuario> usuarios = new ArrayList<>();
        System.out.println("Registro de Usuarios");
        String continuar;
        do {
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            int edad = 0;
            boolean edadValida = false;
            while (!edadValida) {
                try {
                    System.out.print("Edad: ");
                    edad = sc.nextInt();
                    sc.nextLine(); // limpiar buffer
                    if (edad <= 0) {
                        throw new InputMismatchException("Edad debe ser positiva.");
                    }
                    edadValida = true;
                } catch (InputMismatchException e) {
                    System.out.println("Edad no válida. Intenta nuevamente.");
                    sc.nextLine(); // limpiar input incorrecto
                }
            }
            System.out.print("Ciudad: ");
            String ciudad = sc.nextLine();
            usuarios.add(new Usuario(nombre, edad, ciudad));
            System.out.print("¿Deseas registrar otro usuario? (s/n): ");
            continuar = sc.nextLine();
        } while (continuar.equalsIgnoreCase("s"));
        System.out.println("\n--- Estadísticas ---");
        System.out.println("Total de usuarios: " + usuarios.size());
        System.out.printf("Promedio de edad: %.2f\n", ControladorUsuarios.calcularPromedioEdad(usuarios));
        String nombreMasLargo = "";
        for (Usuario u : usuarios) {
            if (u.getNombre().length() > nombreMasLargo.length()) {
                nombreMasLargo = u.getNombre();
            }
        }
        System.out.println("Nombre más largo: " + nombreMasLargo);
        Usuario destacado = ControladorUsuarios.elegirUsuarioDestacado(usuarios);
        if (destacado != null) {
            ControladorUsuarios.MensajeDecorativo.mostrarMensaje("Usuario Destacado: " + destacado);
        } else {
            System.out.println("No hay usuarios para destacar.");
        }
        sc.close();
    }
}
