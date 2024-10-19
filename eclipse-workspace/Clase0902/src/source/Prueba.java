package source;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prueba {
	
	BufferedReader in;
	

	public static void main(String[] args) {
		try {
			Prueba p = new Prueba();
			p.iniciarFlujo();
			p.mostrarMenu();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void iniciarFlujo(){
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public int mostrarMenu() {
		int opcion = 0;
		try {
			do {
				System.out.println("Por favor digite una opcion:");
				System.out.println("1) Sumar");
				System.out.println("2) Restar");
				System.out.println("3) Multiplicar");
				System.out.println("4) Dividir");
				System.out.println("5) Seno");
				System.out.println("6) Coseno");
				System.out.println("7) Raiz cuadrana");
				System.out.println("8) Raiz enesima");
				System.out.println("9) Factorial");
				System.out.println("10) Logaritmo");
				System.out.println("11) Exponencial");
				System.out.println("12) Salir");
				opcion = Integer.parseInt(in.readLine());
				switch (opcion) {
					case 1,2,3,4,5,6,7,8,9,10,11,12:
						return opcion;
					default:
						System.out.println("Ingrese un valor entre 1 - 12\n");
				}
			}while(opcion<1 || opcion >12);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return opcion;
	}
	
	public void calcularOperaciones() {
		
	}
}
