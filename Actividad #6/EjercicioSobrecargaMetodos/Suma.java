package EjercicioSobrecargaMetodos;

public class Suma {

    public void calcularSuma(int a, int b) 
    {
        int total = a + b;
        System.out.println("La suma de " + a + " y " + b + " es = " + total);
    }

    public void calcularSuma(int a, int b, int c) 
    {
        int total = a + b + c;
        System.out.println("La suma de " + a + ", " + b + " y " + c + " es = " + total);
    }

    public void calcularSuma(double a, double b) 
    {
        double total = a + b;
        System.out.println("La suma de " + a + " y " + b + " es = " + total);
    }

    public void calcularSuma(double a, double b, double c) 
    {
        double total = a + b + c;
        System.out.println("La suma de " + a + ", " + b + " y " + c + " es = " + total);
    }

    public static void main (String args[]) {
        
        Suma suma1 = new Suma();
        suma1.calcularSuma(5, 10);
        
        Suma suma2 = new Suma();
        suma2.calcularSuma(5, 10, 15);
        
        Suma suma3 = new Suma();
        suma3.calcularSuma(5.5, 10.5);

        Suma suma4 = new Suma();
        suma4.calcularSuma(5.5, 10.5, 15.5);
    }

}
