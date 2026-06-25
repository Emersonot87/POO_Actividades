package EjercicioClasesAbstractas.EjercicioNumerica;

public class PruebaFracción {

    public static void main(String[] args) {
        Fracción a = new Fracción(1, 2);
        Fracción b = new Fracción(1, 3);

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        System.out.println("a + b = " + a.sumar(b));
        System.out.println("a - b = " + a.restar(b));
        System.out.println("a * b = " + a.multiplicar(b));
        System.out.println("a / b = " + a.dividir(b));

        Fracción c = new Fracción(1, 2);
        System.out.println("a.equals(c): " + a.equals(c));
        System.out.println("a.equals(b): " + a.equals(b));
    }
}
