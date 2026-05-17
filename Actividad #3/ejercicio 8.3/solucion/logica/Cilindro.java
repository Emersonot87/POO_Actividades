package logica;

/**
 * Esta clase denominada Cilindro es una subclase de FiguraGeométrica
 * que cuenta con un radio y una altura.
 * @version 1.2/2020
 */
public class Cilindro extends FiguraGeométrica {
    private double radio;
    private double altura;

    public Cilindro(double radio, double altura) {
        this.radio = radio;
        this.altura = altura;
        this.setVolumen(calcularVolumen());
        this.setSuperficie(calcularSuperficie());
    }

    public double calcularVolumen() {
        return Math.PI * altura * Math.pow(radio, 2.0);
    }

    public double calcularSuperficie() {
        double areaLado = 2.0 * Math.PI * radio * altura;
        double areaBase = 2.0 * Math.PI * Math.pow(radio, 2.0);
        return areaLado + areaBase;
    }
}
