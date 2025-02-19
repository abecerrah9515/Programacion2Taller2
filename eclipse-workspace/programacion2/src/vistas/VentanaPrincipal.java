package vistas;

public class VentanaPrincipal {
    
    public void imprimirMensaje(){
        System.out.println("Prueba vp");
    }
    
    public void sumar(int a, int b) {
        int resultado = a + b;
        System.out.println("El resultado de la suma es = " + resultado);
    }

    public void restar(int a, int b) {
        int resultado = a - b;
        System.out.println("El resultado de la resta es = " + resultado);
    }

    public void multiplicar(int a, int b) {
        int resultado = a * b;
        System.out.println("El resultado de la multiplicación es = " + resultado);
    }

    public void dividir(double a, double b) {
        if (b != 0) {
            double resultado = a / b;
            System.out.println("El resultado de la división es = " + resultado);
        } else {
            System.out.println("Error: No se puede dividir por cero.");
        }
    }
    
    public void seno(double angulo) {
        double resultado = Math.sin(Math.toRadians(angulo));
        System.out.println("El seno de " + angulo + " grados es = " + resultado);
    }

    public void coseno(double angulo) {
        double resultado = Math.cos(Math.toRadians(angulo));
        System.out.println("El coseno de " + angulo + " grados es = " + resultado);
    }

    public void raizCuadrada(double num) {
        if (num >= 0) {
            double resultado = Math.sqrt(num);
            System.out.println("La raíz cuadrada de " + num + " es = " + resultado);
        } else {
            System.out.println("Error: No se puede calcular la raíz cuadrada de un número negativo.");
        }
    }

    public void raizEnesima(double num, double n) {
        if (n != 0) {
            double resultado = Math.pow(num, 1.0 / n);
            System.out.println("La raíz " + n + " de " + num + " es = " + resultado);
        } else {
            System.out.println("Error: No se puede calcular la raíz enésima con exponente cero.");
        }
    }

    public void factorial(int num) {
        if (num < 0) {
            System.out.println("Error: No se puede calcular el factorial de un número negativo.");
            return;
        }
        long resultado = 1;
        for (int i = 1; i <= num; i++) {
            resultado *= i;
        }
        System.out.println("El factorial de " + num + " es = " + resultado);
    }

    public void logaritmo(double num) {
        if (num > 0) {
            double resultado = Math.log(num);
            System.out.println("El logaritmo natural de " + num + " es = " + resultado);
        } else {
            System.out.println("Error: No se puede calcular el logaritmo de un número no positivo.");
        }
    }

    public void exponencial(double x) {
        double resultado = Math.exp(x);
        System.out.println("e^" + x + " es = " + resultado);
    }
}
