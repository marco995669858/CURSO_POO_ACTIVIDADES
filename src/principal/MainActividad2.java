package principal;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import entity.Circulo;
import entity.Figura;
import entity.Rectangulo;
import entity.Triangulo;

public class MainActividad2 {
	private static ArrayList<Figura> historial = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            Decorador.lineaDecorativa();
            System.out.println("Calculadora de Figuras Geométricas");
            Decorador.lineaDecorativa();
            System.out.println("1. Círculo");
            System.out.println("2. Rectángulo");
            System.out.println("3. Triángulo");
            System.out.println("4. Ver historial");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            int opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el radio: ");
                    double radio = leerValorPositivo(sc);
                    Figura circulo = new Circulo(radio);
                    mostrarResultado(circulo);
                    break;
                case 2:
                    System.out.print("Ingresa la base: ");
                    double base = leerValorPositivo(sc);
                    System.out.print("Ingresa la altura: ");
                    double altura = leerValorPositivo(sc);
                    Figura rectangulo = new Rectangulo(base, altura);
                    mostrarResultado(rectangulo);
                    break;
                case 3:
                    System.out.print("Ingresa la base: ");
                    double baseT = leerValorPositivo(sc);
                    System.out.print("Ingresa la altura: ");
                    double alturaT = leerValorPositivo(sc);
                    Triangulo triangulo = new Triangulo(baseT, alturaT);
                    mostrarResultado(triangulo);
                    break;
                case 4:
                    mostrarHistorial();
                    break;
                case 5:
                    continuar = false;
                    mostrarEstadisticas();
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }

        sc.close();
    }

    private static double leerValorPositivo(Scanner sc) {
        double valor = -1;
        while (valor <= 0) {
            try {
                valor = sc.nextDouble();
                sc.nextLine();
                if (valor <= 0) {
                    System.out.print("Debe ser un número positivo. Intenta de nuevo: ");
                }
            } catch (InputMismatchException e) {
                System.out.print("Entrada no válida. Intenta de nuevo: ");
                sc.nextLine();
            }
        }
        return valor;
    }

    private static void mostrarResultado(Figura figura) {
        double area = figura.calcularArea();
        System.out.printf("Área del %s: %.2f\n", figura.getTipo(), area);
        historial.add(figura);
    }

    private static void mostrarHistorial() {
        Decorador.lineaDecorativa();
        if (historial.isEmpty()) {
            System.out.println("No hay cálculos realizados.");
        } else {
            for (Figura f : historial) {
                System.out.printf("%s - Área: %.2f\n", f.getTipo(), f.calcularArea());
            }
        }
        Decorador.lineaDecorativa();
    }

    private static void mostrarEstadisticas() {
        System.out.println("\n--- Estadísticas ---");
        System.out.println("Total de figuras: " + historial.size());
        double sumaAreas = 0;
        for (Figura f : historial) {
            sumaAreas += f.calcularArea();
        }
        double promedio = historial.size() > 0 ? sumaAreas / historial.size() : 0;
        System.out.printf("Promedio de áreas: %.2f\n", promedio);
    }

    static class Decorador {
        public static void lineaDecorativa() {
            System.out.println("***********************");
        }
    }
}
