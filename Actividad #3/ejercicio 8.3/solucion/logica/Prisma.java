package logica;

public class Prisma extends FiguraGeométrica {
    private double base;
    private double altura;
    private double profundidad;

    public Prisma(double base, double altura, double profundidad) {
        this.base = base;
        this.altura = altura;
        this.profundidad = profundidad;
        this.setVolumen(calcularVolumen());
        this.setSuperficie(calcularSuperficie());
    }

    public double calcularVolumen() {
        return base * altura * profundidad;
    }

    public double calcularSuperficie() {
        return 2.0 * ((base * altura) + (base * profundidad) + (altura * profundidad));
    }
}
