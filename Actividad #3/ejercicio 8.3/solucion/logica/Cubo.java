package logica;

/**
 * Esta clase denominada Cubo es una subclase de FiguraGeométrica
 * que cuenta con un lado.
 * @version 1.2/2020
 */
public class Cubo extends FiguraGeométrica {
    private double lado;

    public Cubo(double lado) {
        this.lado = lado;
        this.setVolumen(calcularVolumen());
        this.setSuperficie(calcularSuperficie());
    }

    public double calcularVolumen() {
        return Math.pow(lado, 3.0);
    }

    public double calcularSuperficie() {
        return 6.0 * Math.pow(lado, 2.0);
    }
}
