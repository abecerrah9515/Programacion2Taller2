package source;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import vistas.VentanaPrincipal;

public class Prueba {
	
    public static void main(String[] args) {
        
        VentanaPrincipal vp = new VentanaPrincipal();
        vp.imprimirMensaje();
        
        int num1 = 0, num2 = 0;
        
        try {
            BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ingrese el primer número: ");
            num1 = Integer.parseInt(leer.readLine());
            System.out.println("Ingrese el segundo número: ");
            num2 = Integer.parseInt(leer.readLine());
        } catch (IOException e) {
            System.out.println("Error al leer la entrada: " + e.getMessage());
            return;
        } catch (NumberFormatException e) {
            System.out.println("Por favor ingrese un número válido.");
            return;
        }
    
        vp.sumar(num1, num2);
        vp.restar(num1, num2);
        vp.multiplicar(num1, num2);
        vp.dividir(num1, num2);
        vp.seno(num1);
        vp.coseno(num1);
        vp.raizCuadrada(num1);
        vp.raizEnesima(num1, num2);
        vp.factorial(num1);
        vp.logaritmo(num1);
        vp.exponencial(num1);
    }
}
