package logica;

/**
 * Esta clase denominada Pirámide es una subclase de FiguraGeométrica
 * que cuenta con una base, una altura y un apotema.
 * @version 1.2/2020
 */
public class Piramide extends FiguraGeométrica {
    private double base;
    private double altura;
    private double apotema;

    public Piramide(double base, double altura, double apotema) {
        this.base = base;
        this.altura = altura;
        this.apotema = apotema;
        this.setVolumen(calcularVolumen());
        this.setSuperficie(calcularSuperficie());
    }

    public double calcularVolumen() {
        return (Math.pow(base, 2.0) * altura) / 3.0;
    }

    public double calcularSuperficie() {
        double areaBase = Math.pow(base, 2.0);
        double areaLado = 2.0 * base * apotema;
        return areaBase + areaLado;
    }
}
