package source;

public class Operaciones {

	public double sumar(double a, double b) {
		return a+b;
	}

	public double restar(double a, double b) {
		double c = a-b;
		return c;
	}
	
	public double multiplicar(double a, double b) {
		return a*b;
	}
	
	public double dividir(double a, double b) {
		return a/b;
	}

	public double seno(double angulo) {
        return Math.sin(Math.toRadians(angulo));
    }
	
	public double exponencial(double x) {
        return Math.pow(x, 2);
    }
}
