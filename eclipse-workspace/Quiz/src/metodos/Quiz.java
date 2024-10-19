package metodos;
import java.time.LocalDate;
import java.time.Period;
 
public class Quiz {
	public boolean esBisiesto(int anho) {
        if ((anho % 4 == 0 && anho % 100 != 0) || (anho % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }
	
	public double calcularSalarioNeto(double horasTrabajadas, double tasaHora) {
        double salarioBruto = 0;
        double salarioNeto = 0;
 
        if (horasTrabajadas <= 38) {
            salarioBruto = horasTrabajadas * tasaHora;
        } else {
            double horasExtra = horasTrabajadas - 38;
            double tasaExtra = tasaHora * 1.5;
            salarioBruto = (38 * tasaHora) + (horasExtra * tasaExtra);
        }
 
        if (salarioBruto <= 2000000) {
            salarioNeto = salarioBruto;
        } else {
            salarioNeto = salarioBruto - (salarioBruto * 0.10);
        }
 
        return salarioNeto;
    }
	
	public void descomponerPesos(int cantidad) {
        int[] billetes = {100000, 50000, 20000, 10000, 5000, 2000};
        int[] monedas = {1000, 500, 200, 100};
 
        System.out.println("Descomposicion de $" + cantidad + " pesos:");
 
        for (int billete : billetes) {
            if (cantidad >= billete) {
                int numBilletes = cantidad / billete;
                cantidad %= billete;
                System.out.println(numBilletes + " billete(s) de $" + billete);
            }
        }
 
        for (int moneda : monedas) {
            if (cantidad >= moneda) {
                int numMonedas = cantidad / moneda;
                cantidad %= moneda;
                System.out.println(numMonedas + " moneda(s) de $" + moneda);
            }
        }
 
        if (cantidad > 0) {
            System.out.println("Cantidad restante (menor a 100): " + cantidad + " pesos.");
        }
    }
	
	public void calcularEdad(LocalDate fechaNacimiento, LocalDate fechaActual) {
        
        Period diferencia = Period.between(fechaNacimiento, fechaActual);
 
        if (diferencia.getYears() < 1) {
            int meses = diferencia.getMonths();
            int dias = diferencia.getDays();
            System.out.println("La persona es un bebe de " + meses + " meses y " + dias + " dias.");
        } else {
            int anios = diferencia.getYears();
            System.out.println("La persona tiene " + anios + " años.");
        }
    }
	
	public String convertirARomanos(int numero) {
        int[] valores = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuilder resultado = new StringBuilder();
        
        for (int i = 0; i < valores.length; i++) {
            while (numero >= valores[i]) {
                resultado.append(romanos[i]);
                numero -= valores[i];
            }
        }
        
        return resultado.toString();
    }
	
	public double realizarOperacion(double num1, double num2, char operacion) {
        double resultado = 0;
 
        switch (operacion) {
            case '+':
                resultado = num1 + num2;
                break;
            case '-':
                resultado = num1 - num2;
                break;
            case '*':
                resultado = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    resultado = num1 / num2;
                } else {
                    System.out.println("Division por cero no es permitida.");
                }
                break;
            case '%':
                if (num2 != 0) {
                    resultado = num1 % num2;
                } else {
                	System.out.println("Division por cero no es permitida.");
                }
                break;
            default:
            	System.out.println("Operacion no es valida.");
        }
 
        return resultado;
    }
}