package EjercicioSobrecargaConstructores;

public class Caja {
    double longitud;
    double anchura;
    double altura;
    String tipo;

    public Caja(double longitud, double anchura, double altura) {
        this.longitud = longitud;
        this.anchura = anchura;
        this.altura = altura;
        this.tipo = "Estándar";
    }

    public Caja() {
        this(0, 0, 0, "Vacía");
    }

    public Caja(double medida) {
        this(medida, medida, medida, "Cúbica");
    }

    public Caja(double longitud, double anchura, double altura, String tipo) {
        this(longitud, anchura, altura);
        this.tipo = tipo;
    }

    public void imprimir() {
        System.out.println("Tipo de caja: " + tipo);
        System.out.println("Longitud: " + longitud);
        System.out.println("Anchura: " + anchura);
        System.out.println("Altura: " + altura);
        System.out.println("Volumen: " + (longitud * anchura * altura));
    }

    public static void main(String[] args) {
        Caja caja1 = new Caja(10, 5, 8);
        System.out.println("=== Caja 1 (Constructor con parámetros) ===");
        caja1.imprimir();

        System.out.println();

        Caja caja2 = new Caja();
        System.out.println("=== Caja 2 (Constructor sin parámetros) ===");
        caja2.imprimir();

        System.out.println();

        Caja caja3 = new Caja(5);
        System.out.println("=== Caja 3 (Constructor con una medida - Cúbica) ===");
        caja3.imprimir();

        System.out.println();

        Caja caja4 = new Caja(12, 6, 9, "Premium");
        System.out.println("=== Caja 4 (Constructor con tipo personalizado) ===");
        caja4.imprimir();
    }
}
