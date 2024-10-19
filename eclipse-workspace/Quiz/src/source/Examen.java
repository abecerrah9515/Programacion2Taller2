package source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

import metodos.*;
 
public class Examen {
	
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private static Quiz _metodos = new Quiz();
 
	public static void main(String[] args) {
		
		System.out.println("\tProgramacion II\n");
		System.out.println("\t     QUIZ\n");
		System.out.println("Estudiantes:");
		System.out.println("\tAngel Becerra");
		System.out.println("\tCesar Vergara\n");
		
        boolean salir = false;
        while (!salir) {
        	System.out.println("Opciones:");
            System.out.println("1. Año bisiesto");
            System.out.println("2. Salario neto semanal");
            System.out.println("3. Menor numero de billetes y monedas");
            System.out.println("4. Edad de una persona");
            System.out.println("5. Numero base 10 a numeros romanos");
            System.out.println("6. Calculos matematicos");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opcion: ");
 
            try {
                int opcion = Integer.parseInt(reader.readLine());
 
                switch (opcion) {
                    case 1:
                    	System.out.println("\n***** 1. Año bisiesto *****\n");
                        System.out.print("Ingrese un año: ");
                        int año = Integer.parseInt(reader.readLine());
                        boolean esBisiesto = _metodos.esBisiesto(año);
                        System.out.println("El año " + año + " " + (esBisiesto ? "es" : "no es") + " bisiesto");
                        System.out.println("Presiona Enter para continuar...");
                        try {
                            reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 2:
                    	System.out.println("\n***** 2. Salario neto semanal *****\n");
                        System.out.print("Ingrese las horas trabajadas: ");
                        double horasTrabajadas = Double.parseDouble(reader.readLine());
                        System.out.print("Ingrese la tasa por hora: ");
                        double tasaPorHora = Double.parseDouble(reader.readLine());
                        double salarioNeto = _metodos.calcularSalarioNeto(horasTrabajadas, tasaPorHora);
                        System.out.println("El salario neto semanal es: $" + salarioNeto);
                        System.out.println("Presiona Enter para continuar...");
                        try {
                            reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
 
                    case 3:
                    	System.out.println("\n***** 3. Menor numero de billetes y monedas *****\n");
                        System.out.print("Ingrese una cantidad en pesos colombianos: ");
                        int cantidad = Integer.parseInt(reader.readLine());
                         _metodos.descomponerPesos(cantidad);
                         System.out.println("Presiona Enter para continuar...");
                         try {
                             reader.readLine();
                         } catch (IOException e) {
                             e.printStackTrace();
                         }
                        break;
 
                    case 4:
                    	System.out.println("\n***** 4. Edad de una persona *****\n");
                        System.out.println("Ingrese la fecha de nacimiento (dd mm aaaa): ");
                        System.out.print("Dia: ");
                        int diaNac = Integer.parseInt(reader.readLine());
                        System.out.print("Mes: ");
                        int mesNac = Integer.parseInt(reader.readLine());
                        System.out.print("Anio: ");
                        int anioNac = Integer.parseInt(reader.readLine());
                        System.out.println("Ingrese la fecha actual (dd mm aaaa): ");
                        System.out.print("Dia: ");
                        int diaAct = Integer.parseInt(reader.readLine());
                        System.out.print("Mes: ");
                        int mesAct = Integer.parseInt(reader.readLine());
                        System.out.print("Anio: ");
                        int anioAct = Integer.parseInt(reader.readLine());
                        LocalDate fechaNacimiento = LocalDate.of(anioNac, mesNac, diaNac);
                        LocalDate fechaActual = LocalDate.of(anioAct, mesAct, diaAct);
                        _metodos.calcularEdad(fechaNacimiento, fechaActual);
                        System.out.println("Presiona Enter para continuar...");
                        try {
                            reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
 
                    case 5:
                    	System.out.println("\n***** 5. Numero base 10 a numeros romanos *****\n");
                        System.out.print("Ingrese un numero en base 10: ");
                        int numero = Integer.parseInt(reader.readLine());
                        String romano = _metodos.convertirARomanos(numero);
                        System.out.println("El numero " + numero + " en numeros romanos es: " + romano);
                        System.out.println("Presiona Enter para continuar...");
                        try {
                            reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
 
                    case 6:
                    	System.out.println("\n***** 6. Calculos matematicos *****\n");
                        System.out.print("Ingrese el primer numero: ");
                        double numero1 = Double.parseDouble(reader.readLine());
                        System.out.print("Ingrese el segundo numero: ");
                        double numero2 = Double.parseDouble(reader.readLine());
                        System.out.print("Ingrese la operacion (+, -, *, /, %): ");
                        char operacion = reader.readLine().charAt(0);
                        double resultado = _metodos.realizarOperacion(numero1, numero2, operacion);
                        System.out.println("El resultado de la operacion es: " + resultado);
                        System.out.println("Presiona Enter para continuar...");
                        try {
                            reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
 
                    case 7:
                        salir = true;
                        System.out.println("\nSaliendo...");
                        break;
 
                    default:
                        System.out.println("\nOpcion no valida");
                        System.out.println("Presiona Enter para continuar...");
                        try {
                            reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                }
 
            } catch (IOException | NumberFormatException e) {
                System.out.println("Error: Entrada no valida.");
                
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
 
}